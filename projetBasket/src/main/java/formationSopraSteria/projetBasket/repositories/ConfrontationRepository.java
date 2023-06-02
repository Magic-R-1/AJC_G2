package formationSopraSteria.projetBasket.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formationSopraSteria.projetBasket.entities.Arbitre;
import formationSopraSteria.projetBasket.entities.Confrontation;
import formationSopraSteria.projetBasket.entities.Equipe;


public interface ConfrontationRepository extends JpaRepository<Confrontation, Long> {

	List<Confrontation> getByDateConfrontation(LocalDate dateConfrontation);
	
	List<Confrontation> findByScoreDomicile(int scoreDomicile);
	
	List<Confrontation> findByScoreVisiteur(int scoreVisiteur);
	
	List<Confrontation> findByEquipe(Equipe equipe);
	
	List<Confrontation> findByEquipeVisiteur(Equipe equipeVisiteur);
	
	List<Confrontation> findByEquipeId(Long Id);
	
	List<Confrontation> findByArbitre(Arbitre arbitre);
	
	
	@Query("SELECT c FROM Confrontation c WHERE c.scoreDomicile > :scoreDomicile AND c.scoreVisiteur > :scoreVisiteur")
	    List<Confrontation> findByScoresGreaterThan(@Param("scoreDomicile") int scoreDomicile, @Param("scoreVisiteur") int scoreVisiteur);
	
		
	List<Confrontation> findByReservationsDateReservation(LocalDate dateReservation);

	@Query("update Confrontation p set p.equipe=null where p.equipe=:equipe")
	@Transactional
	@Modifying
	void setEquipeToNull(@Param("equipe") Equipe equipe);
	
	@Query("update Confrontation p set p.arbitre=null where p.arbitre=:arbitre")
	@Transactional
	@Modifying
	void setArbitreToNull(@Param("arbitre") Arbitre arbitre);

	
	@Modifying
	@Transactional
	@Query("DELETE FROM Confrontation c WHERE c.equipe.id = :id")
	void deleteByEquipeId(@Param("id") Long id);

	
	
	

}