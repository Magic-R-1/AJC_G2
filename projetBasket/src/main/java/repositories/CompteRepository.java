package repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Compte;
import entities.StatutRole;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	List<Compte> findByNom(String nom);
	List<Compte> findByNomContaining(String nom);
	Optional<Compte> findByStatutRole(StatutRole statutRole);
}
