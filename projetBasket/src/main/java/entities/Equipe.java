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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="team")
public class Equipe {
	
	@Id
	@Column(name = "team_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="team_franchise")
	private String franchise;
	@Column(name="team_city")
	private String ville;
	
	@OneToMany(mappedBy="equipe")
	@Column(name="players")
	private Set<Joueur> joueur;
	
	@OneToMany(mappedBy="equipe")
	@Column(name="confrontations")
	private Set<Confrontation> confrontations;
	
	@OneToOne
	@JoinColumn(name="team_stadium_id", foreignKey = @ForeignKey(name="team_stadium_id_fk"))
	private Stade stade;
	
	@OneToMany(mappedBy="equipe")
	@Column(name="staff")
	private Set<Personnel> personnel;
	
	@OneToOne
	@JoinColumn(name="team_account_id", foreignKey = @ForeignKey(name="team_account_id_fk"))
	private Compte compte;
	
	public Equipe() {
		
	}
	
	public Equipe(String franchise, String ville, Set<Joueur> joueur, Set<Confrontation> confrontations, Stade stade,
			Set<Personnel> personnel, Compte compte) {
		this.franchise = franchise;
		this.ville = ville;
		this.joueur = joueur;
		this.confrontations = confrontations;
		this.stade = stade;
		this.personnel = personnel;
		this.compte = compte;
	}

	public Set<Personnel> getPersonne() {
		return personnel;
	}

	public void setPersonne(Set<Personnel> personne) {
		this.personnel = personne;
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
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Joueur> getJoueur() {
		return joueur;
	}

	public void setJoueur(Set<Joueur> joueur) {
		this.joueur = joueur;
	}

	public Set<Confrontation> getMatchs() {
		return confrontations;
	}

	public void setMatchs(Set<Confrontation> confrontations) {
		this.confrontations = confrontations;
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
