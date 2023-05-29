package formationSopraSteria.projetBasket.repositories;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formationSopraSteria.projetBasket.entities.Reservation;

@SpringBootTest
class ReservationRepositoryTest {

		@Autowired
		ReservationRepository reservationRepo;
		@Test
		void testcreate() {
			
			Reservation reservation= new Reservation(2000, 4, null, null, null);
			reservationRepo.save(reservation);
			
			Reservation reservation1= new Reservation(5600, 32,LocalDate.parse("2023-05-20"), null, null);
			reservationRepo.save(reservation1);
			
			Reservation reservation2= new Reservation(5600, 32,LocalDate.parse("2033-05-20"), null, null);
			reservationRepo.save(reservation2);
			
		}
		
	

}