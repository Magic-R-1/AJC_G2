package test.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import entities.Stade;
import services.StadeService;

@SpringJUnitConfig(configurations.JpaConfig.class)
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
