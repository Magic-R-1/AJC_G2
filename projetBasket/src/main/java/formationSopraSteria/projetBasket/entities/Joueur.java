package formationSopraSteria.projetBasket.entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonView;

import formationSopraSteria.projetBasket.entities.jsonviews.JsonViews;

@Entity
@Table(name="player")
public class Joueur {
	
	@Id
	@Column(name="player_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Joueur.class)
	private Long id;
	
	@Column(name="player_surname")
	@JsonView(JsonViews.Joueur.class)
	private String nom;
	
	@Column(name="player_name")
	@JsonView(JsonViews.Joueur.class)
	private String prenom;
	
	@Column(name="player_height")
	@JsonView(JsonViews.Joueur.class)
	private double taille;
	
	@Column(name="player_weight")
	@JsonView(JsonViews.Joueur.class)
	private double poids;
	
	@Column(name="player_birth_date")
	@JsonView(JsonViews.Joueur.class)
	private LocalDate date_naissance;
	
	@Column(name="player_jersey_number")
	@JsonView(JsonViews.Joueur.class)
	private int numeroMaillot;
	
	@Column(name="player_wage")
	@JsonView(JsonViews.Joueur.class)
	private double salaire;
	
	@Column(name="player_status")
	@Enumerated(EnumType.STRING)
	@JsonView(JsonViews.Joueur.class)
	private Statut statut;
	
	@Column(name="player_position")
	@Enumerated(EnumType.STRING)
	@JsonView(JsonViews.Joueur.class)
	private Poste poste;
	
	@ManyToOne
    @JoinColumn(name="player_team_id", foreignKey = @ForeignKey(name="player_team_id_fk"))
	@JsonView(JsonViews.JoueurWithEquipe.class)
	private Equipe equipe;
	
	@Embedded
	@JsonView(JsonViews.Joueur.class)
	private AptitudePhysique aptitudesPhysiques;
	
	public Joueur() {
	}

	public Joueur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Joueur(String nom, String prenom, double taille, double poids, LocalDate date_naissance, int numeroMaillot,
			double salaire, Statut statut, Poste poste, Equipe equipe, AptitudePhysique aptitudesPhysiques) {
		this.nom = nom;
		this.prenom = prenom;
		this.taille = taille;
		this.poids = poids;
		this.date_naissance = date_naissance;
		this.numeroMaillot = numeroMaillot;
		this.salaire = salaire;
		this.statut = statut;
		this.poste = poste;
		this.equipe = equipe;
		this.aptitudesPhysiques = aptitudesPhysiques;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	

	public LocalDate getDate_naissance() {
		return date_naissance;
	}



	public void setDate_naissance(LocalDate date_naissance) {
		this.date_naissance = date_naissance;
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

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public AptitudePhysique getAptitudesPhysiques() {
		return aptitudesPhysiques;
	}

	public void setAptitudesPhysiques(AptitudePhysique aptitudesPhysiques) {
		this.aptitudesPhysiques = aptitudesPhysiques;
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
		Joueur other = (Joueur) obj;
		return Objects.equals(id, other.id);
	}
	
}
