package repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import entities.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {
	
	
	
}
