package projetBasket.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetBasket.configurations.JpaConfig;
import projetBasket.entities.Arbitre;

@SpringJUnitConfig(JpaConfig.class)
class ArbitreRepositoryTest {

	@Autowired
 ArbitreRepository arbitreRepo;
	
	@Test
	void test() {
		
		Arbitre arbitre = new Arbitre("Doe", "John",5, "Français");
		arbitreRepo.save(arbitre);
		
	}

}
