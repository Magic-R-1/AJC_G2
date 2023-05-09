package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Compte;
import exceptions.CompteException;
import repositories.CompteRepository;

@Service
public class CompteService {
	
	@Autowired
	private CompteRepository compteRepo;
	
	private void checkCompte(Compte compte) {
		if (compte == null) {
			throw new CompteException("compte null");
		}
		if (compte.getNom() == null || compte.getNom().isEmpty()) {
			throw new CompteException("nom obligatoire");
		}
	}
	
	public Compte create(Compte compte) {
		checkCompte(compte);
		return compteRepo.save(compte);
	}
	
}
