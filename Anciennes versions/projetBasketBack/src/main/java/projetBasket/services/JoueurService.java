package projetBasket.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetBasket.entities.Compte;
import projetBasket.entities.Equipe;
import projetBasket.entities.Joueur;
import projetBasket.entities.Poste;
import projetBasket.exceptions.CompteException;
import projetBasket.exceptions.JoueurException;
import projetBasket.repositories.JoueurRepository;

@Service
public class JoueurService {

	@Autowired
	private JoueurRepository joueurRepo;
	
//	public List<Joueur> rechercherJoueurParAge(int ageDebut, int ageFin) {
//        return joueurRepo.findByAgeBetween(ageDebut, ageFin);
//    }

	//Crude
	
		private void checkJoueur(Joueur joueur) {
			if (joueur == null) {
				throw new JoueurException("joueur null");
			}
		}
		
		private void checkId(Long id) {
			if (id == null) {
				throw new CompteException("id null");
			}
		}
		
		public Joueur getById(Long id) {
			checkId(id);
			return joueurRepo.findById(id).orElseThrow(() -> {
				throw new JoueurException("id inconnu");
			});
		}
		
		public Joueur create(Joueur joueur) {
			checkJoueur(joueur);
			return joueurRepo.save(joueur);
		}
		
		public Joueur update(Joueur joueur) {
			Joueur joueurEnBase = getById(joueur.getId());
			checkJoueur(joueur);
			joueurEnBase.setNom(joueur.getNom());
			joueurEnBase.setPrenom(joueur.getPrenom());
			joueurEnBase.setTaille(joueur.getTaille());
			joueurEnBase.setPoids(joueur.getPoids());
			joueurEnBase.setDate_naissance(joueur.getDate_naissance());
			joueurEnBase.setNumeroMaillot(joueur.getNumeroMaillot());
			joueurEnBase.setSalaire(joueur.getSalaire());
			joueurEnBase.setStatut(joueur.getStatut());
			joueurEnBase.setPoste(joueur.getPoste());
			joueurEnBase.setEquipe(joueur.getEquipe());
			joueurEnBase.setAptitudesPhysiques(joueur.getAptitudesPhysiques());
			
			return joueurRepo.save(joueurEnBase);
		}
		
		public List<Joueur> getAll() {
			return joueurRepo.findAll();
		}
		
		public void delete(Long id) {
			Joueur joueur = getById(id);
			joueurRepo.delete(joueur);
		}
		
		public void delete(Joueur joueur) {
			delete(joueur.getId());
		}
	
	// Fin du CRUDE
	
	public List<Joueur> rechercherJoueurParPoste(Poste poste) {
        return joueurRepo.findByPoste(poste);
    }
	
	public List<Joueur> rechercherJoueurParTaille(int tailleMini, int tailleMaxi) {
        return joueurRepo.findByTailleBetween(tailleMini, tailleMaxi);
    }
	
	public List<Joueur> rechercherJoueurParPoids(int poidsMini, int poidsMaxi) {
        return joueurRepo.findByPoidsBetween(poidsMini, poidsMaxi);
    }
	
	public List<Joueur> rechercherJoueurAvecVitesseSuperieureOuEgaleA(int valeur) {
        return joueurRepo.findByAptitudesPhysiquesVitesseGreaterThanEqual(valeur);
    }
    
    public List<Joueur> rechercherJoueurAvecEnduranceSuperieureOuEgaleA(int valeur) {
        return joueurRepo.findByAptitudesPhysiquesEnduranceGreaterThanEqual(valeur);
    }
    
    public List<Joueur> rechercherJoueurAvecForceSuperieureOuEgaleA(int valeur) {
        return joueurRepo.findByAptitudesPhysiquesForceGreaterThanEqual(valeur);
    }
    
    public List<Joueur> rechercherJoueurAvecDetenteSuperieureOuEgaleA(int valeur) {
        return joueurRepo.findByAptitudesPhysiquesDetenteGreaterThanEqual(valeur);
    }
    
    public List<Joueur> rechercherJoueurAvecAgiliteSuperieureOuEgaleA(int valeur) {
        return joueurRepo.findByAptitudesPhysiquesAgiliteGreaterThanEqual(valeur);
    }
	
//    public List<Joueur> rechercherJoueurAvecMoyenneAptitudesPhysiquesSupérieureOuEgaleA(int moyenne) {
//        return joueurRepo.findByMoyenneAptitudesPhysiquesGreaterThanEqual(moyenne);
//    }
    
}
