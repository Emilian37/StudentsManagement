package gui;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;


import model.Nota;

/**
 * Aceasta clasa implementeaza comportamentul butonului care permite introducerea in baza de date a informatiilor despre o noua nota.
 * Butonul implementeaza interfata Command intrucat efectueaza actiuni cu efect important asupra aplicatiei. 
 * @author Emilian
 *
 */
public class ButonInserareNota extends JButton implements Comanda {

    JComboBox CNP;
    JComboBox codulDisciplinei;
    JComboBox<String> prezentare;
    JTextField nota;

    /**
     * 
     * @param CNP comboboxul care contine cnp-ul studentului pentru care ne intereseaza nota
     * @param codulDisciplinei textfield-ul care contine codul disciplinei pentru care se acorda nota
     * @param prezentare textfield-ul care contine numarul prezentarii pentru care se acrorda nota
     * @param nota textfield-ul care contine nota efectiva 
     */
public ButonInserareNota(JComboBox CNP,JComboBox codulDisciplinei,JComboBox<String> prezentare,JTextField nota){
	this.CNP = CNP;
	this.codulDisciplinei=codulDisciplinei;
    this.prezentare = prezentare;
    this.nota = nota;
    
}
/**
 * Functia preia datele necesare din textfiled-uri sau combobox-uri si apoi creeaza un obiect de tip nota pe baza lor, pe care apoi il introduce in baza de 
 * date. 
 */
    @Override
    public void executa() {
        // TODO Auto-generated method stub
		long cnp=Long.parseLong(CNP.getSelectedItem().toString().trim());
    	//long cnp = Long.parseLong(CNP.getText());
        int CodulDisciplinei = Integer.parseInt(codulDisciplinei.getSelectedItem().toString().trim());
        int Prezentare = Integer.parseInt(prezentare.getSelectedItem().toString().substring(prezentare.getSelectedItem().toString().indexOf("-")+1).trim());
        int Nota = Integer.parseInt(nota.getText());
        Nota n = new Nota(cnp,CodulDisciplinei,Prezentare,Nota);
        n.inserareNota();
    }

}