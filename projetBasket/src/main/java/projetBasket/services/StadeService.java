package projetBasket.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetBasket.entities.Equipe;
import projetBasket.entities.Stade;
import projetBasket.exceptions.EquipeException;
import projetBasket.exceptions.StadeException;
import projetBasket.repositories.EquipeRepository;
import projetBasket.repositories.StadeRepository;

@Service
public class StadeService {

    @Autowired
    private StadeRepository stadeRepo;
    
    @Autowired
    private EquipeRepository equipeRepo;

    // Trouver tous les stades dans une ville donnée
    public List<Stade> trouverStadesParVille(String ville) {
        return stadeRepo.findByVille(ville);
    }

//    // Trouver tous les stades dont la capacité est supérieure ou égale à une certaine valeur
//    public List<Stade> trouverStadesParCapacite(int capacite) {
//        return stadeRepository.findByCapaciteGreaterThanEqual(capacite);
//    }

//    // Trouver le stade qui a la capacité maximale
//    public Stade trouverStadeAvecCapaciteMaximale() {
//        return stadeRepository.findTopByOrderByCapaciteDesc();
//    }

    // Récupérer un stade en fonction de son nom
    public Optional<Stade> trouverStadeParNom(String nom) {
        return stadeRepo.findByNom(nom);
    }

    // Récupérer tous les stades d'une certaine équipe
    public List<Stade> trouverStadesParEquipe(Equipe equipe) {
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
	
	public void delete(Long id) {
		this.delete(this.getById(id));
	}
    
}



