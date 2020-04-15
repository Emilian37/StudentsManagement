package gui;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;

import exception.CnpException;
import model.Adresa;
import model.Judet;
import model.Repozitory;
import model.Sex;
import model.Student;
import model.Validare;

/**
 * Aceasta clasa implementeaza comportamentul butonului care permite introducerea in baza de date a informatiilor despre un nou student.
 * Butonul implementeaza interfata Command intrucat efectueaza actiuni cu efect important asupra aplicatiei. 
 * @author Emilian
 *
 */
@SuppressWarnings("serial")
public class ButonInserareStudent extends JButton implements Comanda{
	protected JTextField textInserareNume;
	protected JTextField textInserarePrenume;
	protected JTextField textInserareCNP;
	protected JDatePickerImpl textInserareDataNasterii;
	protected JRadioButton m,f;
	protected JTextField textAdresaStrada;
	protected JTextField textAdresaNr;
	protected JTextField textAdresaBloc;
	protected JTextField textAdresaAp;
	protected JComboBox comboJudet;
	protected JTextField textAdresaOras;
	
	/**
	 * 
	 * @param nume camp de text din care se preia numele studentului
	 * @param prenume camp de text din care se preia numele studentului
	 * @param cnp camp de text din care se preia cnp-ul studentului
	 * @param data panel special din care se preia data nasterii studentului
	 * @param m buton radio care permite preluarea sexului studentului
	 * @param f buton radio care permite preluarea sexului studentului
	 * @param textAdresaStrada camp de text din care se preia strada studentului
	 * @param textAdresaNr camp de text din care se preia numarul strazii studentului
	 * @param textAdresaBloc camp de text din care se preia blocul studentului
	 * @param textAdresaAp camp de text din care se preia apartamentul studentului
	 * @param comboJudet combobox din care se preia judetul studentului
	 * @param textAdresaOras camp de text din care se preia orasul studentului
	 */
	public ButonInserareStudent(JTextField nume,JTextField prenume,JTextField cnp,JDatePickerImpl data,JRadioButton m,JRadioButton f,JTextField textAdresaStrada,JTextField textAdresaNr,JTextField textAdresaBloc,JTextField textAdresaAp,JComboBox comboJudet,JTextField textAdresaOras){
		this.textInserareNume=nume;
		this.textInserarePrenume=prenume;
		this.textInserareCNP=cnp;
		this.textInserareDataNasterii=data;
		this.m=m;
		this.f=f;
		this.textAdresaStrada=textAdresaStrada;
		this.textAdresaNr=textAdresaNr;
		this.textAdresaBloc=textAdresaBloc;
		this.textAdresaAp=textAdresaAp;
		this.comboJudet=comboJudet;
		this.textAdresaOras=textAdresaOras;
	}
	
	/**
	 * Functia preia datele necesare din textfiled-uri sau combobox-uri si apoi creeaza un obiect de tip student pe baza lor, pe care apoi il introduce in baza de 
	 * date, via Repository.  Mai intai se creeaza un obiect de tip adresa, care este introdus in baza de date si apoi id-ul acestuia este setat
	 * ca id-adresa la student, iar apoi este introdus studentul in baza de date. 
	 */
	public void executa(){
		String numeStudent=textInserareNume.getText();
		String prenumeStudent=textInserarePrenume.getText();
		long cnpStudent=Long.parseLong(textInserareCNP.getText());
		int zi=textInserareDataNasterii.getModel().getDay();
		int an=textInserareDataNasterii.getModel().getYear();
		int luna=textInserareDataNasterii.getModel().getMonth()+1;
		LocalDate data=LocalDate.of(an, luna, zi);
		Sex s=Sex.Feminin;
		if(m.isSelected())
			s=Sex.Masculin;
		String strada=textAdresaStrada.getText();
		int nr=Integer.parseInt(textAdresaNr.getText());
		int bloc=Integer.parseInt(textAdresaBloc.getText());
		int ap=Integer.parseInt(textAdresaNr.getText());
		String oras=textAdresaOras.getText();
		
		String jud=(String)(comboJudet.getSelectedItem());
		Judet judet=Judet.getJudet(jud);
		//Validare v=new Validare();
		//try {
		//	if(v.cnpValid(cnpStudent, data, s, judet)==true) {
				Student st=new Student(cnpStudent,numeStudent,prenumeStudent,data,s);
				Adresa adresa=new Adresa(strada,nr,bloc,ap,judet,oras);
				// mai intai se baga adresa in baza de date, si apoi studentul 
				Repozitory.getInstance().addAdresa(adresa);
				st.setId(adresa.getId());
				Repozitory.getInstance().addStudent(st);
		/*	}
		} catch (CnpException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			textInserareNume.setText("");
			textInserarePrenume.setText("");
			textAdresaStrada.setText("");
			textAdresaNr.setText("");
			textAdresaBloc.setText("");
			textAdresaOras.setText("");
		}*/
		
	}
}
