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
import entities.Confrontation;
import entities.Equipe;
import entities.Personnel;
import entities.Poste;
import entities.Stade;

@Transactional
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	   
	Optional<Equipe> findByFranchise(String franchise);

	List<Equipe> findByVille(String ville);
	
	List<Equipe> findByJoueurNom(String nom);
	
	List<Equipe> findByConfrontation(Confrontation confrontation);
	
	List<Equipe> findByStade(Stade stade);
	
	List<Equipe> findByPersonnel(Personnel personnel);
	
	Optional<Equipe> findByCompte(Compte compte);
	
	List<Equipe> findByConfrontation_DateConfrontation(LocalDate dateConfrontation);

	List<Equipe> findByJoueur_SalaireGreaterThan(double salaire);

	List<Equipe> findByPersonnel_SalaireLessThan(double salaire);

	List<Equipe> findByJoueur_Poste(Poste poste);

	
	
	@Query("update Equipe p set p.stade=null where p.stade=:stade")
	@Transactional
	@Modifying
	void setStadeToNull(@Param("stade") Stade stade);
	
	
	
	
}
