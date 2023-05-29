package projetBasket.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetBasket.configurations.JpaConfig;
import projetBasket.entities.Equipe;

@SpringJUnitConfig(JpaConfig.class)
class EquipeRepositoryTest {

	@Autowired
	EquipeRepository equipeRepo;
	
	@Test
	void test() {
		
		Equipe  equipe = new Equipe("Jesaispas", "New York", null, null, null, null, null);
		equipeRepo.save(equipe);
		
		
		
	}

}