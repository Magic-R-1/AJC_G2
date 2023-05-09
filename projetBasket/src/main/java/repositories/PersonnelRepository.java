package repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import entities.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel, Long>{
	
	@Transactional
	@Modifying
	public void insert(Personnel personnel);
	
	@Transactional
	@Modifying
	public void update(Personnel personnel);
	
	@Transactional
	@Modifying
	public void delete(Personnel personnel);
	
	@Transactional
	@Modifying
	public void deleteByKey(Long key);
	
	public Optional<Personnel> findByKey(Long key);
	
	public List<Personnel> findAll();

}

