package formationSopraSteria.projetBasket.services;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formationSopraSteria.projetBasket.entities.Confrontation;

@SpringBootTest
public class ConfrontationServiceTest {

	@Autowired
	ConfrontationService confrontationSrv;
	
	@Test
	List <Confrontation> testGetAll () {
		return confrontationSrv.getAll();
	}
}
