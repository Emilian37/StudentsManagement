package gui;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import model.Disciplina;
import model.Observator;
import model.Repozitory;

/**
 * Clasa apare in panel-ul de inserare a unei note. 
 * @author Emilian
 *
 */


public class ComboDiscipline extends JComboBox<String> implements Comanda, Observator {

	protected static String[] discipline;
	protected JLabel textDisciplina;
	
	static{
		discipline=new String[Repozitory.getInstance().getDiscipline().size()];
		for(int i=0;i<Repozitory.getInstance().getDiscipline().size();i++){
			discipline[i]=String.valueOf(Repozitory.getInstance().getDiscipline().get(i).getCodDisciplina());
		}
	}
	
	/**
	 * Clasa primeste ca parametru eticheta in care trebuie sa incarce descrierea disciplinei. 
	 * @param textDisciplina
	 */
	public ComboDiscipline(JLabel textDisciplina) {
		super(discipline);
		this.textDisciplina = textDisciplina;
	}

	/**
	 * Functia se datoreaza implementarii interfetei Observer, intrucat continutul comboboxului trebuie actualizat permanent cu date provenind de la 
	 * Repository.Functia sterge fostul continut al comboboxului, si adauga rand pe rand noua lista de discipline. 
	 */
	@Override
	public void update() {
		String st[]=new String[Repozitory.getInstance().getDiscipline().size()];
		for(int i=0;i<Repozitory.getInstance().getDiscipline().size();i++){
			st[i]=String.valueOf(Repozitory.getInstance().getDiscipline().get(i).getCodDisciplina());
		}
		
		this.removeAll();
		for(String s: st)
			this.addItem(s);

	}

	/**
	 * Functia se datoreaza interfeti Command. Actiunea ei consta in a gasi discplina selectata in lista de discipline a Repository-ului si apoi modifica 
	 * label-ul alaturat incarcand in el o descriere a disciplinei care contine codul de disciplina,denumirea si numarul de credite.
	 */
	@Override
	public void executa() {
		int codDisciplina=Integer.parseInt(this.getSelectedItem().toString().trim());
		for(Disciplina d: Repozitory.getInstance().getDiscipline()) {
			if(d.getCodDisciplina()==codDisciplina) {
				String txt="Disciplina: "+d.getCodDisciplina()+" "+d.getDenumireDisciplina()+" nr credite: "+d.getNrCredite();
				textDisciplina.setText(txt);
			}
		}

	}

}
