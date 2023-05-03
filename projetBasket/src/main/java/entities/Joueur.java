package entities;

import java.util.ArrayList;
import java.util.List;

public class Joueur {

	private String nom;
	private String prenom;
	private double taille;
	private double poids;
	private int age;
	private int numeroMaillot;
	private double salaire;
	private Equipe equipe;
	private Statut statut;
	private Poste poste;
	private List<AptitudePhysique> aptitudesPhysiques = new ArrayList();
	
	
	public Joueur(String nom, String prenom, double taille, double poids, int age, int numeroMaillot, double salaire,
			Equipe equipe, Statut statut, Poste poste, List<AptitudePhysique> aptitudesPhysiques) {
		this.nom = nom;
		this.prenom = prenom;
		this.taille = taille;
		this.poids = poids;
		this.age = age;
		this.numeroMaillot = numeroMaillot;
		this.salaire = salaire;
		this.equipe = equipe;
		this.statut = statut;
		this.poste = poste;
		this.aptitudesPhysiques = aptitudesPhysiques;
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


	public double getTaille() {
		return taille;
	}


	public void setTaille(double taille) {
		this.taille = taille;
	}


	public double getPoids() {
		return poids;
	}


	public void setPoids(double poids) {
		this.poids = poids;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getNumeroMaillot() {
		return numeroMaillot;
	}


	public void setNumeroMaillot(int numeroMaillot) {
		this.numeroMaillot = numeroMaillot;
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


	public Statut getStatut() {
		return statut;
	}


	public void setStatut(Statut statut) {
		this.statut = statut;
	}


	public Poste getPoste() {
		return poste;
	}


	public void setPoste(Poste poste) {
		this.poste = poste;
	}


	public List<AptitudePhysique> getAptitudesPhysiques() {
		return aptitudesPhysiques;
	}


	public void setAptitudesPhysiques(List<AptitudePhysique> aptitudesPhysiques) {
		this.aptitudesPhysiques = aptitudesPhysiques;
	}


	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", prenom=" + prenom + ", taille=" + taille + ", poids=" + poids + ", age=" + age
				+ ", numeroMaillot=" + numeroMaillot + ", salaire=" + salaire + ", equipe=" + equipe + ", statut="
				+ statut + ", poste=" + poste + ", aptitudesPhysiques=" + aptitudesPhysiques + "]";
	}
		
	
	
	
	
	
	
}
