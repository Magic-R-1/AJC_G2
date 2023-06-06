package formationSopraSteria.projetBasket.services;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formationSopraSteria.projetBasket.entities.Arbitre;

@SpringBootTest
public class ArbitreServiceTest {

	@Autowired
	ArbitreService arbitreSrv;
	
	@Test
	void testCreate () {
		Arbitre A1 = new Arbitre("Gill", "John", 10, "Allemand"); 
		arbitreSrv.create(A1);
		Arbitre A2 = new Arbitre("Delauné", "Carole", 11, "française "); 
		arbitreSrv.create(A2);
		Arbitre A3 = new Arbitre("Collin ", "Jean-Charles", 15, "France "); 
		arbitreSrv.create(A3);
	}
	
	@Test
	@Disabled
	List <Arbitre> testGetAll () {
		return arbitreSrv.getAll();
	}
	
	@Test
	@Disabled
	void testgetById() {
		arbitreSrv.getById(1L);
	}
	
	@Test
	@Disabled
	void getByNom() {
		arbitreSrv.getByNom("Bash");
	}
	
	@Test
	@Disabled
	void testupdate() {
		Arbitre arbitre = arbitreSrv.getById(2L);
		arbitre.setPrenom("Git");
		arbitreSrv.update(arbitre);
	}
	
	@Test
	@Disabled
	void testdelete() {
		arbitreSrv.delete(1L);
	}
}
