package gui;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import javax.swing.JTextField;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import model.Judet;
import model.Repozitory;


@SuppressWarnings("serial")
public class Interfata extends JFrame implements ActionListener {
	JPanel mainPanel;
	JTabbedPane tabbedPane;
	JComponent panelComponent1;
	JComponent panelComponent2;
	JComponent panelComponent3;
	JComponent panelComponent4;
	JComponent panelComponent5;
	JComponent panelComponent6;
	JComponent panelComponent7;
	JComponent panelComponent8;
	JComponent panelComponent9;
	JComponent panelComponent10;
	
	
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JPanel panel41;  //panel buton Inserare Student
	JLabel labelNume;
	JLabel labelPrenume;
	JLabel labelCNP;
	JLabel labelDataNasterii;
	JLabel labelSex;
	
	JLabel labelAdresaStrada;
	JLabel labelAdresaNr;
	JLabel labelAdresaBloc;
	JLabel labelAdresaAp;
	JLabel labelAdresaJudet;
	JLabel labelAdresaOras;
	
	JTextField textInserare1;
	JTextField textInserare2;
	JTextField textInserare3;
	JDatePickerImpl textInserare4;
	JRadioButton SexM;
	JRadioButton SexF;
	
	JTextField textAdresaStrada;
	JTextField textAdresaNr;
	JTextField textAdresaBloc;
	JTextField textAdresaAp;
	JComboBox comboBoxJudet;  //ComboBox
	JTextField textAdresaOras;
	
	JPanel panel52;
	JPanel panel53;
	JPanel panel54;
	JPanel panel55;
	JPanel panel56;
	JPanel panel57;
	
	//Buton INSERARE STUDENT
	ButonInserareStudent butonInserareStudent;
	
	JPanel panel6;
	JPanel panel7;
	JPanel panel8;
	JPanel panel9;
	JPanel panel10;
	JPanel panel11;
	JPanel panel12;
	JPanel panel13;
	JPanel panel42; //panel buton inserare Disciplina
	JLabel labelCodDisciplina;
	JLabel labelDenumireDisciplina;
	JLabel labelNrCredite;
	JLabel labelSemestru;
	JLabel labelNrOreLaborator;
	JLabel labelNrOreCurs;
	JLabel labelNrOreSeminar;
	JLabel labelFormaExaminare;
	JTextField textDisciplina1;
	JTextField textDisciplina2;
	JTextField textDisciplina3;
	JTextField textDisciplina4;
	JTextField textDisciplina5;
	JTextField textDisciplina6;
	JTextField textDisciplina7;
	JTextField textDisciplina8;
	//Buton Inserare DIsciplina
	ButonInserareDisciplina butonInserareDisciplina;
	
	
	JPanel panel14;
	JPanel panel22; //revenim cu panel din nou la inserare Nota
	JPanel panel23;
	JPanel panel24;
	JPanel panel43; //panel buton inserare Nota
	JLabel labelCodDisciplina1;
	JLabel labelDisciplina;
	JLabel labelInserareCNP;
	JLabel labelStudent;
	JLabel labelInserarePrezentare;
	JLabel labelInserareNota;
	ComboDiscipline comboDiscipline;
	ComboCNP comboCNP;
	JComboBox<String> prezentare;
	JTextField textInserareNota;
	//Buton inserare nota
	ButonInserareNota butonInserareNota;
	
	//MOdificare Strudent
	JPanel panel15;
	JPanel panel16;
	JPanel panel17;
	JPanel panel18;
	JPanel panel19;
	JPanel panel20;
	JPanel panel21;
	JPanel panel44; //panel buton modificare student
	JLabel labelModificare1;
	ComboStudenti comboModificareStudent; //comboSelectieModificareStudent		
	
	MyCheckBox cbxNume;
	MyCheckBox cbxPrenume;
	MyCheckBox cbxCNP;
	JCheckBox cbxDataNasterii;
	JCheckBox cbxSex;
	JLabel labelModificareNume;
	JLabel labelModificarePrenume;
	JLabel labelModificareCNP;
	JLabel labelModificareData;
	JLabel labelModificareSex;
	JTextField textModificareNume;
	JTextField textModificarePrenume;
	JTextField textModificareCNP;
	JDatePickerImpl textModificareData;
	JRadioButton butonSexM;
	JRadioButton butonSexF;
	//buton modificare Student
	ButonModificareStudent butonModificareStudent;
	
