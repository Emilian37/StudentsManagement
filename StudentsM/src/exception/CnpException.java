package exception;

public class CnpException extends Exception {
	String mesaj;
	long cnp;
	
	public CnpException(String mesaj,long cnp){
		this.mesaj=mesaj;
		this.cnp=cnp;
	}
	public String getMessage(){
		return "Cnp: "+this.cnp+" invalid !! "+" motiv: "+mesaj;
	}

}
