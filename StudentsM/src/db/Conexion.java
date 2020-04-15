package db;
import java.sql.*;
import java.util.logging.Logger;

/**
 * 
 * @author Emilian
 * <p>Aceasta clasa realizeaza conexiunea la baza de date. 
 * Este o clasa de tip singleton care asigura unicitatea instantei si accesarea facila de oriunde. </p>
 */

public class Conexion {
	
	/**
	 * Pastreaza conexiunea efectiva la baza de date care poate crea statementuri care executa instructiuni SQL
	 */
	private Connection connection=null;
	/**
	 * Se pastreaza un Logger unic la nivel de aplicatie folosit in operatiile de debugging si de verificare a rularii.
	 */
	public static Logger logger=Logger.getAnonymousLogger();
	private static Conexion instance=null;
	
	/**
	 * Constructorul clasei Conexion este privat pentru a nu putea fi instantiat de la exterior 
	 */
	private Conexion(){
		String dataBase="jdbc:mysql://localhost/students";
		String user="root";
		String parola="";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dataBase, user, parola);
			if(connection!=null)
				logger.info("Conectiune reusita !!!!");
			else
				logger.info("Conexioune nereusita!!");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Conexion getInstance(){
		if(instance==null ){
			instance=new Conexion();
		}
		return instance;
	}
	
	/**
	 * <p>Functia este utilizata pentru a realiza legaturi efective la baza de date a aplicatie. Obiectele de tip <b>Connection</b> permit crearea de
	 * Satementuri, care executa instructiuni SQL</p>
	 * @return un obiect de tip <a href="https://docs.oracle.com/javase/7/docs/api/java/sql/Connection.html">Connection</a>
	 */
	public Connection getConnection(){
		return connection;
	}
	
}
