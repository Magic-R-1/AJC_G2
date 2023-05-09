package entities;

import java.time.LocalDate;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity 
@Table(name = "confrontation")
public class Confrontation {
	
	@Id
	@Column(name = "confrontation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "confrontation_date")
    private LocalDate date;
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
	
	
	public Confrontation() {
		
	}



	public Confrontation(Long id, LocalDate date, int duree, int scoreDomicile, int scoreVisiteur) {
		super();
		this.id = id;
		this.date = date;
		this.duree = duree;
		this.scoreDomicile = scoreDomicile;
		this.scoreVisiteur = scoreVisiteur;
	}







	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
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
