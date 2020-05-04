package formationAdmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BDD {
	
	private Connection cnx;
	private static Statement stmt;
	private static ResultSet rs;
	private ResultSetMetaData resMeta;
	
	//Recherche et chargement du driver approprié à la BDD
	public void chargerDriver(String pilote) {
		
		// Chargement du Driver (pilote)
		try {
			Class.forName(pilote);
			System.out.println("Driver trouvé!!!");
		}
		catch (ClassNotFoundException e) {

			System.out.println("Driver non trouvé!!!");
			e.printStackTrace();
		}
	}
	
	// Etablissement de la connexion à la base de données
	public void connexionBdd(String localisationBdd, String bddName, String user, String password) {
		
		try {
			cnx = DriverManager.getConnection("jdbc:"+localisationBdd+bddName, user, password);
			System.out.println("Connexion à la BDD "+ bddName +" OK!!");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problème Connexion BDD "+ bddName + "  !!");

			e.printStackTrace();
		}
		
	}
	
	// Creation d'un objet Statement
	public void creerStatement() {
		try {
			stmt = cnx.createStatement();
		} 
		catch (SQLException e) {
			LoginVue.affichagePopUp("Problème création statement!!");
			e.printStackTrace();
		}
	}
	
	public static void executeSelect(String requete) {
		try {
			rs = stmt.executeQuery(requete);
			
		} catch (SQLException e) {
			
			LoginVue.affichagePopUp("Probleme requete SELECT non executée !!");
			e.printStackTrace();
		}
	}
	
	public static void executeUpdate(String requete) {
		try {
			stmt.executeUpdate(requete);
			LoginVue.affichagePopUp("Requete UPDATE éxécutée !!");
		} catch (SQLException e) {
			
			LoginVue.affichagePopUp("Problème requete UPDATE non executée !!");
			e.printStackTrace();
		}
	}
	
	public boolean recupererResultatsRequete() throws SQLException {
		
		// Traitement de requête
		 int count = 0;
	        while(rs.next()){
	            count = count+1;
	        }
	        if (count==1){
	        	
	        	return true;
	    }
			return false;
	}
	
	public void FillTable(JTable table, String Query) throws IllegalAccessException, InstantiationException {
	    try {
	        //To remove previously added rows
	        while(table.getRowCount() > 0) {
	        	
	            ((DefaultTableModel) table.getModel()).removeRow(0);
	        }
	        
	        int columns = rs.getMetaData().getColumnCount();
	        while(rs.next()) {  
	        	
	            Object[] row = new Object[columns];
	            for (int i = 1; i <= columns; i++) {  
	            	
	                row[i - 1] = rs.getObject(i);
	            }
	            ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
	        }

	        rs.close();
	    } catch(SQLException e) {
	    	
	    }
	}

	public static ResultSet getRs() {
		return rs;
	}
	
}