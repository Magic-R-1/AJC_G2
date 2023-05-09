package repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import entities.Arbitre;

public interface ArbitreRepository extends JpaRepository<Arbitre, Long> {
	
	@Transactional
	@Modifying
	public void insert(Arbitre arbitre);
	
	@Transactional
	@Modifying
	public void update(Arbitre arbitre);
	
	@Transactional
	@Modifying
	public void delete(Arbitre arbitre);
	
	@Transactional
	@Modifying
	public void deleteByKey(Long key);
	
	public Arbitre findByKey(Long key);
	
	public List<Arbitre> findAll();

}
