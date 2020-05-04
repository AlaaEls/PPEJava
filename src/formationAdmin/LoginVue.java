package formationAdmin;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;

public class LoginVue {
	
	// Frame
	private static JFrame frameLogin = new JFrame();
	
	//labels
	private JLabel labelMail = new JLabel("Mail");
	private JLabel labelPassword = new JLabel("Mot de passe");;
	
	//bouttons
	private JButton loginButton = new JButton("Connexion");
	
	//Jtextfields
	private JTextField mailField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();

	// Constructeur
	public LoginVue() {
		
		passwordField.setBounds(143, 139, 123, 20);
		passwordField.setColumns(10);
		
		frameLogin.setBounds(100, 100, 450, 300);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.getContentPane().setLayout(null);
		
		labelMail.setBounds(143, 37, 134, 17);
		frameLogin.getContentPane().add(labelMail);
		
		labelPassword.setBounds(143, 114, 77, 14);
		frameLogin.getContentPane().add(labelPassword);
		
		mailField.setBounds(143, 64, 123, 18);
		frameLogin.getContentPane().add(mailField);
		mailField.setColumns(10);
		
		frameLogin.getContentPane().add(loginButton);
		loginButton.setBounds(143, 191, 123, 34);
		
		frameLogin.getContentPane().add(passwordField);
		
		//ajout d'un titre du frame
		frameLogin.setTitle("Interface de Connexion");
		frameLogin.setVisible(true);
	}

	// ajout d'un actionListener sur le bouton Connexion
	public void ecouteurBtnLogin(ActionListener Event) {
		
		loginButton.addActionListener(Event);
	}
	
	// méthode qui permet d'afficher un pop up
	public static void affichagePopUp(String message){

		JOptionPane.showMessageDialog(frameLogin, message);
	}
	
	// les getters 
	public String getPasswordField() {
		
		String stringPasswordField = passwordField.getText();
		return stringPasswordField;
	}

	public String getMailField() {
		
		String stringUsernameField = mailField.getText();
		return stringUsernameField;
	}
	
	public static JFrame getFrameLogin() {
		
		return frameLogin;
	}
	
}
