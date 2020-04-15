package gui;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

/**
 * Clasa este folosita pentru a modela CheckBox-urile din panel-ul de modificare. CheckBoxurile sunt legate de text-field-uri si odata 
 * ce ele sunt bifate este permisa editarea textfield-ului asociat. Intrucat aceste checkbox-uri realizeaza actiuni cu efect notabil la 
 * nivelul aplicatiei, ele vor implementa interfata Command.  
 * @author Emilian
 *
 */
@SuppressWarnings("serial")
public class MyCheckBox extends JCheckBox implements Comanda{

	JTextField text;
	
	/**
	 * @param text un obiect de tip TextField care este asociat checkbox-ului curent 
	 */
	public MyCheckBox(JTextField text){
		this.text=text;
	}
	
	/**
	 * Functia modifica aspectul si comportamentul textfield-ului asociat. Daca CheckBox-ul este selectat atunci text-field-ul asociat va putea 
	 * fi editabil, iar in caz contrar nu este editabil.
	 */
	@Override
	public void executa() {
		if(this.isSelected())
			text.setEditable(true);
		else
			text.setEditable(false);
		
	}

}
