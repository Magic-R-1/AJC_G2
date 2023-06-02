package formationSopraSteria.projetBasket.entities;

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

import com.fasterxml.jackson.annotation.JsonView;

import formationSopraSteria.projetBasket.entities.jsonviews.JsonViews;



@Entity 
@Table(name = "confrontation")
public class Confrontation {
	
	@Id
	@Column(name = "confrontation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Base.class)
    private Long id;
	
	@Column(name = "confrontation_date")
	@JsonView(JsonViews.Base.class)
    private LocalDate dateConfrontation;
	
	@Column(name = "confrontation_duree")
	@JsonView(JsonViews.Base.class)
    private int duree;
	
	@Column(name = "confrontation_home_score")
	@JsonView(JsonViews.Base.class)
    private int scoreDomicile;
	
	@Column(name = "confrontation_away_score")
	@JsonView(JsonViews.Base.class)
    private int scoreVisiteur;
	
	@ManyToOne
	@JoinColumn(name="confrontation_referee_id", foreignKey = @ForeignKey(name="confrontation_referee_id_fk"))
	@JsonView(JsonViews.Base.class)
	private Arbitre arbitre;
	
	@ManyToOne
	@JoinColumn(name="confrontation_team_Home_id", foreignKey = @ForeignKey(name="confrontation_team_Home_id_fk"))
	@JsonView(JsonViews.Base.class)
	private Equipe equipe;
	
	@ManyToOne
	@JoinColumn(name="confrontation_team_Guest_id", foreignKey = @ForeignKey(name="confrontation_team_Guest_id_fk"))
	@JsonView(JsonViews.Base.class)
	private Equipe equipeVisiteur;
	
	@OneToMany(mappedBy="confrontation")
	@Column(name="bookings_confrontation")
	@JsonView(JsonViews.ConfrontationWithReservation.class)
	private Set<Reservation> reservations;
	
	public Confrontation() {
		
	}

	


	public Confrontation(LocalDate dateConfrontation, int duree, int scoreDomicile, int scoreVisiteur, Arbitre arbitre,
			Equipe equipe, Equipe equipeVisiteur, Set<Reservation> reservations) {
		super();
		this.dateConfrontation = dateConfrontation;
		this.duree = duree;
		this.scoreDomicile = scoreDomicile;
		this.scoreVisiteur = scoreVisiteur;
		this.arbitre = arbitre;
		this.equipe = equipe;
		this.equipeVisiteur = equipeVisiteur;
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
	public Equipe getEquipeVisiteur() {
		return equipeVisiteur;
	}

	public void setEquipeVisiteur(Equipe equipeVisiteur) {
		this.equipeVisiteur = equipeVisiteur;
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
