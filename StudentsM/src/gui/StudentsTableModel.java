package gui;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

import db.Conexion;
import model.Observator;
import model.Student;
import model.Repozitory;

/**
 * <p> Aceasta clasa modeleaza continutul tabelului care este folosit in panelul care afiseaza toti studentii din baza de date.</p>
 * @author Emilian
 *
 */
public class StudentsTableModel extends AbstractTableModel implements Observator {

	private static final long serialVersionUID = 1L;
	protected Object[][] rows;
	protected String[] columnNames = { "CNP","Nume","Prenume","Data Nasterii","Sex" };
	protected ArrayList<Student> students = new ArrayList<Student>();

	// folosim un bloc de initializare care este apelat inainate de constructorul default fara parametri ai clasei 
	{
		students=Repozitory.getInstance().getStudenti();
		rows = new Object[students.size() + 1][6];
		//System.out.println("--->>> " + products.size());
		for (int i = 0; i < students.size(); i++) {
			rows[i][0] = students.get(i).getCNP();
			rows[i][1] = students.get(i).getNume();
			rows[i][2] = students.get(i).getPrenume();
			rows[i][3] = students.get(i).getData();
			rows[i][4] = students.get(i).getSex();
		}

	}


	/**
	 * Aceasta functie apare in aceasta clasa intrucat clasa reprezinta un observator al repositry-ului. Tabelul se actualizeaza ca 
	 * continut in functie de continutul listei de studenti a repository-ului. Functia update se duce la Repository, isi extrage din 
	 * acesta lista de studenti, si apoi isi inlocuieste matrice rows cu continutul reactulizat. 
	 */
	@Override
	public void update() {
		fireTableDataChanged();
		students=Repozitory.getInstance().getStudenti();
		rows = new Object[students.size() + 1][6];
		for (int i = 0; i < students.size(); i++) {
			rows[i][0] = students.get(i).getCNP();
			rows[i][1] = students.get(i).getNume();
			rows[i][2] = students.get(i).getPrenume();
			rows[i][3] = students.get(i).getData();
			rows[i][4] = students.get(i).getSex();
		}
		Conexion.logger.info("UPDATE model tabel studenti: "+Arrays.toString(rows));
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
	 * @return numarul de randuri ale tabelului, dat de numarul de studenti
	 */
	@Override
	public int getRowCount() {
		return students.size();
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
