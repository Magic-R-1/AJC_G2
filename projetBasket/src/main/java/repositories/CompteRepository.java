package repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	
	@Transactional
	@Modifying
	public void insert(Compte compte);
	
	@Transactional
	@Modifying
	public void update(Compte compte);
	
	@Transactional
	@Modifying
	public void delete(Compte compte);
	
	@Transactional
	@Modifying
	public void deleteByKey(Long key);
	
	public Optional<Compte> findByKey(Long key);
	
	public List<Compte> findAll();

}
