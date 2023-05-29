package projetBasket.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetBasket.configurations.JpaConfig;

@SpringJUnitConfig(JpaConfig.class)
class PersonnelServiceTest {

		@Autowired
		PersonnelService personnelSrv;
		
		@Test
		void testUpdateSalaire() {
			personnelSrv.modifierSalairePersonnel(1L, 1500);
		}

}
