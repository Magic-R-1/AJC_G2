package entities;


public class AptitudePhysique {

	private int vitesse;
	private int endurance;
	private int force;
	private int detente;
	private int agilite;
	
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