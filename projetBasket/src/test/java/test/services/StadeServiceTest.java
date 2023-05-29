package test.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import entities.Stade;
import exceptions.StadeException;
import repositories.StadeRepository;
import services.StadeService;

@SpringJUnitConfig(configurations.JpaConfig.class)
class StadeServiceTest {

	@Autowired
	StadeService stadeSrv;
	
	@Autowired
	StadeRepository stadeRepo;
	
	@Test
	void testCreate() {
		stadeSrv.create("Staples Center", 20000, "Los Angeles");
	}
	
	@Test
	List<Stade> testGetAll() {
		return stadeSrv.getAll();
	}
	
	@Test
	List<Stade> testFindByVille() {
		return stadeSrv.getByVille("Los Angeles");
	}
	
	
	@Test
	List<Stade> testfindByCapaciteGreaterThanEqual() {
		return stadeSrv.getByCapaciteGreaterThanEqual(0);
	}
	
	@Test
	void testfindByNom() {
		stadeSrv.getByNom("Staples");
	}
	
	@Test
	List<Stade> testfindByEquipe() {
		return stadeSrv.getByEquipe(null);
	}
	
	@Test
	void getByIdExceptionTest() {
		assertThrows(StadeException.class, () -> {
			stadeSrv.getById(null);
		});
	}
	
	
    @Test
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
    public void testDeleteStade() {

        Stade stade = new Stade();
        stade.setNom("Stade à Supprimer");
        stade.setCapacite(10000);
        stade.setVille("Ville Supprimer");

       
        stadeRepo.save(stade);

     
        stadeRepo.delete(stade);

    }
    
    @Test
    public void testDeleteId() {
        Stade stade = new Stade();
        stade.setNom("Stade à Supprimer");
        stade.setCapacite(10000);
        stade.setVille("Ville Supprimer");

     
        stadeRepo.save(stade);

       
        stadeRepo.deleteById(stade.getId());

    }
    
    
	  
	}

	
