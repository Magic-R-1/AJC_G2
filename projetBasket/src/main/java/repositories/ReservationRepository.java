package repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entities.Compte;
import entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	@Query("update Reservation r set r.compte=null where r.compte=:compte")
	@Transactional
	@Modifying
	void setCompteToNull(@Param("compte") Compte compte);
}


