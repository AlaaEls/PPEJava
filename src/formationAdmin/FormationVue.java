package formationAdmin;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class FormationVue extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//frame
	private static JFrame frameFormation = new JFrame();;
	
	//Tableau
    private JTable jTableFor = new JTable();
    private JScrollBar scrollBar = new JScrollBar();
	
	//textfields
	private JTextField txtNumFormation = new JTextField();
	private JTextField txtNbPlaces = new JTextField();
	private JTextField txtObjectif  = new JTextField();
	private JTextField txtCouts = new JTextField();;
	
	//bouttons
	private JButton btnUpdate = new JButton("Modifier");
	private JButton btnInsert = new JButton("Insérer");
	private JButton btnReturnIndex = new JButton("Retourner à l'acceuil");
	private JButton btnDelete = new JButton("Supprimer");
	
	//labels
	private JLabel lblNumFor = new JLabel("numFormation");
	private JLabel lblObjectif = new JLabel("objectif");
	private JLabel lblCouts = new JLabel("couts");
	private JLabel lblNbPlaces = new JLabel("nbPlaces");
	private final JPanel panel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	
	public FormationVue() {
		
		frameFormation.setTitle("Formations");
		frameFormation.getContentPane().setLayout(null);
		
		frameFormation.setBounds(100, 100, 724, 476);
		frameFormation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFormation.getContentPane().setLayout(null);
		
		panel.setBorder(new TitledBorder(null, "FORMATIONS DISPONIBLES", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(35, 92, 612, 272);
		
		frameFormation.getContentPane().add(panel);
		panel.setLayout(null);
		scrollPane.setBounds(6, 16, 600, 250);
		
		panel.add(scrollPane);
		scrollPane.setViewportView(jTableFor);
		
		jTableFor.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"numFormation", "nbPlaces", "objectif", "couts"} ));
		frameFormation.getContentPane().add(scrollBar, BorderLayout.EAST);
		
		//paramétrage graphique du label numFormation
		lblNumFor.setBounds(35, 30, 86, 14);
		frameFormation.getContentPane().add(lblNumFor);
		
		//paramétrage graphique du label nbPlaces
		lblNbPlaces.setBounds(209, 30, 65, 14);
		frameFormation.getContentPane().add(lblNbPlaces);
		
		//paramétrage graphique du label Objectif
		lblObjectif.setBounds(366, 30, 65, 14);
		frameFormation.getContentPane().add(lblObjectif);
		
		//paramétrage graphique du label couts
		lblCouts.setBounds(524, 30, 65, 14);
		frameFormation.getContentPane().add(lblCouts);
		
		//paramétrage graphique du jtextfield numFormation
		txtNumFormation.setBounds(35, 55, 131, 20);
		frameFormation.getContentPane().add(txtNumFormation);
		txtNumFormation.setColumns(10);
		
		//paramétrage graphique du jtextfield nbPlaces
		txtNbPlaces.setBounds(203, 55, 134, 20);
		frameFormation.getContentPane().add(txtNbPlaces);
		txtNbPlaces.setColumns(10);
		
		//paramétrage graphique du jtextfield objectif
		txtObjectif.setBounds(358, 55, 134, 20);
		frameFormation.getContentPane().add(txtObjectif);
		txtObjectif.setColumns(10);
		
		//paramétrage graphique du jtextfield couts
		txtCouts.setBounds(524, 54, 134, 23);
		frameFormation.getContentPane().add(txtCouts);
		txtCouts.setColumns(10);
		
		//paramétrage graphique du boutton Insert
		btnInsert.setBounds(35, 379, 89, 23);
		frameFormation.getContentPane().add(btnInsert);
		
		//paramétrage graphique du boutton Update
		btnUpdate.setBounds(152, 379, 89, 23);
		frameFormation.getContentPane().add(btnUpdate);
		
		//paramétrage graphique du boutton Retour à l'acceuil
		btnReturnIndex.setBounds(418, 379, 260, 23);
		frameFormation.getContentPane().add(btnReturnIndex);
		
		//paramétrage graphique du boutton Delete
		btnDelete.setBounds(270, 379, 113, 23);
		frameFormation.getContentPane().add(btnDelete);
		frameFormation.setVisible(false);
	}
	
	
	// ajout des actionListener pour les bouttons
	public void ecouteurBtnInsert(ActionListener EventInsert) {
		
		btnInsert.addActionListener(EventInsert);
	}

	public void ecouteurBtnDelete(ActionListener EventDelete) {

		btnDelete.addActionListener(EventDelete);
	}

	public void ecouteurBtnReturnIndex(ActionListener EventRIndex) {

		btnReturnIndex.addActionListener(EventRIndex);
	}

	public void ecouteurBtnUpdate(ActionListener EventUpdate) {

		btnUpdate.addActionListener(EventUpdate);
	}

	//getters des JTextfields 
	public String getTxtNumFormation() {
		
		String stringTxtNumFormation = txtNumFormation.getText();
		return stringTxtNumFormation;
	}

	public String getTextNbPlaces() {
		
		String stringTxtNbPlaces = txtNbPlaces.getText();
		return stringTxtNbPlaces;
	}

	public String getTxtObjectif() {
		
		String stringTxtObjectif = txtObjectif.getText();
		return stringTxtObjectif;
	}

	public String getTxtCouts() {
		
		String stringTxtCouts = txtCouts.getText();
		return stringTxtCouts;
	}

	public static JFrame frameFormation() {
		return frameFormation;
	}

	public JTable getJTableFor() {
		return jTableFor;
	}
}