	//Modificare Disciplina
	JPanel panel25;
	JPanel panel26;
	JPanel panel27;
	JPanel panel28;
	JPanel panel29;
	JPanel panel30;
	JPanel panel31;
	JPanel panel32;
	JPanel panel33;
	JPanel panel34;
	JPanel panel45; //panel buton modificare disciplina
	
	JLabel labelModificareDisciplina;
	ComboModificareDisciplina comboModificareDisciplina;
	MyCheckBox cbxCodDisciplina;
	MyCheckBox cbxDenumireDisciplina;
	MyCheckBox cbxNrCredite;
	MyCheckBox cbxSemestru;
	MyCheckBox cbxOreLaborator;
	MyCheckBox cbxOreCurs;
	MyCheckBox cbxOreSeminar;
	MyCheckBox cbxFormaDeExaminare;
	JLabel labelModificareCod;
	JLabel labelModificareDenumireDisciplina;
	JLabel labelModificareNrCredite;
	JLabel labelModificareSemestru;
	JLabel labelModificareOreLaborator;
	JLabel labelModificareOreCurs;
	JLabel labelModificareOreSeminar;
	JLabel labelModificareFormaDeExaminare;
	JTextField textModificareCod;
	JTextField textModificareDenumireDisciplina;
	JTextField textModificareNrCredite;
	JTextField textModificareSemestru;
	JTextField textModificareOreLaborator;
	JTextField textModificareOreCurs;
	JTextField textModificareOreSeminar;
	JTextField textModificareFormaDeExaminare;
	//buton modificare disciplina
	ButonModificareDisciplina butonModificareDisciplina;
	
	//Modificare Nota
	
	JPanel panel35;
	JPanel panel36;
	JPanel panel37;
	JPanel panel38;
	JPanel panel39;
	JPanel panel40;
	JPanel panel46; //panel buton modificare Nota
	JLabel labelModificareNota;
	
	ComboStudentiModificareNota comboStudentiNota;
	JLabel labelInfo;
	ComboDisciplina comboDisciplina;
	
	JLabel labelInfoDenumire;
	JTextField textInfo1;
	JTextField textInfo2;
	JTextField textInfo3;
	
	JCheckBox cbxNotaCNP;
	//JCheckBox cbxNotaCodDisciplina;
	//JCheckBox cbxNotaPrezentare;
	MyCheckBox cbxNota;
	JLabel labelModificareNotaCNP;
	JLabel labelModificareNotaCodDisciplina;
	JLabel labelModificareNotaPrezentare;
	JLabel labelModificareNota1;
	JTextField textModificareNotaCNP;
	JTextField textModificareNotaCodDisciplina;
	JTextField textModificareNotaPrezentare;
	JTextField textModificareNota;
	//buton modificare NOTA
	ButonModificareNota butonModificareNota;
	
	JPanel panel47;
	JPanel panel48;
	JLabel labelStergereStudent;
	JComboBox comboStergere;
	
	
	JPanel panel49;
	StudentsTable tabelVizualizareStudenti;
	
	JPanel panel50;
	JTable tabelVizualizareDiscipline;
	
	JPanel panel51;
	JLabel labelStudent2;
	ComboStudenti2 comboStudenti2;
	JTable tabelVizualizareNote;
	
