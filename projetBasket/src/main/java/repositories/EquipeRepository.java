package repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	@Transactional
	@Modifying
	public void insert(Equipe Equipe);
	
	@Transactional
	@Modifying
	public void update(Equipe Equipe);
	
	@Transactional
	@Modifying
	public void delete(Equipe Equipe);
	
	@Transactional
	@Modifying
	public void deleteByKey(Long key);
	
	public Optional<Equipe> findByKey(Long key);
	
	public List<Equipe> findAll();

}
