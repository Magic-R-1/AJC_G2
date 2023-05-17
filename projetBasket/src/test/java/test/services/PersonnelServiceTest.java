package test.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import entities.Personnel;
import repositories.PersonnelRepository;
import services.PersonnelService;

@SpringJUnitConfig(configurations.JpaConfig.class)
class PersonnelServiceTest {

		@Autowired
		PersonnelService personnelSrv;
		
		@Test
		void testUpdateSalaire() {
			personnelSrv.modifierSalairePersonnel(1L, 1500);
		}

}
