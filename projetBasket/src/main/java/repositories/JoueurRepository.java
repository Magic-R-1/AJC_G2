package repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import entities.Arbitre;
import entities.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

	@Transactional
	@Modifying
	public void insert(Joueur arbitre);
	
	@Transactional
	@Modifying
	public void update(Joueur arbitre);
	
	@Transactional
	@Modifying
	public void delete(Joueur arbitre);
	
	@Transactional
	@Modifying
	public void deleteByKey(Long key);
	
	public Optional<Joueur> findByKey(Long key);
	
	public List<Joueur> findAll();
	
}
