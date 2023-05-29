package formationSopraSteria.projetBasket.restcontrollers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formationSopraSteria.projetBasket.entities.Reservation;
import formationSopraSteria.projetBasket.entities.jsonviews.JsonViews;
import formationSopraSteria.projetBasket.services.ReservationService;



@RestController
@RequestMapping("/api/reservation")
public class ReservationRestController {

	@Autowired
	private ReservationService ReservationSrv;
	
	
	@GetMapping("")
	@JsonView(JsonViews.Reservation.class)
	public List<Reservation> getAll() {
		return ReservationSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Reservation.class)
	public Reservation getById(@PathVariable("id") Long id) {
		return ReservationSrv.getById(id);
	}
	
	@GetMapping("/dateReservation/{dateReservation}")
	@JsonView(JsonViews.Reservation .class)
	public List<Reservation > findBydateReservation(@PathVariable("dateReservation") LocalDate dateReservation) {
		return  ReservationSrv.findBydateReservation(dateReservation);
	}

	
	@PostMapping("")
	@JsonView(JsonViews.Reservation.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Reservation create(@Valid @RequestBody Reservation Reservation,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return ReservationSrv.create(Reservation);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Reservation.class)
	public Reservation update(@Valid @RequestBody Reservation Reservation,BindingResult br,@PathVariable Long id) {
		Reservation.setId(id);
		return ReservationSrv.update(Reservation);
	}  
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		ReservationSrv.delete(id);
	}
	
}

