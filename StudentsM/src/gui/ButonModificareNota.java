package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import db.Conexion;

/**
 * Aceasta clasa implementeaza comportamentul butonului care permite modificarea unei note.
 * Butonul implementeaza interfata Command intrucat efectueaza actiuni cu efect important asupra aplicatiei. 
 * @author Emilian
 *
 */
public class ButonModificareNota extends JButton implements Comanda{

	JComboBox cnpCombo;
	JComboBox disciplinaCombo;
	JTextField txtNota;
	JCheckBox rb;
	/**
	 * 
	 * @param cnp combobox-ul de unde se preia cnpul studentului la care vrem sa-i  modificam nota 
	 * @param d combobox-ul de unde se preia disciplina la care vrem sa-i  modificam nota 
	 * @param txt textfield-ul de unde se preia noua nota 
	 * @param rbb checkboxul care ne spune daca putem sau nu modifica nota
	 */
	public ButonModificareNota(JComboBox cnp,JComboBox d,JTextField txt,JCheckBox rbb) {
		super("Modifica NOTA");
		this.cnpCombo=cnp;
		this.disciplinaCombo=d;
		this.txtNota=txt;
		this.rb=rbb;
	}
	
	/**
	 * Functia identifica mai intai studentul pe baza cnp-ului, apoi se identifica codul disciplinei si in cele din urma se reactualizeaza nota 
	 * pe baza cnpului gasit si a codului de disciplina. 
	 */
	@Override
	public void executa() {
		long cnp=Long.parseLong(this.cnpCombo.getSelectedItem().toString());
		String denumireDisciplina=disciplinaCombo.getSelectedItem().toString();
		int codDisciplina=-1;
		try {
			Statement st=Conexion.getInstance().getConnection().createStatement();
			String sql1="SELECT `CodDisciplina` FROM `disciplina` WHERE `DenumireDisciplina`=\""+denumireDisciplina+"\"";
			ResultSet rs=st.executeQuery(sql1);
			rs.next();
			codDisciplina=rs.getInt("CodDisciplina");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(rb.isSelected()) {
			int nota=Integer.parseInt(this.txtNota.getText().trim());
			String sql="UPDATE `nota` SET `Nota`=\""+nota+"\" WHERE `CNP`=\""+cnp+"\" AND `CodDisciplina`=\""+codDisciplina+"\"";
			Conexion.logger.info(sql);
			try {
				Statement st=Conexion.getInstance().getConnection().createStatement();
				st.execute(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	

}
