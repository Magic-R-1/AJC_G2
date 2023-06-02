package formationSopraSteria.projetBasket.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formationSopraSteria.projetBasket.entities.Equipe;
import formationSopraSteria.projetBasket.entities.Stade;

@Transactional
public interface StadeRepository extends JpaRepository<Stade, Long>{
	
	
	//Trouver tous les stades dans une ville donnée :
	List<Stade> findByVille(String ville);

	
	//Trouver tous les stades dont la capacité est supérieure ou égale à une certaine valeur :
	List<Stade> findByCapacite(int capacite);
	

	//Récupérer un stade en fonction de son nom :
	Optional<Stade> findByNom(String nom);

	
	
	//Récupérer tous les stades d'une certaine équipe :
	List<Stade> findByEquipe(Equipe equipe);


	 @Query("update Stade p set p.equipe=null where p.equipe=:equipe")
	@Transactional
	@Modifying
	void setEquipeToNull(@Param("equipe") Equipe equipe);


	List<Stade> findByCapaciteGreaterThanEqual(int capacite);


	@Modifying
	@Transactional
	@Query("UPDATE Stade c SET c.equipe = null WHERE c.equipe.id = :id")
	void updateEquipeIdToNull(@Param("id") Long id);





}