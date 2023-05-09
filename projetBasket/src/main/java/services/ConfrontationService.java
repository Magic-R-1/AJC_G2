package services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Confrontation;
import repositories.ConfrontationRepository;

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

	    public List<Confrontation> findByDate(LocalDate date) {
	        return confrontationRepo.findByDate(date);
	    }

	    public List<Confrontation> findByScoreDomicile(int scoreDomicile) {
	        return confrontationRepo.findByScoreDomicile(scoreDomicile);
	    }

	    public List<Confrontation> findByScoreVisiteur(int scoreVisiteur) {
	        return confrontationRepo.findByScoreVisiteur(scoreVisiteur);
	    }

	    /*public List<Confrontation> findByEquipeDomicileOrEquipeVisiteur(String equipe) {
	        return confrontationRepo.findByEquipeDomicileOrEquipeVisiteur(equipe);
	    }*/

	    public List<Confrontation> findByEquipeId(Long equipeId) {
	        return confrontationRepo.findByEquipeId(equipeId);
	    }

	    public List<Confrontation> findByArbitre(String nomArbitre) {
	        return confrontationRepo.findByArbitre(nomArbitre);
	    }

	    public List<Confrontation> findByScoresGreaterThan(int scoreDomicile, int scoreVisiteur) {
	        return confrontationRepo.findByScoresGreaterThan(scoreDomicile, scoreVisiteur);
	    }
}
