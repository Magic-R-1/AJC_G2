package formationSopraSteria.projetBasket.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formationSopraSteria.projetBasket.entities.Arbitre;

@SpringBootTest
class ArbitreRepositoryTest {

	@Autowired
 ArbitreRepository arbitreRepo;
	
	@Test
	void test() {
		
		Arbitre arbitre = new Arbitre("Doe", "John",5, "Français");
		arbitreRepo.save(arbitre);
		
	}

}
