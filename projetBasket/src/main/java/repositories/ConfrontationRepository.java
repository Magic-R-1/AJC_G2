package repositories;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import entities.Arbitre;
import entities.Confrontation;
import entities.Equipe;


public interface ConfrontationRepository extends JpaRepository<Confrontation, Long> {

	List<Confrontation> findByDateConfrontation(LocalDate dateConfrontation);
	
	List<Confrontation> findByScoreDomicile(int scoreDomicile);
	
	List<Confrontation> findByScoreVisiteur(int scoreVisiteur);
	
	List<Confrontation> findByEquipe(Equipe equipe);
	
	List<Confrontation> findByEquipeId(Long Id);
	
	List<Confrontation> findByArbitre(Arbitre arbitre);
	
	
	@Query("SELECT c FROM Confrontation c WHERE c.scoreDomicile > :scoreDomicile AND c.scoreVisiteur > :scoreVisiteur")
	    List<Confrontation> findByScoresGreaterThan(@Param("scoreDomicile") int scoreDomicile, @Param("scoreVisiteur") int scoreVisiteur);
	
		
	List<Confrontation> findByReservationsDateReservation(LocalDate dateReservation);

	@Query("update Confrontation p set p.equipe=null where p.equipe=:equipe")
	@Transactional
	@Modifying
	void setEquipeToNull(@Param("equipe") Equipe equipe);
	
	
	

}
