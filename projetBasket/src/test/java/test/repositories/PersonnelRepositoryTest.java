package test.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import entities.Personnel;
import repositories.PersonnelRepository;

@SpringJUnitConfig(configurations.JpaConfig.class)
class PersonnelRepositoryTest {

		@Autowired
		PersonnelRepository personnelRepo;
		
		@Test
	   void testCreate() {
        // Nouveau personnel en base avec un salaire initial de 2000
	  
       Personnel personnel = new Personnel("Jean", "david", 2000, null, null);
       personnelRepo.save(personnel);

		}

}
