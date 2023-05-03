package entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity 
@Table(name = "arbitre")
public class Arbitre {
	
	@Id
	@Column(name = "referee_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "referee_last_name", nullable = false)
	private String nom;
	@Column(name = "referee_first_name", nullable = false)
    private String prenom;
	@Column(name = "referee_seniority")
    private int anciennete;
	@Column(name = "referee_nationality")
    private String nationalite;
    
	//@OneToMany(mappedBy = "arbitre")
	//private Set<BasketMatch> basketmatchs;
	
	
	public Arbitre() {
		
	}


	public Arbitre(Long id, String nom, String prenom, int anciennete, String nationalite) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.anciennete = anciennete;
		this.nationalite = nationalite;
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


	public int getAnciennete() {
		return anciennete;
	}


	public void setAnciennete(int anciennete) {
		this.anciennete = anciennete;
	}


	public String getNationalite() {
		return nationalite;
	}


	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
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
		Arbitre other = (Arbitre) obj;
		return Objects.equals(id, other.id);
	}


	
	
	
}
