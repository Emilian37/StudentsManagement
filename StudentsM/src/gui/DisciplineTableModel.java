package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import db.Conexion;
import model.Disciplina;
import model.Observator;
import model.Repozitory;

/**
 * Clasa contine modelul tabelului de discipline. Se implementeaza interfata Observer intrucat continutul tabelului de discipline se reactualizeaza 
 * in functie de continutul listei de discipline a Repository-ului. Clasa foloseste un bloc de initializare si nu constructor default.
 * @author Emilian
 *
 */

@SuppressWarnings("serial")
public class DisciplineTableModel extends AbstractTableModel implements Observator {

	protected Object[][] rows;
	protected String[] columnNames = { "Cod","Denumire","Nr Credite","Semestru","Ore Lab","Ore Curs","Ore Seminar","Examinare" };
	protected ArrayList<Disciplina> discipline = new ArrayList<Disciplina>();

	{
		discipline=Repozitory.getInstance().getDiscipline();
		rows = new Object[discipline.size()][9];
		for (int i = 0; i < discipline.size(); i++) {
			rows[i][0] = discipline.get(i).getCodDisciplina();
			rows[i][1] = discipline.get(i).getDenumireDisciplina();
			rows[i][2] = discipline.get(i).getNrCredite();
			rows[i][3] = discipline.get(i).getSemestru();
			rows[i][4] = discipline.get(i).getNrOreLaborator();
			rows[i][5]=discipline.get(i).getNrOreCurs();
			rows[i][6]=discipline.get(i).getNrOreSeminar();
			rows[i][7]=discipline.get(i).getFormaDeExaminare();
		}

	}
	
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Functie care apare datorita mostenirii lui AbstractTableModel. 
	 * @return o matrice de obiecte care este de fapt continutul tabelului.
	 */
	public Object[][] getRows() {
		return rows;
	}

	/**
	 * Functie care apare datorita mostenirii lui AbstractTableModel. 
	 * @param rows noul continut 
	 */
	public void setRows(Object[][] rows) {
		this.rows = rows;
	}

	/**
	 * Functie care apare datorita mostenirii lui AbstractTableModel. 
	 * Functia returneaza antetul tabelului (celule cu denumirile coloanelor). 
	 * @return un vector de obiecte de tip String care contin numele coloanelor din tabel 
	 */
	public String[] getColumnNames() {
		return columnNames;
	}

	/**
	 * Functie care apare datorita mostenirii lui AbstractTableModel. 
	 * Functia modifica antetul tabelului. 
	 * @param columnNames noile denumiri de coloane 
	 */
	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	/**
	 * Functie care apare datorita mostenirii lui AbstractTableModel. 
	 * @return numarul de coloane care apar in antet
	 */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * Functie care apare datorita mostenirii lui AbstractTableModel. 
	 * @return numarul de randuri ale tabelului, dat de numarul de discipline
	 */
	@Override
	public int getRowCount() {
		return discipline.size();
	}

	/**
	 * Functie care apare datorita mostenirii lui AbstractTableModel. 
	 * Functia este folosita pentru a obtine valoarea unei celule din tabel pe baza liniei si a coloanei. 
	 */
	@Override
	public Object getValueAt(int row, int col) {
		return rows[row][col];
	}
	
	/**
	 * Functie care apare datorita mostenirii lui AbstractTableModel. 
	 * Tabelul nu contine nici o celula editabila. 
	 */
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	/**
	 * Functia este folosita pentru a notifica obiectul JTAble ca continutul sau (modelul) s-a modifficat.
	 */
	public void fireTableDataChanged() {
		Conexion.logger.info("FIRE!");
		super.fireTableDataChanged();
	}

}
