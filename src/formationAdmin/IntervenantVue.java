package formationAdmin;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IntervenantVue extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//frame
	private static JFrame interFrame = new JFrame();;
	
	//tableau
    private static JTable jTableInter = new JTable();
    private JScrollBar scrollBar = new JScrollBar();
	private final JPanel panel = new JPanel();
	private final JScrollPane scrollPanInter = new JScrollPane();
	
	//textfields
	private JTextField txtIdInter = new JTextField();
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom  = new JTextField();
	private JTextField txtTitre = new JTextField();;
	
	//bouttons
	private JButton btnUpdate = new JButton("Modifier");
	private JButton btnInsertInter = new JButton("Insérer");
	private JButton btnReturnIndex = new JButton("Retourner à l'acceuil");
	private JButton btnDelete = new JButton("Supprimer");
	
	//labels
	private JLabel lbIdIntervenant = new JLabel("idIntervenant");
	private JLabel lblPrenom = new JLabel("prenom");
	private JLabel lblTitre = new JLabel("titre");
	private JLabel lblNom = new JLabel("nom");
	
	public IntervenantVue() {
		
		interFrame.setTitle("Intervenants");
		interFrame.getContentPane().setLayout(null);
		
		interFrame.setBounds(100, 100, 724, 476);
		interFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		interFrame.getContentPane().setLayout(null);
		panel.setForeground(Color.BLUE);
		
		panel.setBorder(new TitledBorder(null, "INTERVENANTS DISPONIBLES ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(35, 92, 612, 272);
		
		interFrame.getContentPane().add(panel);
		panel.setLayout(null);
		scrollPanInter.setBounds(6, 16, 600, 250);
		
		panel.add(scrollPanInter);
		scrollPanInter.setViewportView(getjTableInter());
		
		getjTableInter().setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"idIntervenant", "nom", "prenom", "titre"} )); //ajout des noms des colonnes
		interFrame.getContentPane().add(scrollBar, BorderLayout.EAST);
		
		//paramétrage graphique du label idIntervenant
		lbIdIntervenant.setBounds(35, 30, 86, 14);
		interFrame.getContentPane().add(lbIdIntervenant);
		
		//paramétrage graphique du label nom
		lblNom.setBounds(209, 30, 65, 14);
		interFrame.getContentPane().add(lblNom);
		
		//paramétrage graphique du label prenom
		lblPrenom.setBounds(366, 30, 65, 14);
		interFrame.getContentPane().add(lblPrenom);
		
		//paramétrage graphique du label titre
		lblTitre.setBounds(524, 30, 65, 14);
		interFrame.getContentPane().add(lblTitre);
		
		//paramétrage graphique du jtextfield idIntervenant
		txtIdInter.setBounds(35, 55, 131, 20);
		interFrame.getContentPane().add(txtIdInter);
		txtIdInter.setColumns(10);
		
		//paramétrage graphique du jtextfield nom
		txtNom.setBounds(203, 55, 134, 20);
		interFrame.getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		//paramétrage graphique du jtextfield prenom
		txtPrenom.setBounds(358, 55, 134, 20);
		interFrame.getContentPane().add(txtPrenom);
		txtPrenom.setColumns(10);
		
		//paramétrage graphique du jtextfield titre
		txtTitre.setBounds(524, 54, 134, 23);
		interFrame.getContentPane().add(txtTitre);
		txtTitre.setColumns(10);
		
		//ajout d'un actionListener sur le boutton insert
		btnInsertInter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BDD.executeUpdate("INSERT INTO `intervenant`(`idIntervenant`, `nom`, `prenom`, `titre`) VALUES ("+getTxtIdInter()+", '"+getTxtNom()+"', '"+getTxtPrenom()+"','"+getTxtTitre()+"')");	
				// mis à jour du tableau intervenants
				BDD.executeSelect("SELECT * FROM `intervenant`");
				getjTableInter().setModel(DbUtils.resultSetToTableModel(BDD.getRs()));
			}
		});
		
		//paramétrage graphique du boutton Insert
		btnInsertInter.setBounds(35, 379, 89, 23);
		interFrame.getContentPane().add(btnInsertInter);
		
		//ajout d'un actionListener sur le boutton Update
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//requete qui met à jour les informations dont l'idIntervenant correspond
				BDD.executeUpdate("UPDATE `intervenant` SET `idIntervenant`="+getTxtIdInter()+",`nom`='"+getTxtNom()+"', `prenom`='"+getTxtPrenom()+"', `titre`='"+getTxtTitre()+"' WHERE `idIntervenant`="+getTxtIdInter());
				// mis à jour du tableau intervenants
				BDD.executeSelect("SELECT * FROM `intervenant`");
				getjTableInter().setModel(DbUtils.resultSetToTableModel(BDD.getRs()));	
			}
		});
		
		//paramétrage graphique du boutton Update
		btnUpdate.setBounds(152, 379, 89, 23);
		interFrame.getContentPane().add(btnUpdate);
		
		//ajout d'un actionListener sur le boutton retourner à l'acceuil
		btnReturnIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				IndexVue.getFrameIndex().setVisible(true);
				interFrame.setVisible(false);		
			}
		});
		
		//paramétrage graphique du boutton Retour à l'acceuil
		btnReturnIndex.setBounds(418, 379, 260, 23);
		interFrame.getContentPane().add(btnReturnIndex);
		
		//ajout d'un actionListener sur le boutton Delete
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//requete qui supprime les champs dont l'idIntervenant correspond
				BDD.executeUpdate("DELETE FROM `intervenant` WHERE `idIntervenant`="+getTxtIdInter());
				BDD.executeSelect("SELECT * FROM `intervenant`");
				getjTableInter().setModel(DbUtils.resultSetToTableModel(BDD.getRs()));	
			}
		});
		
		//paramétrage graphique du boutton Delete
		btnDelete.setBounds(270, 379, 113, 23);
		interFrame.getContentPane().add(btnDelete);

	}
	
	//getters 
	public String getTxtIdInter() {
		
		String stringTxtNumFormation = txtIdInter.getText();
		return stringTxtNumFormation;
	}

	public String getTxtNom() {
		
		String stringTxtNbPlaces = txtNom.getText();
		return stringTxtNbPlaces;
	}

	public String getTxtPrenom() {
		
		String stringTxtObjectif = txtPrenom.getText();
		return stringTxtObjectif;
	}

	public String getTxtTitre() {
		
		String stringTxtCouts = txtTitre.getText();
		return stringTxtCouts;
	}

	public static JFrame getInterFrame() {
		
		return interFrame;
	}

	public static JTable getjTableInter() {
		
		return jTableInter;
	}

}
