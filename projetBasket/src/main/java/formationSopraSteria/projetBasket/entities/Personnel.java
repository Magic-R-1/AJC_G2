package formationSopraSteria.projetBasket.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import formationSopraSteria.projetBasket.entities.jsonviews.JsonViews;

@Entity
@Table(name = "staff")
public class Personnel {
	
	@JsonView(JsonViews.Base.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	private Long id;
	@Column(name = "staff_last_name")
	@JsonView(JsonViews.Base.class)
	private String nom;
	@Column(name = "staff_first_name")
	@JsonView(JsonViews.Base.class)
	private String prenom;
	@Column(name = "staff_salary")
	@JsonView(JsonViews.Base.class)
	private double salaire;
	@ManyToOne
	@JoinColumn(name="staff_team_id",foreignKey = @ForeignKey(name="staff_team_id_fk"))
	private Equipe equipe;
	@Enumerated(EnumType.STRING)
	@Column(name="role_staff")
	private Role_Personnel role_personnel;

	
	public Personnel() {
		super();
	}




	public Personnel(Long id, String nom, String prenom, double salaire, Equipe equipe, Role_Personnel role_personnel) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
		this.equipe = equipe;
		this.role_personnel = role_personnel;
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




	public Role_Personnel getRole_personnel() {
		return role_personnel;
	}




	public void setRole_personnel(Role_Personnel role_personnel) {
		this.role_personnel = role_personnel;
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
		Personnel other = (Personnel) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}