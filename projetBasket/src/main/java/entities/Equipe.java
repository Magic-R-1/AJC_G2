package entities;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
	
	private String franchise;
	private String ville; 
	private List<Joueur> joueur = new ArrayList();
	private List<Match> matchs = new ArrayList();
	private Stade stade;
	private Personne personne;
	
	public Equipe(String franchise, String ville, List<Joueur> joueur, List<Match> matchs, Stade stade, Personne personne) {
		this.franchise = franchise;
		this.ville = ville;
		this.joueur = joueur;
		this.matchs = matchs;
		this.stade = stade;
		this.personne = personne;
		
		
		
		
	}


	public Personne getPersonne() {
		return personne;
	}


	public void setPersonne(Personne personne) {
		this.personne = personne;
	}


	public String getFranchise() {
		return franchise;
	}


	public void setFranchise(String franchise) {
		this.franchise = franchise;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public List<Joueur> getJoueur() {
		return joueur;
	}


	public void setJoueurs(List<Joueur> joueur) {
		this.joueur = joueur;
	}


	public List<Match> getMatchs() {
		return matchs;
	}


	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}


	public Stade getStade() {
		return stade;
	}


	public void setStade(Stade stade) {
		this.stade = stade;
	}


	@Override
	public String toString() {
		return "Equipe [franchise=" + franchise + ", ville=" + ville + ", stade=" + stade + ", personne=" + personne
				+ "]";
	}


	
	
	
	
}
