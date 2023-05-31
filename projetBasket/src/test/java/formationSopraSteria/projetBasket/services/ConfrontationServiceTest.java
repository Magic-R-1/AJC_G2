package formationSopraSteria.projetBasket.services;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formationSopraSteria.projetBasket.entities.Compte;
import formationSopraSteria.projetBasket.entities.Confrontation;

@SpringBootTest
public class ConfrontationServiceTest {

	@Autowired
	ConfrontationService confrontationSrv;
	
	@Test
	void testCreate () {
		Confrontation Cf1 = new Confrontation(LocalDate.parse("2023-05-09"), 120, 3, 2, null, null, null);
		confrontationSrv.create(Cf1);
	}
	
	
	@Test
	@Disabled
	List <Confrontation> testGetAll () {
		return confrontationSrv.getAll();
	}
	
	@Test
	@Disabled
	void testgetById() {
		confrontationSrv.getById(1L);
	}
	
	@Test
	@Disabled
	void getByDateConfrontation() {
		confrontationSrv.getByDateConfrontation(LocalDate.parse("2023-05-31"));
	}
	
	@Test
	@Disabled
	void testupdate() {
		Confrontation confrontation = confrontationSrv.getById(2L);
		confrontation.setDuree(60);
		confrontationSrv.update(confrontation);
	}
	
	@Test
	@Disabled
	void testdelete() {
		confrontationSrv.delete(1L);
	}
	
}
