package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Compte;
import entities.StatutRole;
import exceptions.CompteException;
import repositories.CompteRepository;
import repositories.ReservationRepository;

@Service
public class CompteService {
	
	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private ReservationRepository reservationRepo;
		
	private void checkCompte(Compte compte) {
		if (compte == null) {
			throw new CompteException("compte null");
		}
		if (compte.getNom() == null || compte.getLogin().isEmpty()) {
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
		return compteRepo.save(compte);
	}
	
	public Compte update(Compte compte) {
		Compte compteEnBase = getById(compte.getId());
		checkCompte(compte);
		compteEnBase.setLogin(compte.getLogin());
		compteEnBase.setPassword(compte.getPassword());
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
}
