package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Equipe;
import entities.Joueur;
import entities.Poste;
import repositories.JoueurRepository;

@Service
public class JoueurService {

	@Autowired
	private JoueurRepository joueurRepo;
	
//	public List<Joueur> rechercherJoueurParAge(int ageDebut, int ageFin) {
//        return joueurRepo.findByAgeBetween(ageDebut, ageFin);
//    }

	public Joueur modifierTailleJoueur(Long joueurId, int nouvelleTaille) {
        Optional<Joueur> joueurOptional = joueurRepo.findById(joueurId);

        if (joueurOptional.isPresent()) {
            Joueur joueur = joueurOptional.get();
            joueur.setTaille(nouvelleTaille);
            return joueurRepo.save(joueur);
        } else {
            throw new IllegalArgumentException("Joueur non trouvé avec l'ID : " + joueurId);
        }
    }
	
	public List<Joueur> rechercherJoueurParPoste(Poste poste) {
        return joueurRepo.findByPoste(poste);
    }
	
	public List<Joueur> rechercherJoueurParTaille(int tailleMini, int tailleMaxi) {
        return joueurRepo.findByTailleBetween(tailleMini, tailleMaxi);
    }
	
	public List<Joueur> rechercherJoueurParPoids(int poidsMini, int poidsMaxi) {
        return joueurRepo.findByPoidsBetween(poidsMini, poidsMaxi);
    }
	
	public void changerEquipeJoueur(Long joueurId, Equipe nouvelleEquipe) {
		joueurRepo.changerEquipe(joueurId, nouvelleEquipe);
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
