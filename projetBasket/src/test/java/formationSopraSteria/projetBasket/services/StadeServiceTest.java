package formationSopraSteria.projetBasket.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formationSopraSteria.projetBasket.entities.Stade;
import formationSopraSteria.projetBasket.exceptions.StadeException;
import formationSopraSteria.projetBasket.repositories.StadeRepository;

@SpringBootTest
class StadeServiceTest {

	@Autowired
	StadeService stadeSrv;
	
	@Autowired
	StadeRepository stadeRepo;
	
	@Test
	void testCreate() {
		stadeSrv.create("Staples Center", 20000, "Los Angeles");
		stadeSrv.create("Chase Center", 25000, "San Fransisco");
		stadeSrv.create("Paycom Center", 22000, "Oklahoma City");
		stadeSrv.create("TD Garden", 30000, "Boston");
	}
	
	@Test
	 @Disabled
	List<Stade> testGetAll() {
		return stadeSrv.getAll();
	}
	
	@Test
	 @Disabled
	List<Stade> testFindByVille() {
		return stadeSrv.getByVille("Los Angeles");
	}
	
	
	@Test
	 @Disabled
	List<Stade> testfindByCapaciteGreaterThanEqual() {
		return stadeSrv.getByCapaciteGreaterThanEqual(0);
	}
	
	@Test
	@Disabled
	void testfindByNom() {
		stadeSrv.getByNom(null);
	}
	
	@Test
	 @Disabled
	List<Stade> testfindByEquipe() {
		return stadeSrv.getByEquipe(null);
	}
	
	@Test
	 @Disabled
	void getByIdExceptionTest() {
		assertThrows(StadeException.class, () -> {
			stadeSrv.getById(null);
		});
	}
	
	
    @Test
    @Disabled
    public void testUpdate() {
        // Créer un stade de test avec des valeurs initiales
        Stade stadeInitial = new Stade();
        stadeInitial.setNom("Stade Initial");
        stadeInitial.setCapacite(10000);
        stadeInitial.setVille("Ville Initial");

        // Sauvegarder le stade initial en base
        Stade stadeEnBase = stadeRepo.save(stadeInitial);

        // Créer un stade avec les valeurs de mise à jour
        Stade stadeMiseAJour = new Stade();
        stadeMiseAJour.setId(stadeEnBase.getId());
        stadeMiseAJour.setNom("Stade Mis à Jour");
        stadeMiseAJour.setCapacite(20000);
        stadeMiseAJour.setVille("Ville Mise à Jour");

        // Appeler la méthode update avec le stade de mise à jour
        Stade stadeMisAJour = stadeSrv.update(stadeMiseAJour);

        // Vérifier que le stade mis à jour correspond aux valeurs attendues
        assertEquals(stadeEnBase.getId(), stadeMisAJour.getId());
        assertEquals(stadeMiseAJour.getNom(), stadeMisAJour.getNom());
        assertEquals(stadeMiseAJour.getCapacite(), stadeMisAJour.getCapacite());
        assertEquals(stadeMiseAJour.getVille(), stadeMisAJour.getVille());

       
    }
    
    @Test
    @Disabled
    public void testDeleteStade() {

        Stade stade = new Stade();
        stade.setNom("Stade à Supprimer");
        stade.setCapacite(10000);
        stade.setVille("Ville Supprimer");

       
        stadeRepo.save(stade);

     
        stadeRepo.delete(stade);

    }
    
    @Test
    @Disabled
    public void testDeleteId() {
        Stade stade = new Stade();
        stade.setNom("Stade à Supprimer");
        stade.setCapacite(10000);
        stade.setVille("Ville Supprimer");

     
        stadeRepo.save(stade);

       
        stadeRepo.deleteById(stade.getId());

    }
    
    
	  
	}