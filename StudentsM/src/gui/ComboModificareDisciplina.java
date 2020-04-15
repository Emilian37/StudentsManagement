package gui;

import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.Disciplina;
import model.Observator;
import model.Repozitory;

/**
 * Aceasta clasa apare in panelul de modificare disciplina. Acest combo incarca o serie de text-field-uri cu datele care descriu o disciplina, 
 * textfield-uri ce urmeaza a fi modificate doar daca check-box alaturat a fost selectat. 
 * @author Emilian
 *
 */
public class ComboModificareDisciplina extends JComboBox implements Observator,Comanda{
	
	JTextField textModificareCod;
	JTextField textModificareDenumire;
	JTextField textModificareNrCredite;
	JTextField textModificareSemestru;
	JTextField textModificareOreLab;
	JTextField textModificareOreCurs;
	JTextField textModificareOreSeminar;
	JTextField textModfificareFormaEx;
	
	static String[] discipline;
	static{
		discipline=new String[Repozitory.getInstance().getDiscipline().size()];
		for(int i=0;i<Repozitory.getInstance().getDiscipline().size();i++){
			discipline[i]=Repozitory.getInstance().getDiscipline().get(i).getDenumireDisciplina();
		}
	}
	
	/**
	 * Constructorul primeste ca parametrii toate textfield-urile in care incarca date. 
	 * @param textModificareCod camp de text care incarca codul disciplinei
	 * @param textModificareDenumire camp de text care incarca denumirea disciplinei
	 * @param textModificareNrCredite camp de text care incarca numarul de credite ale disciplinei
	 * @param textModificareSemestru camp de text care incarca semestrul disciplinei
	 * @param textModificareOreLab camp de text care incarca numarul de ore de laborator a disciplinei
	 * @param textModificareOreCurs camp de text care incarca numarul de ore de curs a disciplinei
	 * @param textModificareOreSeminar camp de text care incarca numarul de ore de seminar a disciplinei
	 * @param textModfificareFormaEx camp de text care incarca forma de examinare a disciplinei
	 */
	@SuppressWarnings("unchecked")
	public ComboModificareDisciplina(JTextField textModificareCod, JTextField textModificareDenumire,
			JTextField textModificareNrCredite, JTextField textModificareSemestru, JTextField textModificareOreLab,
			JTextField textModificareOreCurs, JTextField textModificareOreSeminar, JTextField textModfificareFormaEx) {
		super(discipline);
		this.textModificareCod = textModificareCod;
		this.textModificareDenumire = textModificareDenumire;
		this.textModificareNrCredite = textModificareNrCredite;
		this.textModificareSemestru = textModificareSemestru;
		this.textModificareOreLab = textModificareOreLab;
		this.textModificareOreCurs = textModificareOreCurs;
		this.textModificareOreSeminar = textModificareOreSeminar;
		this.textModfificareFormaEx = textModfificareFormaEx;
	}

	/**
	 * Functia se datoreaza implemntarii interfeti Command. Functia incarca in textfield-uri care sunt initial needitabile detalii despre disciplina
	 * care tocmai a fost selectata. 
	 */
	@Override
	public void executa() {
		String elementAles=(String)this.getSelectedItem();
		Scanner scan=new Scanner(elementAles);
		String nume=scan.next();
		for(Disciplina s:Repozitory.getInstance().getDiscipline()){
			if(nume.equals(s.getDenumireDisciplina())){
				this.textModificareCod.setText(Integer.toString(s.getCodDisciplina()));
				this.textModificareDenumire.setText(nume);
				this.textModificareNrCredite.setText(Integer.toString(s.getNrCredite()));
				this.textModificareSemestru.setText(Integer.toString(s.getSemestru()));
				this.textModificareOreSeminar.setText(Integer.toString(s.getNrOreSeminar()));
				this.textModificareOreCurs.setText(Integer.toString(s.getNrOreCurs()));
				this.textModificareOreLab.setText(Integer.toString(s.getNrOreLaborator()));
				this.textModfificareFormaEx.setText(s.getFormaDeExaminare());
				break;
			}
				
		}
		scan.close();
		
	}

	/**
	 * Functia se datoreaza implentarii interfetei Observer. Ea sterge lista de denumiri de disciplina, si inarca apoi element cu element noua lista 
	 * de denumiri de disciplina care tocmai a prealut-o de la Repository. 
	 */
	@Override
	public void update() {
		discipline=new String[Repozitory.getInstance().getDiscipline().size()];
		for(int i=0;i<Repozitory.getInstance().getDiscipline().size();i++){
			discipline[i]=Repozitory.getInstance().getDiscipline().get(i).getDenumireDisciplina();
		}
		
		this.removeAll();
		for(String d:discipline) {
			this.addItem(d);
		}
	}
	
	
	
}
