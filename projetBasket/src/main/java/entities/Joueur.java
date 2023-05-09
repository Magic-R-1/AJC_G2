package entities;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="player")
public class Joueur {
	
	@Id
	@Column(name="player_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="player_surname")
	private String nom;
	@Column(name="player_name")
	private String prenom;
	@Column(name="player_height")
	private double taille;
	@Column(name="player_weight")
	private double poids;
	@Column(name="player_age")
	private int age;
	@Column(name="player_jersey_number")
	private int numeroMaillot;
	@Column(name="player_wage")
	private double salaire;
	@Column(name="player_status")
	private Statut statut;
	@Column(name="player_position")
	private Poste poste;
	@ManyToOne
    @JoinColumn(name="player_team_id", foreignKey = @ForeignKey(name="player_team_id_fk"))
	private Equipe equipe;
	@OneToOne(mappedBy="joueur")
	@Column(name="physical_ability")
	private AptitudePhysique aptitudesPhysiques;
	
	public Joueur() {
	}

	public Joueur(String nom, String prenom, double taille, double poids, int age, int numeroMaillot, double salaire,
			Statut statut, Poste poste, Equipe equipe, AptitudePhysique aptitudesPhysiques) {
		this.nom = nom;
		this.prenom = prenom;
		this.taille = taille;
		this.poids = poids;
		this.age = age;
		this.numeroMaillot = numeroMaillot;
		this.salaire = salaire;
		this.statut = statut;
		this.poste = poste;
		this.equipe = equipe;
		this.aptitudesPhysiques = aptitudesPhysiques;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
