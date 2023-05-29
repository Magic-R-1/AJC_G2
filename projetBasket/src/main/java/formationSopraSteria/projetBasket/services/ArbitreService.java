package formationSopraSteria.projetBasket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formationSopraSteria.projetBasket.entities.Arbitre;
import formationSopraSteria.projetBasket.exceptions.ArbitreException;
import formationSopraSteria.projetBasket.repositories.ArbitreRepository;
import formationSopraSteria.projetBasket.repositories.ConfrontationRepository;

@Service
public class ArbitreService {
	
	@Autowired
	private ArbitreRepository arbitreRepo;
	
	@Autowired
	private ConfrontationRepository confrontationRepo;
	
	private void checkArbitre(Arbitre arbitre) {
		if (arbitre == null) {
			throw new ArbitreException("arbitre null");
		}
		if (arbitre.getNom() == null || arbitre.getNom().isEmpty()) {
			throw new ArbitreException("nom obligatoire");
		}
	}
	
	private void checkId(Long id) {
		if (id == null) {
			throw new ArbitreException("id null");
		}
	}
	public Arbitre create(Arbitre arbitre) {
		checkArbitre(arbitre);
		return arbitreRepo.save(arbitre);
	}
	public Arbitre update(Arbitre arbitre) {
		Arbitre arbitreEnBase = getById(arbitre.getId());
		checkArbitre(arbitre);
		arbitreEnBase.setNom(arbitre.getNom());
		arbitreEnBase.setPrenom(arbitre.getPrenom());
		arbitreEnBase.setAnciennete(arbitre.getAnciennete());
		arbitreEnBase.setNationalite(arbitre.getNationalite());		
		return arbitreRepo.save(arbitreEnBase);
	}
	public Arbitre getById(Long id) {
		checkId(id);
		return arbitreRepo.findById(id).orElseThrow(() -> {
			throw new ArbitreException("id inconnu");
		});
	}
	
	public ArbitreService(ArbitreRepository arbitreRepository) {
        this.arbitreRepo = arbitreRepository;
    }
	
	public List<Arbitre> getAll() {
		return arbitreRepo.findAll();
	}
	
	public void delete(Arbitre arbitre) {
		delete(arbitre.getId());
	}
	
	public void delete(Long id) {
		Arbitre arbitre = getById(id);
		confrontationRepo.setArbitreToNull(arbitre);
		arbitreRepo.delete(arbitre);

	}
	public List<Arbitre> getByNom(String nom) {
		return arbitreRepo.findByNomContaining(nom);
	}
}