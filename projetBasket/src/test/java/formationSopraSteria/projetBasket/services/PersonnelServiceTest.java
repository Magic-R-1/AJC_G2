package formationSopraSteria.projetBasket.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonnelServiceTest {

		@Autowired
		PersonnelService personnelSrv;
		
		@Test
		void testUpdateSalaire() {
			personnelSrv.modifierSalairePersonnel(1L, 15200);
		}
//        
//		void testupdate() {
//			
//		personnelSrv.update();
//		}
}