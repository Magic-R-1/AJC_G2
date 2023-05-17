package test.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import entities.Equipe;
import repositories.EquipeRepository;

@SpringJUnitConfig(configurations.JpaConfig.class)
class EquipeRepositoryTest {

	@Autowired
	EquipeRepository equipeRepo;
	
	@Test
	void test() {
		
		Equipe  equipe = new Equipe("Jesaispas", "New York", null, null, null, null, null);
		equipeRepo.save(equipe);
		assertNotNull(equipe.getId());
		
		
	}
		
	}
	
	