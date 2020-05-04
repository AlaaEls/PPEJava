package formationAdmin;

import java.sql.SQLException;

public class MainFormation {

	public static void main(String[] args) throws SQLException {
		
		LoginVue LaConnexionVue = new LoginVue();
		
		IndexVue lIndexVue = new IndexVue();
		
		FormationVue laFormationVue = new FormationVue();
		
		IntervenantVue lIntervenantsVue = new IntervenantVue();
		
		BDD laBDD = new BDD();
		
		ControleurFormation LeControleurFormation = new ControleurFormation(LaConnexionVue, laBDD, laFormationVue);

	}

}
