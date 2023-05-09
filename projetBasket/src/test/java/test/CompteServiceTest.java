package test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import entities.Compte;
import entities.StatutRole;
import repositories.CompteRepository;

@SpringJUnitConfig(configurations.JpaConfig.class)
class CompteServiceTest {

	@Autowired
	CompteRepository compteRepo;
	
	@Test
	void test() {	
		Compte C1 = new Compte("login","pass","Toto","Bob","email",StatutRole.ROLE_GM);
		compteRepo.save(C1);
		
	}

}
