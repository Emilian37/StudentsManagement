package model;
import java.util.ArrayList;

import db.Conexion;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Clasa de tip entitate care mapeaza o tabela (Nota) din baza de date.
 * @author Emilian
 *
 */

public class Nota {
	protected long CNP;
	protected int codDisciplina;
	protected int prezentare;
	protected int nota;
	
	/**
	 *  
	 * @param CNP
	 * @param codDisciplina
	 * @param prezentare
	 * @param nota
	 */
	public Nota(long CNP,int codDisciplina,int prezentare,int nota){
		this.CNP=CNP;
		this.codDisciplina=codDisciplina;
		this.prezentare=prezentare;
		this.nota=nota;
	}
	
	/**
	 *  Functia returneaza o lista de Note pe care le gaseste in baza de date.
	 *  Functia interogheaza baza de date pentru a obtine toate notele din tabela Nota apoi parcurge rezultatul rand cu rand ,
	 *  si la parcurgere scoate cnp-ul , numele, codDisciplina, nota,etc si pe baza lor reconstituie un obiect de tip Nota
	 *   pe care apoi il introduce
	 *  in Array list de Note .
	 *  Functia este apelata de catre repository la instantierea acestuia pentru a incarca lista  de studenti repositoriului .
	 * @return
	 */
	public static ArrayList<Nota> getNote(){
		ArrayList<Nota> note=new ArrayList<Nota> ();
		try{
			Statement statement=Conexion.getInstance().getConnection().createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM `nota`");
				while(rs.next()){
				int CNP=rs.getInt("CNP");
				int codDisciplina=rs.getInt("CodDisciplina");
				int prezentare=rs.getInt("Prezentare");
				int nota=rs.getInt("Nota");
				Nota n=new Nota(CNP,codDisciplina,prezentare,nota);
				note.add(n);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return note;
	}
	
	/**
	 *   Functia insereaza in baza de date o nota  indentic cu obiectul curent ca si continut . Functia mai intai executa instructiunea de
	 *  insert apoi se duce in baza de date o interogheaza pentru a obtine cnp-ul tocmai inserat pe care il seteaza ca valoare a 
	 *  obiectului curent.
	 */
	public void inserareNota(){
		try{
			Statement statement=Conexion.getInstance().getConnection().createStatement();
			String sql="INSERT INTO `nota`(`CNP`, `CodDisciplina`, `Prezentare`, `Nota`) VALUES ('"+this.CNP+"','"+this.codDisciplina+"','"+this.prezentare+"','"+this.nota+"')";
			statement.execute(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 *  Functia sterge o nota  complet din baza de date; 
	 *  Functia creeaza o instructiune sql pe care o executa cu ajutorul unui statemant.
	 */

	public void stergereNota(){
		try{
			Statement statement=Conexion.getInstance().getConnection().createStatement();
			String sql="DELETE FROM `nota` WHERE CNP=='"+this.CNP+"';";
			statement.execute(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 *  Functia primeste ca si parametru un obiect nou de tip Nota si compara atribut cu atribut obiectul curent cu obiectul primit
	 *  ca parametru . Daca un atribut este diferit in obiectul parametru fata de obiectul curent atunci se executa o instructiune sql de 
	 *  update pentru campul respectiv.
	 */
	public void modificareNota(Nota nota){
		try{
			Statement statement=Conexion.getInstance().getConnection().createStatement();
			String sql="UPDATE `nota` SET";
			if(this.CNP!=nota.getCNP())
				sql=sql+"`CNP`='"+nota.getCNP()+"',";
			if(this.codDisciplina!=nota.getCodDisciplina())
				sql=sql+"`CodDisciplina`='"+nota.getCodDisciplina()+"',";
			if(this.prezentare != nota.getPrezentare())
				sql=sql+"`Prezentare`='"+nota.getPrezentare()+"',";
			if(this.nota != nota.getNota())
				sql=sql+"`Nota`='"+nota.getNota()+"',";
			int pozitieVirgula=sql.lastIndexOf(',');
			sql=sql.substring(0, pozitieVirgula);
			sql=sql+"WHERE `CNP`='"+this.CNP+"';";
			statement.execute(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public long getCNP() {
		return CNP;
	}

	public int getCodDisciplina() {
		return codDisciplina;
	}

	public int getPrezentare() {
		return prezentare;
	}

	public int getNota() {
		return nota;
	}
	@Override
	public String toString(){
		return "\nCNP: "+this.CNP+" codul disciplinei: "+this.codDisciplina+" prezentarea: "+this.prezentare+" Nota: "+this.nota;		
	}
	@Override
	public boolean equals(Object o){
		if(o instanceof Nota){
			Nota n=(Nota)o;
			if(this.CNP==n.getCNP() && this.codDisciplina==n.getCodDisciplina() && this.prezentare==n.getPrezentare() && this.nota==n.getNota())
				return true;
			else
				return false;
		}
		return false;
	}
}
