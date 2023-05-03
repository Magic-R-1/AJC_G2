package entities;

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
@Table(name="team")
public class Equipe {
	
	@Id
	@Column(name = "id_team")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="team_franchise")
	private String franchise;
	
	@Column(name="team_city")
	private String ville;
	
	//@Column(name="player")
	@Transient
	private Set<Joueur> joueur;
	
	//@Column(name="match")
	@Transient
	private Set<BasketMatch> matchs;
	
	//@Column(name="stadium")
	@Transient
	private Stade stade;
	
	//@Column(name="people")
	@Transient
	private Personne personne;
	
	
	public Equipe() {
		
	}
	
	public Equipe(String franchise, String ville, Stade stade, Personne personne) {
		this.franchise = franchise;
		this.ville = ville;
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


	public Stade getStade() {
		return stade;
	}


	public void setStade(Stade stade) {
		this.stade = stade;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Joueur> getJoueur() {
		return joueur;
	}

	public void setJoueur(Set<Joueur> joueur) {
		this.joueur = joueur;
	}

	public Set<BasketMatch> getMatchs() {
		return matchs;
	}

	public void setMatchs(Set<BasketMatch> matchs) {
		this.matchs = matchs;
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
		Equipe other = (Equipe) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
	

	
	
	
	
}
