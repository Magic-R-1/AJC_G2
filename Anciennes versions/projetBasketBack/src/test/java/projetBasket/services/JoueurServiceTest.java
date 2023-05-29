package projetBasket.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetBasket.configurations.JpaConfig;
import projetBasket.entities.Joueur;
import projetBasket.entities.Poste;

@SpringJUnitConfig(JpaConfig.class)
class JoueurServiceTest {

	@Autowired
	JoueurService joueurSrv;
	
	@Test
	void testgetById() {
		joueurSrv.getById(1L);
	}
	
	@Test
	void create() {
		Joueur joueur = new Joueur("Bryant", "Kobe");
		joueurSrv.create(joueur);
	}
	
	@Test
	void testUpdate() {
		Joueur joueur = joueurSrv.getById(2L);
		joueur.setNumeroMaillot(24);
		joueurSrv.update(joueur);
	}
	
	@Test
	void testGetAll() {
		joueurSrv.getAll();
	}
	
	@Test
	@Disabled
	void testDelete() {
		joueurSrv.delete(2L);
	}

	@Test
	void testPoste() {
		joueurSrv.rechercherJoueurParPoste(Poste.AilierFort);
	}
	
	@Test
	void testTaille() {
		joueurSrv.rechercherJoueurParTaille(180, 190);
	}
	
	@Test
	void testPoids() {
		joueurSrv.rechercherJoueurParPoids(100, 120);
	}
	
	@Test
	void testVitesse() {
		joueurSrv.rechercherJoueurAvecVitesseSuperieureOuEgaleA(80);
	}
	
}
