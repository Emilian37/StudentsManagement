package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import db.Conexion;
import model.Triplet;

/**
 * Aceasta clasa modeleaza tabelul care apare in panelul care permite vizualizarea notelor studentilor. Aceasta clasa nu este observator 
 * intrucat tabelul de note se incarca in mod distinct pentru fiecare student in parte. 
 * @author Emilian
 *
 */

@SuppressWarnings("serial")
public class NoteTableModel extends AbstractTableModel {
	
	// continutul 
	protected Object[][] rows;
	protected String[] columnNames = { "Denumire Disciplina","Sesiune","Nota"};
	
	protected ArrayList<Triplet<String,Integer,Integer>> note=new ArrayList<Triplet<String,Integer,Integer>>();
	
	/**
	 * Constructorul modelului tabelului de note actualizeaza continutul acestuia (rows) in functie de datele primite.
	 * @param n este o lista de triplete de date de tipul: string(numele disciplinei),int(numarul sesiunii), int (nota efectiva). 
	 */
	public NoteTableModel(ArrayList<Triplet<String,Integer,Integer>> n) {
		this.note=n;
		rows = new Object[note.size()][4];
		//System.out.println("--->>> " + products.size());
		for (int i = 0; i < note.size(); i++) {
			rows[i][0] = note.get(i).getA();
			rows[i][1] = int2Sesiune(note.get(i).getB());
			rows[i][2] = note.get(i).getC();
		}
	}
	
	/**
	 * 
	 * @param i numarul de ordine al sesiunii 
	 * @return un String care descrie sesiunea
	 */
	public String int2Sesiune(int i) {
		switch(i) {
		case 1:
			return "Iarna";
		case 2: 
			return "Vara";
		case 3: 
			return "Toamna";
		default:
			return "Speciala";
		}
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
		return note.size();
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
