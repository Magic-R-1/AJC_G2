package formationSopraSteria.projetBasket.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formationSopraSteria.projetBasket.entities.Equipe;

@SpringBootTest
class EquipeRepositoryTest {

	@Autowired
	EquipeRepository equipeRepo;
	
	@Test
	void test() {
		
		Equipe  equipe = new Equipe("Jesaispas", "New York", null, null, null, null, null);
		equipeRepo.save(equipe);
		
		
		
	}

}