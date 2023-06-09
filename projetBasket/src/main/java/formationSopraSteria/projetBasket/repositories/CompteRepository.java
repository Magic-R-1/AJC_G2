package formationSopraSteria.projetBasket.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formationSopraSteria.projetBasket.entities.Compte;
import formationSopraSteria.projetBasket.entities.Equipe;
import formationSopraSteria.projetBasket.entities.StatutRole;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	List<Compte> findByNom(String nom);
	List<Compte> findByNomContaining(String nom);
	
	
	Optional<Compte>findByLogin(String login);
	Optional<Compte>findByEmail(String email);
	
	Optional<Compte> findByStatutRole(StatutRole statutRole);

	  @Query("update Compte p set p.equipe=null where p.equipe=:equipe")
		@Transactional
		@Modifying
		void setEquipeToNull(@Param("equipe") Equipe equipe);
	
	  
	  @Modifying
	  @Transactional
	  @Query("UPDATE Compte c SET c.equipe = null WHERE c.equipe.id = :id")
	  void updateEquipeIdToNull(@Param("id") Long id);


}
