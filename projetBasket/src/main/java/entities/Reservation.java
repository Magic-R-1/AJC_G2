package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation {

	private Integer id;
	private double prix;
	private Integer quantite;
	private LocalDate dateReservation;
	private List<Match> matchs = new ArrayList(); 
	private Compte compte;

	


	public Reservation(Integer id, double prix, Integer quantite, LocalDate dateReservation, List<Match> matchs,
			Compte compte) {
		this.id = id;
		this.prix = prix;
		this.quantite = quantite;
		this.dateReservation = dateReservation;
		this.matchs = matchs;
		this.compte = compte;
		}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public Integer getQuantite() {
		return quantite;
	}


	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}


	public LocalDate getDateReservation() {
		return dateReservation;
	}


	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}


	public List<Match> getMatchs() {
		return matchs;
	}


	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}


	
	public String toString() {
		return "Reservation [id=" + id + ", prix=" + prix + ", quantite=" + quantite + ", dateReservation="
				+ dateReservation + "]";
	}


	
	
	
	
	
	
}
