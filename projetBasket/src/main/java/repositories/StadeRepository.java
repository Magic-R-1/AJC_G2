package repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Equipe;
import entities.Stade;

public interface StadeRepository extends JpaRepository<Stade, Long>{
	
	
	//Trouver tous les stades dans une ville donnée :
	List<Stade> findByVille(String ville);

	
	//Trouver tous les stades dont la capacité est supérieure ou égale à une certaine valeur :
	List<Stade> findByCapaciteGreaterThanEqual(int capacite);
	
	
	//Trouver le stade qui a la capacité maximale :
	Stade findTopByOrderByCapaciteDesc();

	//Récupérer un stade en fonction de son nom :
	Optional<Stade> findByNom(String nom);

	
	
	//Récupérer tous les stades d'une certaine équipe :
	List<Stade> findByEquipe(Equipe equipe);

}
