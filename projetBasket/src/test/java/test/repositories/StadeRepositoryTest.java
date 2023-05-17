package test.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import entities.Stade;
import repositories.StadeRepository;

@SpringJUnitConfig(configurations.JpaConfig.class)
class StadeRepositoryTest {

	@Autowired
	StadeRepository stadeRepo;
	
	@Test
	void test() {
		
		Stade  Stade = new Stade("SuperChuette", 0, "Paris");
		stadeRepo.save(Stade);
		
	}

}
