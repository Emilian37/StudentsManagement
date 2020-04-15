package model;
import java.util.ArrayList;

import db.Conexion;


/**
 * Clasa repository este clasa cea mai importanta a aplicatiei intrucat acesta este o copie fidela a bazei de date. Orice modificare de
 * date (adaugare stergere, update) este facuta prin intermediu repositoriului .
 * Repositoriul se incarca la rularea aplicatiei si pastraza in el liste cu toate obiectele din baze de date. \
 * Repositoriul este un singleton si un subiect in acelasi timp . Este singleton intrucat aplicatia are nevoie de o singura replica a
 * bazei de date si nu de mai multe. Este subiect intrucat toti observatori (ComboBoxurile si tabelele ) isi iau datele si se modifica in
 * functie de continutul acestuia .
 * @author Emilian
 *
 */
public class Repozitory implements Subject{
	
	{
		Conexion.logger.info("************* Incarcare date");
	}
	protected ArrayList<Student> studenti=Student.getStudenti();
	protected ArrayList<Disciplina> discipline=Disciplina.getDisciplina();
	protected ArrayList<Nota> note=Nota.getNote();
	protected ArrayList<Adresa> adrese=Adresa.getAdresa();
	{
		Conexion.logger.info("************* Incarcare date realizata!");
	}
	private static Repozitory instanta=null;
	private ArrayList<Observator> observatori=new ArrayList<Observator> ();
	
	private Repozitory(){	
		
	}
	
	/**
	 * 
	 * @return unica instanta a repositoriului .
	 */
	public static Repozitory getInstance(){
		if(instanta==null)
			instanta=new Repozitory();
		return instanta;
	}

	
	
	/**
	 *  Functia updateaza continutul continututl tuturor observatorilor care se afla stocati intr-o lista.
	 */

	@Override
	public void notifyAllOb() {
		for(int i=0;i<observatori.size();i++){
			observatori.get(i).update();
		}
	}

	/**
	 *  Functia adauga un observator in lista repositoriului . 
	 */

	@Override
	public void addObservator(Observator obs) {
		observatori.add(obs);
		
	}
	/**
	 *  Functia sterge un observator din lista repositoriului.
	 */

	@Override
	public void remmoveObservator(Observator obs) {
		observatori.remove(obs);
		
	}
	
	/**
	 *  Functia permite introducerea unui student atat in baza de date cat si in lista repositoriului si apoi notifica toti observatori
	 *  cu privirea la adaugarea efectuata.
	 * @param st
	 */
	public void addStudent(Student st){
		studenti.add(st); // se baga studentul in lista din repository 
		st.inserareStudent(); // se baga in baza de date 
		notifyAllOb(); // notiifica observatorii 
	}
	
	/**
	 *  Functia permite adaugarea unei adresa atat in baza de date cat si in lista repositoriului si apoi notifica toti observatori 
	 *  cu privirea la adaugarea efectuata.
	 * @param a
	 */
	public void addAdresa(Adresa a){
		adrese.add(a);
		a.inserareAdresa();
		notifyAllOb();
	}
	/**
	 *  Functia permite  adaugarea unei discipline atat in baza de date cat si in lista repositoriului si apoi notifica toti observatori 
	 *  cu privirea la adaugarea efectuata.
	 * @param d
	 */
	public void addDisciplina(Disciplina d){
		d.inserareDisciplina();
		discipline.add(d);
		notifyAllOb();
	}

	/**
	 * 
	 * @return lista de studenti 
	 */
	public ArrayList<Student> getStudenti() {
		return studenti;
	}



	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}



	public ArrayList<Disciplina> getDiscipline() {
		return discipline;
	}



	public void setDiscipline(ArrayList<Disciplina> discipline) {
		this.discipline = discipline;
	}



	public ArrayList<Nota> getNote() {
		return note;
	}



	public void setNote(ArrayList<Nota> note) {
		this.note = note;
	}



	public ArrayList<Adresa> getAdrese() {
		return adrese;
	}



	public void setAdrese(ArrayList<Adresa> adrese) {
		this.adrese = adrese;
	}
	
}
