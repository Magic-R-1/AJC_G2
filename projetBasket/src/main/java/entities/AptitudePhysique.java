package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable //Reviens à faire une table avec @Entity, mais ici avec Embeddable sera directement embarqué dans la classe mère (ici Joueur). Chaque colonne ci-dessous apparaitra dans Joueur.
public class AptitudePhysique {

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