package test.repositories;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import entities.Confrontation;
import repositories.ConfrontationRepository;

@SpringJUnitConfig(configurations.JpaConfig.class)
class ConfrontationRepositoryTest {

	@Autowired
	ConfrontationRepository confrontationRepo;
	
	@Test
	void test() {
		
		Confrontation confrontation = new Confrontation(LocalDate.parse("2023-05-09"), 120, 3, 2, null, null, null);

		confrontationRepo.save(confrontation);
		
	}

}
