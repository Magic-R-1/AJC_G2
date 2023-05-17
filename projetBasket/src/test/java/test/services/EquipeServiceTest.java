package test.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import configurations.JpaConfig;
import entities.Compte;
import entities.Confrontation;
import entities.Equipe;
import entities.Personnel;
import entities.Poste;
import entities.Stade;
import exceptions.EquipeException;
import exceptions.StadeException;
import repositories.EquipeRepository;
import services.EquipeService;


@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
public class EquipeServiceTest {

	@Autowired
	private EquipeService equipeSrv;
	
	@Autowired
	private EquipeRepository equipeRepo;

@Test
void testCreate() {
	equipeSrv.create("Bimbo", "Miami", null, null, null, null, null);
}

@Test
void testGetAll() {
	equipeSrv.getAll();
}

@Test
void testByFranchise() {
	equipeSrv.findByFranchise("Los");
}

@Test
void testByVille() {
	equipeSrv.findByVille("Los Angeles");
}

@Test
void testByJoueurNom() {
	equipeSrv.findByJoueurNom("Lebron");
}

@Test
void testByConfrontations() {
	equipeSrv.findByConfrontations(null);
}

@Test
void testByStade() {
	equipeSrv.findByStade(null);
}

@Test
void testByPersonnel() {
	equipeSrv.findByPersonnel(null);
}


@Test
void testByCompte() {
	equipeSrv.findByCompte(null);
}


@Test
void testByDateConfrontation() {
	equipeSrv.findByConfrontations_DateConfrontation(null);
}


@Test
void testBySalaireMore() {
	equipeSrv.findByJoueur_SalaireGreaterThan(0);
}


@Test
void testBySalaireLess() {
	equipeSrv.findByPersonnel_SalaireLessThan(0);
}


@Test
void testByJoueurPoste() {
	equipeSrv.findByJoueur_Poste(null);
}

@Test
void testByVillePrefix() {
	equipeSrv.findByVilleStartsWith(null);
}

@Test
void getByIdExceptionTest() {
	assertThrows(EquipeException.class, () -> {
		equipeSrv.getById(9999999L);
	});
}




@Test
public void testUpdate() {
	// Créer un Equipe de test avec des valeurs initiales
    Equipe equipeInitial = new Equipe("Pable", "AucuneInspi", null, null, null, null, null);

    // Sauvegarder le Equipe initial en base
    Equipe equipeEnBase = equipeRepo.save(equipeInitial);

    // Créer un Equipe avec les valeurs de mise à jour
    Equipe equipeMiseAJour = new Equipe();
    equipeMiseAJour.setId(equipeEnBase.getId()); // Définir l'ID de l'équipe de mise à jour
    equipeMiseAJour.setFranchise("Pablo"); // Mettre à jour la franchise
    
    // Appeler la méthode update avec le Equipe de mise à jour
    Equipe equipeMisAJour = equipeSrv.update(equipeMiseAJour);
    
    // Vérifier que le stade mis à jour correspond aux valeurs attendues
    assertEquals(equipeEnBase.getId(), equipeMisAJour.getId());
    assertEquals(equipeMiseAJour.getFranchise(), equipeMisAJour.getFranchise());
    assertEquals(equipeEnBase.getJoueur(), equipeMisAJour.getJoueur());
    assertEquals(equipeEnBase.getVille(), equipeMisAJour.getVille());
    assertEquals(equipeEnBase.getMatchs(), equipeMisAJour.getMatchs());
    assertEquals(equipeEnBase.getStade(), equipeMisAJour.getStade());
}

@Test
public void testDeleteEquipe() {

    Equipe equipe = new Equipe("Pablo", "AucuneInspi", null, null, null, null, null);

   
    equipeRepo.save(equipe);

 
    equipeRepo.delete(equipe);

}

@Test
public void testDeleteId() {
	Equipe equipe = new Equipe("Pablo", "AucuneInspi", null, null, null, null, null);

	   

 
    equipeRepo.save(equipe);

   
    equipeRepo.deleteById(equipe.getId());

}





//long count();



}