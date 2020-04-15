package model;

/**
 *   <p> Se utilizeaza spre a fi implementata de catre orice observator. Observatori din aplicatia noastra sunt : 
 *   Combo CNP , ComboDisciplina , ComboDiscipline , ComboModificareDisciplina , ComboModificareNota, ComboStudenti, ComboStudenti2 , 
 *   ComboStudentiModificareNota , StudentsTable, StudentsTableModel </p>
 * @author Emilian
 */
 
 
public interface Observator {
	
	public void update();

}
