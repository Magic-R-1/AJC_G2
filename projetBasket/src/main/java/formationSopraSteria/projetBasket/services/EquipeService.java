package formationSopraSteria.projetBasket.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formationSopraSteria.projetBasket.entities.Compte;
import formationSopraSteria.projetBasket.entities.Confrontation;
import formationSopraSteria.projetBasket.entities.Equipe;
import formationSopraSteria.projetBasket.entities.Joueur;
import formationSopraSteria.projetBasket.entities.Personnel;
import formationSopraSteria.projetBasket.entities.Poste;
import formationSopraSteria.projetBasket.entities.Stade;
import formationSopraSteria.projetBasket.exceptions.EquipeException;
import formationSopraSteria.projetBasket.repositories.CompteRepository;
import formationSopraSteria.projetBasket.repositories.ConfrontationRepository;
import formationSopraSteria.projetBasket.repositories.EquipeRepository;
import formationSopraSteria.projetBasket.repositories.JoueurRepository;
import formationSopraSteria.projetBasket.repositories.PersonnelRepository;
import formationSopraSteria.projetBasket.repositories.StadeRepository;

@Service
@Transactional
public class EquipeService {
	
	@Autowired
	private EquipeRepository equipeRepo;
	
	@Autowired
	private JoueurRepository joueurRepo;
	
	@Autowired
	private ConfrontationRepository confrontationRepo;
	
	
	@Autowired
	private StadeRepository stadeRepo;
	
	
	@Autowired
	private PersonnelRepository personnelRepo;
	
	@Autowired
	private CompteRepository compteRepo;
	
	
	private void checkEquipe(Equipe equipe) {
		if (equipe == null) {
			throw new EquipeException("equipe inconnue");
		}
		if (equipe.getFranchise() == null || equipe.getFranchise().isEmpty()) {
			throw new EquipeException("franchise obligatoire");
		}
		
	}
	

	private void checkId(Long id) {
		if (id == null) {
			throw new EquipeException("id null");
		}
	}
	
	
	public List<Equipe> getByVille(String ville) {
		return equipeRepo.findByVille(ville);
	}
	
	public List<Equipe> getByJoueurNom(String nom) {
		return equipeRepo.findByJoueurNom(nom);
	}
	
	public Equipe getByFranchise(String franchise) {
		Equipe equipe = equipeRepo.findByFranchise(franchise).orElseThrow(() -> {
  	        throw new EquipeException("equipe inconnu");
  	    });
  	    checkEquipe(equipe);

  	    return equipe;
  	}


	public List<Equipe> getByConfrontation(Confrontation confrontation){
		return equipeRepo.findByConfrontation(confrontation);
	}
	
	public List<Equipe> getByStade(Stade stade){
		return equipeRepo.findByStade(stade);
	}
	
	public List<Equipe> getByPersonnel(Personnel personnel){
		return equipeRepo.findByPersonnel(personnel);
	}
	
	public Equipe getByCompte(Compte compte) {
		Equipe equipe = equipeRepo.findByCompte(compte).orElseThrow(() -> {
  	        throw new EquipeException("equipe inconnu");
  	    });
  	    checkEquipe(equipe);

  	    return equipe;
  	}
	
	
	public List<Equipe> getByConfrontations_DateConfrontation(LocalDate dateConfrontation){
		return equipeRepo.findByConfrontation_DateConfrontation(dateConfrontation);
	}
	
	public List<Equipe> getByJoueur_SalaireGreaterThan(double salaire){
		return equipeRepo.findByJoueur_SalaireGreaterThan(salaire);
	}
	
	public List<Equipe> getByPersonnel_SalaireLessThan(double salaire){
		return equipeRepo.findByPersonnel_SalaireLessThan(salaire);
	}
	
	public List<Equipe> getByJoueur_Poste(Poste poste){
		return equipeRepo.findByJoueur_Poste(poste);
	}
	
	
	 public List<Equipe> getAll() {
			return equipeRepo.findAll();
		}

	 public Equipe getById(Long id) {
			checkId(id);
			return equipeRepo.findById(id).orElseThrow(() -> {
				throw new EquipeException("id inconnu");
			});
		}


	 public Equipe create(Equipe equipe) {
	        checkEquipe(equipe);
	        return equipeRepo.save(equipe);
	    }
	 

