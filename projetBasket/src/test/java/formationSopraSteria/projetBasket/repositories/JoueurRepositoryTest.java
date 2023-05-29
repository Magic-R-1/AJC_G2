package formationSopraSteria.projetBasket.repositories;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formationSopraSteria.projetBasket.entities.AptitudePhysique;
import formationSopraSteria.projetBasket.entities.Joueur;
import formationSopraSteria.projetBasket.entities.Poste;
import formationSopraSteria.projetBasket.entities.Statut;

@SpringBootTest
class JoueurRepositoryTest {

	@Autowired
	JoueurRepository joueurRepo;
	
	@Test
	void testCreationJoueur() {
		AptitudePhysique ap1 = new AptitudePhysique(90, 90, 90, 90, 90);
		Joueur joueur1 = new Joueur("James","LeBron",206,113,LocalDate.parse("1984-12-30"),6,44000000,Statut.Titulaire,Poste.AilierFort,null,ap1);
		joueurRepo.save(joueur1);
	}
	
}
