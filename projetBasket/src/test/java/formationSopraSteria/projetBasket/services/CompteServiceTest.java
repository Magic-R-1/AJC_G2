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
	void testCreate() {
		Compte c1 = new Compte("admin", "admin",StatutRole.ROLE_ADMIN);
		compteSrv.create(c1);
		Compte c2 = new Compte("El-hafid", "YBRAHIMA",StatutRole.ROLE_GM);
		compteSrv.create(c2);
		Compte c3 = new Compte("Erwan", "admin",StatutRole.ROLE_GM);
		compteSrv.create(c3);
		Compte c4 = new Compte("Léa", "Simonet",StatutRole.ROLE_GM);
		compteSrv.create(c4);
		Compte c5 = new Compte("Bernadette", "admin",StatutRole.ROLE_GM);
		compteSrv.create(c5);
		Compte c6 = new Compte("Insaf", "admin",StatutRole.ROLE_CLIENT);
		compteSrv.create(c6);
		Compte c7 = new Compte("Jean", "Jean",StatutRole.ROLE_CLIENT);
		compteSrv.create(c7);
		Compte c8 = new Compte("Jordan", "Jordan",StatutRole.ROLE_CLIENT);
		compteSrv.create(c8);
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


