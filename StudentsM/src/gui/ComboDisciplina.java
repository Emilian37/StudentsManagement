package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import db.Conexion;
import model.Cvadruplet;
import model.Disciplina;
import model.Observator;
import model.Repozitory;
import model.Triplet;
import java.util.TreeSet;

/**
 * Clasa afiseaza Dsiciplinele pe care le detine un student pe baza CNP-ului ales de noi.
 * Clasa apare in panel-ul de Modificare Nota. 
 * Aceasta clasa este "parametrizata" cu CNP-ul unui student, in sensul ca lista de note, care reprezinta continutul comboboxului se incarca 
 * in functie de acest CNP. Acest CNP nu este setat prin constructor intrucat CNP-ul se modifica de la exterior de catre alt combobox, deci nu 
 * este necesar spre a fi setat la "aparitia" combobox-ului in interfata grafica. 
 * @author Emilian
 *
 */


public class ComboDisciplina extends JComboBox implements Comanda,Observator{
	
	protected long cnpStudent;
	protected ArrayList<Cvadruplet<Integer,Integer,Integer,String>> note=new ArrayList<Cvadruplet<Integer,Integer,Integer,String>> ();
	protected JLabel labelInfo;
	protected JTextField textNota1;
	protected JTextField textNota2;
	protected JTextField textNota3;
	
	/**
	 * Constructorul primeste ca parametri doar componentele grafice de care are nevoie pentru a-si realiza executia. 
	 * @param labelInfo eticheta pe care o va modifica prin actiunea sa, adica va scrie in ea detalii despre disciplina selectata de catre student.
	 * @param textNota1 campul de text in care se va incarca nota de la prima sesiune pentru materia si studentul selectat. 
	 * @param textNota2 campul de text in care se va incarca nota de la a doua sesiune pentru materia si studentul selectat. 
	 * @param textNota3 campul de text in care se va incarca nota de la a treia sesiune pentru materia si studentul selectat. 
	 */
	public ComboDisciplina(JLabel labelInfo, JTextField textNota1, JTextField textNota2, JTextField textNota3) {
		super();
		this.labelInfo = labelInfo;
		this.textNota1 = textNota1;
		this.textNota2 = textNota2;
		this.textNota3 = textNota3;
	}

	/**
	 * Functia modifica label-ul alaturat incarcand descrierea disciplinei. Functia se datoreaza interfetei Command.
	 */
	@Override
	public void executa() {
		String elementAles=(String)this.getSelectedItem();
		
		for(Cvadruplet<Integer,Integer,Integer,String> nota:this.note){
			if(nota.getD().equals(elementAles)){
				this.labelInfo.setText("Disciplina cod:"+nota.getA()+" denumir:"+nota.getD());
				int cod=nota.getA();
				
				break;
			}
		}
			
		labelInfo.setText("Numar Credite: ");
	}

	/**
	 * Elementele care isi modifica continutul implementeaza Observer.Se incarca din baza de date disciplinele, cu notele aferente. 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void update() {
		this.removeAllItems();
		
		String sql="SELECT `CodDisciplina`,`Prezentare`,`Nota` FROM `nota` WHERE `CNP`="+this.cnpStudent+";";
		note=new ArrayList<Cvadruplet<Integer,Integer,Integer,String>> ();
		try {
			Statement statement=Conexion.getInstance().getConnection().createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()){
				int codDisciplina=rs.getInt("CodDisciplina");
				int prezentare=rs.getInt("Prezentare");
				int nota=rs.getInt("Nota");
				Cvadruplet <Integer,Integer,Integer,String> t=new Cvadruplet<Integer,Integer,Integer,String>(codDisciplina,prezentare,nota,null);
				note.add(t);
			}
			
			rs.close();
			TreeSet<Cvadruplet<Integer,Integer,Integer,String>> noteDistincte=new TreeSet<Cvadruplet<Integer,Integer,Integer,String>>();
			
			for(int i=0;i<note.size();i++){
				
				int codDisciplinaNota=note.get(i).getA();
				sql="SELECT `DenumireDisciplina` FROM `disciplina` WHERE `CodDisciplina`="+codDisciplinaNota;
				ResultSet rs2=statement.executeQuery(sql);
				rs2.next();
				String denumireDisciplina=rs2.getString("DenumireDisciplina");
				note.get(i).setD(denumireDisciplina);
				noteDistincte.add(note.get(i));
				//this.addItem(denumireDisciplina);
			}
			
			for(Cvadruplet<Integer,Integer,Integer,String> nt:noteDistincte)
				this.addItem(nt.getD());


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public long getCnpStudent() {
		return cnpStudent;
	}

	public void setCnpStudent(long cnpStudent) {
		this.cnpStudent = cnpStudent;
	}
	
	

}
