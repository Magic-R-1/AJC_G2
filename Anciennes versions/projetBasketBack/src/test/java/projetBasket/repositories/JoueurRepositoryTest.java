package projetBasket.repositories;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetBasket.configurations.JpaConfig;
import projetBasket.entities.AptitudePhysique;
import projetBasket.entities.Joueur;
import projetBasket.entities.Poste;
import projetBasket.entities.Statut;

@SpringJUnitConfig(JpaConfig.class)
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
