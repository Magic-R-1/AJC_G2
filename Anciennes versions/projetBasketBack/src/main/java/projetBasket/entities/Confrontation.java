package projetBasket.entities;

import java.time.LocalDate;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity 
@Table(name = "confrontation")
public class Confrontation {
	
	@Id
	@Column(name = "confrontation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "confrontation_date")
    private LocalDate dateConfrontation;
	@Column(name = "confrontation_duree")
    private int duree;
	@Column(name = "confrontation_home_score")
    private int scoreDomicile;
	@Column(name = "confrontation_away_score")
    private int scoreVisiteur;
	@ManyToOne
	@JoinColumn(name="confrontation_referee_id", foreignKey = @ForeignKey(name="confrontation_referee_id_fk"))
	private Arbitre arbitre;
	@ManyToOne
	@JoinColumn(name="confrontation_team_id", foreignKey = @ForeignKey(name="confrontation_team_id_fk"))
	private Equipe equipe;
	@OneToMany(mappedBy="confrontation")
	@Column(name="bookings_confrontation")
	private Set<Reservation> reservations;
	
	public Confrontation() {
		
	}

	public Confrontation(LocalDate dateConfrontation, int duree, int scoreDomicile, int scoreVisiteur, Arbitre arbitre,
			Equipe equipe, Set<Reservation> reservations) {
		super();
		this.dateConfrontation = dateConfrontation;
		this.duree = duree;
		this.scoreDomicile = scoreDomicile;
		this.scoreVisiteur = scoreVisiteur;
		this.arbitre = arbitre;
		this.equipe = equipe;
		this.reservations = reservations;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateConfrontation() {
		return dateConfrontation;
	}

	public void setDateConfrontation(LocalDate dateConfrontation) {
		this.dateConfrontation = dateConfrontation;
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

	public Arbitre getArbitre() {
		return arbitre;
	}

	public void setArbitre(Arbitre arbitre) {
		this.arbitre = arbitre;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
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
		Confrontation other = (Confrontation) obj;
		return Objects.equals(id, other.id);
	}
	
}
