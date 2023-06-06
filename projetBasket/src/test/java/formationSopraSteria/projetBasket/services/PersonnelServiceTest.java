package formationSopraSteria.projetBasket.services;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formationSopraSteria.projetBasket.entities.Personnel;
import formationSopraSteria.projetBasket.entities.Role_Personnel;

@SpringBootTest
class PersonnelServiceTest {

		@Autowired
		PersonnelService personnelSrv;
		
		
		@Test
		   void testCreate() {
	     
		  
	       Personnel EP1 = new Personnel(1L,"Darvin","ham",612300,null,Role_Personnel.ENTRAINEUR_PRINCIPAL);
	       personnelSrv.create(EP1);
	       Personnel EP2 = new Personnel(2L,"Kerr","Steve",8400000,null,Role_Personnel.ENTRAINEUR_PRINCIPAL);
	       personnelSrv.create(EP2);
	       Personnel EP3 = new Personnel(3L,"Daigneault","Mark",150000,null,Role_Personnel.ENTRAINEUR_PRINCIPAL);
	       personnelSrv.create(EP3);
	       Personnel EP4 = new Personnel(4L,"Mazzula","Joe",6000000,null,Role_Personnel.ENTRAINEUR_PRINCIPAL);
	       personnelSrv.create(EP4);
	       
	       Personnel EA1 = new Personnel(5L,"Handy","Phil",120000,null,Role_Personnel.ENTRAINEUR_ADJOINT);
	       personnelSrv.create(EA1);
	       Personnel EA2 = new Personnel(6L,"Atkinson","Kenny",420000,null,Role_Personnel.ENTRAINEUR_ADJOINT);
	       personnelSrv.create(EP2);
	       Personnel EA3 = new Personnel(7L,"Jones","Bobs",1350000,null,Role_Personnel.ENTRAINEUR_ADJOINT);
	       personnelSrv.create(EP3);
	       Personnel EA4 = new Personnel(8L,"Silas","Stephen",6000000,null,Role_Personnel.ENTRAINEUR_ADJOINT);
	       personnelSrv.create(EA4);
	       
	       Personnel PF1 = new Personnel(9L,"Michael","Santos",30000,null,Role_Personnel.PREPARATEUR_PHYSIQUE);
	       personnelSrv.create(PF1);
	       Personnel PF2 = new Personnel(10L,"Alain","Quintallet",20000,null,Role_Personnel.PREPARATEUR_PHYSIQUE);
	       personnelSrv.create(PF2);
	       Personnel PF3 = new Personnel(11L,"Jean","Delatours",12000,null,Role_Personnel.PREPARATEUR_PHYSIQUE);
	       personnelSrv.create(PF3);
	       Personnel PF4 = new Personnel(12L,"Jivenon","lock",24000,null,Role_Personnel.PREPARATEUR_PHYSIQUE);
	       personnelSrv.create(PF4);
	       Personnel k1 = new Personnel(13L,"Olivier","Santos",10000,null,Role_Personnel.KINESITHERAPEUTE);
	       personnelSrv.create(k1);
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