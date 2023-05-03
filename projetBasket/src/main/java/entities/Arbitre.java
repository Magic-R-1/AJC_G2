package entities;

public class Arbitre {
	private String nom;
    private String prenom;
    private int anciennete;
    private String nationalite;
    
    
	public Arbitre(String nom, String prenom, int anciennete, String nationalite) {
		this.nom = nom;
		this.prenom = prenom;
		this.anciennete = anciennete;
		this.nationalite = nationalite;
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


	public int getAnciennete() {
		return anciennete;
	}


	public void setAnciennete(int anciennete) {
		this.anciennete = anciennete;
	}


	public String getNationalite() {
		return nationalite;
	}


	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}


	@Override
	public String toString() {
		return "Arbitre [nom=" + nom + ", prenom=" + prenom + ", anciennete=" + anciennete + ", nationalite="
				+ nationalite + "]";
	}
	
	
	
	
}
