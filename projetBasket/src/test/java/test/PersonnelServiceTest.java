package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import entities.Personnel;
import repositories.PersonnelRepository;
import services.PersonnelService;

@SpringJUnitConfig(configurations.JpaConfig.class)
class PersonnelServiceTest {

		@Autowired
		PersonnelRepository personnelRepo;
		
		@Test
			
			   void testUpdateSalaire() {
		        // Nouveau personnel en base avec un salaire initial de 2000
			  
		        Personnel personnel = new Personnel("Jean", "david", 2000, null, null);
		        personnelRepo.save(personnel);

		        // Update  du personnel à 1500 via la méthode updateSalaire()
		        PersonnelService personnelService = new PersonnelService();
		        personnel.setSalaire(6000);
		        personnelService.updateSalaire(personnel);

		        // Vérification de la  mis à jour du salaire du personnel  en base
		        Personnel personnelEnBase = personnelRepo.findById(personnel.getId()).orElse(null);
		        assertNotNull(personnelEnBase);
		        assertEquals(1500, personnelEnBase.getSalaire(), 0.001);
			
		}

}
