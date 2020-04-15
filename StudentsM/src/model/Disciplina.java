package model;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.Conexion;

/**
 * @author Emilian
 *  <p> Clasa de tip entitate care mapeaza o tabela (adresa) din baza de date .</p> 
 *  
 */

public class Disciplina implements Cloneable{

		protected int codDisciplina;
		protected String denumireDisciplina;
		protected int nrCredite;
		protected int semestru;
		protected int nrOreLaborator;
		protected int nrOreCurs;
		protected int nrOreSeminar;
		protected String formaDeExaminare;
		
		/**
		 * Constructor care primeste ca si parametri toate atributele clasei . Este rar utilizat intrucat cod disciplina se
		 *  genereaza de catre baza de date, prin autoincrementare .
		 * @param codDisciplina
		 * @param denumireDisciplina
		 * @param nrCredite
		 * @param semestru
		 * @param nrOreLaborator
		 * @param nrOreCurs
		 * @param nrOreSeminar
		 * @param formaDeExaminare
		 */
		public Disciplina(int codDisciplina,String  denumireDisciplina,int nrCredite,int semestru,int nrOreLaborator,int nrOreCurs,int nrOreSeminar,String formaDeExaminare){
			this.codDisciplina=codDisciplina;
			this.denumireDisciplina=denumireDisciplina;
			this.nrCredite=nrCredite;
			this.semestru=semestru;
			this.nrOreLaborator=nrOreLaborator;
			this.nrOreCurs=nrOreCurs;
			this.nrOreSeminar=nrOreSeminar;
			this.formaDeExaminare=formaDeExaminare;
		}
		
		
		/**
		 * Constructorul care nu primeste ca parametrul codul disciplinei a unei adrese ; este folosit adesea in aplicatie.
		 * @param denumireDisciplina
		 * @param nrCredite
		 * @param semestru
		 * @param nrOreLaborator
		 * @param nrOreCurs
		 * @param nrOreSeminar
		 * @param formaDeExaminare
		 */
		
		public Disciplina(String denumireDisciplina, int nrCredite, int semestru, int nrOreLaborator, int nrOreCurs,
				int nrOreSeminar, String formaDeExaminare) {
			super();
			this.denumireDisciplina = denumireDisciplina;
			this.nrCredite = nrCredite;
			this.semestru = semestru;
			this.nrOreLaborator = nrOreLaborator;
			this.nrOreCurs = nrOreCurs;
			this.nrOreSeminar = nrOreSeminar;
			this.formaDeExaminare = formaDeExaminare;
		}

		/**
		 * Functia returneaza o lista de discipline  pe care le gaseste in baza de date.
		 *  Functia interogheaza baza de date pentru a obtine toate disciplinele din tabela disciplina apoi parcurge rezultatul
		 *   rand cu rand  si la parcurgere scoate codul disciplinei  , numeleDisciplinei , nrCredite ,etc si pe baza
		 *    lor reconstituie un obiect de tip disciplina pe care apoi il introduce
		 *  in Array list de discipline  .
		 *  Functia este apelata de catre repository la instantierea acestuia pentru a incarca lista  de discipline a  repositoriului .
		 * @return Toate disciplinele din baze de date.
		 */

