package entities;

import java.util.ArrayList;
import java.util.List;
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
@Table(name="player")
public class Joueur {
	
	@Id
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
	@Transient
	//@Column(name="player_team")
	private Equipe equipe;
	@Column(name="player_status")
	private Statut statut;
	@Column(name="player_position")
	private Poste poste;
	@Transient
	private Set<AptitudePhysique> aptitudesPhysiques;
		
	public Joueur() {
	}

	public Joueur(String nom, String prenom, double taille, double poids, int age, int numeroMaillot, double salaire,
			Equipe equipe, Statut statut, Poste poste, Set<AptitudePhysique> aptitudesPhysiques) {
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


	public Set<AptitudePhysique> getAptitudesPhysiques() {
		return aptitudesPhysiques;
	}


	public void setAptitudesPhysiques(Set<AptitudePhysique> aptitudesPhysiques) {
		this.aptitudesPhysiques = aptitudesPhysiques;
	}


	@Override
	public int hashCode() {
		return Objects.hash(age, aptitudesPhysiques, equipe, nom, numeroMaillot, poids, poste, prenom, salaire, statut,
				taille);
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
		return age == other.age && Objects.equals(aptitudesPhysiques, other.aptitudesPhysiques)
				&& Objects.equals(equipe, other.equipe) && Objects.equals(nom, other.nom)
				&& numeroMaillot == other.numeroMaillot
				&& Double.doubleToLongBits(poids) == Double.doubleToLongBits(other.poids) && poste == other.poste
				&& Objects.equals(prenom, other.prenom)
				&& Double.doubleToLongBits(salaire) == Double.doubleToLongBits(other.salaire) && statut == other.statut
				&& Double.doubleToLongBits(taille) == Double.doubleToLongBits(other.taille);
	}

	
	
}
