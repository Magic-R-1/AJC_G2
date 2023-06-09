package formationSopraSteria.projetBasket.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formationSopraSteria.projetBasket.entities.Compte;
import formationSopraSteria.projetBasket.entities.Confrontation;
import formationSopraSteria.projetBasket.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
 
	List<Reservation> findByCompteId(Compte compte);
	
	List<Reservation> findByConfrontationId(Confrontation confrontation);
	
	List<Reservation> findBydateReservation(LocalDate dateReservation);
	
	List<Reservation> findByPrix(double prix);
	
	List<Reservation> findByQuantite(Integer quantite);

	@Query("update Reservation c set c.compte=null where c.compte=:compte")
	@Transactional
	@Modifying
	void setCompteToNull(@Param("compte") Compte compte);
	
	@Query("update Reservation c set c.confrontation=null where c.confrontation=:confrontation")
    @Transactional
    @Modifying
    void setConfrontationToNull(@Param("confrontation") Confrontation confrontation);
	
}
