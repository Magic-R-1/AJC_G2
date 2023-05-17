package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Equipe;
import entities.Stade;
import exceptions.EquipeException;
import exceptions.StadeException;
import repositories.EquipeRepository;
import repositories.StadeRepository;

@Service
public class StadeService {

    @Autowired
    private StadeRepository stadeRepo;
    
    @Autowired
    private EquipeRepository equipeRepo;

    // Trouver tous les stades dans une ville donnée
    public List<Stade> findByVille(String ville) {
        return stadeRepo.findByVille(ville);
    }

     public List<Stade> findByCapaciteGreaterThanEqual(int capacite) {
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
     
     private void checkId(Long id) {
    	 if(id ==null) {
    		 throw new StadeException("id null");
    	 }
     }
     
     
     
     public Stade findByNom(String nom) {
    	  Stade stade = stadeRepo.findByNom(nom).orElseThrow(() -> {
    	        throw new StadeException("stade inconnu");
    	    });
    	    checkStade(stade);

    	    return stade;
    	}


    // Récupérer tous les stades d'une certaine équipe
    public List<Stade> findByEquipe(Equipe equipe) {
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
	
	
	public void delete(Stade stade) {
		equipeRepo.setStadeToNull(stade);
		stadeRepo.delete(stade);

	}
	

}



