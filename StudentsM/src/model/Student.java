package model;
import java.time.LocalDate;
import java.util.ArrayList;
import db.Conexion;

import java.sql.*;

/**
 * <p> Clasa de tip entitate care mapeaza o tabela (Student) din baza de date .</p> 
 * @author Emilian
 *
 */
public class Student implements Cloneable{
	
	protected long CNP;
	protected String nume;
	protected String prenume;
	protected LocalDate data;
	protected Sex sex;
	protected int idAdresa;
	

	 
	/**
	 * Constructorul care nu primeste ca parametrul idAdresa student  ; este folosit adesea in aplicatie.
	 * @param CNP
	 * @param nume
	 * @param prenume
	 * @param data
	 * @param sex
	 * @param idAdresa
	 */
	
	public Student(long CNP,String nume,String prenume,LocalDate data,Sex sex) {
		this.CNP=CNP;
		this.nume=nume;
		this.prenume=prenume;
		this.data=data;
		this.sex=sex;
	}
	

	 /**
	  * Constructor care primeste ca si parametri toate atributele clasei . Este rar utilizat intrucat id se genereaza de catre baza de date, 
	  * prin autoincrementare .
	  * @param CNP
	  * @param nume
	  * @param prenume
	  * @param data
	  * @param sex
	  */
	
	public Student(long CNP, String nume,String prenume,LocalDate data,Sex sex,int idAdresa){
		this.CNP=CNP;
		this.nume=nume;
		this.prenume=prenume;
		this.data=data;
		this.sex=sex;
		this.idAdresa=idAdresa;
	}
	
	/**
	 *  Functia returneaza o lista de studenti pe care le gaseste in baza de date.
	 *  Functia interogheaza baza de date pentru a obtine toti studenti din tabela student apoi parcurge rezultatul rand cu rand ,
	 *  si la parcurgere scoate cnp-ul , numele, pronumele,etc si pe baza lor reconstituie un obiect de tip student pe care apoi il introduce
	 *  in Array list de studenti .
	 *  Functia este apelata de catre repository la instantierea acestuia pentru a incarca lista  de studenti repositoriului .
	 * @return
	 */
	public static ArrayList<Student> getStudenti(){
		ArrayList<Student> studenti=new ArrayList<Student> ();
		try{
			Statement statement=Conexion.getInstance().getConnection().createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM `student`");
			while(rs.next()){
				long CNP;
				CNP=rs.getLong("CNP");
				String nume;
				nume=rs.getString("Numele");
				String prenume;
				prenume=rs.getString("Prenume");
				Date data;
				data=rs.getDate("Data Nasterii");
				LocalDate date=data.toLocalDate();
				String s=rs.getString("Sex");
				Sex sex=Sex.Feminin;
				if(s.equals("M"))
					sex=Sex.Masculin;
				Student st=new Student(CNP,nume,prenume,date,sex);
				Conexion.logger.info("Student incarcat: "+st.toString());
				studenti.add(st);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return studenti;
	}
	
	/**
	 *   Functia insereaza in baza de date un student indentic cu obiectul curent ca si continut . Functia mai intai executa instructiunea de
	 *  insert apoi se duce in baza de date o interogheaza pentru a obtine cnp-ul tocmai inserat pe care il seteaza ca valoare a 
	 *  obiectului curent.
	 */
	public void inserareStudent(){
		try{
			Statement statement=Conexion.getInstance().getConnection().createStatement();
			String sql="INSERT INTO `student` (`CNP`, `Numele`, `Prenume`, `Data Nasterii`, `Sex`,`idAdresa`) VALUES ('"+this.CNP+"', '"+this.nume+"', '"+this.prenume+"', '"+this.data.toString()+"', '"+(this.sex.equals(Sex.Masculin)?"M":"F")+"'"+", '"+this.idAdresa+"')";
			statement.execute(sql);
			Conexion.logger.info(this.toString()+" was inserted succefuly");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 *  Functia sterge un student  complet din baza de date; 
	 *  Functia creeaza o instructiune sql pe care o executa cu ajutorul unui statemant.
	 */
	public void stergereStudent(){
		try{
			Statement statement=Conexion.getInstance().getConnection().createStatement();
			String sql="DELETE FROM `student` WHERE CNP='"+this.CNP+"';";
			statement.execute(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 *  Functia primeste ca si parametru un obiect nou de tip student si compara atribut cu atribut obiectul curent cu obiectul primit
	 *  ca parametru . Daca un atribut este diferit in obiectul parametru fata de obiectul curent atunci se executa o instructiune sql de 
	 *  update pentru campul respectiv.
	 */
	public void modificareStudent(Student student){
		try{
			Statement statement=Conexion.getInstance().getConnection().createStatement();
			String sql="UPDATE `student` SET ";
			if(this.CNP != student.getCNP())
				sql=sql+"`CNP`='"+student.getCNP()+"',";
			if(!this.nume.equals(student.getNume()))
				sql=sql+"`Numele`='"+student.getNume()+"',";
			if(!this.prenume.equals(student.getPrenume()))
				sql=sql+"`Prenume`='"+student.getPrenume()+"',";
			if(!this.data.equals(student.getData()))
				sql=sql+"`Data Nasterii`='"+student.getData().getYear()+"-"+student.getData().getMonthValue()+"-"+student.getData().getDayOfMonth()+"',";
			if(!this.sex.equals(student.getSex()))
				sql=sql+"`Sex`='"+(student.getSex().equals(Sex.Masculin)?"M":"F")+"',";
			int pozitieVirgula=sql.lastIndexOf(',');
			sql=sql.substring(0, pozitieVirgula);
			sql=sql+" WHERE `CNP`='"+this.CNP+"';";
			Conexion.getInstance().logger.info(sql);
			statement.execute(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	 
	 
	 
	@Override
	public String toString(){
		return "\nCnp: "+this.CNP+" Nume "+this.nume+" Prenume: "+this.prenume+" Data: "+this.data+" Sex: "+this.sex;
	}
	@Override
	public boolean equals(Object o){
		if (o instanceof Student){
			Student s=(Student)o;
			if(this.CNP==s.getCNP() && this.nume.equals(s.getNume()) && this.prenume.equals(s.getPrenume()) && this.data.equals(s.getData()) && this.sex.equals(s.getSex()))
				return true;
			else
				return false;
		}
		return false;
	}
	public long getCNP(){
		return CNP;
	}
	public String getNume(){
		return nume;
	}
	public String getPrenume(){
		return prenume;
	}
	public LocalDate getData(){
		return data;
	}
	public Sex getSex(){
		return sex;
	}
	public void setId(int id){
		this.idAdresa=id;
	}
	
	public int getIdAdresa() {
		return idAdresa;
	}

	public void setIdAdresa(int idAdresa) {
		this.idAdresa = idAdresa;
	}

	public void setCNP(long cNP) {
		CNP = cNP;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Object clone(){
		return new Student(CNP,nume,prenume,data,sex,idAdresa);
	}
}