		public static ArrayList<Disciplina> getDisciplina(){
			ArrayList<Disciplina> discipline=new ArrayList<Disciplina> ();
			try{
				Statement statement=Conexion.getInstance().getConnection().createStatement();
				ResultSet rs=statement.executeQuery("SELECT * FROM `disciplina`");
				while(rs.next()){
					int codDisciplina;
					codDisciplina=rs.getInt("CodDisciplina");
					String denumireDisciplina;
					denumireDisciplina=rs.getString("DenumireDisciplina");
					int nrCredite;
					nrCredite=rs.getInt("NRCredite");
					int semestru;
					semestru=rs.getInt("Semestru");
					int nrOreLaborator;
					nrOreLaborator=rs.getInt("NrOreLaborator");
					int nrOreSeminar;
					nrOreSeminar=rs.getInt("NrOreSeminar");
					int nrOreCurs;
					nrOreCurs=rs.getInt("NrOreCurs");
					String formaDeExaminare;
					formaDeExaminare=rs.getString("FormaDeExaminare");
					Disciplina d=new Disciplina(codDisciplina,denumireDisciplina,nrCredite,semestru,nrOreLaborator,nrOreSeminar,nrOreCurs,formaDeExaminare);
					discipline.add(d);
					Conexion.getInstance().logger.info(" Disciplina adaugata: "+d.toString());
					
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return discipline;
		}
		
		/**
		 *  Functia insereaza in baza de date o disciplina indentica cu obiectul curent ca si continut . Functia mai intai executa
		 *   instructiunea de
		 *  insert apoi se duce in baza de date o interogheaza pentru a obtine codul disciplinei  tocmai inserate pe care il seteaza
		 *   ca valoare a  obiectului curent.
		 */
		public void inserareDisciplina(){
			try{
				Statement statement=Conexion.getInstance().getConnection().createStatement();
				String sql="INSERT INTO `disciplina`(`DenumireDisciplina`, `NrCredite`, `Semestru`, `NrOreLaborator`, `NrOreCurs`, `NrOreSeminar`, `FormaDeExaminare`) VALUES ('"+this.denumireDisciplina+"','"+this.nrCredite+"','"+this.semestru+"','"+this.nrOreLaborator+"','"+this.nrOreSeminar+"','"+this.nrOreCurs+"','"+this.formaDeExaminare+"')";
				statement.execute(sql);
				sql="SELECT `CodDisciplina` FROM `disciplina` WHERE `DenumireDisciplina`=\""+this.denumireDisciplina+"\" AND `Semestru`=\""+this.semestru+"\"";
				ResultSet rs=statement.executeQuery(sql);
				rs.next();
				this.codDisciplina=rs.getInt("CodDisciplina");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		/**
		 *  Functia sterge o disciplina complet din baza de date; 
		 *  Functia creeaza o instructiune sql pe care o executa cu ajutorul unui statemant.
		 */
		public void stergeredisciplina(){
			try{
				Statement statement=Conexion.getInstance().getConnection().createStatement();
				String sql="DELETE FROM `disciplina` WHERE CodDisciplina='"+this.codDisciplina+"';";
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	/**
	 *  Functia primeste ca si parametru un obiect nou de tip disciplina si compara atribut cu atribut obiectul curent cu obiectul primit
	 *  ca parametru . Daca un atribut este diferit in obiectul parametru fata de obiectul curent atunci se executa o instructiune sql de 
	 *  update pentru campul respectiv.
	 * @param disciplina
	 */
		public void modificareDisciplina(Disciplina disciplina){
			try{
				Statement statement=Conexion.getInstance().getConnection().createStatement();
				String sql="UPDATE `disciplina` SET";
				if(this.codDisciplina != disciplina.getCodDisciplina())
					sql=sql+"`CodDisciplina`='"+disciplina.getCodDisciplina()+"',";
				if(this.denumireDisciplina != disciplina.getDenumireDisciplina())
					sql=sql+"`DenumireDisciplina`='"+disciplina.getDenumireDisciplina()+"',";
				if(this.nrCredite != disciplina.getNrCredite())
					sql=sql+"`NrCredite`='"+disciplina.getNrCredite()+"',";
				if(this.semestru != disciplina.getSemestru())
					sql=sql+"`Semestru`='"+disciplina.getSemestru()+"',";
				if(this.nrOreLaborator != disciplina.getNrOreLaborator())
					sql=sql+"`NrOreLaborator`='"+disciplina.getNrOreLaborator()+"',";
				if(this.nrOreSeminar != disciplina.getNrOreSeminar())
					sql=sql+"`NrOreSeminar`='"+disciplina.getNrOreSeminar()+"',";
				if(this.nrOreCurs != disciplina.getNrOreCurs())
					sql=sql+"`NrOreCurs`='"+disciplina.getNrOreCurs()+"',";
				if(this.formaDeExaminare != disciplina.getFormaDeExaminare())
					sql=sql+"`FormaDeExaminare`='"+disciplina.getFormaDeExaminare()+"',";
				int pozitievirgula=sql.lastIndexOf(',');
				sql=sql.substring(0, pozitievirgula);
				sql=sql+" WHERE `CodDisciplina`='"+this.codDisciplina+"';";
				Conexion.getInstance().logger.info(sql);
				statement.execute(sql);
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		public int getCodDisciplina() {
			return codDisciplina;
		}

		public String getDenumireDisciplina() {
			return denumireDisciplina;
		}

		public int getNrCredite() {
			return nrCredite;
		}

		public int getSemestru() {
			return semestru;
		}

		public int getNrOreLaborator() {
			return nrOreLaborator;
		}

		public int getNrOreCurs() {
			return nrOreCurs;
		}

		public int getNrOreSeminar() {
			return nrOreSeminar;
		}

		public String getFormaDeExaminare() {
			return formaDeExaminare;
		}

		@Override
		public String toString() {
			return "\nDisciplina: "+this.codDisciplina+" Denumirea: "+this.denumireDisciplina+" Credite: "+this.nrCredite+ " Semestrul: "+this.semestru+ " ore laborator: "+this.nrOreLaborator+" ore seminar: "+this.nrOreSeminar+" ore curs "+this.nrOreCurs+" Forma de examinare: "+this.formaDeExaminare;
		}
		@Override
		public boolean equals(Object o){
			if(o instanceof Disciplina){
				Disciplina d=(Disciplina)o;
				if(this.codDisciplina==d.getCodDisciplina() && this.denumireDisciplina.equals(d.getDenumireDisciplina()) && this.nrCredite==d.getNrCredite() && this.semestru==d.getSemestru() && this.nrOreLaborator==d.getNrOreLaborator() && this.nrOreSeminar==d.getNrOreSeminar() && this.nrOreCurs==d.getNrOreCurs() && this.formaDeExaminare.equals(d.getFormaDeExaminare()))
					return true;
				else
					return false;
						
			}
			else
				return false;
		}
		public Object clone(){
			return new Disciplina(codDisciplina,denumireDisciplina,nrCredite,semestru,nrOreLaborator
					,nrOreCurs,nrOreSeminar,formaDeExaminare);
			
		}

		public void setCodDisciplina(int codDisciplina) {
			this.codDisciplina = codDisciplina;
		}

		public void setDenumireDisciplina(String denumireDisciplina) {
			this.denumireDisciplina = denumireDisciplina;
		}

		public void setNrCredite(int nrCredite) {
			this.nrCredite = nrCredite;
		}

		public void setSemestru(int semestru) {
			this.semestru = semestru;
		}

		public void setNrOreLaborator(int nrOreLaborator) {
			this.nrOreLaborator = nrOreLaborator;
		}

		public void setNrOreCurs(int nrOreCurs) {
			this.nrOreCurs = nrOreCurs;
		}

		public void setNrOreSeminar(int nrOreSeminar) {
			this.nrOreSeminar = nrOreSeminar;
		}

		public void setFormaDeExaminare(String formaDeExaminare) {
			this.formaDeExaminare = formaDeExaminare;
		}
		
		
}
