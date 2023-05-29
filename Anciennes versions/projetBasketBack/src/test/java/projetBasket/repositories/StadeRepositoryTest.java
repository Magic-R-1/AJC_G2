package projetBasket.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetBasket.configurations.JpaConfig;
import projetBasket.entities.Stade;

@SpringJUnitConfig(JpaConfig.class)
class StadeRepositoryTest {

	@Autowired
	StadeRepository stadeRepo;
	
	@Test
	void test() {
		
		Stade  Stade = new Stade("SuperChuette", 0, "Paris");
		stadeRepo.save(Stade);
		
	}

}
