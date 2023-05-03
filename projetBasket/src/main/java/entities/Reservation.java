package entities;


import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private Long id;
	@Column(name = "reservation_prix")
	private double prix;
	@Column(name = "total_reservation")
	private Integer quantite;
	@Column(name = "reservation_date")
	private LocalDate dateReservation;
	
	@Transient
	private Set<Match> MatchReservation;
	//private List<Match> matchs = new ArrayList<Match>(); 
	@Transient
	private Compte compte;
	
	public Reservation() {
		super();
	}

	public Reservation(double prix, Integer quantite, LocalDate dateReservation, Set<Match> matchReservation,
			Compte compte) {
		super();
		this.prix = prix;
		this.quantite = quantite;
		this.dateReservation = dateReservation;
		MatchReservation = matchReservation;
		this.compte = compte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Set<Match> getMatchReservation() {
		return MatchReservation;
	}

	public void setMatchReservation(Set<Match> matchReservation) {
		MatchReservation = matchReservation;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(id, other.id);
	}

	
	

	
    


	
	
	
	
	
	
}
