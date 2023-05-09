package repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import entities.Confrontation;

public interface ConfrontationRepository extends JpaRepository<Confrontation, Long> {
	
	@Transactional
	@Modifying
	public void insert(Confrontation confrontation);
	
	@Transactional
	@Modifying
	public void update(Confrontation confrontation);
	
	@Transactional
	@Modifying
	public void delete(Confrontation confrontation);
	
	@Transactional
	@Modifying
	public void deleteByKey(Long key);
	
	public Optional <Confrontation> findByKey(Long key);
	
	public List<Confrontation> findAll();

}
