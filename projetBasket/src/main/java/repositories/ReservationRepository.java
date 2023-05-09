package repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	@Transactional
	@Modifying
	public void insert(Reservation arbitre);
	
	@Transactional
	@Modifying
	public void update(Reservation arbitre);
	
	@Transactional
	@Modifying
	public void delete(Reservation arbitre);
	
	@Transactional
	@Modifying
	public void deleteByKey(Long key);
	
	public Optional<Reservation> findByKey(Long key);
	
	public List<Reservation> findAll();

}


