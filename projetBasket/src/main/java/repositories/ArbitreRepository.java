package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Arbitre;
import entities.Confrontation;

public interface ArbitreRepository extends JpaRepository<Arbitre, Long> {
	
	List<Arbitre> findByConfrontation(Confrontation confrontation);

}
