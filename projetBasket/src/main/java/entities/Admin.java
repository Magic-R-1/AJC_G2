package entities;

public class Admin extends Compte{

	

	public Admin(Integer id, String login, String password, String nom, String prenom, String email) {
		super(id, login, password, nom, prenom, email);
	}

	public Admin(String login, String password, String nom, String prenom, String email) {
		super(login, password, nom, prenom, email);
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + "]";
	}

	
	
	
	
}
