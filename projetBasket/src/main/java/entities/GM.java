package entities;

public class GM extends Compte {


	public GM(Integer id, String login, String password, String nom, String prenom, String email) {
		super(id, login, password, nom, prenom, email);
	}

	public GM(String login, String password, String nom, String prenom, String email) {
		super(login, password, nom, prenom, email);
	}

	
	
	
}
