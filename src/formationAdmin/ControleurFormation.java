package formationAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import net.proteanit.sql.DbUtils;

// le controleur fait le pont 
// entre la vue et le modèle
public class ControleurFormation {

	private LoginVue laLoginVue;
	private BDD laBDD;
	private FormationVue laFormationVue;
	
	public ControleurFormation(LoginVue laConnexionVue, BDD laBDD, FormationVue laFormationVue) throws SQLException {
		
		this.laLoginVue = laConnexionVue;
		this.laBDD = laBDD;
		this.laFormationVue = laFormationVue;
							
		// Charger le driver JBDC
		this.laBDD.chargerDriver("com.mysql.jdbc.Driver");
				
		// Connexion à la BDD
		this.laBDD.connexionBdd("mysql://localhost/", "formations", "root", "");
				
		// Creation d'ub statement
		this.laBDD.creerStatement();
		
		//initialisation des classes actionListener qui seront affectées aux boutons 
		//bouttons frame login
		this.laLoginVue.ecouteurBtnLogin(new ActBtnLogin());
		
		// bouttons frame formations
		this.laFormationVue.ecouteurBtnInsert(new ActBtnInsert());
		this.laFormationVue.ecouteurBtnDelete(new ActBtnDelete());
		this.laFormationVue.ecouteurBtnReturnIndex(new ActBtnReturnIndex());
		this.laFormationVue.ecouteurBtnUpdate(new ActBtnUpdate());	
	
	}
	
	//classe actionListener qui permet de se connecter sur l'appli
	class ActBtnLogin implements ActionListener {

		public void actionPerformed(ActionEvent Event) {
				
			String mail = laLoginVue.getMailField();
			String password = laLoginVue.getPasswordField();
			
			// Requête qui va comparer les informations de connexion récupérées sur l'IHM avec la BDD 
			BDD.executeSelect("SELECT (`mail`),(`password`) FROM (`utilisateur`) WHERE (`mail`) = '"+ mail +"' and (`password`) = '"+ password + "'");
			
			// si la requête renvoie vraie alors la connexion se fait
			try {
				if(laBDD.recupererResultatsRequete() == true ) {
						
					//affichage de l'acceuil
					LoginVue.getFrameLogin().setVisible(false);
					IndexVue.getFrameIndex().setVisible(true);
							
				} else {
						
					LoginVue.affichagePopUp("Mail ou MDP incorrect!");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Création des champs du tableau formation
			BDD.executeSelect("SELECT * FROM `formation`");
			laFormationVue.getJTableFor().setModel(DbUtils.resultSetToTableModel(BDD.getRs()));
			
			// Création des champs du tableau intervenant
			BDD.executeSelect("SELECT * FROM `intervenant`");
			IntervenantVue.getjTableInter().setModel(DbUtils.resultSetToTableModel(BDD.getRs()));	
		}
	}
	
// classes actionListener qui permettent des modifications sur la table Formations
 class ActBtnInsert implements ActionListener {

		public void actionPerformed(ActionEvent Event) {
			
			//requete qui va insérer un nouvel index dans la table formation
			BDD.executeUpdate("INSERT INTO `formation`(`numFormation`, `nbPlaces`, `objectif`, `couts`) VALUES ("+laFormationVue.getTxtNumFormation()+", "+laFormationVue.getTextNbPlaces()+", '"+laFormationVue.getTxtObjectif()+"',"+laFormationVue.getTxtCouts()+")");	
			// mis à jour du tableau formation
			BDD.executeSelect("SELECT * FROM `formation`");
			laFormationVue.getJTableFor().setModel(DbUtils.resultSetToTableModel(BDD.getRs()));
		}
 	}
 
 class ActBtnUpdate implements ActionListener {

		public void actionPerformed(ActionEvent Event) {
			
			//requete qui met à jour les informations dont le numFormation correspond
			BDD.executeUpdate("UPDATE `formation` SET `numFormation`="+laFormationVue.getTxtNumFormation()+",`nbPlaces`="+laFormationVue.getTextNbPlaces()+", `objectif`='"+laFormationVue.getTxtObjectif()+"', `couts`="+laFormationVue.getTxtCouts()+" WHERE `numFormation`="+laFormationVue.getTxtNumFormation());
			// mis à jour du tableau formation
			BDD.executeSelect("SELECT * FROM `formation`");
			laFormationVue.getJTableFor().setModel(DbUtils.resultSetToTableModel(BDD.getRs()));
		}
	}
 
 class ActBtnDelete implements ActionListener {

		public void actionPerformed(ActionEvent Event) {
			
			//requete qui supprime les informations dont le numFormation correspond
			BDD.executeUpdate("DELETE FROM `formation` WHERE `numFormation`="+laFormationVue.getTxtNumFormation());
			// mis à jour du tableau formation
			BDD.executeSelect("SELECT * FROM `formation`");
			laFormationVue.getJTableFor().setModel(DbUtils.resultSetToTableModel(BDD.getRs()));
		}
	}
 
 class ActBtnReturnIndex implements ActionListener {

		public void actionPerformed(ActionEvent Event) {
			
			//retour à l'accueil
			IndexVue.getFrameIndex().setVisible(true);
			FormationVue.frameFormation().setVisible(false);
		}
		
		// classes actionListener qui permettent des modifications sur la table Formations
		 class ActBtnInsert implements ActionListener {

				public void actionPerformed(ActionEvent Event) {
					
					//requete qui va insérer un nouvel index dans la table formation
					BDD.executeUpdate("INSERT INTO `formation`(`numFormation`, `nbPlaces`, `objectif`, `couts`) VALUES ("+laFormationVue.getTxtNumFormation()+", "+laFormationVue.getTextNbPlaces()+", '"+laFormationVue.getTxtObjectif()+"',"+laFormationVue.getTxtCouts()+")");	
					// mis à jour du tableau formation
					BDD.executeSelect("SELECT * FROM `formation`");
					laFormationVue.getJTableFor().setModel(DbUtils.resultSetToTableModel(BDD.getRs()));
			  }
		 }
	}
}
