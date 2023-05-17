package repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entities.Compte;
import entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	   
	
	//Récupérer une équipe par son nom:
	@Query("SELECT e FROM Equipe e WHERE e.nom = :nom")
	Equipe findEquipeByNom(@Param("nom") String nom);

	
	//Récupérer toutes les équipes d'une ville donnée :
	List<Equipe> findByVille(String ville);
	
	//Récupérer toutes les équipes ayant un joueur avec un nom donné :
	@Query("SELECT e FROM Equipe e JOIN e.joueur j WHERE j.nom = :nom")
	    List<Equipe> findByJoueurNom(@Param("nom") String nom);


	//Récupérer toutes les équipes ayant joué une confrontation après une certaine date
	@Query("SELECT e FROM Equipe e JOIN e.confrontations c WHERE c.date > :date")
	    List<Equipe> findByConfrontationDateAfter(@Param("date") LocalDate date);

	//Récupérer toutes les équipes dont le compte a effectué une réservation dans un certain intervalle de dates
	@Query("SELECT DISTINCT e FROM Equipe e JOIN e.membres m JOIN m.reservations r WHERE r.dateDebut >= :dateDebut AND r.dateFin <= :dateFin AND r.compte = :compte")
	List<Equipe> findEquipesByMembreReservationBetweenDates(@Param("dateDebut") LocalDate dateDebut, @Param("dateFin") LocalDate dateFin, @Param("compte") Compte compte);

	
	//Récupérer toutes les équipes dont la date de création est antérieure à une certaine date
	@Query("SELECT e FROM Equipe e WHERE e.dateCreation < :date")
	List<Equipe> findEquipesByDateCreationBefore(@Param("date") LocalDate date);

	
	//Récupérer toutes les équipes dont le responsable est un certain compte :
	@Query("SELECT e FROM Equipe e WHERE e.responsable = :compte")
	List<Equipe> findEquipesByResponsable(@Param("compte") Compte compte);

	
	//Récupérer toutes les équipes dont le nom contient un certain mot :
	@Query("SELECT e FROM Equipe e WHERE e.nom LIKE %:nom%")
	List<Equipe> findEquipesByNomContaining(@Param("nom") String nom);

	
	//Trouver toutes les équipes avec leur moyenne d'âge :
	@Query("SELECT e, AVG(j.age) FROM Equipe e LEFT JOIN e.joueur j GROUP BY e")
	List<Equipe> trouverEquipesAvecMoyenneAge();


	//Trouver toutes les équipes avec leur joueur ayant la plus grande taille :
	@Query("SELECT e, j FROM Equipe e LEFT JOIN e.joueur j WHERE j.taille = (SELECT MAX(j2.taille) FROM Joueur j2 WHERE j2.equipe = e)")
	List<Equipe> trouverEquipesAvecJoueurPlusGrand();
	
	
	//Trouver toutes les équipes qui ont participé à au moins une confrontation :
	@Query("SELECT DISTINCT c.equipe FROM Confrontation c JOIN c.equipe")
	List<Equipe> findAllEquipesWithConfrontation();


	//Trouver toutes les équipes qui n'ont pas participé à une confrontation :
	@Query("SELECT e FROM Equipe e WHERE e NOT IN (SELECT DISTINCT c.equipe FROM Confrontation c JOIN c.equipe)")
	List<Equipe> findAllEquipesWithoutConfrontation();
	
	
	//Trouver toutes les équipes qui ont joué contre une équipe donnée :
	@Query("SELECT DISTINCT c.equipe FROM Confrontation c WHERE c.equipe != :team AND EXISTS (SELECT 1 FROM Confrontation c2 WHERE c2.equipe = :team AND c2.id = c.id)")
	List<Equipe> findOpponentsOfEquipe(@Param("team") Equipe equipe);
	

	
}
