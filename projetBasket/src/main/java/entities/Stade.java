package entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="stadium")

public class Stade {

	
	@Id
	@Column(name="stadium_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="stadium_name")
	private String nom;
	
	@Column(name="stadium_capacity")
	private int capacite;
	
	@Column(name="stadium_city")
	private String ville;
	
	@OneToOne(mappedBy="stade")
	@Column(name="team")
	private Equipe equipe;
	
	public Stade() {
		
	}
	
	public Stade(String nom, int capacite, String ville) {
		this.nom = nom;
		this.capacite = capacite;
		this.ville = ville;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getCapacite() {
		return capacite;
	}


	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		Stade other = (Stade) obj;
		return Objects.equals(id, other.id);
	}

	

	
	
	
}
