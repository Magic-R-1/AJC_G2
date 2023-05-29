package formationSopraSteria.projetBasket.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formationSopraSteria.projetBasket.entities.Equipe;
import formationSopraSteria.projetBasket.entities.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel, Long>{
	
	List<Personnel> findBySalaire(double salaire);

	@Query("update Personnel p set p.equipe=null where p.equipe=:equipe")
	@Transactional
	@Modifying
	void setEquipeToNull(@Param("equipe") Equipe equipe);

	List<Personnel> findByNomContaining(String nom);

	
}
