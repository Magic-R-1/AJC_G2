package entities;

public class Stade {

	private String nom;
	private int capacite;
	private String ville;
	
	
	public Stade(String nom, int capacite, String ville) {
		this.nom = nom;
		this.capacite = capacite;
		this.ville = ville;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getCapacite() {
		return capacite;
	}


	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	@Override
	public String toString() {
		return "Stade [nom=" + nom + ", capacity=" + capacite + ", ville=" + ville + "]";
	}
	
	
	
}
