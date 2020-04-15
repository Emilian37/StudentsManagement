package gui;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import model.Observator;
import model.Repozitory;
import model.Student;

/**
 * Aceasta clasa este folosita pentru a modela combobox-ul de cnp-uri din interfata de modificare a unui student. 
 * Este comanda intrucat produce efecte importante (se actulizeaza o eticheta cu infomratii despre student) si observator intrucat lista 
 * de cnp-uri se modifica in functie de continutul repository-ului. 
 * @author Emilian
 *
 */
public class ComboCNP extends JComboBox<String> implements Comanda, Observator {

	protected JLabel labelStudent;
	static String cnps[];
	
	static{
		cnps=new String[Repozitory.getInstance().getStudenti().size() ];
		int i=0;
		for(Student s: Repozitory.getInstance().getStudenti()) {
			cnps[i++]=s.getCNP()+"";
		}
	}
	
	/**
	 * Se foloeste un bloc static de initializare anterior apelarii constructorului intrucat lista de cnp-uri trebuie incarcata la inceput.
	 * @param label eticheta pe care comboboxul o va modifica incarcand in ea date despre studentul selectat.
	 */
	public ComboCNP(JLabel label) {
		super(cnps);
		this.labelStudent=label;
	}
	
	/**
	 * Functia este datorrata implementarii interfetei Observer. Ea permite reactulizarea permanenta a listei acestuia de note ale 
	 * studentilor. Lista este resetata cu lista obtinuta de la repository. 
	 */
	@Override
	public void update() {
		String st[]=new String[Repozitory.getInstance().getStudenti().size()];
		for(int i=0;i<Repozitory.getInstance().getStudenti().size();i++){
			st[i]=String.valueOf(Repozitory.getInstance().getStudenti().get(i).getCNP());
		}
		this.removeAll();
		for(String s: st)
			this.addItem(s);
	}

	/**
	 * Efectul actiunii acestei functii este de a incarca in eticheta de langa cnp date despre studentul selectat. 
	 */
	@Override
	public void executa() {
		long cnp=Long.parseLong(this.getSelectedItem().toString().trim());
		for(Student s: Repozitory.getInstance().getStudenti())
			if(s.getCNP()==cnp) {
				String txt=" Student nume: "+s.getNume()+" prenume: "+s.getPrenume()+" sex: "+s.getSex()+" data nasterii: "+s.getData();
				labelStudent.setText(txt);
			}

	}

}