	public Interfata(){
		mainPanel=new JPanel();
		tabbedPane=new JTabbedPane();
		panelComponent1=new JPanel();
		tabbedPane.addTab("Inserare Student",null,panelComponent1,"Insereaza Student");
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		panel5=new JPanel();
		panel6=new JPanel();
		panel7=new JPanel();
		panel8=new JPanel();
		panel9=new JPanel();
		panel10=new JPanel();
		panel11=new JPanel();
		panel12=new JPanel();
		panel13=new JPanel();
		panel14=new JPanel();
		panel15=new JPanel();
		panel16=new JPanel();
		panel17=new JPanel();
		panel18=new JPanel();
		panel19=new JPanel();
		panel20=new JPanel();
		panel21=new JPanel();
		panel22=new JPanel();
		panel23=new JPanel();
		panel24=new JPanel();
		panel25=new JPanel();
		panel26=new JPanel();
		panel27=new JPanel();
		panel28=new JPanel();
		panel29=new JPanel();
		panel30=new JPanel();
		panel31=new JPanel();
		panel32=new JPanel();
		panel33=new JPanel();
		panel34=new JPanel();
		panel35=new JPanel();
		panel36=new JPanel();
		panel37=new JPanel();
		panel38=new JPanel();
		panel39=new JPanel();
		panel40=new JPanel();
		panel41=new JPanel();
		panel42=new JPanel();
		panel43=new JPanel();
		panel44=new JPanel();
		panel45=new JPanel();
		panel46=new JPanel();
		panel47=new JPanel();
		panel48=new JPanel();
		panel49=new JPanel();
		panel50=new JPanel();
		panel51=new JPanel();
		
		panel52=new JPanel();
		panel53=new JPanel();
		panel54=new JPanel();
		panel55=new JPanel();
		panel56=new JPanel();
		panel57=new JPanel();
		
		labelNume=new JLabel("NUME:");
		textInserare1=new JTextField(10);
		textInserare1.setEditable(true);
		panel1.add(labelNume);
		panel1.add(textInserare1);
		
		
		labelPrenume=new JLabel("Prenume");
		textInserare2=new JTextField(10);
		textInserare2.setEditable(true);
		panel2.add(labelPrenume);
		panel2.add(textInserare2);
		
		
		labelCNP=new JLabel("Introduceti CNP");
		textInserare3=new JTextField(12);
		textInserare3.setEditable(true);
		panel3.add(labelCNP);
		panel3.add(textInserare3);
		
		labelDataNasterii=new JLabel("Introduceti data nasterii");
		
		 UtilDateModel model = new UtilDateModel();
		 LocalDate date=LocalDate.now();
	     model.setDate(date.getYear(),date.getMonthValue()-1, date.getDayOfMonth());
	     model.setSelected(true);
	     
	     Properties p=new Properties();
	     p.put("text.today", "Azi");
	     p.put("text.month", "Luna");
	     p.put("text.year", "An");
	     JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
	     textInserare4 = new JDatePickerImpl(datePanel,null);
		panel4.add(labelDataNasterii);
		panel4.add(textInserare4);
		
		labelSex=new JLabel("Introduceti Sexul Studentului");
		SexM=new JRadioButton("Masculin");
		SexM.setSelected(true);
		SexF=new JRadioButton("Feminin");
		ButtonGroup g=new ButtonGroup();
		g.add(SexM);
		g.add(SexF);
		panel5.add(labelSex);
		panel5.add(SexM);
		panel5.add(SexF);
		
		labelAdresaStrada=new JLabel("Strada:");
		textAdresaStrada=new JTextField(10);
		textAdresaStrada.setEditable(true);
		panel52.add(labelAdresaStrada);
		panel52.add(textAdresaStrada);
		
		labelAdresaNr=new JLabel("Numar: ");
		textAdresaNr=new JTextField(5);
		textAdresaNr.setEditable(true);
		panel53.add(labelAdresaNr);
		panel53.add(textAdresaNr);
		
		labelAdresaBloc=new JLabel("Bloc ");
		textAdresaBloc=new JTextField(3);
		textAdresaBloc.setEditable(true);
		panel54.add(labelAdresaBloc);
		panel54.add(textAdresaBloc);
		
		labelAdresaAp=new JLabel("Apartament");
		textAdresaAp=new JTextField(3);
		textAdresaAp.setEditable(true);
		panel55.add(labelAdresaAp);
		panel55.add(textAdresaAp);
		
		comboBoxJudet=new JComboBox(Judet.judete());
		panel56.add(comboBoxJudet);
		
		labelAdresaOras=new JLabel("Oras");
		textAdresaOras=new JTextField(10);
		panel57.add(labelAdresaOras);
		panel57.add(textAdresaOras);
			
		
		butonInserareStudent=new ButonInserareStudent(textInserare1,textInserare2,textInserare3,textInserare4,SexM,SexF,textAdresaStrada,textAdresaNr,textAdresaBloc,textAdresaAp,comboBoxJudet,textAdresaOras);
		butonInserareStudent.setText("INSERARE STUDENT");
		panel41.add(butonInserareStudent);
		butonInserareStudent.addActionListener(this);
		
		panelComponent1.add(panel1);
		panelComponent1.add(panel2);
		panelComponent1.add(panel3);
		panelComponent1.add(panel4);
		panelComponent1.add(panel5);
		panelComponent1.add(panel52);
		panelComponent1.add(panel53);
		panelComponent1.add(panel54);
		panelComponent1.add(panel55);
		panelComponent1.add(panel56);
		panelComponent1.add(panel57);
		panelComponent1.add(butonInserareStudent);
		panelComponent1.setLayout(new BoxLayout(panelComponent1,BoxLayout.Y_AXIS));
		
		
		panelComponent2=new JPanel();
		tabbedPane.addTab("Inserare Disciplina",null,panelComponent2,"Insereaza Disciplina");
		
		labelCodDisciplina=new JLabel("Codul DIsciplinei");
		textDisciplina1=new JTextField(10);
		textDisciplina1.setEditable(false);
		panel6.add(labelCodDisciplina);
		panel6.add(textDisciplina1);
		
		labelDenumireDisciplina=new JLabel("Denumirea Disciplinei: ");
		textDisciplina2=new JTextField(10);
		textDisciplina2.setEditable(true);
		panel7.add(labelDenumireDisciplina);
		panel7.add(textDisciplina2);
		
		labelNrCredite=new JLabel("NUmar de Credite: ");
		textDisciplina3=new JTextField(10);
		textDisciplina3.setEditable(true);
		panel8.add(labelNrCredite);
		panel8.add(textDisciplina3);
		
		labelSemestru=new JLabel("Semestrul: ");
		textDisciplina4=new JTextField(10);
		textDisciplina4.setEditable(true);
		panel9.add(labelSemestru);
		panel9.add(textDisciplina4);
		
		labelNrOreLaborator=new JLabel("Nr Ore Laborator: ");
		textDisciplina5=new JTextField(10);
		textDisciplina5.setEditable(true);
		panel10.add(labelNrOreLaborator);
		panel10.add(textDisciplina5);
		
		labelNrOreCurs=new JLabel("Nr Ore Curs: ");
		textDisciplina6=new JTextField(10);
		textDisciplina6.setEditable(true);
		panel11.add(labelNrOreCurs);
		panel11.add(textDisciplina6);
		
		labelNrOreSeminar=new JLabel("Nr Ore Seminar: ");
		textDisciplina7=new JTextField(10);
		textDisciplina7.setEditable(true);
		panel12.add(labelNrOreSeminar);
		panel12.add(textDisciplina7);
		
		labelFormaExaminare=new JLabel("Forma de Examinare ");
		textDisciplina8=new JTextField(10);
		textDisciplina8.setEditable(true);
		panel13.add(labelFormaExaminare);
		panel13.add(textDisciplina8);
		
		butonInserareDisciplina=new ButonInserareDisciplina(textDisciplina2,textDisciplina3,
					textDisciplina4,textDisciplina5,textDisciplina6,textDisciplina7,textDisciplina8);
		butonInserareDisciplina.setText("INSERARE DISCIPLINA");
		panel42.add(butonInserareDisciplina);
		butonInserareDisciplina.addActionListener(this);
		
		
		panelComponent2.add(panel6);
		panelComponent2.add(panel7);
		panelComponent2.add(panel8);
		panelComponent2.add(panel9);
		panelComponent2.add(panel10);
		panelComponent2.add(panel11);
		panelComponent2.add(panel12);
		panelComponent2.add(panel13);
		panelComponent2.add(panel42);
		panelComponent2.add(butonInserareDisciplina);
		panelComponent2.setLayout(new BoxLayout(panelComponent2,BoxLayout.Y_AXIS));
		
		panelComponent3=new JPanel();
		tabbedPane.addTab("Inserare Nota",null,panelComponent3,"Insereaza Nota");
		
		labelInserareCNP=new JLabel("CNP");
		labelStudent=new JLabel();
		labelStudent.setSize(new Dimension(50,15));
		comboCNP=new ComboCNP(labelStudent);
		comboCNP.addActionListener(this);
		Repozitory.getInstance().addObservator(comboCNP);
		panel22.add(labelInserareCNP);
		panel22.add(comboCNP);
		panel22.add(labelStudent);
		
		labelCodDisciplina1=new JLabel("Codul Disciplinei ");
		labelDisciplina=new JLabel();
		labelDisciplina.setSize(new Dimension(50,20));
		comboDiscipline=new ComboDiscipline(labelDisciplina);
		Repozitory.getInstance().addObservator(comboDiscipline);
		comboDiscipline.addActionListener(this);
		panel14.add(labelCodDisciplina1);
		panel14.add(comboDiscipline);
		panel14.add(labelDisciplina);
		
		labelInserarePrezentare=new JLabel("Prezentarea");
		prezentare=new JComboBox<String>(new String[]{"Iarna-1","Vara-2","Toamna-3","Speciala-4"});
		panel23.add(labelInserarePrezentare);
		panel23.add(prezentare);
		
		labelInserareNota=new JLabel("Nota");
		textInserareNota=new JTextField(2);
		textInserareNota.setEditable(true);
		panel24.add(labelInserareNota);
		panel24.add(textInserareNota);
		
		butonInserareNota=new ButonInserareNota(comboCNP,comboDiscipline,prezentare,textInserareNota);
		butonInserareNota.setText("INSERARE NOTA");
		panel43.add(butonInserareNota);
		butonInserareNota.addActionListener(this);
		
		
		panelComponent3.add(panel14);
		panelComponent3.add(panel22);
		panelComponent3.add(panel23);
		panelComponent3.add(panel24);
		panelComponent3.add(panel43);		
		panelComponent3.setLayout(new BoxLayout(panelComponent3,BoxLayout.Y_AXIS));
		
		panelComponent4=new JPanel();
		tabbedPane.addTab("Modificare Student",null,panelComponent4,"Modificare Nota");
		
		labelModificare1=new JLabel("MODIFICARE STUDENT");
		panel15.add(labelModificare1);
		
		
		
		labelModificareNume=new JLabel("Nume");
		textModificareNume=new JTextField(15);
		cbxNume=new MyCheckBox(textModificareNume);
		cbxNume.addActionListener(this);
		textModificareNume.setEditable(false);
		panel17.add(cbxNume);
		panel17.add(labelModificareNume);
		panel17.add(textModificareNume);
		
		
		labelModificarePrenume=new JLabel("Prenume");
		textModificarePrenume=new JTextField(15);
		cbxPrenume=new MyCheckBox(textModificarePrenume);
		cbxPrenume.addActionListener(this);
		textModificarePrenume.setEditable(false);
		panel18.add(cbxPrenume);
		panel18.add(labelModificarePrenume);
		panel18.add(textModificarePrenume);
		
		
		labelModificareCNP=new JLabel("CNP");
		textModificareCNP=new JTextField(15);
		cbxCNP=new MyCheckBox(textModificareCNP);
		cbxCNP.addActionListener(this);
		textModificareCNP.setEditable(false);
		panel19.add(cbxCNP);
		panel19.add(labelModificareCNP);
		panel19.add(textModificareCNP);
		
		
		labelModificareData=new JLabel("Data Nasterii");
		
		 UtilDateModel model2 = new UtilDateModel();
		 LocalDate date2=LocalDate.now();
	     model2.setDate(date.getYear(),date.getMonthValue()-1, date.getDayOfMonth());
	     model2.setSelected(true);
	    
	     JDatePanelImpl datePanel2 = new JDatePanelImpl(model2,p);
	     
		textModificareData= new JDatePickerImpl(datePanel2,null);;
		cbxDataNasterii=new JCheckBox();
		panel20.add(cbxDataNasterii);
		panel20.add(labelModificareData);
		panel20.add(textModificareData);
		
		cbxSex=new JCheckBox();
		labelModificareSex=new JLabel("Sex");
		butonSexM=new JRadioButton("Masculin");
		butonSexF=new JRadioButton("Ferminin");
		ButtonGroup group=new ButtonGroup();
		group.add(butonSexF);
		group.add(butonSexM);
		
		comboModificareStudent=new ComboStudenti(textModificareNume,textModificarePrenume,textModificareCNP,butonSexM,butonSexF,textModificareData);	
		panel16.add(comboModificareStudent);
		comboModificareStudent.addActionListener(this);
		Repozitory.getInstance().addObservator(comboModificareStudent);
		panel21.add(cbxSex);
		panel21.add(labelModificareSex);
		panel21.add(butonSexM);
		panel21.add(butonSexF);
		
		butonModificareStudent=new ButonModificareStudent(comboModificareStudent,cbxNume,textModificareNume,cbxPrenume,textModificarePrenume,
				cbxCNP,textModificareCNP,cbxDataNasterii,textModificareData,cbxSex,butonSexM,butonSexF);
		butonModificareStudent.addActionListener(this);
		panel44.add(butonModificareStudent);
		
		
		panelComponent4.add(panel15);
		panelComponent4.add(panel16);
		panelComponent4.add(panel17);
		panelComponent4.add(panel18);
		panelComponent4.add(panel19);
		panelComponent4.add(panel20);
		panelComponent4.add(panel21);
		panelComponent4.add(panel44);
		panelComponent4.setLayout(new BoxLayout(panelComponent4,BoxLayout.Y_AXIS));
		
		panelComponent5=new JPanel();
		tabbedPane.addTab("Modificare disciplina",null,panelComponent5,"Modificare Disciplina");
		
		labelModificareDisciplina=new JLabel("Modificare Disciplina");
		panel25.add(labelModificareDisciplina);
		
		
		labelModificareCod=new JLabel("Cod Disciplina");
		textModificareCod=new JTextField(15);
		textModificareCod.setEditable(false);
		cbxCodDisciplina=new MyCheckBox(textModificareCod);
		cbxCodDisciplina.addActionListener(this);
		panel27.add(cbxCodDisciplina);
		panel27.add(labelModificareCod);
		panel27.add(textModificareCod);
		
		
		labelModificareDenumireDisciplina=new JLabel("Denumire Disciplina");
		textModificareDenumireDisciplina=new JTextField(15);
		textModificareDenumireDisciplina.setEditable(false);
		cbxDenumireDisciplina=new MyCheckBox(textModificareDenumireDisciplina);
		cbxDenumireDisciplina.addActionListener(this);
		panel28.add(cbxDenumireDisciplina);
		panel28.add(labelModificareDenumireDisciplina);
		panel28.add(textModificareDenumireDisciplina);
		
		
		labelModificareNrCredite=new JLabel("Numar de Credite");
		textModificareNrCredite=new JTextField(2);
		textModificareNrCredite.setEditable(false);
		cbxNrCredite=new MyCheckBox(textModificareNrCredite);
		cbxNrCredite.addActionListener(this);
		panel29.add(cbxNrCredite);
		panel29.add(labelModificareNrCredite);
		panel29.add(textModificareNrCredite);
		
		
		labelModificareSemestru=new JLabel("Semestrul");
		textModificareSemestru=new JTextField(1);
		textModificareSemestru.setEditable(false);
		cbxSemestru=new MyCheckBox(textModificareSemestru);
		cbxSemestru.addActionListener(this);
		panel30.add(cbxSemestru);
		panel30.add(labelModificareSemestru);
		panel30.add(textModificareSemestru);
		
		
		labelModificareOreLaborator=new JLabel("Numar de ore la laborator");
		textModificareOreLaborator=new JTextField(2);
		textModificareOreLaborator.setEditable(false);
		cbxOreLaborator=new MyCheckBox(textModificareOreLaborator);
		cbxOreLaborator.addActionListener(this);
		panel31.add(cbxOreLaborator);
		panel31.add(labelModificareOreLaborator);
		panel31.add(textModificareOreLaborator);
		
		
		labelModificareOreCurs=new JLabel("Numar de ore la curs");
		textModificareOreCurs=new JTextField(2);
		textModificareOreCurs.setEditable(false);
		cbxOreCurs=new MyCheckBox(textModificareOreCurs);
		cbxOreCurs.addActionListener(this);
		panel32.add(cbxOreCurs);
		panel32.add(labelModificareOreCurs);
		panel32.add(textModificareOreCurs);
		
		
		labelModificareOreSeminar=new JLabel("numar de ore la seminar");
		textModificareOreSeminar=new JTextField(2);
		textModificareOreSeminar.setEditable(false);
		cbxOreSeminar=new MyCheckBox(textModificareOreSeminar);
		cbxOreSeminar.addActionListener(this);
		panel33.add(cbxOreSeminar);
		panel33.add(labelModificareOreSeminar);
		panel33.add(textModificareOreSeminar);
		
		
		labelModificareFormaDeExaminare=new JLabel("Forma de examinare");
		textModificareFormaDeExaminare=new JTextField(10);
		textModificareFormaDeExaminare.setEditable(false);
		cbxFormaDeExaminare=new MyCheckBox(textModificareFormaDeExaminare);
		cbxFormaDeExaminare.addActionListener(this);
		panel34.add(cbxFormaDeExaminare);
		panel34.add(labelModificareFormaDeExaminare);
		panel34.add(textModificareFormaDeExaminare);
		
		comboModificareDisciplina=new ComboModificareDisciplina(textModificareCod,textModificareDenumireDisciplina,textModificareNrCredite,
				textModificareSemestru,textModificareOreLaborator,textModificareOreCurs,textModificareOreSeminar,textModificareFormaDeExaminare);
		panel26.add(comboModificareDisciplina);
		comboModificareDisciplina.addActionListener(this);
		Repozitory.getInstance().addObservator(comboModificareDisciplina);
		
		butonModificareDisciplina=new ButonModificareDisciplina(comboModificareDisciplina,textModificareCod,
				cbxCodDisciplina,textModificareDenumireDisciplina,cbxDenumireDisciplina,
				textModificareNrCredite,cbxNrCredite,textModificareSemestru,cbxSemestru,textModificareOreLaborator,
				cbxOreLaborator,textModificareOreCurs,cbxOreCurs,textModificareOreSeminar,
				cbxOreSeminar,textModificareFormaDeExaminare,cbxFormaDeExaminare);
		butonModificareDisciplina.addActionListener(this);
		panel45.add(butonModificareDisciplina);
		
		panelComponent5.add(panel25);
		panelComponent5.add(panel26);
		panelComponent5.add(panel27);
		panelComponent5.add(panel28);
		panelComponent5.add(panel29);
		panelComponent5.add(panel30);
		panelComponent5.add(panel31);
		panelComponent5.add(panel32);
		panelComponent5.add(panel33);
		panelComponent5.add(panel34);
		panelComponent5.add(panel45);
		panelComponent5.setLayout(new BoxLayout(panelComponent5,BoxLayout.Y_AXIS));
		
		panelComponent6=new JPanel();
		tabbedPane.addTab("Modificare nota",null,panelComponent6,"Modificare nota");
		
		labelModificareNota=new JLabel("MODIFICARE NOTA");
		panel35.add(labelModificareNota);
		
		
		
		//cbxNotaCNP=new JCheckBox();
		//panel37.add(cbxNotaCNP);
		//labelModificareNotaCNP=new JLabel("CNP");
		//textModificareNotaCNP=new JTextField(12);
		//textModificareNotaCNP.setEditable(true);
		
		
		//panel37.add(labelModificareNotaCNP);
		
		
		//cbxNotaCodDisciplina=new JCheckBox();
		labelModificareNotaCodDisciplina=new JLabel("Cod Disciplina");
		textModificareNotaCodDisciplina=new JTextField(15);
		//panel38.add(cbxNotaCodDisciplina);
		panel38.add(labelModificareNotaCodDisciplina);
		panel38.add(textModificareNotaCodDisciplina);
		
		//cbxNotaPrezentare=new JCheckBox();
		labelModificareNotaPrezentare=new JLabel("Prezentarea:");
		textModificareNotaPrezentare=new JTextField(2);
		//panel39.add(cbxNotaPrezentare);
		panel39.add(labelModificareNotaPrezentare);
		panel39.add(textModificareNotaPrezentare);
		
		
		labelModificareNota1=new JLabel("Nota");
		textModificareNota=new JTextField(2);
		textModificareNota.setEditable(false);
		cbxNota=new MyCheckBox(textModificareNota);
		cbxNota.addActionListener(this);
		panel40.add(cbxNota);
		panel40.add(labelModificareNota1);
		panel40.add(textModificareNota);
		
		
		labelInfoDenumire=new JLabel();
		textInfo1=new JTextField();
		textInfo2=new JTextField();
		textInfo3=new JTextField();
		
		comboDisciplina=new ComboDisciplina(labelInfoDenumire,textInfo1,textInfo2,textInfo3);
		comboDisciplina.addActionListener(this);
		Repozitory.getInstance().addObservator(comboDisciplina);
		labelInfo=new JLabel();
		comboStudentiNota=new ComboStudentiModificareNota(labelInfo,comboDisciplina);
		comboStudentiNota.addActionListener(this);
		Repozitory.getInstance().addObservator(comboStudentiNota);
		panel36.add(comboStudentiNota);
		panel36.add(labelInfo);
		panel37.add(comboDisciplina);
		//panel37.add(labelInfoDenumire);
		butonModificareNota=new ButonModificareNota(comboStudentiNota,comboDisciplina,textModificareNota,cbxNota);
		butonModificareNota.addActionListener(this);
		panel46.add(butonModificareNota);
		
		panelComponent6.add(panel35);
		panelComponent6.add(panel36);
		panelComponent6.add(panel37);
		//panelComponent6.add(panel38);
		//panelComponent6.add(panel39);
		panelComponent6.add(panel40);
		panelComponent6.add(panel46);
		panelComponent6.setLayout(new BoxLayout(panelComponent6,BoxLayout.Y_AXIS));
		
		panelComponent7=new JPanel();
		tabbedPane.addTab("Stergere",null,panelComponent7,"Stergere");
		
		labelStergereStudent=new JLabel("STERGERE STUDENT");
		panel47.add(labelStergereStudent);
		
		comboStergere=new JComboBox();
		panel48.add(comboStergere);
		
		panelComponent7.add(panel47);
		panelComponent7.add(panel48);
		panelComponent7.setLayout(new BoxLayout(panelComponent7,BoxLayout.Y_AXIS));
		
		panelComponent8=new JPanel();
		tabbedPane.addTab("Vizualizare Studenti",null,panelComponent8,"Viziualizare Studenti");
		
		
		StudentsTableModel modelStudenti = new StudentsTableModel();
		Repozitory.getInstance().addObservator(modelStudenti);
	    tabelVizualizareStudenti = new StudentsTable(modelStudenti.getRows(), modelStudenti.getColumnNames());
	    //tabelVizualizareStudenti.addComponentListener(null);
	    Repozitory.getInstance().addObservator(tabelVizualizareStudenti);
	    JScrollPane scrollPane=new JScrollPane(tabelVizualizareStudenti);
	    tabelVizualizareStudenti.setFillsViewportHeight(true);
		panel49.add(scrollPane);
		panelComponent8.add(panel49);
		panelComponent8.setLayout(new BoxLayout(panelComponent8,BoxLayout.Y_AXIS));
		
		
		panelComponent9=new JPanel();
		tabbedPane.addTab("Vizualizare Discipline",null,panelComponent9,"Vizualizare Discipline");
		
		DisciplineTableModel modelDiscipline=new DisciplineTableModel();
		Repozitory.getInstance().addObservator(modelStudenti);
		tabelVizualizareDiscipline=new JTable(modelDiscipline.getRows(),modelDiscipline.getColumnNames());
		tabelVizualizareDiscipline.setPreferredSize(new Dimension(550,200));
		JScrollPane scrollPane2=new JScrollPane(tabelVizualizareDiscipline);
		scrollPane2.setPreferredSize(new Dimension(550,200));
		tabelVizualizareDiscipline.setFillsViewportHeight(true);
		panel50.add(scrollPane2);
		panelComponent9.add(panel50);
		panelComponent9.setLayout(new BoxLayout(panelComponent9,BoxLayout.Y_AXIS));
		
		panelComponent10=new JPanel();
		tabbedPane.addTab("Vizualizare Note Student",null,panelComponent10,"Viziualizare Note");
		labelStudent2=new JLabel();
		labelStudent2.setSize(100, 20);
		comboStudenti2=new ComboStudenti2(labelStudent2,panel51);
		comboStudenti2.addActionListener(this);
		Repozitory.getInstance().addObservator(comboStudenti2);
		
		panel51.add(comboStudenti2);
		panel51.add(labelStudent2);
		
		panelComponent10.add(panel51);
		panelComponent10.setLayout(new BoxLayout(panelComponent10,BoxLayout.Y_AXIS));
		
		mainPanel.add(tabbedPane);
		
		
		this.add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		this.setSize(1300,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Functia este folosita pentru a putea implementa interfata ActionListener intrucat interfata grafica a aplicatiei este si "ascultator"
	 * al tururor evenimentelor care se produc. Pentru evenimentele produse se obtine sursa acestora, iar apoi este apelata functia execute()
	 * care "apartine" de sursa. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		((Comanda)e.getSource()).executa();
		
	}
	

	public static void main(String[] args) {
		Interfata in=new Interfata();

	}


}
