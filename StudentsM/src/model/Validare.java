package model;
import java.time.LocalDate;
import java.util.Arrays;

import db.Conexion;
import exception.CnpException;

/**
 * <p> Clasa care contine functii pentru validarea datelor introduse in diverse formulare din cadrul aplicatiei. <p>
 * @author Emilian
 *
 */
public class Validare {
	
	/**
	 * <p> Functia efectueaza o validare inteligenta a CNP-ului in functie date specifice studentului precum data nasterii care trebuie 
	 * sa se gaseasca in cnp, sexul si judetul acestuia. 
	 * @param cnp CNP-ul care trebuie validat. 
	 * @param dataNasterii data naserii studentului care trebuie sa regaseasca in CNP-ul lui. 
	 * @param sex genul care trebuie sa se regaseasca in CNP-ul acestuia. 
	 * @param judet judetul de domiciliu al studentului al carui cod se regaseste in cnpul acestuia.
	 * @return o valoare de adevar care ne spune daca cnp-ul este valid sau nu conform cu datele introduse
	 * @throws CnpException
	 */
	public static boolean cnpValid(long cnp,LocalDate dataNasterii,Sex sex,Judet judet) throws CnpException{
		boolean raspuns=true;
		
		int[] cifre=new int[13];
		long c=cnp;
		int i=12;
		while(c != 0 && i>=0){
			int u=(int)(c%10);
			c=c/10;
			cifre[i]=u;
			i--;
		}
		
		Conexion.logger.info("Cifre CNP: "+Arrays.toString(cifre));
		boolean conditieSex=(cifre[0]>=1 && cifre[0]<=9);
		if(conditieSex==false){
			CnpException e=new CnpException("Cifra sexului din CNP nu este in intervalul 1 - 9",cnp);
			throw e;
		}
		
		boolean conditieSex2=true;
		if(sex==Sex.Masculin)
			conditieSex2=(cifre[0]==1 || cifre[0]==3 || cifre[0]==5 || cifre[0]==7);
		
		if(sex==Sex.Feminin)
			conditieSex2=(cifre[0]==2 || cifre[0]==4 || cifre[0]==6);
		
		if(!conditieSex2){
			CnpException e=new CnpException("Sexul introdus nu coincide cu cel din CNP !",cnp);
			throw e;
		}
			
		int an=cifre[1]*10+cifre[2];
		if(cifre[0]==1 || cifre[0]==2)
			an=1900+an;
		else if(cifre[0]==3 || cifre[0]==4)
			an=1800+an;
		else if(cifre[0]==5 || cifre[0]==6)
			an=2000+an;
		else
			an=1900+an;
		 int luna=cifre[3]*10+cifre[4];
		 int zi=cifre[5]*10+cifre[6];
		 
		 LocalDate date=LocalDate.of(an, luna, zi);
		 boolean conditieDataNasterii=(date.equals(dataNasterii));
		 if(!conditieDataNasterii){
			CnpException e=new CnpException("Data Nasterii din CNP nu corespunde cu data nasterii introduse!",cnp);
			throw e;
		 }
		 
		 int jud=cifre[7]*10+cifre[8];
		 boolean conditieJudet=(jud>=1 && jud<=52);
		 if(!conditieJudet){
			CnpException e=new CnpException("Judetul introdus nu exista!",cnp);
		 	throw e;
		 }
		 
		 boolean conditieJudet2=(jud==judet.getCod());
		 if(!conditieJudet2){
			 CnpException e=new CnpException("Judetul din CNP nu corestunde cu judetul introdus",cnp);
			 throw e;
		 }
		 
		 /*int[] codDetector={2,7,9,1,4,6,3,5,8,2,7,9};
		 int suma=0;
		 for(i=0;i<11;i++){
			 suma=suma+(cifre[i]*codDetector[i]);
		 }
		int f=suma%11;
		boolean conditieCifraControl=(f==10)? (cifre[12]==1):(cifre[12]==f);
		
		if(!conditieCifraControl){
			CnpException e=new CnpException("Cifra de control din CNP nu este corecta ",cnp);
			throw e;
		}*/
		 
		return (conditieSex && conditieSex2 && conditieJudet && conditieJudet2);
	}
	
	public static void main(String[] args){
		//cnpValid(1234567891023l);
		
	}
	
}
