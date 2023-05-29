package projetBasket.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetBasket.entities.Compte;
import projetBasket.entities.Confrontation;
import projetBasket.entities.Reservation;
import projetBasket.exceptions.ReservationException;
import projetBasket.repositories.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	private void checkReservation(Reservation reservation) {
		if (reservation == null) {
			throw new ReservationException("reservation null");
		}
		if (reservation.getPrix() < 0) {
			throw new ReservationException("prix invalide");
		}
		if (reservation.getQuantite() == null || reservation.getQuantite() <= 0) {
			throw new ReservationException("quantite invalide");
		}
		if (reservation.getDateReservation() == null || reservation.getDateReservation().isBefore(LocalDate.now())) {
			throw new ReservationException("date de réservation invalide");
		}
		if (reservation.getConfrontation() == null) {
			throw new ReservationException("confrontation invalide");
		}
		if (reservation.getCompte() == null) {
			throw new ReservationException("compte invalide");
		}
	}
	
	private void checkId(Long id) {
		if (id == null) {
			throw new ReservationException("id null");
		}
	}
	
	public Reservation create(Reservation reservation) {
		checkReservation(reservation);
		return reservationRepo.save(reservation);
	}
	
	public Reservation updatePrix(Reservation reservation) {
		Reservation reservationEnBase = getById(reservation.getId());
		reservationEnBase.setPrix(reservation.getPrix());
		return reservationRepo.save(reservationEnBase);
	}
	
	public Reservation updateQuantite(Reservation reservation) {
		Reservation reservationEnBase = getById(reservation.getId());
		reservationEnBase.setQuantite(reservation.getQuantite());
		return reservationRepo.save(reservationEnBase);
	}
	
	public Reservation updateDateReservation(Reservation reservation) {
		Reservation reservationEnBase = getById(reservation.getId());
		reservationEnBase.setDateReservation(reservation.getDateReservation());
		return reservationRepo.save(reservationEnBase);
	}
	
	public Reservation getById(Long id) {
		checkId(id);
		return reservationRepo.findById(id)
				.orElseThrow(() -> new ReservationException("id inconnu"));
	}
	
	public List<Reservation> findByCompteId(Compte compte) {
		return reservationRepo.findByCompteId(compte);
	}
	
	public List<Reservation> findByConfrontationId(Confrontation confrontation) {
		return reservationRepo.findByConfrontationId(confrontation);
	}
	
	public List<Reservation> findBydateReservation(LocalDate dateReservation) {
		return reservationRepo.findBydateReservation(dateReservation);
	}
	
	public List<Reservation> findByPrix(double prix) {
		return reservationRepo.findByPrix(prix);
	}

	public List<Reservation> findByQuantite(Integer quantite) {
		return reservationRepo.findByQuantite(quantite);
	}
	
}


	