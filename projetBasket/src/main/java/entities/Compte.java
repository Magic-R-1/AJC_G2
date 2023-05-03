package entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "compte")
public abstract class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="compte_id")
	protected Integer id;
	@Column(name="compte_login")
	protected String login;
	@Column(name="compte_password")
	protected String password;	
	@Column(name="compte_last_name")
	private String nom;
	@Column(name="compte_first_name")
	private String prenom;
	@Column(name="compte_email")
	protected String email;
	@Column(name="compte_statut")
	private StatutRole statutRole;
	
	public Compte() {
		
	}
	public Compte(Integer id, String login, String password, String nom, String prenom, String email,
			StatutRole statutRole) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.statutRole = statutRole;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public StatutRole getStatutRole() {
		return statutRole;
	}
	public void setStatutRole(StatutRole statutRole) {
		this.statutRole = statutRole;
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
		Compte other = (Compte) obj;
		return Objects.equals(id, other.id);
	}
		
	
	
}
