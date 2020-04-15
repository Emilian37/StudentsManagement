package gui;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.Disciplina;
import model.Repozitory;

/**
 * Aceasta clasa implementeaza comportamentul butonului care permite introducerea in baza de date a informatiilor despre o noua disciplina.
 * Butonul implementeaza interfata Command intrucat efectueaza actiuni cu efect important asupra aplicatiei. 
 * @author Emilian
 *
 */
public class ButonInserareDisciplina extends JButton implements Comanda{
	
    JTextField denumire;
    JTextField nrCredite;
    JTextField semestru;
    JTextField nrOreLaborator;
    JTextField nrOreCurs;
    JTextField nrOreSeminar;
    JTextField formaExaminare;
    
    /**
     * 
     * @param denumire textfield-ul de unde butonul preia denumirea disciplinei 
     * @param nrCredite textfield-ul de unde butonul preia numarul de credite ale disciplinei 
     * @param semestru textfield-ul de unde butonul preia semestrul  disciplinei 
     * @param nrOreLaborator textfield-ul de unde butonul preia numarul de ore de laborator a disciplinei 
     * @param nrOreCurs textfield-ul de unde butonul preia numarul de ore de curs a disciplinei 
     * @param nrOreSeminar textfield-ul de unde butonul preia numarul de ore de seminar a disciplinei 
     * @param formaExaminare textfield-ul de unde butonul preia forma de examinare a disciplinei 
     */
    public ButonInserareDisciplina (JTextField denumire,JTextField nrCredite,JTextField semestru,
    		JTextField nrOreLaborator, JTextField nrOreCurs, JTextField nrOreSeminar, JTextField formaExaminare){
    	
        this.denumire=denumire;
        this.nrCredite=nrCredite;
        this.semestru=semestru;
        this.nrOreLaborator=nrOreLaborator;
        this.nrOreCurs=nrOreCurs;
        this.nrOreSeminar=nrOreSeminar;
        this.formaExaminare=formaExaminare;
    }
    
    
    /**
     * Butonul preia din textfield-uri informatiile necesare, creeaza apoi un obiect de tip disciplina, pe care apoi il transmite repository-ului
     * ca acesta sa il introduca in baza de date. 
     */
	@Override
	public void executa() {
        String numeDisciplina = denumire.getText();
        int numarCredite = Integer.parseInt(nrCredite.getText());
        int Semestru = Integer.parseInt(semestru.getText());
        int NrOreLaborator = Integer.parseInt(nrOreLaborator.getText());
        int NrOreCurs = Integer.parseInt(nrOreCurs.getText());
        int NrOreSeminar = Integer.parseInt(nrOreSeminar.getText());
        String FormaExaminare = formaExaminare.getText();
        Disciplina dis = new Disciplina (numeDisciplina,numarCredite,Semestru,NrOreLaborator,NrOreCurs,NrOreSeminar,FormaExaminare);
        Repozitory.getInstance().addDisciplina(dis);
        }
		
}
