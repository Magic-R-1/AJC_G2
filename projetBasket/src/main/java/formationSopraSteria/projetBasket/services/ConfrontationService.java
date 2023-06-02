package formationSopraSteria.projetBasket.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formationSopraSteria.projetBasket.entities.Arbitre;
import formationSopraSteria.projetBasket.entities.Confrontation;
import formationSopraSteria.projetBasket.entities.Equipe;
import formationSopraSteria.projetBasket.exceptions.ConfrontationException;
import formationSopraSteria.projetBasket.repositories.ArbitreRepository;
import formationSopraSteria.projetBasket.repositories.ConfrontationRepository;
import formationSopraSteria.projetBasket.repositories.EquipeRepository;
import formationSopraSteria.projetBasket.repositories.ReservationRepository;

@Service
public class ConfrontationService {
	
	@Autowired
	private ConfrontationRepository confrontationRepo;
	@Autowired
	private ArbitreRepository arbitreRepo;
	@Autowired
	private EquipeRepository equipeRepo;
	@Autowired
	private ReservationRepository reservationRepo;
	
	 private void checkConfrontation(Confrontation confrontation) {
		if (confrontation == null) {
			throw new ConfrontationException("confrontation null");
		}
		if (confrontation.getDateConfrontation() == null) {
			throw new ConfrontationException("date de confrontation obligatoire");
		}
	}
	 
	 private void checkId(Long id) {
			if (id == null) {
				throw new ConfrontationException("id null");
			}
		}
	
	 	public Confrontation create(Confrontation confrontation) {
		checkConfrontation(confrontation);
		return confrontationRepo.save(confrontation);
	} 
	
		public List<Confrontation> getByDateConfrontation(LocalDate dateConfrontation) {
	        return confrontationRepo.getByDateConfrontation(dateConfrontation);
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
	    public List<Confrontation> findByEquipeVisiteur(Equipe equipeVisiteur) {
	        return confrontationRepo.findByEquipeVisiteur(equipeVisiteur);
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
	    
	    public Confrontation update(Confrontation confrontation) {
			Confrontation confrontationEnBase = getById(confrontation.getId());
			checkConfrontation(confrontation);
			confrontationEnBase.setDateConfrontation(confrontation.getDateConfrontation());
			confrontationEnBase.setDuree(confrontation.getDuree());
			confrontationEnBase.setScoreDomicile(confrontation.getScoreDomicile());
			confrontationEnBase.setScoreVisiteur(confrontation.getScoreVisiteur());
			confrontationEnBase.setArbitre(confrontation.getArbitre());
			confrontationEnBase.setEquipe(confrontation.getEquipe());
			confrontationEnBase.setEquipeVisiteur(confrontation.getEquipeVisiteur());
			return confrontationRepo.save(confrontationEnBase);
		}
		public Confrontation getById(Long id) {
			checkId(id);
			return confrontationRepo.findById(id).orElseThrow(() -> {
				throw new ConfrontationException("id inconnu");
			});
		}
		
		public ConfrontationService(ConfrontationRepository confrontationRepository) {
	        this.confrontationRepo = confrontationRepository;
	    }
		
		public List<Confrontation> getAll() {
			return confrontationRepo.findAll();
		}
		
		public void delete(Confrontation confrontation) {
			delete(confrontation.getId());
		}
		
		public void delete(Long id) {
			Confrontation confrontation = getById(id);
			//arbitreRepo.setConfrontationToNull(confrontation);
			//equipeRepo.setConfrontationToNull(confrontation);
			reservationRepo.setConfrontationToNull(confrontation);
			
			confrontationRepo.delete(confrontation);

		}
	    
	   
}