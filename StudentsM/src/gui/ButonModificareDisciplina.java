package gui;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.Disciplina;
import model.Repozitory;

/**
 * Aceasta clasa implementeaza comportamentul butonului care permite modificarea unei discipline.
 * Butonul implementeaza interfata Command intrucat efectueaza actiuni cu efect important asupra aplicatiei. 
 * @author Emilian
 *
 */

public class ButonModificareDisciplina extends JButton implements Comanda{
	
	ComboModificareDisciplina comboModificare;
	JTextField textModCod;
	MyCheckBox cbxCod;
	JTextField textModDenumire;
	MyCheckBox cbxDenumire;
	JTextField textModNrCredite;
	MyCheckBox cbxNrCredite;
	JTextField textModSemestru;
	MyCheckBox cbxSemestru;
	JTextField textOreLab;
	MyCheckBox cbxOreLab;
	JTextField textOreCurs;
	MyCheckBox cbxOreCurs;
	JTextField textOreSeminar;
	MyCheckBox cbxOreSeminar;
	JTextField textFormaExaminare;
	MyCheckBox cbxFormaExaminare;
	
	

	public ButonModificareDisciplina(ComboModificareDisciplina comboModificare, JTextField textModCod,
			MyCheckBox cbxCod, JTextField textModDenumire, MyCheckBox cbxDenumire, JTextField textModNrCredite,
			MyCheckBox cbxNrCredite, JTextField textModSemestru, MyCheckBox cbxSemestru, JTextField textOreLab,
			MyCheckBox cbxOreLab, JTextField textOreCurs, MyCheckBox cbxOreCurs, JTextField textOreSeminar,
			MyCheckBox cbxOreSeminar, JTextField textFormaExaminare, MyCheckBox cbxFormaExaminare) {
		super("MODIFICARE DISCIPLINA");
		this.comboModificare = comboModificare;
		this.textModCod = textModCod;
		this.cbxCod = cbxCod;
		this.textModDenumire = textModDenumire;
		this.cbxDenumire = cbxDenumire;
		this.textModNrCredite = textModNrCredite;
		this.cbxNrCredite = cbxNrCredite;
		this.textModSemestru = textModSemestru;
		this.cbxSemestru = cbxSemestru;
		this.textOreLab = textOreLab;
		this.cbxOreLab = cbxOreLab;
		this.textOreCurs = textOreCurs;
		this.cbxOreCurs = cbxOreCurs;
		this.textOreSeminar = textOreSeminar;
		this.cbxOreSeminar = cbxOreSeminar;
		this.textFormaExaminare = textFormaExaminare;
		this.cbxFormaExaminare = cbxFormaExaminare;
	}

	/**
	 * Functia identifica disciplina care trebuie modificata pe baza codului acesteia care tocmai a fost selectat, si apoi modifica un atribut 
	 * al disciplinei selectate doar daca combobox-ul corespeunzator a fost selectat. 
	 */
	@Override
	public void executa() {
		String elementAles=(String) this.comboModificare.getSelectedItem();
		Scanner scan=new Scanner(elementAles);
		String denumire=scan.next();
		for(Disciplina d:Repozitory.getInstance().getDiscipline()){
			if(denumire.equals(d.getDenumireDisciplina())){
				Disciplina d2=(Disciplina)d.clone();
				if(cbxCod.isSelected())
					d2.setCodDisciplina(Integer.parseInt(textModCod.getText()));
				if(cbxDenumire.isSelected())
					d2.setDenumireDisciplina(textModDenumire.getText());
				if(cbxNrCredite.isSelected())
					d2.setNrCredite(Integer.parseInt(textModNrCredite.getText()));
				if(cbxSemestru.isSelected())
					d2.setSemestru(Integer.parseInt(textModSemestru.getText()));
				if(cbxOreLab.isSelected())
					d2.setNrOreLaborator(Integer.parseInt(textOreLab.getText()));
				if(cbxOreCurs.isSelected())
					d2.setNrOreCurs(Integer.parseInt(textOreCurs.getText()));
				if(cbxOreSeminar.isSelected())
					d2.setNrOreSeminar(Integer.parseInt(textOreSeminar.getText()));
				if(cbxFormaExaminare.isSelected())
					d2.setFormaDeExaminare(textFormaExaminare.getText());
				d.modificareDisciplina(d2);
				break;
			}
		}
		scan.close();
		
		
	}

}
