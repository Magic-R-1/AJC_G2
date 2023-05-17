package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Compte;
import entities.Equipe;
import entities.Stade;
import exceptions.EquipeException;
import exceptions.StadeException;
import repositories.EquipeRepository;
import repositories.StadeRepository;

@Service
public class StadeService {

    @Autowired
    private StadeRepository stadeRepository;
    
    @Autowired
    private EquipeRepository equipeRepository;

    // Trouver tous les stades dans une ville donnée
    public List<Stade> trouverStadesParVille(String ville) {
        return stadeRepository.findByVille(ville);
    }

    // Trouver tous les stades dont la capacité est supérieure ou égale à une certaine valeur
    public List<Stade> trouverStadesParCapacite(int capacite) {
        return stadeRepository.findByCapaciteGreaterThanEqual(capacite);
    }

    // Trouver le stade qui a la capacité maximale
    public Stade trouverStadeAvecCapaciteMaximale() {
        return stadeRepository.findTopByOrderByCapaciteDesc();
    }

    // Récupérer un stade en fonction de son nom
    public Optional<Stade> trouverStadeParNom(String nom) {
        return stadeRepository.findByNom(nom);
    }

    // Récupérer tous les stades d'une certaine équipe
    public List<Stade> trouverStadesParEquipe(Equipe equipe) {
        return stadeRepository.findByEquipe(equipe);
    }
    
    
    public Stade getById(Long id) {
		if (id == null) {
			throw new StadeException("id obligatoire");
		}
		return stadeRepository.findById(id).orElseThrow(() -> {
			throw new StadeException("id inconnu");
		});
	}
    
	public Stade create(Stade stade) {
		if (stade.getNom() == null || stade.getNom().isEmpty()) {
			throw new EquipeException("Nom obligatoire");
		}
		return stadeRepository.save(stade);
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
		return stadeRepository.save(stadeEnBase);
	}
	
	
	public void delete(Stade stade) {
		equipeRepository.setStadeToNull(stade);
		stadeRepository.delete(stade);

	}
	
	public void delete(Long id) {
		this.delete(this.getById(id));
	}
    
}



