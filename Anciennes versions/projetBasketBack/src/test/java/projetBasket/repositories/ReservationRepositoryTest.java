package projetBasket.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetBasket.configurations.JpaConfig;
import projetBasket.entities.Reservation;

@SpringJUnitConfig(JpaConfig.class)
class ReservationRepositoryTest {

		@Autowired
		ReservationRepository reservationRepo;
		
		@Test
		void test() {
			
			Reservation reservation= new Reservation(2000, 4, null, null, null);
			reservationRepo.save(reservation);
			
		}

}
