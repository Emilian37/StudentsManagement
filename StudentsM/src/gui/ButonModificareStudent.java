package gui;

import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;

import model.Repozitory;
import model.Sex;
import model.Student;

/**
* Aceasta clasa implementeaza comportamentul butonului care permite modificarea unui student.
* Butonul implementeaza interfata Command intrucat efectueaza actiuni cu efect important asupra aplicatiei. 
* @author Emilian
*
*/

public class ButonModificareStudent extends JButton implements Comanda{

	ComboStudenti comboStudent;
	MyCheckBox checkNume;
	JTextField textNume;
	MyCheckBox checkPrenume;
	JTextField textPrenume;
	MyCheckBox checkCnp;
	JTextField textCnp;
	JCheckBox checkData;
	JDatePickerImpl data;
	JCheckBox checkSex;
	JRadioButton radioM;
	JRadioButton radioF;
	
	
	public ButonModificareStudent(ComboStudenti comboStudent, MyCheckBox checkNume, JTextField textNume,
			MyCheckBox checkPrenume, JTextField textPrenume, MyCheckBox checkCnp, JTextField textCnp,
			JCheckBox checkData, JDatePickerImpl data, JCheckBox checkSex, JRadioButton radioM, JRadioButton radioF) {
		super("MDIFICARE STUDENT");
		this.comboStudent = comboStudent;
		this.checkNume = checkNume;
		this.textNume = textNume;
		this.checkPrenume = checkPrenume;
		this.textPrenume = textPrenume;
		this.checkCnp = checkCnp;
		this.textCnp = textCnp;
		this.checkData = checkData;
		this.data = data;
		this.checkSex = checkSex;
		this.radioM = radioM;
		this.radioF = radioF;
	}



	/**
	 * Functia identifica studentul care trebuie modificat pe baza cnp-lui acesteia care tocmai a fost selectat, si apoi modifica un atribut 
	 * al studentului selectat doar daca checkbox-ul corespeunzator a fost selectat. 
	 */
	@Override
	public void executa() {
		String elementAles=(String)(this.comboStudent.getSelectedItem());
		Scanner scan=new Scanner(elementAles);
		String nume=scan.next();
		String prenume=scan.next();
		for(Student s:Repozitory.getInstance().getStudenti()){
			if(nume.equals(s.getNume()) && prenume.equals(s.getPrenume())){
				Student s2=(Student)s.clone();
				if(checkNume.isSelected())
					s2.setNume(textNume.getText());
				if(checkPrenume.isSelected())
					s2.setPrenume(textPrenume.getText());
				if(checkCnp.isSelected())
					s2.setCNP(Long.parseLong(textCnp.getText()));
				if(checkData.isSelected()){
					int zi=data.getModel().getDay();
					int luna=data.getModel().getMonth()+1;
					int an=data.getModel().getYear();
					LocalDate localDate=LocalDate.of(an, luna, zi);
					s2.setData(localDate);
				}
				if(checkSex.isSelected()){
					Sex sex=Sex.Masculin;
					if(radioF.isSelected())
						sex=Sex.Feminin;
					s2.setSex(sex);
				}
				s.modificareStudent(s2);
								
				break;
			}
		}
		
	}

	
}
