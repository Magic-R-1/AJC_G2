package formationSopraSteria.projetBasket.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import formationSopraSteria.projetBasket.entities.Personnel;
import formationSopraSteria.projetBasket.entities.Role_Personnel;

@SpringBootTest
class PersonnelRepositoryTest {

		@Autowired
		PersonnelRepository personnelRepo;
		
		@Test
	   void testCreate() {
        // Nouveau personnel en base avec un salaire initial de 2000
	  
       Personnel personnel = new Personnel(1L,"Jean", "david", 2000, null, null);
       personnelRepo.save(personnel);
       
       Personnel personnel2 = new Personnel(2L,"Julien", "gualo", 2300, null, null);
       personnelRepo.save(personnel2);
       
       Personnel personnel4 = new Personnel(7L,"jojy", "cbb",2000,null,Role_Personnel.KINESITHERAPEUTE);
       personnelRepo.save(personnel4);

		}
}
//		@Disabled
//		@Test
//      void testdelete() {
//    	personnelRepo.deleteById(2L);
//      }
//}