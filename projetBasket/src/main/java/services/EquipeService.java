package services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Compte;
import entities.Confrontation;
import entities.Equipe;
import entities.Joueur;
import entities.Personnel;
import entities.Stade;
import exceptions.EquipeException;
import repositories.EquipeRepository;

@Service
public class EquipeService {
	
	@Autowired
	private EquipeRepository equipeRepository;
	
	public Equipe findEquipeByNom(String nom) {
		return equipeRepository.findEquipeByNom(nom);
	}
	
	public List<Equipe> findByVille(String ville) {
		return equipeRepository.findByVille(ville);
	}
	
	public List<Equipe> findByJoueurNom(String nom) {
		return equipeRepository.findByJoueurNom(nom);
	}
	
	 // Trouver toutes les équipes ayant joué une confrontation après une certaine date
    public List<Equipe> findByConfrontationDateAfter(LocalDate date) {
        return equipeRepository.findByConfrontationDateAfter(date);
    }
	
	public List<Equipe> findEquipesByMembreReservationBetweenDates(LocalDate dateDebut, LocalDate dateFin, Compte compte) {
		return equipeRepository.findEquipesByMembreReservationBetweenDates(dateDebut, dateFin, compte);
	}
	
	public List<Equipe> findEquipesByDateCreationBefore(LocalDate date) {
		return equipeRepository.findEquipesByDateCreationBefore(date);
	}
	
	public List<Equipe> findEquipesByResponsable(Compte compte) {
		return equipeRepository.findEquipesByResponsable(compte);
	}
	
	public List<Equipe> findEquipesByNomContaining(String nom) {
		return equipeRepository.findEquipesByNomContaining(nom);
	}
	
	
	// Trouver toutes les équipes avec leur moyenne d'âge
    public List<Equipe> trouverEquipesAvecMoyenneAge() {
        return equipeRepository.trouverEquipesAvecMoyenneAge();
    }
    
    // Trouver toutes les équipes avec leur joueur ayant la plus grande taille
    public List<Equipe> trouverEquipesAvecJoueurPlusGrand() {
        return equipeRepository.trouverEquipesAvecJoueurPlusGrand();
    }
	
	public List<Equipe> findAllEquipesWithConfrontation() {
		return equipeRepository.findAllEquipesWithConfrontation();
	}
	
	public List<Equipe> findAllEquipesWithoutConfrontation() {
		return equipeRepository.findAllEquipesWithoutConfrontation();
	}
	
	
	 // Trouver toutes les équipes ayant joué contre une équipe donnée
    public List<Equipe> findOpponentsOfEquipe(Equipe equipe) {
        return equipeRepository.findOpponentsOfEquipe(equipe);
    }

    

	public Equipe getById(Long id) {
	
		if (id == null) {
			throw new EquipeException("id obligatoire");
		}
		return equipeRepository.findById(id).orElseThrow(() -> {
			throw new EquipeException("id inconnu");
		});

		
	}
	
	public Equipe create(Equipe equipe) {
		if (equipe.getFranchise() == null || equipe.getFranchise().isEmpty()) {
			throw new EquipeException("Franchise obligatoire");
		}
		return equipeRepository.save(equipe);
	}

	public Equipe create(String franchise, String ville, Set <Joueur> joueur, Set <Confrontation> confrontation, Stade stade, Set <Personnel> personnel, Compte compte ) {
		return this.create(new Equipe(franchise, ville, joueur, confrontation, stade, personnel, compte));
	}
	
	public Equipe update(Equipe equipe) {
		Equipe equipeEnBase = this.getById(equipe.getId());
		if (equipe.getFranchise() != null && !equipe.getFranchise().isEmpty()) {
			equipeEnBase.setFranchise(equipe.getFranchise());
		}
		equipeEnBase.setJoueur(equipe.getJoueur());
		equipeEnBase.setMatchs(equipe.getMatchs());
		equipeEnBase.setPersonne(equipe.getPersonne());
		equipeEnBase.setStade(equipe.getStade());
		equipeEnBase.setVille(equipe.getVille());
		return equipeRepository.save(equipeEnBase);
	}
	
	
	
	
    


	
}

