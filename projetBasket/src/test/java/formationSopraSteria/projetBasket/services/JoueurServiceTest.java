package formationSopraSteria.projetBasket.services;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formationSopraSteria.projetBasket.entities.Joueur;
import formationSopraSteria.projetBasket.entities.Poste;

@SpringBootTest
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