	public Equipe update(Equipe equipe) {
	    Equipe equipeEnBase = getById(equipe.getId());
	   
	    checkEquipe(equipe);
	    
	    equipeEnBase.setVille(equipe.getVille());
	    equipeEnBase.setFranchise(equipe.getFranchise());


	    
	    if (equipe.getJoueur() != null) {
	        Set<Joueur> joueursEnBase = equipeEnBase.getJoueur();
	        Set<Joueur> joueursMiseAJour = equipe.getJoueur();

	        
	        for (Joueur joueurMiseAJour : joueursMiseAJour) {
	          
	            Joueur joueurEnBase = getJoueurById(joueursEnBase, joueurMiseAJour.getId());

	            if (joueurEnBase != null) {
	             
	                joueurEnBase.setNom(joueurMiseAJour.getNom());
	               
	            } else {
	              
	                joueursEnBase.add(joueurMiseAJour);
	            }
	        }

	      
	        joueursEnBase.retainAll(joueursMiseAJour);

	        equipeEnBase.setJoueur(joueursEnBase);
	    }
	    
	    
	    if (equipe.getPersonnel() != null) {
	        Set<Personnel> personnelsEnBase = equipeEnBase.getPersonnel();
	        Set<Personnel> personnelsMiseAJour = equipe.getPersonnel();

	      
	        for (Personnel personnelMiseAJour : personnelsMiseAJour) {
	           
	            Personnel personnelEnBase = getPersonnelById(personnelsEnBase, personnelMiseAJour.getId());

	            if (personnelEnBase != null) {
	                
	                personnelEnBase.setNom(personnelMiseAJour.getNom());
	              
	            } else {
	               
	                personnelsEnBase.add(personnelMiseAJour);
	            }
	        }

	        
	        equipeEnBase.setPersonnel(personnelsEnBase);
	    }
	    
	 
	    if (equipe.getConfrontation() != null) {
	        Set<Confrontation> confrontationsEnBase = equipeEnBase.getConfrontation();
	        Set<Confrontation> confrontationsMiseAJour = equipe.getConfrontation();

	     
	        for (Confrontation confrontationMiseAJour : confrontationsMiseAJour) {
	         
	            Confrontation confrontationEnBase = getConfrontationById(confrontationsEnBase, confrontationMiseAJour.getId());

	            if (confrontationEnBase != null) {
	           
	                confrontationEnBase.setId(confrontationMiseAJour.getId());
	        
	            } else {
	          
	                confrontationsEnBase.add(confrontationMiseAJour);
	            }
	        }

	        equipeEnBase.setConfrontation(confrontationsEnBase);
	    }

	
	    if (equipe.getStade() != null) {
	        Stade stade = equipeEnBase.getStade();
	        if (stade == null) {
	            stade = new Stade();
	            equipeEnBase.setStade(stade);
	        }
	        stade.setNom(equipe.getStade().getNom());
	        stade.setCapacite(equipe.getStade().getCapacite());
	        stade.setVille(equipe.getStade().getVille());
	    }

	  
	    if (equipe.getCompte() != null) {
	        Compte compte = equipeEnBase.getCompte();
	        if (compte == null) {
	            compte = new Compte();
	            equipeEnBase.setCompte(compte);
	        }
	        compte.setNom(equipe.getCompte().getNom());
	        compte.setEmail(equipe.getCompte().getEmail());
	        compte.setLogin(equipe.getCompte().getLogin());
	        compte.setPassword(equipe.getCompte().getPassword());
	        compte.setPrenom(equipe.getCompte().getPrenom());
	        compte.setStatutRole(equipe.getCompte().getStatutRole());
	        
	        equipeEnBase.setCompte(compte);
	    }

	    
	    
	    
	    
	    return equipeRepo.save(equipeEnBase);
	}
	
	

	// Méthode utilitaire pour obtenir un joueur à partir de son ID
	private Joueur getJoueurById(Set<Joueur> joueurs, Long id) {
	    for (Joueur joueur : joueurs) {
	        if (joueur.getId().equals(id)) {
	            return joueur;
	        }
	    }
	    return null;
	}
	
	
	// Méthode utilitaire pour obtenir un membre du personnel à partir de son ID
	private Personnel getPersonnelById(Set<Personnel> personnels, Long id) {
	    for (Personnel personnel : personnels) {
	        if (personnel.getId().equals(id)) {
	            return personnel;
	        }
	    }
	    return null;
	}

	// Méthode utilitaire pour obtenir une confrontation à partir de son ID
	private Confrontation getConfrontationById(Set<Confrontation> confrontations, Long id) {
	    for (Confrontation confrontation : confrontations) {
	        if (confrontation.getId().equals(id)) {
	            return confrontation;
	        }
	    }
	    return null;
	}

	  
	
	public void delete(Equipe equipe) {
		joueurRepo.setEquipeToNull(equipe);
		confrontationRepo.setEquipeToNull(equipe);
		stadeRepo.setEquipeToNull(equipe);
		personnelRepo.setEquipeToNull(equipe);
		compteRepo.setEquipeToNull(equipe);
		
		equipeRepo.delete(equipe);

	}
	
	public void delete(Long id) {
        Equipe equipe = equipeRepo.findById(id).orElse(null);
        if (equipe != null) {
            // Supprimer l'équipe des confrontations liées
            confrontationRepo.setEquipeToNull(equipe);

            // Supprimer l'équipe du stade lié
            Stade stade = equipe.getStade();
            if (stade != null) {
                stade.setEquipe(null);
                stadeRepo.save(stade);
            }

            // Supprimer l'équipe du compte lié
            Compte compte = equipe.getCompte();
            if (compte != null) {
                compte.setEquipe(null);
                compteRepo.save(compte);
            }

            // Supprimer l'équipe elle-même
            equipeRepo.delete(equipe);
        }
    }

	
}
