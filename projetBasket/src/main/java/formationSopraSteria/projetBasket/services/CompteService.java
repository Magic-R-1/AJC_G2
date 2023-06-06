package formationSopraSteria.projetBasket.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formationSopraSteria.projetBasket.entities.Compte;
import formationSopraSteria.projetBasket.entities.StatutRole;
import formationSopraSteria.projetBasket.exceptions.CompteException;
import formationSopraSteria.projetBasket.repositories.CompteRepository;
import formationSopraSteria.projetBasket.repositories.ReservationRepository;

@Service
public class CompteService {
	
	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	private void checkCompte(Compte compte) {
		if (compte == null) {
			throw new CompteException("compte null");
		}
		if (compte.getLogin() == null || compte.getLogin().isEmpty()) {
			throw new CompteException("login obligatoire");
		}
	}
	private void checkId(Long id) {
		if (id == null) {
			throw new CompteException("id null");
		}
	}
	
	public Compte create(Compte compte) {
		checkCompte(compte);
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));
		System.out.println(compte.getPassword());
		return compteRepo.save(compte);
	}
	
	
	public Compte update(Compte compte) {
		Compte compteEnBase = getById(compte.getId());
	
		checkCompte(compte);
		compteEnBase.setLogin(compte.getLogin());
		compteEnBase.setPassword(passwordEncoder.encode(compte.getPassword()));
		compteEnBase.setNom(compte.getNom());
		compteEnBase.setPrenom(compte.getPrenom());
		compteEnBase.setEmail(compte.getEmail());
		compteEnBase.setStatutRole(compte.getStatutRole());		
		return compteRepo.save(compteEnBase);
	}
	public Compte getById(Long id) {
		checkId(id);
		return compteRepo.findById(id).orElseThrow(() -> {
			throw new CompteException("id inconnu");
		});
	}
	
	public Compte getByStatutRole(StatutRole statutRole) {
	    if (statutRole == null) {
	        throw new CompteException("StatutRole null");
	    }
	    return compteRepo.findByStatutRole(statutRole)
	            .orElseThrow(() -> new CompteException("Aucun compte trouvé avec le statutRole spécifié"));
	}
	
	
	public List<Compte> getAll() {
		return compteRepo.findAll();
	}

	
	public void delete(Compte compte) {
		delete(compte.getId());
	}

	public void delete(Long id) {
		Compte compte = getById(id);
		reservationRepo.setCompteToNull(compte);
		compteRepo.delete(compte);

	}
	
	public List<Compte> getByNom(String nom) {
		return compteRepo.findByNomContaining(nom);
	}
	
	public Compte getByLogin(String login) {
		return compteRepo.findByLogin(login).orElseThrow(() -> {
			throw new UsernameNotFoundException("compte inconnu");
		});
	}
	
	public Compte getByEmail(String email) {
		return compteRepo.findByEmail(email).orElseThrow(() -> {
			throw new UsernameNotFoundException("compte inconnu");
		});
	}
	
	public Compte createAdmin(String login,String password) {
		return create(new Compte(login, password, StatutRole.ROLE_ADMIN));
	}
	
	public Compte createClient(String login,String password) {
		return create(new Compte(login, password, StatutRole.ROLE_CLIENT));
	}
	
	public Compte createGm(String login,String password) {
		return create(new Compte(login, password, StatutRole.ROLE_GM));
	}
	
	public boolean checkDoublon(String login, String email) {
	    // Vérification du doublon du login
	    Optional<Compte> compteByLogin = compteRepo.findByLogin(login);
	    if (compteByLogin.isPresent()) {
	        return true; // Doublon trouvé pour le login
	    }

	    // Vérification du doublon de l'email
	    Optional<Compte> compteByEmail = compteRepo.findByEmail(email);
	    if (compteByEmail.isPresent()) {
	        return true; // Doublon trouvé pour l'email
	    }

	    return false; // Aucun doublon trouvé
	}
	
	
}