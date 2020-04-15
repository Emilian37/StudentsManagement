package gui;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import model.Observator;

/**
 * <p> Clasa redefineste un tabel conforma cu cerinntele noastre: un tabel trebuie sa isi modifice continutul, deci sa fie un observator.</p>
 * @author Emilian
 *
 */
@SuppressWarnings("serial")
public class StudentsTable extends JTable implements Observator {

	public StudentsTable(Object[][] a,String[] b) {
		super(a,b);
	}
	
	/**
	 * Functia permite resetarea modelului tabelului. 
	 * @param model noul continut al tabelului 
	 */
	public void setModel(StudentsTableModel model) {
		this.setModel(model);
	}
	
	/**
	 * Functia apare datorita implementarii interfetei Observer. 
	 * Tabelul trebuie sa se redeseneze dupa ce continutul acestuia s-a modificat. 
	 */
	@Override
	public void update() {
		this.setModel(dataModel);
		((AbstractTableModel)this.getModel()).fireTableDataChanged(); 
		repaint();
	}

}
