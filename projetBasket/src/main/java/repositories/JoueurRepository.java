package repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entities.Equipe;
import entities.Joueur;
import entities.Poste;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {
	
//	@Query("SELECT j FROM Joueur j WHERE TIMESTAMPDIFF(YEAR, current_date, j.date_naissance) >= :ageDebut" +
//	"AND TIMESTAMPDIFF(YEAR, current_date, j.date_naissance) <= :ageFin")
//	List<Joueur> findByAgeBetween(int ageDebut, int ageFin);
//	
	List<Joueur> findByPoste(Poste poste);
	
	@Query("SELECT j FROM Joueur j WHERE j.taille >= :tailleMini AND j.taille <= :tailleMaxi")
	List<Joueur> findByTailleBetween(int tailleMini, int tailleMaxi);
	
	@Query("SELECT j FROM Joueur j WHERE j.poids >= :poidsMini AND j.poids <= :poidsMaxi")
	List<Joueur> findByPoidsBetween(int poidsMini, int poidsMaxi);
	
	@Modifying
	@Transactional
    @Query("UPDATE Joueur j SET j.equipe = :nouvelleEquipe WHERE j.id = :joueurId")
    void changerEquipe(Long joueurId, Equipe nouvelleEquipe);
	
	// Aptitudes physiques
    List<Joueur> findByAptitudesPhysiquesVitesseGreaterThanEqual(int valeur);

    List<Joueur> findByAptitudesPhysiquesEnduranceGreaterThanEqual(int valeur);

    List<Joueur> findByAptitudesPhysiquesForceGreaterThanEqual(int valeur);

    List<Joueur> findByAptitudesPhysiquesDetenteGreaterThanEqual(int valeur);

    List<Joueur> findByAptitudesPhysiquesAgiliteGreaterThanEqual(int valeur);
	
//    @Query("SELECT j FROM Joueur j WHERE " +
//            "(SELECT AVG(a.vitesse + a.endurance + a.force + a.detente + a.agilite) " +
//            "FROM j.aptitudesPhysiques a) >= :moyenne")
//     List<Joueur> findByMoyenneAptitudesPhysiquesGreaterThanEqual(int moyenne);

    @Query("update Joueur p set p.equipe=null where p.equipe=:equipe")
	@Transactional
	@Modifying
	void setEquipeToNull(@Param("equipe") Equipe equipe);

    
}
