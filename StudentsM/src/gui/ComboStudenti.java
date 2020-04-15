package gui;

import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;

import model.Observator;
import model.Repozitory;
import model.Sex;
import model.Student;

/** Clasa ComboStudenti modeleaza combo-ul ce contina lista numelor studentilor 
 * Apartine panelu-lui de modificare student.
 * 
 * @author Emilian
 *
 */

public class ComboStudenti extends JComboBox<String> implements Observator,Comanda{
	
	static String[] studenti;
	static{
		studenti=new String[Repozitory.getInstance().getStudenti().size()];
		for(int i=0;i<Repozitory.getInstance().getStudenti().size();i++){
			studenti[i]=Repozitory.getInstance().getStudenti().get(i).getNume()+" "+Repozitory.getInstance().getStudenti().get(i).getPrenume();
		}
	}
	
	protected JTextField nume;
	protected JTextField prenume;
	protected JTextField cnp;
	protected JDatePickerImpl dataNasterii;
	protected JRadioButton sexM;
	protected JRadioButton sexF;
	

	/** 
	 * 
	 * @param nume textfield-ul in care combobox-ul va incarca numele studentului selectat
	 * @param prenume textfield-ul in care combobox-ul va incarca prenumele studentului selectat
	 * @param cnp textfield-ul in care combobox-ul va incarca cnpului studentului selectat
	 * @param sexM radiobuton-ul in care combobox-ul va incarca sexul studentului selectat
	 * @param sexF radiobuton-ul in care combobox-ul va incarca sexul studentului selectat
	 * @param data panelul in care combobox-ul va incarca data nasterii studentului selectat
	 */
	public ComboStudenti(JTextField nume,JTextField prenume,JTextField cnp,JRadioButton sexM,JRadioButton sexF,JDatePickerImpl data){
		super(studenti);
		this.nume=nume;
		this.prenume=prenume;
		this.cnp=cnp;
		this.dataNasterii=data;
		this.sexF=sexF;
		this.sexM=sexM;
	}
	
	/**
	 * Acest combobox incarca in diferite elemente(textfielduri, butoane radio, paneluri de data) atributele specifice ale studentului 
	 * selectat.
	 */
	@Override
	public void executa() {
		String elementAles=(String) this.getSelectedItem();
		Scanner scan=new Scanner(elementAles);
		String nume=scan.next();
		String prenume=scan.next();
		for(Student s:Repozitory.getInstance().getStudenti()){
			if(nume.equals(s.getNume()) && prenume.equals(s.getPrenume())){
				this.nume.setText(nume);
				this.prenume.setText(prenume);
				this.cnp.setText(Long.toString(s.getCNP()));
				if(s.getSex()==Sex.Masculin)
					this.sexM.setSelected(true);
				else
					this.sexF.setSelected(true);
				this.dataNasterii.getModel().setDate(s.getData().getYear(),s.getData().getMonthValue()-1, s.getData().getDayOfMonth());
				break;
			}
		}
		
	}

	/**
	 * Functia este datorrata implementarii interfetei Observer. Ea permite reactulizarea permanenta a listei acestuia de nume si prenume de 
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
