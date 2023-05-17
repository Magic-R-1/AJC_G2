package repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entities.Compte;
import entities.Equipe;
import entities.StatutRole;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	List<Compte> findByNom(String nom);
	List<Compte> findByNomContaining(String nom);
	Optional<Compte> findByStatutRole(StatutRole statutRole);

	  @Query("update Compte p set p.equipe=null where p.equipe=:equipe")
		@Transactional
		@Modifying
		void setEquipeToNull(@Param("equipe") Equipe equipe);

}
