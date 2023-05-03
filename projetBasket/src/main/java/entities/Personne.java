package entities;

public class Personne {
	private String nom;
	private String prenom;
	private double salaire;
	private Equipe equipe;
	private Role role;
	
	
	public Personne(String nom, String prenom, double salaire, Equipe equipe, Role role) {
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
		this.equipe = equipe;
		this.role = role;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public double getSalaire() {
		return salaire;
	}


	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}


	public Equipe getEquipe() {
		return equipe;
	}


	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}

	
	

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", salaire=" + salaire + ", equipe=" + equipe + ", role="
				+ role + "]";
	}

	
	
	
	
}
