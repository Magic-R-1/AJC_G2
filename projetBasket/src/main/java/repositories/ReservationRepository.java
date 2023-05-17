package repositories;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import entities.Compte;
import entities.Confrontation;
import entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
 
	List<Reservation> findByCompteId(Compte compte);
	
	List<Reservation> findByConfrontationId(Confrontation confrontation);
	
	List<Reservation> findByDateReservation(LocalDate dateReservation);
	
	List<Reservation> findByPrix(double prix);
	
	List<Reservation> findByQuantite(Integer quantite);
	
}


