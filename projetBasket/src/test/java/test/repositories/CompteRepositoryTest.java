package test.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import configurations.JpaConfig;
import entities.Compte;
import entities.StatutRole;
import repositories.CompteRepository;

@SpringJUnitConfig(JpaConfig.class)
class CompteRepositoryTest {

	@Autowired
	CompteRepository compteRepo;


	@Test
	void test() {
		Compte c1 = new Compte("toto", "bobi","tt","rhh","tt",StatutRole.ROLE_ADMIN);
		Compte c2 = new Compte("aa", "v","vd","rhddh","dd",StatutRole.ROLE_CLIENT);
		Compte c3 = new Compte("rt", "vret","etvd","rhrtddh","drd",StatutRole.ROLE_GM);
		Compte c4 = new Compte("agja", "gjv","gvd","rhgjdh","dhd",StatutRole.ROLE_CLIENT);
		compteRepo.save(c1);
		compteRepo.save(c2);
		compteRepo.save(c3);
		compteRepo.save(c4);
		assertNotNull(c1.getId());
		
		Optional<Compte> opt= compteRepo.findById(c1.getId());
		if(opt.isPresent()) {
			assertTrue( opt.get() instanceof Compte);
		}
	}

}
