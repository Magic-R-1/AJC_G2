package formationSopraSteria.projetBasket.services;

import java.time.LocalDate;

import formationSopraSteria.projetBasket.entities.Reservation;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReservationServiceTest {

	@Autowired
	ReservationService reservationSrv;
	
	@Test
	void create() {
		Reservation reservation = new Reservation(10, 2, null, null, null);
		reservationSrv.create(reservation);
	}
	
	@Test
	@Disabled	
	void testupdatePrix () {
		reservationSrv.modifierPrixreservation(1L,1450);
	}

	@Test
	@Disabled
	void testupdateQuantite () {
		reservationSrv.modifierQuantitereservation(1L,10);	
	}

	@Test
	@Disabled
	void testupdateDate () {
	    reservationSrv.modifierDateReservation(3L, LocalDate.parse("2025-03-05"));
	}
	
	@Test
	@Disabled
	void testfindbydate () {
		reservationSrv.findBydateReservation(LocalDate.parse("2025-03-05"));
	}
		
}
