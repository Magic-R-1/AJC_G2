package formationSopraSteria.projetBasket.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import formationSopraSteria.projetBasket.entities.Arbitre;

public interface ArbitreRepository extends JpaRepository<Arbitre, Long> {
	
	List<Arbitre> findByNom(String nom);
	List<Arbitre> findByNomContaining(String nom);
	
//	@Query("update Arbitre a set a.confrontation=null where a.confrontation=:confrontation")
//	@Transactional
//	@Modifying
//	void setConfrontationToNull(@Param("confrontation") Confrontation confrontation);

}