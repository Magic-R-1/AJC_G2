package repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel, Long>{
	
	List<Personnel> findBySalaire(double salaire);
	
}

