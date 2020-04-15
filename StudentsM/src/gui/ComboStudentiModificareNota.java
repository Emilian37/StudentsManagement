package gui;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import model.Observator;
import model.Repozitory;
import model.Student;

/** Clasa se foloseste pentru a implementa un combo ce contine CNP-urile studentilor 
* Apare in panel-urile de modificare nota. Rolul acestuia este de a incarca pentru fiecare student doar disciplinele la care are note.
* Clasa foloseste un bloc de initializare static care se executa inainte de constructor, iar acest bloc are rolul de construi lista de cnp=uri 
* care va reprezentat continutul comboboxului. Intrucat prima linie a constructorului trebuie sa fie apelul de clasa parinte,  constructia listei
* de cnp=uri trebuie sa aibe loc inainte de apelul de constructor, deci suntem fortati sa utilizam un bloc de initializare static. 
*/

public class ComboStudentiModificareNota extends JComboBox<String> implements Comanda,Observator{
	
	static String[] cnpStudenti;
	JLabel textInfoStudenti;
	ComboDisciplina comboDisciplina;
	
	static{
		cnpStudenti=new String[Repozitory.getInstance().getStudenti().size()];
		for(int i=0;i<Repozitory.getInstance().getStudenti().size();i++){
			cnpStudenti[i]=String.valueOf(Repozitory.getInstance().getStudenti().get(i).getCNP());
		}
	} // bloc de initializare static 
	
	
	/**
	 * 
	 * @param textInfoStudenti eticheta pe care o va modifica punand in ea date despre studentul ales. 
	 * @param comboDisciplina  combo-ul care isi va incarca continutul in functie de studentul ales. 
	 */
	public ComboStudentiModificareNota(JLabel textInfoStudenti,ComboDisciplina comboDisciplina){
		super(cnpStudenti);
		this.textInfoStudenti=textInfoStudenti;
		this.comboDisciplina=comboDisciplina;
	}

	/**
	 * Executia acestui combo presupune doua mari etape: gasirea studentului selectat din lista de studenti, si notificarea componentelor 
	 * asupra studentului selectat. Componentele, adica JLabel si Combobox se modifica in functie de studentul selectat. 
	 */
	@Override
	public void executa() {
		String elementAles=(String)this.getSelectedItem();
		Long cnpAles=Long.parseLong(elementAles);
		Student s=null;
		for(Student st:Repozitory.getInstance().getStudenti()){
			if(cnpAles==st.getCNP()){
				s=st;
				break;
			}
		}
		textInfoStudenti.setText("Nume: "+s.getNume()+" Prenume: "+s.getPrenume()+" Data Nasterii: "+s.getData());
		comboDisciplina.setCnpStudent(cnpAles);
		comboDisciplina.update();
	}

	/**
	 * Functia este datorata implementarii interfetei observer intrucat lista de cnp-uri trebuie sa fie actualizata permanent in functie de 
	 * continutul repository-ului. Se sterge continutul listei de cnp-uri, iar apoi se incarca lista de cnp-uri obtinute din repository 
	 * rand pe rand.
	 */
	@Override
	public void update() {
		cnpStudenti=new String[Repozitory.getInstance().getStudenti().size()];
		for(int i=0;i<Repozitory.getInstance().getStudenti().size();i++){
			cnpStudenti[i]=String.valueOf(Repozitory.getInstance().getStudenti().get(i).getCNP());
		}
		
		this.removeAll();
		for(String s: cnpStudenti)
			this.addItem(s);
		
	}
	
	

}
