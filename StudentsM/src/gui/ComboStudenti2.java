package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import db.Conexion;
import model.Observator;
import model.Repozitory;
import model.Sex;
import model.Student;
import model.Triplet;

/**
 * Acest combobox reprezinta comboboxul din interfata grafica a panelului care afiseaza notele unui student. Comboboxul reprezinta o lista de
 *  cnp-uri ale tuturor studentilor actualizata permanent. Acest combobox implementeaza interfetel command si observer intrucat, combo-ul 
 *  produce o actiune importanta: afiseaza un tabel; iar tot combo-ul isi actualizeaza lista de cnp-uri permanent, deci este si un observator. 
 * @author Emilian
 *
 */

@SuppressWarnings("serial")
public class ComboStudenti2 extends JComboBox<String> implements Comanda,Observator {
	
	JLabel label;
	JPanel panel;
	
	static String[] studenti;
	
	static{
		studenti=new String[Repozitory.getInstance().getStudenti().size()];
		for(int i=0;i<Repozitory.getInstance().getStudenti().size();i++){
			studenti[i]=Repozitory.getInstance().getStudenti().get(i).getNume()+" "+Repozitory.getInstance().getStudenti().get(i).getPrenume();
		}
	}
	
	/**
	 * 
	 * Constructorul este precedat de un bloc de initializare static care incarca lista de nume a studentilor. 
	 * @param label eticheta in care va incarca numele, prenumele si alte date ale studentului ales
	 * @param pane panelul in care va incarca un nou tabel reprezentand notele studentului ales
	 */
	public ComboStudenti2(JLabel label,JPanel pane) {
		super(studenti);
		this.label=label;
		this.panel=pane;
	}

	/**
	 * Aceasta functie mai intai cauta studentul ales in lista din repository si apoi scrie continutul etichetei cu numele, prenumele, 
	 * cnp-ul acestuia. Apoi se conecteaza la baza de date, la tabelul note de unde scoate notele studentului respectiv. Aceste note vor fi 
	 * incarcate intr-o lista de triplete de forma: cod-disciplina, nr sesiune, nota efectiva. Pe baza codului disciplinei obtinem numele 
	 * disciplinei, si in cele din urma obtinem astfel o lista de triplete de forma denumire disciplina, sesiune, nota. Aceasta lista va fi 
	 * pasata constructorului clasei NoteTableModel, pentru a obtine un tabel care este apoi incarcat in panel. Panelul isi sterge continutul 
	 * anterior si apoi incarca noul tabel si se redeseneaza. 
	 * 
	 */
	@Override
	public void executa() {
		// TODO Auto-generated method stub
		String elementAles=(String) this.getSelectedItem();
		Scanner scan=new Scanner(elementAles);
		String nume=scan.next();
		String prenume=scan.next();
		for(Student s:Repozitory.getInstance().getStudenti()){
			if(nume.equals(s.getNume()) && prenume.equals(s.getPrenume())){
				long cnp=s.getCNP();
				LocalDate date=s.getData();
				Sex sex=s.getSex();
				String string="Student cnp:"+cnp+" nume:"+nume+" prenume: "+prenume+" sex:"+sex+" data nasterii:"+date.toString();
				label.setText(string);
				
				ArrayList<Triplet<Integer,Integer,Integer>> note1=new ArrayList<Triplet<Integer,Integer,Integer>>();
				ArrayList<Triplet<String,Integer,Integer>> note=new ArrayList<Triplet<String,Integer,Integer>>();
				try {
					String sql1="SELECT * FROM `nota` WHERE `CNP`="+cnp;
					Statement st = Conexion.getInstance().getConnection().createStatement();
					ResultSet rs=st.executeQuery(sql1);
					while(rs.next()) {
						int cnp2=rs.getInt("CNP");
						int codDisciplina=rs.getInt("CodDisciplina");
						int sesiune=rs.getInt("Prezentare");
						int nota=rs.getInt("Nota");
						Triplet<Integer,Integer,Integer> t=new Triplet<Integer,Integer,Integer>(codDisciplina,sesiune,nota);
						note1.add(t);
					}
					
					for(Triplet<Integer,Integer,Integer> tr:note1) {
						String sql2="SELECT `DenumireDisciplina` FROM `disciplina` WHERE `CodDisciplina`="+tr.getA().toString();
						Statement st2=Conexion.getInstance().getConnection().createStatement();
						ResultSet rs2=st.executeQuery(sql2);
						rs2.next();
						String disciplina=rs2.getString("DenumireDisciplina");
						rs2.close();
						Triplet<String,Integer,Integer> trr=new Triplet<String,Integer,Integer>(disciplina,Integer.parseInt(tr.getB().toString()),Integer.parseInt(tr.getC().toString()));
						note.add(trr);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				Conexion.logger.info(" Note: "+note.toString());
				NoteTableModel noteModel=new NoteTableModel(note);
				JTable table=new JTable(noteModel.getRows(),noteModel.getColumnNames());
				JScrollPane scrollPane=new JScrollPane(table);
				for(int i=0;i<this.panel.getComponentCount();i++)
					if(this.panel.getComponent(i) instanceof JScrollPane) {
						this.panel.remove(i);
					}
				this.panel.add(scrollPane);
				this.panel.repaint();
			}
		}

	}

	
	/**
	 * Functia este datorata implementarii interfetei Observer. Ea permite reactulizarea permanenta a listei acestuia de nume si prenume de 
	 * studneti. Lista este resetata cu lista obtinuta de la repository. 
	 */
	@Override
	public void update() {
		
		String st[]=new String[Repozitory.getInstance().getStudenti().size()];
		for(int i=0;i<Repozitory.getInstance().getStudenti().size();i++){
			st[i]=Repozitory.getInstance().getStudenti().get(i).getNume()+" "+Repozitory.getInstance().getStudenti().get(i).getPrenume();
		}
		
		this.removeAll();
		for(String s: st)
			this.addItem(s);
		
	}

}
