package projetBasket.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetBasket.entities.Compte;
import projetBasket.entities.Confrontation;
import projetBasket.entities.Equipe;
import projetBasket.entities.Joueur;
import projetBasket.entities.Personnel;
import projetBasket.entities.Stade;
import projetBasket.exceptions.EquipeException;
import projetBasket.repositories.CompteRepository;
import projetBasket.repositories.ConfrontationRepository;
import projetBasket.repositories.EquipeRepository;
import projetBasket.repositories.JoueurRepository;
import projetBasket.repositories.PersonnelRepository;
import projetBasket.repositories.StadeRepository;

@Service
public class EquipeService {
	
	@Autowired
	private EquipeRepository equipeRepository;
	
	@Autowired
	private JoueurRepository joueurRepository;
	
	@Autowired
	private ConfrontationRepository confrontationRepository;
	
	
	@Autowired
	private StadeRepository stadeRepository;
	
	
	@Autowired
	private PersonnelRepository personnelRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	
	public List<Equipe> findByVille(String ville) {
		return equipeRepository.findByVille(ville);
	}
	
	public List<Equipe> findByJoueurNom(String nom) {
		return equipeRepository.findByJoueurNom(nom);
	}
	
	public List<Equipe> findByFranchise(String franchise){
		return equipeRepository.findByFranchise(franchise);
	}

//	public List<Equipe> findByConfrontation(Confrontation confrontation){
//		return equipeRepository.findByConfrontation(confrontation);
//	}
	
	public List<Equipe> findByStade(Stade stade){
		return equipeRepository.findByStade(stade);
	}
	
	public List<Equipe> findByPersonnel(Personnel personnel){
		return equipeRepository.findByPersonnel(personnel);
	}
	
	public List<Equipe> findByCompte(Compte compte){
		return equipeRepository.findByCompte(compte);
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
	
	public void delete(Equipe equipe) {
		joueurRepository.setEquipeToNull(equipe);
		confrontationRepository.setEquipeToNull(equipe);
		stadeRepository.setEquipeToNull(equipe);
		personnelRepository.setEquipeToNull(equipe);
		compteRepository.setEquipeToNull(equipe);
		
		equipeRepository.delete(equipe);

	}
	
	public void delete(Long id) {
		this.delete(this.getById(id));
	}
    


	
}

