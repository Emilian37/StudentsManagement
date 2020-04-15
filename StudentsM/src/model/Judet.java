package model;


/**
 * Enumeratie care contine toare judetele din Romania . Enumeratia are un constructor privat care primeste ca parametru un cod 
 * a judetului ( un nr de la 1 la 40 ) si denumirea judetului .
 * @author Emilian
 *
 */
public enum Judet{
ALBA(1,"ALBA"),
ARAD(2,"ARAD"),
ARGES(3,"ARGES"),
BACAU(4,"BACAU"),
BIHOR(5,"BIHOR"),
BISTRITA_NASAUD(6,"BISTRITA_NASAUD"),
BOTOSANI(7,"BOTOSANI"),
BRAILA(8,"BRAILA"),
BRASOV(9,"BRASOV"),
BUZAU(10,"BUZAU"),
CALARASI(11,"CALARASI"),
CARAS_SEVERIN(12,"CARAS_SEVERIN"),
CLUJ(13,"CLUJ"),
CONSTANTA(14,"CONSTANTA"),
COVASNA(15,"COVASNA"),
DIMBOVITA(16,"DIMBOVITA"),
DOLJ(17,"DOLJ"),
GALATI(18,"GALATI"),
GIURGIU(19,"GIURGIU"),
GORJ(20,"GORJ"),
HARGHITA(21,"HARGHITA"),
HUNEDOARA(22,"HUNEDOARA"),
IALOMITA(23,"IALOMITA"),
IASI(24,"IASI"),
ILFOV(25,"ILFOV"),
MARAMURES(26,"MARAMURES"),
MEHEDINTI(27,"MEHEDINTI"),
MURES(28,"MURES"),
NEAMT(29,"NEAMT"),
OLT(30,"OLT"),
PRAHOVA(31,"PRAHOVA"),
SALAJ(32,"SALAJ"),
SATU_MARE(33,"SATU_MARE"),
SIBIU(34,"SIBIU"),
SUCEAVA(37,"SUCEAVA"),
TELEORMAN(36,"TELEORMAN"),
TIMIS(35,"TIMIS"),
TULCEA(38,"TULCEA"),
VASLUI(39,"VASLUI"),
VILCEA(40,"VILCEA"),
VRANCEA(41,"VRANCEA");

private int cod;
private String nume;

private Judet(int cod,String nume){
	this.cod=cod;
	this.nume=nume;
}

  /**
   * 
   * @return codul judetului 
   */
public int getCod(){
	return cod;
}

/**
 * 
 * @param s denumirea judetului .
 * @return judetul pe baza denumiri acestuia data sub forma de string .
 */
public static Judet getJudet(String s){
	if(s.equals(ALBA.nume))
		return ALBA;
	else if(s.equals(ARAD.nume))
		return ARAD;
	else if(s.equals(ARGES.nume))
		return ARGES;
	else if(s.equals(BACAU.nume))
		return BACAU;
	else if(s.equals(BIHOR.nume))
		return BIHOR;
	else if(s.equals(BISTRITA_NASAUD.nume))
		return BISTRITA_NASAUD;
	else if(s.equals(BOTOSANI.nume))
		return BOTOSANI;
	else if(s.equals(BRAILA.nume))
		return BRAILA;
	else if(s.equals(BRASOV.nume))
		return BRASOV;
	else if(s.equals(BUZAU.nume))
		return BUZAU;
	else if(s.equals(CALARASI.nume))
		return CALARASI;
	else if(s.equals(CARAS_SEVERIN.nume))
		return CARAS_SEVERIN;
	else if(s.equals(CLUJ.nume))
		return CLUJ;
	else if(s.equals(CONSTANTA.nume))
		return CONSTANTA;
	else if(s.equals(COVASNA.nume))
		return COVASNA;
	else if(s.equals(DIMBOVITA.nume))
		return DIMBOVITA;
	else if(s.equals(DOLJ.nume))
		return DOLJ;
	else if(s.equals(GALATI.nume))
		return GALATI;
	else if(s.equals(GIURGIU.nume))
		return GIURGIU;
	else if(s.equals(GORJ.nume))
		return GORJ;
	else if(s.equals(HARGHITA.nume))
		return HUNEDOARA;
	else if(s.equals(IALOMITA.nume))
		return IALOMITA;
	else if(s.equals(IASI.nume))
		return IASI;
	else if(s.equals(ILFOV.nume))
		return ILFOV;
	else if(s.equals(MARAMURES.nume))
		return MARAMURES;
	else if(s.equals(MEHEDINTI.nume))
		return MEHEDINTI;
	else if(s.equals(MURES.nume))
		return MURES;
	else if(s.equals(NEAMT.nume))
		return NEAMT;
	else if(s.equals(OLT.nume))
		return OLT;
	else if(s.equals(PRAHOVA.nume))
		return PRAHOVA;
	else if(s.equals(SALAJ.nume))
		return SALAJ;
	else if(s.equals(SATU_MARE.nume))
		return SATU_MARE;
	else if(s.equals(SIBIU.nume))
		return SIBIU;
	else if(s.equals(SUCEAVA.nume))
		return SUCEAVA;
	else if(s.equals(TELEORMAN.nume))
		return TELEORMAN;
	else if(s.equals(TIMIS.nume))
		return TIMIS;
	else if(s.equals(TULCEA.nume))
		return TULCEA;
	else if(s.equals(VASLUI.nume))
		return VASLUI;
	else if(s.equals(VILCEA.nume))
		return VILCEA;
	else 
		return VRANCEA;
}

/**
 * 
 * @return o lista de siruri de caractere care contin denumirile tuturor judetelor.
 */
public static String[] judete(){
	String[] jud=new String[41];
	jud[0]=ALBA.toString();
	jud[1]=ARAD.toString();
	jud[2]=ARGES.toString();
	jud[3]=BACAU.toString();
	jud[4]=BIHOR.toString();
	jud[5]=BISTRITA_NASAUD.toString();
	jud[6]=BOTOSANI.toString();
	jud[7]=BRAILA.toString();
	jud[8]=BRASOV.toString();
	jud[9]=BUZAU.toString();
	jud[10]=CALARASI.toString();
	jud[11]=CARAS_SEVERIN.toString();
	jud[12]=CLUJ.toString();
	jud[13]=CONSTANTA.toString();
	jud[14]=COVASNA.toString();
	jud[15]=DIMBOVITA.toString();
	jud[16]=DOLJ.toString();
	jud[17]=GALATI.toString();
	jud[18]=GIURGIU.toString();
	jud[19]=GORJ.toString();
	jud[20]=HARGHITA.toString();
	jud[21]=HUNEDOARA.toString();
	jud[22]=IALOMITA.toString();
	jud[23]=IASI.toString();
	jud[24]=ILFOV.toString();
	jud[25]=MARAMURES.toString();
	jud[26]=MEHEDINTI.toString();
	jud[27]=MURES.toString();
	jud[28]=NEAMT.toString();
	jud[29]=OLT.toString();
	jud[30]=PRAHOVA.toString();
	jud[31]=SALAJ.toString();
	jud[32]=SATU_MARE.toString();
	jud[33]=SIBIU.toString();
	jud[34]=SUCEAVA.toString();
	jud[35]=TELEORMAN.toString();
	jud[36]=TIMIS.toString();
	jud[37]=TULCEA.toString();
	jud[38]=VASLUI.toString();
	jud[39]=VILCEA.toString();
	jud[40]=VRANCEA.toString();
	
	return jud;
}
}