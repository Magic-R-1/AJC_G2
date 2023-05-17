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
			   void testUpdateSalaire() {
		        // Nouveau personnel en base avec un salaire initial de 2000
			  
		       Personnel personnel = new Personnel("Jean", "david", 2000, null, null);
		       personnelRepo.save(personnel);

		  // Update  du personnel à 1500 via la méthode updateSalaire()
		  // PersonnelService personnelService = new PersonnelService();
		        
		   //    Personnel personnelEnBase = personnelRepo.findById(personnelEnBase.getId()).orElse(null);
		   //   personnelEnBase.setSalaire(6000);
		   //   personnelRepo.updateSalaire(personnelEnBase);

//		        // Vérification de la  mis à jour du salaire du personnel  en base
//	        Personnel personnelEnBase = personnelRepo.findById(personnel.getId()).orElse(null);
//		        assertNotNull(personnelEnBase);
//		        assertEquals(1500, personnelEnBase.getSalaire(), 0.001);
//			
		}

}
