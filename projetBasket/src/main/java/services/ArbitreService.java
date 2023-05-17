package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Arbitre;
import entities.Confrontation;
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
	
	public ArbitreService(ArbitreRepository arbitreRepository) {
        this.arbitreRepo = arbitreRepository;
    }
	
	public List<Arbitre> findByConfrontation(Confrontation confrontation) {
        return arbitreRepo.findByConfrontation(confrontation);
    }
}
