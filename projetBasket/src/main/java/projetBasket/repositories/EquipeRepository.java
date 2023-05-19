package projetBasket.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetBasket.entities.Compte;
import projetBasket.entities.Equipe;
import projetBasket.entities.Personnel;
import projetBasket.entities.Stade;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	   
	List<Equipe> findByFranchise(String franchise);

	List<Equipe> findByVille(String ville);
	
	List<Equipe> findByJoueurNom(String nom);
	
	//List<Equipe> findByConfrontation(Confrontation confrontation);
	
	List<Equipe> findByStade(Stade stade);
	
	List<Equipe> findByPersonnel(Personnel personnel);
	
	List<Equipe> findByCompte(Compte compte);

//	//Récupérer toutes les équipes dont le compte a effectué une réservation dans un certain intervalle de dates
//	@Query("SELECT DISTINCT e FROM Equipe e JOIN e.membres m JOIN m.reservations r WHERE r.dateDebut >= :dateDebut AND r.dateFin <= :dateFin AND r.compte = :compte")
//	List<Equipe> findEquipesByMembreReservationBetweenDates(@Param("dateDebut") LocalDate dateDebut, @Param("dateFin") LocalDate dateFin, @Param("compte") Compte compte);

//	//Trouver toutes les équipes avec leur moyenne d'âge :
//	@Query("SELECT e, AVG(FUNCTION('DATEDIFF', 'YEAR', j.date_naissance, CURRENT_DATE)) FROM Equipe e LEFT JOIN fetch Joueur j ON e.joueurId = j.id GROUP BY e")
//	Optional<Equipe> findByIdFetchJoueurAge(@Param("id") Long id, @Param("date_naissance") int date_naissance);

	@Query("update Equipe p set p.stade=null where p.stade=:stade")
	@Transactional
	@Modifying
	void setStadeToNull(@Param("stade") Stade stade);
	
	
	
	
}
