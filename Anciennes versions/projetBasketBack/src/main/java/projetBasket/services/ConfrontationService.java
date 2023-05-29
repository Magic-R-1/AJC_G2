package projetBasket.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetBasket.entities.Arbitre;
import projetBasket.entities.Confrontation;
import projetBasket.entities.Equipe;
import projetBasket.repositories.ConfrontationRepository;

@Service
public class ConfrontationService {
	
	@Autowired
	private ConfrontationRepository confrontationRepo;
	
	/* private void checkConfrontation(Confrontation confrontation) {
		if (confrontation == null) {
			throw new ConfrontationException("confrontation null");
		}
		if (confrontation.getId() == null || confrontation.getId().isEmpty()) {
			throw new ConfrontationException("nom obligatoire");
		}
	}
	
	public Confrontation create(Confrontation confrontation) {
		checkConfrontation(confrontation);
		return confrontationRepo.save(confrontation);
	} */
	
	
	
	
	 public ConfrontationService(ConfrontationRepository confrontationRepository) {
	        this.confrontationRepo = confrontationRepository;
	    }

	   public List<Confrontation> findByDateConfrontation(LocalDate dateConfrontation) {
	        return confrontationRepo.findByDateConfrontation(dateConfrontation);
	    }

	    public List<Confrontation> findByScoreDomicile(int scoreDomicile) {
	        return confrontationRepo.findByScoreDomicile(scoreDomicile);
	    }

	    public List<Confrontation> findByScoreVisiteur(int scoreVisiteur) {
	        return confrontationRepo.findByScoreVisiteur(scoreVisiteur);
	    }

	    public List<Confrontation> findByEquipe(Equipe equipe) {
	        return confrontationRepo.findByEquipe(equipe);
	    }

	    public List<Confrontation> findByEquipeId(Long Id) {
	        return confrontationRepo.findByEquipeId(Id);
	    }

	    public List<Confrontation> findByArbitre(Arbitre arbitre) {
	        return confrontationRepo.findByArbitre(arbitre);
	    }

	    
	    
	    public List<Confrontation> findByScoresGreaterThan(int scoreDomicile, int scoreVisiteur) {
	        return confrontationRepo.findByScoresGreaterThan(scoreDomicile, scoreVisiteur);
	    }
	    
	    public List<Confrontation> findByReservationsDateReservation(LocalDate dateReservation) {
	        return confrontationRepo.findByReservationsDateReservation(dateReservation);
	    }
	    
	   
}
