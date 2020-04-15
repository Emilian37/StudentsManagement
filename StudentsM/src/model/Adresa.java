package model;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.Conexion;

/**
 * <p> Clasa de tip entitate care mapeaza o tabela (adresa) din baza de date .</p> 
 * @author Emilian
 *
 */

public class Adresa {

	private int id;
	protected String strada;
	protected int nr;
	protected int bloc;
	protected int ap;
	protected Judet judet;
	protected String oras;
	/**
	 * Constructor care primeste ca si parametri toate atributele clasei . Este rar utilizat intrucat id se genereaza de catre baza de date, 
	 * prin autoincrementare .
	 * @param id  - idul unic autoincrementat a undei adrese.
	 * @param strada 
	 * @param nr 
	 * @param bloc
	 * @param ap
	 * @param judet
	 * @param oras
	 */
	public Adresa(int id, String strada, int nr, int bloc, int ap, Judet judet, String oras) {
		this.id = id;
		this.strada = strada;
		this.nr = nr;
		this.bloc = bloc;
		this.ap = ap;
		this.judet = judet;
		this.oras = oras;
	}
	/**
	 *  Constructorul care nu primeste ca parametrul idul unei adrese ; este folosit adesea in aplicatie.
	 * @param strada
	 * @param nr
	 * @param bloc
	 * @param ap
	 * @param judet
	 * @param oras
	 */
	public Adresa(String strada, int nr, int bloc, int ap, Judet judet, String oras) {
		this.strada = strada;
		this.nr = nr;
		this.bloc = bloc;
		this.ap = ap;
		this.judet = judet;
		this.oras = oras;
	}
	
	
	/**
	 *  Functia returneaza o lista de adrese pe care le gaseste in baza de date.
	 *  Functia interogheaza baza de date pentru a obtine toate adresele din tabela adresa apoi parcurge rezultatul rand cu rand ,
	 *  si la parcurgere scoate idul , strada , numarul,etc si pe baza lor reconstituie un obiect de tip adresa pe care apoi il introduce
	 *  in Array list de adrese .
	 *  Functia este apelata de catre repository la instantierea acestuia pentru a incarca lista  de adrese repositoriului .
	 * @return Toate adresele din bazele de date.
	 */
	public static ArrayList<Adresa> getAdresa(){
		ArrayList<Adresa> adrese=new ArrayList<Adresa> ();
		try{
			Statement statement=Conexion.getInstance().getConnection().createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM `adresa`");
			
			while(rs.next()){ // te duce pe cate un rand nou din rezultat 
				int id=rs.getInt("id");
				String str=rs.getString("strada");
				int nr=rs.getInt("numar");
				int bloc=rs.getInt("bloc");
				int ap=rs.getInt("apartament");
				String jud=rs.getString("judet");
				Judet judet=Judet.getJudet(jud);
				String oras=rs.getString("oras");
				Adresa adresa=new Adresa(id,str,nr,bloc,ap,judet,oras);
				adrese.add(adresa);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return adrese;
	}
	/**
	 *  Functia insereaza in baza de date o adresa indentica cu obiectul curent ca si continut . Functia mai intai executa instructiunea de
	 *  insert apoi se duce in baza de date o interogheaza pentru a obtine id-ul adresei tocmai inserate pe care il seteaza ca valoare a 
	 *  obiectului curent.
	 */
	public void inserareAdresa(){
		try{
			Statement statement=Conexion.getInstance().getConnection().createStatement();
			String sql="INSERT INTO `adresa`(`strada`, `numar`, `bloc`,`apartament`,`judet`,`oras`) VALUES ('"+this.strada+"','"+this.nr+"','"+this.bloc+"','"+this.ap+"','"+this.judet+"','"+this.oras+"')";
			statement.execute(sql);
			
			sql="SELECT `id` FROM `adresa` WHERE `strada`='"+this.strada+"' AND `numar`='"+this.nr+"' AND `bloc`='"+this.bloc+"' AND `apartament`='"+this.ap+"' AND `judet`='"+this.judet+"' and `oras`='"+this.oras+"'";
			
			ResultSet st=statement.executeQuery(sql);
			st.next();
			this.id=st.getInt("id");
			Conexion.logger.info(this.toString()+" was sucefully inserted");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		return "Adresa [id=" + id + ", strada=" + strada + ", nr=" + nr + ", bloc=" + bloc + ", ap=" + ap + ", judet="
				+ judet + ", oras=" + oras + "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresa other = (Adresa) obj;
		if (ap != other.ap)
			return false;
		if (bloc != other.bloc)
			return false;
		if (id != other.id)
			return false;
		if (judet != other.judet)
			return false;
		if (nr != other.nr)
			return false;
		if (oras == null) {
			if (other.oras != null)
				return false;
		} else if (!oras.equals(other.oras))
			return false;
		if (strada == null) {
			if (other.strada != null)
				return false;
		} else if (!strada.equals(other.strada))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStrada() {
		return strada;
	}
	public void setStrada(String strada) {
		this.strada = strada;
	}
	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	public int getBloc() {
		return bloc;
	}
	public void setBloc(int bloc) {
		this.bloc = bloc;
	}
	public int getAp() {
		return ap;
	}
	public void setAp(int ap) {
		this.ap = ap;
	}
	public Judet getJudet() {
		return judet;
	}
	public void setJudet(Judet judet) {
		this.judet = judet;
	}
	public String getOras() {
		return oras;
	}
	public void setOras(String oras) {
		this.oras = oras;
	}
	
	
}
