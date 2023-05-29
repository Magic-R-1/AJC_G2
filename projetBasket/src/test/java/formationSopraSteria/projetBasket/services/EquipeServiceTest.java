package formationSopraSteria.projetBasket.services;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import formationSopraSteria.projetBasket.entities.Compte;
import formationSopraSteria.projetBasket.entities.Equipe;
import formationSopraSteria.projetBasket.entities.Joueur;
import formationSopraSteria.projetBasket.entities.Personnel;
import formationSopraSteria.projetBasket.entities.Stade;
import formationSopraSteria.projetBasket.entities.StatutRole;
import formationSopraSteria.projetBasket.exceptions.EquipeException;
import formationSopraSteria.projetBasket.repositories.CompteRepository;
import formationSopraSteria.projetBasket.repositories.EquipeRepository;
import formationSopraSteria.projetBasket.repositories.StadeRepository;

@SpringBootTest
@Transactional
@Rollback
public class EquipeServiceTest {

	@Autowired
	private EquipeService equipeSrv;

	@Autowired
	private EquipeRepository equipeRepo;

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private StadeRepository stadeRepo;

	private Equipe equipe;
	private Compte compte;
	private Stade stade;

	@BeforeEach
	public void setup() {
		// Création d'une instance d'équipe et d'un compte
		compte = new Compte();
		compte.setLogin("login");
		compte.setPassword("password");
		compteRepository.save(compte);
		equipe = new Equipe();
		equipe.setFranchise("Franchise");
		equipe.setCompte(compte);
		equipe.setJoueur(new HashSet<>());
		equipe.setConfrontation(new HashSet<>());
		equipe.setPersonnel(new HashSet<>());
		equipe.setVille("Ville1");
		stade = new Stade();
		stade.setCapacite(500);
		stade.setNom("Stade1");
		stade.setVille("VilleA");
		stade = stadeRepo.save(stade);
		equipe.setStade(stade);
		equipe = equipeRepo.save(equipe);

	}

	@Test
	void testCreateEquipe() {

		Equipe equipeCreee = equipeSrv.create(equipe);

		// Vérifier que l'équipe a été créée avec succès en comparant les attributs
		assertEquals("Franchise", equipeCreee.getFranchise());
		assertEquals("Ville1", equipeCreee.getVille());
	}

	@Test
	void testGetAll() {
		equipeSrv.getAll();
	}

	@Test
	@Disabled
	void testByFranchise() {
	    Equipe equipetest = equipeSrv.getByFranchise("Los");
	    assertNull(equipetest);  // Vérifie si l'équipe renvoyée n'est pas nulle
	}


	@Test
	void testByVille() {
		equipeSrv.getByVille("Los Angeles");
	}

	@Test
	void testByJoueurNom() {
		equipeSrv.getByJoueurNom("Lebron");
	}

	@Test
	void testByConfrontation() {
		equipeSrv.getByConfrontation(null);
	}

	@Test
	void testByStade() {
		equipeSrv.getByStade(null);
	}

	@Test
	void testByPersonnel() {
		equipeSrv.getByPersonnel(null);
	}

	@Test
	public void testGetByCompte() {

		Equipe equipeCompte = equipeSrv.getByCompte(compte);
		assertEquals(equipe, equipeCompte);
	}


	@Test
	void testByDateConfrontation() {
		equipeSrv.getByConfrontations_DateConfrontation(null);
	}

	@Test
	void testBySalaireMore() {
		equipeSrv.getByJoueur_SalaireGreaterThan(0);
	}

	@Test
	void testBySalaireLess() {
		equipeSrv.getByPersonnel_SalaireLessThan(0);
	}

	@Test
	void testByJoueurPoste() {
		equipeSrv.getByJoueur_Poste(null);
	}


	@Test
	void getByIdExceptionTest() {
		assertThrows(EquipeException.class, () -> {
			equipeSrv.getById(9999999L);
		});
	}

	@Test
	public void testUpdate() {

		    // Créer une équipe de mise à jour avec les attributs souhaités
		    Equipe equipeMiseAJour = new Equipe();
		    equipeMiseAJour.setId(equipe.getId());
		    equipeMiseAJour.setFranchise("Red");
		    equipeMiseAJour.setCompte(new Compte("login", "password", "nom", "prenom", "email", StatutRole.ROLE_CLIENT));
		    equipeMiseAJour.setVille("Ville2");
		    equipeMiseAJour.setJoueur(equipe.getJoueur());
		    equipeMiseAJour.setPersonnel(equipe.getPersonnel());
		    // Définir les autres attributs de mise à jour si nécessaire

		    // Appeler la méthode update du service
		    Equipe equipeMajEnBase = equipeSrv.update(equipeMiseAJour);

		    // Vérifier que les attributs mis à jour correspondent aux valeurs attendues
		    assertEquals(equipe.getFranchise(), equipeMajEnBase.getFranchise());
		    assertEquals(equipe.getCompte(), equipeMajEnBase.getCompte());
		    assertEquals(equipe.getVille(), equipeMajEnBase.getVille());

		    // Comparer les collections joueur élément par élément
		    assertEquals(equipe.getJoueur().size(), equipeMajEnBase.getJoueur().size());
		    for (Joueur joueur : equipe.getJoueur()) {
		        assertTrue(equipeMajEnBase.getJoueur().contains(joueur));
		    }

		    // Comparer les collections personnel élément par élément
		    assertEquals(equipe.getPersonnel().size(), equipeMajEnBase.getPersonnel().size());
		    for (Personnel personnel : equipe.getPersonnel()) {
		        assertTrue(equipeMajEnBase.getPersonnel().contains(personnel));
		        
		   
		        
		        
		    }
		    
		}


	@Test
	public void testDeleteEquipe() {

		Equipe equipe1 = new Equipe("Pablo", "AucuneInspi", null, null, null, null, null);

		equipeRepo.save(equipe1);

		equipeRepo.delete(equipe1);

	}

	@Test
	public void testDeleteId() {
		Equipe equipe1 = new Equipe("Pablo", "AucuneInspi", null, null, null, null, null);

		equipeRepo.save(equipe1);

		equipeRepo.deleteById(equipe1.getId());

	}


}