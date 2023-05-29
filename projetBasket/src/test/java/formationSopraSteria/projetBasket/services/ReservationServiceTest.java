package formationSopraSteria.projetBasket.services;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReservationServiceTest {

		@Autowired
		ReservationService reservationSrv;
		
	@Disabled	
	@Test
	
	void testupdatePrix () {
		reservationSrv.modifierPrixreservation(1L,1450);
		
	}
	@Disabled
	@Test
	void testupdateQuantite () {
		reservationSrv.modifierQuantitereservation(1L,10);
		
	}
	@Disabled
	@Test
	void testupdateDate () {
	    reservationSrv.modifierDateReservation(3L, LocalDate.parse("2025-03-05"));
	}
	@Test
	void testfindbydate () {
		reservationSrv.findBydateReservation(LocalDate.parse("2025-03-05"));
	}
		
}
