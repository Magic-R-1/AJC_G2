package test.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import repositories.JoueurRepository;
import services.JoueurService;

@SpringJUnitConfig(configurations.JpaConfig.class)
class JoueurServiceTest {

	@Autowired
	JoueurService joueurSrv;
	
	@Test
	void testUpdateTaille() {
		joueurSrv.modifierTailleJoueur(1L, 190);
	}

}
