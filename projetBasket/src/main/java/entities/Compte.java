package entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "account")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
	protected Long id;
	@Column(name="account_login")
	protected String login;
	@Column(name="account_password")
	protected String password;	
	@Column(name="account_last_name")
	private String nom;
	@Column(name="account_first_name")
	private String prenom;
	@Column(name="account_email")
	protected String email;
	@Column(name="account_status")
	private StatutRole statutRole;
	@OneToMany(mappedBy="compte")
	@Column(name="bookings")
	private Set<Reservation> reservations;
	@OneToOne(mappedBy="compte")
	private Equipe equipe;
	
	public Compte() {
		
	}
	public Compte(Long id, String login, String password, String nom, String prenom, String email,
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
