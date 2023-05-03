package entities;

import java.util.Date;

public class Match {
	
    private Date date;
    private int duree;
    private int scoreDomicile;
    private int scoreVisiteur;
    
    
	public Match(Date date, int duree, int scoreDomicile, int scoreVisiteur) {
		this.date = date;
		this.duree = duree;
		this.scoreDomicile = scoreDomicile;
		this.scoreVisiteur = scoreVisiteur;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public int getScoreDomicile() {
		return scoreDomicile;
	}


	public void setScoreDomicile(int scoreDomicile) {
		this.scoreDomicile = scoreDomicile;
	}


	public int getScoreVisiteur() {
		return scoreVisiteur;
	}


	public void setScoreVisiteur(int scoreVisiteur) {
		this.scoreVisiteur = scoreVisiteur;
	}


	@Override
	public String toString() {
		return "Match [date=" + date + ", duree=" + duree + ", scoreDomicile=" + scoreDomicile + ", scoreVisiteur="
				+ scoreVisiteur + "]";
	}
    
    
    
	
}
