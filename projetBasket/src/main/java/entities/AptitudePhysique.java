package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="physical_ability")
public class AptitudePhysique {

	@Id
	@Column(name = "physical_ability_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="speed")
	private int vitesse;
	@Column(name="endurance")
	private int endurance;
	@Column(name="strength")
	private int force;
	@Column(name="jump")
	private int detente;
	@Column(name="agility")
	private int agilite;
	@OneToOne
	@JoinColumn(name="physical_ability_player_id", foreignKey = @ForeignKey(name="physical_ability_player_id_fk"))
	private Joueur joueur;
	
	public AptitudePhysique() {
	}
	
	public AptitudePhysique(int vitesse, int endurance, int force, int detente, int agilite) {
		super();
		this.vitesse = vitesse;
		this.endurance = endurance;
		this.force = force;
		this.detente = detente;
		this.agilite = agilite;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getDetente() {
		return detente;
	}

	public void setDetente(int detente) {
		this.detente = detente;
	}

	public int getAgilite() {
		return agilite;
	}

	public void setAgilite(int agilite) {
		this.agilite = agilite;
	}


	
}