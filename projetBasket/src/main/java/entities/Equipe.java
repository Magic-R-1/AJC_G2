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

import com.fasterxml.jackson.annotation.JsonView;

import entities.jsonviews.JsonViews;


@Entity
@Table(name="team")
public class Equipe {
	
	@Id
	@Column(name = "team_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="team_franchise")
	@JsonView(JsonViews.Base.class)
	private String franchise;
	@Column(name="team_city")
	@JsonView(JsonViews.Base.class)
	private String ville;
	
	@OneToMany(mappedBy="equipe")
	@Column(name="players")
	@JsonView(JsonViews.EquipeWithJoueur.class)
	private Set<Joueur> joueur;
	
	@OneToMany(mappedBy="equipe")
	@Column(name="confrontation")
	@JsonView(JsonViews.EquipeWithConfrontation.class)
	private Set<Confrontation> confrontation;
	
	@OneToOne
	@JoinColumn(name="team_stadium_id", foreignKey = @ForeignKey(name="team_stadium_id_fk"))
	@JsonView(JsonViews.EquipeWithStade.class)
	private Stade stade;
	
	@OneToMany(mappedBy="equipe")
	@Column(name="staff")
	@JsonView(JsonViews.EquipeWithPersonnel.class)
	private Set<Personnel> personnel;
	
	@OneToOne
	@JoinColumn(name="team_account_id", foreignKey = @ForeignKey(name="team_account_id_fk"))
	@JsonView(JsonViews.EquipeWithCompte.class)
	private Compte compte;
	
	
	
	
	public Equipe() {
		
	}
	
	public Equipe(String franchise, String ville, Set<Joueur> joueur, Set<Confrontation> confrontation, Stade stade,
			Set<Personnel> personnel, Compte compte) {
		this.franchise = franchise;
		this.ville = ville;
		this.joueur = joueur;
		this.confrontation = confrontation;
		this.stade = stade;
		this.personnel = personnel;
		this.compte = compte;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<Joueur> getJoueur() {
		return joueur;
	}

	public void setJoueur(Set<Joueur> joueur) {
		this.joueur = joueur;
	}

	public Set<Confrontation> getConfrontation() {
		return confrontation;
	}

	public void setConfrontation(Set<Confrontation> confrontation) {
		this.confrontation = confrontation;
	}

	public Stade getStade() {
		return stade;
	}

	public void setStade(Stade stade) {
		this.stade = stade;
	}

	public Set<Personnel> getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Set<Personnel> personnel) {
		this.personnel = personnel;
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
		Equipe other = (Equipe) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
	

	
	
	
	
}
