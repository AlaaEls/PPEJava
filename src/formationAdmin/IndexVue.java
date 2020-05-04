package formationAdmin;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IndexVue {

	//propri�t�es
	private static JFrame  frameIndex = new JFrame();
	private JButton btnLogout = new JButton("D�connexion");
	private JButton btnFormations = new JButton("Formations");
	private JButton btnIntervenants = new JButton("Intervenants");

	//constructeur
	public IndexVue() {
		
		frameIndex.setTitle("Accueil");
		frameIndex.setBounds(100, 100, 495, 332);
		frameIndex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameIndex.getContentPane().setLayout(null);
		
		// param�trage graphique du boutton Formations
		btnFormations.setBounds(60, 135, 130, 39);
		frameIndex.getContentPane().add(btnFormations);
		
		// param�trage de l'action du boutton Intervenants
		btnIntervenants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				IntervenantVue.getInterFrame().setVisible(true);
				frameIndex.setVisible(false);
			}
		});
		
		// param�trage graphique du boutton Intervenants
		btnIntervenants.setBounds(270, 135, 130, 39);
		frameIndex.getContentPane().add(btnIntervenants);
		
		// param�trage graphique du boutton D�connexion
		btnLogout.setBounds(22, 25, 114, 23);
		frameIndex.getContentPane().add(btnLogout);
		
		// param�trage de l'action du boutton formation
		btnFormations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frameIndex.setVisible(false);
				FormationVue.frameFormation().setVisible(true);
			}
		});
		
		// param�trage de l'action du boutton D�connexion
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginVue.getFrameLogin().setVisible(true);
				frameIndex.setVisible(false);
			}
		});
	
	}
	
	//getters
	public static JFrame getFrameIndex() {
		
		return frameIndex;
	}

}
