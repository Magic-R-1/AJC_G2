package repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import entities.Stade;

public interface StadeRepository extends JpaRepository<Stade, Long>{
	
	@Transactional
	@Modifying
	public void insert(Stade Stade);
	
	@Transactional
	@Modifying
	public void update(Stade Stade);
	
	@Transactional
	@Modifying
	public void delete(Stade Stade);
	
	@Transactional
	@Modifying
	public void deleteByKey(Long key);
	
	public Optional<Stade> findByKey(Long key);
	
	public List<Stade> findAll();

}
