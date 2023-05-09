package repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entities.Confrontation;


public interface ConfrontationRepository extends JpaRepository<Confrontation, Long> {

	List<Confrontation> findByDate(LocalDate date);
	
	List<Confrontation> findByScoreDomicile(int scoreDomicile);
	
	List<Confrontation> findByScoreVisiteur(int scoreVisiteur);
	
	List<Confrontation> findByEquipeDomicileOrEquipeVisiteur(String equipe);
	
	List<Confrontation> findByEquipeId(Long equipeId);
	
	List<Confrontation> findByArbitre(String nomArbitre);
	
	@Query("SELECT c FROM Confrontation c WHERE c.scoreDomicile > :scoreDomicile AND c.scoreVisiteur > :scoreVisiteur")
	    List<Confrontation> findByScoresGreaterThan(@Param("scoreDomicile") int scoreDomicile, @Param("scoreVisiteur") int scoreVisiteur);
	
	
	

}
