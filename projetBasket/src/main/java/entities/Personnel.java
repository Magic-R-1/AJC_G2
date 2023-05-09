package entities;

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
@Table(name = "staff")
public class Personnel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	private Long id;
	@Column(name = "staff_last_name")
	private String nom;
	@Column(name = "staff_first_name")
	private String prenom;
	@Column(name = "staff_salary")
	private double salaire;
	@ManyToOne
	@JoinColumn(name="staff_team_id",foreignKey = @ForeignKey(name="staff_team_id_fk"))
	private Equipe equipe;
	
	@Column(name="role")
	private Role role;
	
	public Personnel() {
		super();
	}



	public Personnel(String nom, String prenom, double salaire, Equipe equipe, Role role) {
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
		this.equipe = equipe;
		this.role = role;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
