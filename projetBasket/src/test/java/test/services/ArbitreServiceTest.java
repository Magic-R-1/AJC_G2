package test.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import entities.Arbitre;
import repositories.ArbitreRepository;

@SpringJUnitConfig(configurations.JpaConfig.class)
class ArbitreServiceTest {

	@Autowired
 ArbitreRepository arbitreRepo;
	
	@Test
	void test() {
		
		Arbitre arbitre = new Arbitre("Doe", "John",5, "Français");
		arbitreRepo.save(arbitre);
		
	}

}
