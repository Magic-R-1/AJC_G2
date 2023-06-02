package formationSopraSteria.projetBasket.services;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formationSopraSteria.projetBasket.entities.Personnel;

@SpringBootTest
class PersonnelServiceTest {

		@Autowired
		PersonnelService personnelSrv;
		
		
		@Test
		   void testCreate() {
	     
		  
	       Personnel personnel = new Personnel(1L,"afi","dd",2000,null,null);
	       personnelSrv.create(personnel);
	       
	       Personnel personnel1 = new Personnel(2L,"ani","ddi",2000,null,null);
	       personnelSrv.create(personnel1);

			}
		
		@Test
		@Disabled
		void testUpdateSalaire() {
			personnelSrv.modifierSalairePersonnel(1L, 15200);
		}
//        
//		void testupdate() {
//			
//		personnelSrv.update();
//		}
}