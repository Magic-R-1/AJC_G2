package formationSopraSteria.projetBasket.services;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formationSopraSteria.projetBasket.entities.Joueur;
import formationSopraSteria.projetBasket.entities.Poste;
import formationSopraSteria.projetBasket.entities.Statut;

@SpringBootTest
class JoueurServiceTest {

	@Autowired
	JoueurService joueurSrv;
	
	@Test
	@Disabled
	void testgetById() {
		joueurSrv.getById(1L);
	}
	
	@Test
	@Disabled
	void create() {
		
		
		Joueur joueur1 = new Joueur("Rudy", "Gobert",2.16,117,LocalDate.parse("26/06/1992"),27,35688000,Statut.Titulaire,Poste.Pivot,null,null);
		joueurSrv.create(joueur1);
		
		
		
		
		
		
		}
	
	@Test
	@Disabled
	void testUpdate() {
		Joueur joueur = joueurSrv.getById(2L);
		joueur.setNumero_maillot(24);
		joueurSrv.update(joueur);
	}
	
	@Test
	@Disabled
	void testGetAll() {
		joueurSrv.getAll();
	}
	
	@Test
	@Disabled
	void testDelete() {
		joueurSrv.delete(2L);
	}

	@Test
	@Disabled
	void testPoste() {
		joueurSrv.rechercherJoueurParPoste(Poste.AilierFort);
	}
	
	@Test
	@Disabled
	void testTaille() {
		joueurSrv.rechercherJoueurParTaille(180, 190);
	}
	
	@Test
	@Disabled
	void testPoids() {
		joueurSrv.rechercherJoueurParPoids(100, 120);
	}
	
	@Test
	@Disabled
	void testVitesse() {
		joueurSrv.rechercherJoueurAvecVitesseSuperieureOuEgaleA(80);
	}
	
}
