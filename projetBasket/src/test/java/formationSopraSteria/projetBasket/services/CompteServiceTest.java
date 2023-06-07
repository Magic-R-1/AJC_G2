package formationSopraSteria.projetBasket.services;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formationSopraSteria.projetBasket.entities.Compte;
import formationSopraSteria.projetBasket.entities.StatutRole;

@SpringBootTest
class CompteServiceTest {

	@Autowired
	CompteService compteSrv;
	
	@Test
	@Disabled
	void testCreate() {
		Compte c1 = new Compte("admin1", "admin1","admin1","admin1","admin1@gmail.com",StatutRole.ROLE_ADMIN);
		compteSrv.create(c1);
	}
	
	@Test
	@Disabled
	List<Compte> testGetAll() {
		return compteSrv.getAll();}
	
	@Test
	@Disabled
	void testgetById() {
		compteSrv.getById(1L);
	}
	
	@Test
	@Disabled
	void testupdate() {
		Compte compte = compteSrv.getById(2L);
		compte.setNom("frf");
		compteSrv.update(compte);
	}
	@Test
	@Disabled
	void testdelete() {
		compteSrv.delete(1L);
	}
	@Test
	@Disabled
	void testgetByStatutRole() {
		compteSrv.getByStatutRole(StatutRole.ROLE_ADMIN);
	}
	@Test
	@Disabled
	void testgetByNom() {
		compteSrv.getByNom("tt");
	}
}


