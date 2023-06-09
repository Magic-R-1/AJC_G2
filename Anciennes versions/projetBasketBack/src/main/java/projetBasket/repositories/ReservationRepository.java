package projetBasket.repositories;


import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetBasket.entities.Compte;
import projetBasket.entities.Confrontation;
import projetBasket.entities.Reservation;

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

	
	
}


