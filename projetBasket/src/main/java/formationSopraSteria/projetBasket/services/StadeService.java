package formationSopraSteria.projetBasket.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formationSopraSteria.projetBasket.entities.Equipe;
import formationSopraSteria.projetBasket.entities.Stade;
import formationSopraSteria.projetBasket.exceptions.EquipeException;
import formationSopraSteria.projetBasket.exceptions.StadeException;
import formationSopraSteria.projetBasket.repositories.EquipeRepository;
import formationSopraSteria.projetBasket.repositories.StadeRepository;

@Service
@Transactional
public class StadeService {

    @Autowired
    private StadeRepository stadeRepo;
    
    @Autowired
    private EquipeRepository equipeRepo;

   
    public List<Stade> getByVille(String ville) {
        return stadeRepo.findByVille(ville);
    }

     public List<Stade> getByCapaciteGreaterThanEqual(int capacite) {
        return stadeRepo.findByCapaciteGreaterThanEqual(capacite);
    }


     private void checkStade (Stade stade) {
    	 if(stade == null) {
    		 throw new StadeException("stade null");
    	 }
    	 if (stade.getNom() == null || stade.getNom().isEmpty()) {
    		 throw new StadeException("nom obligatoire");
    	 }
     }
     
     public Stade getByNom(String nom) {
    	  Stade stade = stadeRepo.findByNom(nom).orElseThrow(() -> {
    	        throw new StadeException("stade inconnu");
    	    });
    	    checkStade(stade);

    	    return stade;
    	}


    // Récupérer tous les stades d'une certaine équipe
    public List<Stade> getByEquipe(Equipe equipe) {
        return stadeRepo.findByEquipe(equipe);
    }
    
    public List<Stade> getAll() {
		return stadeRepo.findAll();
	}
    

    public Stade getById(Long id) {
		if (id == null) {
			throw new StadeException("id obligatoire");
		}
		return stadeRepo.findById(id).orElseThrow(() -> {
			throw new StadeException("id inconnu");
		});
	}
    
	public Stade create(Stade stade) {
		if (stade.getNom() == null || stade.getNom().isEmpty()) {
			throw new EquipeException("Nom obligatoire");
		}
		return stadeRepo.save(stade);
	}

	public Stade create(String nom, int capacite, String ville) {
		return this.create(new Stade(nom, capacite, ville));
	}
	
	public Stade update(Stade stade) {
		Stade stadeEnBase = this.getById(stade.getId());
		if (stade.getNom() != null && !stade.getNom().isEmpty()) {
			stadeEnBase.setNom(stade.getNom());
		}
		stadeEnBase.setCapacite(stade.getCapacite());
		stadeEnBase.setVille(stade.getVille());
		return stadeRepo.save(stadeEnBase);
	}
	
	
	public void delete(Long id) {
		Stade stadeEnBase = getById(id);
		equipeRepo.setStadeToNull(stadeEnBase);
		stadeRepo.delete(stadeEnBase);
	}

	public void deleteMultiple(List<Long> ids) {
	    for (Long id : ids) {
	        stadeRepo.deleteById(id);
	    }
	}

	

}