package projetBasket.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetBasket.entities.Stade;
import projetBasket.configurations.JpaConfig;

@SpringJUnitConfig(JpaConfig.class)
class StadeServiceTest {

	@Autowired
	StadeService stadeSrv;
	
	@Test
	void testCreate() {
		stadeSrv.create("Staples Center", 20000, "Los Angeles");
	}
	
	@Test
	List<Stade> testGetAll() {
		return stadeSrv.getAll();
	}

}
