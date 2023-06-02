package formationSopraSteria.projetBasket.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;

import formationSopraSteria.projetBasket.entities.jsonviews.JsonViews;

@Entity 
@Table(name = "account")

public class Compte implements UserDetails  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
	@JsonView(JsonViews.Base.class)
	protected Long id;
	
	@NotBlank(message = "*ne doit pas etre vide")
	@Column(name="account_login",nullable = false)
	@JsonView(JsonViews.Base.class)
	protected String login;
	
	@NotBlank(message = "*ne doit pas Ãªtre vide")
	@Column(name="account_password",nullable = false)
	@JsonView(JsonViews.Base.class)
	protected String password;	
	
	@Column(name="account_last_name")
	@JsonView(JsonViews.Base.class)
	private String nom;
	
	@Column(name="account_first_name")
	@JsonView(JsonViews.Base.class)
	private String prenom;
	
	@Column(name="account_email")
	@JsonView(JsonViews.Base.class)
	protected String email;
	
	@Column(name="account_status")
	@JsonView(JsonViews.Base.class)
	@Enumerated(EnumType.STRING)
	private StatutRole statutRole;
	
	@OneToMany(mappedBy="compte")
	@Column(name="bookings")
	@JsonView(JsonViews.CompteWithReservation.class)
	private Set<Reservation> reservations;
	
	@OneToOne(mappedBy="compte")
	@JsonView(JsonViews.Compte.class)
	private Equipe equipe;
	
	public Compte() {
		
	}
	
	public Compte(String login, String password,
			StatutRole statutRole) {
		super();
		this.login = login;
		this.password = password;
		this.statutRole = statutRole;
	}
	
	
	public Compte( String login, String password, String nom, String prenom, String email,
			StatutRole statutRole) {
		super();
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
	
	
	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(statutRole.toString()));
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	}
		
	
	