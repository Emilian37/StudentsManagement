package model;

/**
 * <img src="https://en.wikipedia.org/wiki/Observer_pattern#/media/File:W3sDesign_Observer_Design_Pattern_UML.jpg">
 * <p> Se utilizeaza spre a fi implementata de catre orice subiect. Trebuie sa aibe functii pentru adaugare/stergere de observatori, 
 * respectiv notificarea tuturor observatorilor. Ub subiect trebuie de asemenea sa aibe o lista de observatori. </p>
 * @author Emilian
 * 
 *
 */

public interface Subject {
	
	/**
	 * Se anunta toti observatorii de modificare. 
	 */
	public void notifyAllOb();
	
	/**
	 * <p> Se adauga un nou observator in lista de observatori ai subiectului. </p>
	 * @param obs un biect care implementeaza interfata Observer. 
	 */
	public void addObservator(Observator obs);
	
	/**
	 * <p> Se sterge un observator in lista de observatori ai subiectului. </p>
	 * @param obs un biect care implementeaza interfata Observer. 
	 */
	public void remmoveObservator(Observator obs);

}
