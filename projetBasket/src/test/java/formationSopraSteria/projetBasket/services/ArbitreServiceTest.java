package formationSopraSteria.projetBasket.services;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formationSopraSteria.projetBasket.entities.Arbitre;

@SpringBootTest
public class ArbitreServiceTest {

	@Autowired
	ArbitreService arbitreSrv;
	
	@Test
	List <Arbitre> testGetAll () {
		return arbitreSrv.getAll();
	}
}