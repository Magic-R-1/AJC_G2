package formationSopraSteria.projetBasket.repositories;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import formationSopraSteria.projetBasket.entities.Confrontation;

@SpringBootTest
class ConfrontationRepositoryTest {

	@Autowired
	ConfrontationRepository confrontationRepo;
	
	@Test
	void test() {
		
		Confrontation confrontation = new Confrontation(LocalDate.parse("2023-05-20"), 240, 1, 2, null, null, null);

		confrontationRepo.save(confrontation);
		
	}

}