package formationSopraSteria.projetBasket.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formationSopraSteria.projetBasket.entities.Stade;

@SpringBootTest
class StadeRepositoryTest {

	@Autowired
	StadeRepository stadeRepo;
	
	@Test
	void test() {
		
		Stade  Stade = new Stade("SuperChuette", 0, "Paris");
		stadeRepo.save(Stade);
		
	}

}
