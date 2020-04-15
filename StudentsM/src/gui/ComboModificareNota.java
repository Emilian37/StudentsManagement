package gui;

import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.Nota;
import model.Observator;
import model.Repozitory;

/**
 * Acest combobox contine o lista de note ale unui student. 
 * @author Emilian
 *
 */
public class ComboModificareNota extends JComboBox<String> implements Comanda,Observator{
	
	static String[] note;
	static{
		note=new String[Repozitory.getInstance().getNote().size()];
		for(int i=0;i<Repozitory.getInstance().getNote().size();i++)
			note[i]=String.valueOf(Repozitory.getInstance().getNote().get(i).getCNP());
		
	}
	
	JTextField textModificareNotaCNP;
	JTextField textModificareNotaCodDisciplina;
	JTextField textModificareNotaPrezentare;
	JTextField textModificareNota;
	

	/**
	 * 
	 * @param textModificareNotaCNP
	 * @param textModificareNotaCodDisciplina
	 * @param textModificareNotaPrezentare
	 * @param textModificareNota
	 */
	public ComboModificareNota(JTextField textModificareNotaCNP, JTextField textModificareNotaCodDisciplina,
			JTextField textModificareNotaPrezentare, JTextField textModificareNota) {
		super(note);
		this.textModificareNotaCNP = textModificareNotaCNP;
		this.textModificareNotaCodDisciplina = textModificareNotaCodDisciplina;
		this.textModificareNotaPrezentare = textModificareNotaPrezentare;
		this.textModificareNota = textModificareNota;
	}

	@Override
	public void executa() {
		String elementAles=(String) this.getSelectedItem();
		Scanner scan=new Scanner(elementAles);
		long cnp=scan.nextLong();
		for(Nota n:Repozitory.getInstance().getNote()){
			if(cnp==(n.getCNP())){
				this.textModificareNotaCNP.setText(Long.toString(n.getCNP()));
				this.textModificareNotaCodDisciplina.setText(Integer.toString(n.getCodDisciplina()));
				this.textModificareNotaPrezentare.setText(Integer.toString(n.getPrezentare()));
				this.textModificareNota.setText(Integer.toString(n.getNota()));
				break;
			}
		}	
	}

	/**
	 * Functia este datorrata implementarii interfetei Observer. Ea permite reactulizarea permanenta a listei acestuia de note ale 
	 * studentilor. Lista este resetata cu lista obtinuta de la repository. 
	 */
	@Override
	public void update() {
		note=new String[Repozitory.getInstance().getNote().size()];
		for(int i=0;i<Repozitory.getInstance().getNote().size();i++)
			note[i]=String.valueOf(Repozitory.getInstance().getNote().get(i).getCNP());
		this.removeAll();
		for(String n: note)
			this.addItem(n);
		
	}

}
