package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Arbitre;
import exceptions.ArbitreException;
import repositories.ArbitreRepository;

@Service
public class ArbitreService {
	
	@Autowired
	private ArbitreRepository arbitreRepo;
	
	private void checkArbitre(Arbitre arbitre) {
		if (arbitre == null) {
			throw new ArbitreException("arbitre null");
		}
		if (arbitre.getNom() == null || arbitre.getNom().isEmpty()) {
			throw new ArbitreException("nom obligatoire");
		}
	}
	
	public Arbitre create(Arbitre arbitre) {
		checkArbitre(arbitre);
		return arbitreRepo.save(arbitre);
	}
	
}
