package formationSopraSteria.projetBasket.restcontrollers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import formationSopraSteria.projetBasket.entities.Confrontation;
import formationSopraSteria.projetBasket.entities.jsonviews.JsonViews;
import formationSopraSteria.projetBasket.services.ConfrontationService;

@RestController
@RequestMapping("/api/confrontation")
@CrossOrigin(origins = "http://localhost:4200")
public class ConfrontationRestController {

	
	@Autowired
	private ConfrontationService confrontationSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Stade.class)
	public List<Confrontation> getAll() {
		return confrontationSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Confrontation.class)
	public Confrontation getById(@PathVariable("id") Long id) {
		return confrontationSrv.getById(id);
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Confrontation.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Confrontation create(@Valid @RequestBody Confrontation confrontation,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return confrontationSrv.create(confrontation);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Confrontation.class)
	public Confrontation update(@Valid @RequestBody Confrontation confrontation,BindingResult br,@PathVariable Long id) {
		confrontation.setId(id);
		return confrontationSrv.update(confrontation);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		confrontationSrv.delete(id);
	}
	
	@GetMapping("/dateConfrontation/{dateConfrontation}")
	@JsonView(JsonViews.Arbitre.class)
	public List<Confrontation> getByDateConfrontation (@PathVariable LocalDate dateConfrontation){
		return confrontationSrv.getByDateConfrontation(dateConfrontation);
	}
	
	@GetMapping("/scoreDomicile/{scoreDomicile}")
	@JsonView(JsonViews.Arbitre.class)
	public List<Confrontation> findByScoreDomicile (@PathVariable int scoreDomicile){
		return confrontationSrv.findByScoreDomicile(scoreDomicile);
	}
	
	@GetMapping("/scoreVisiteur/{scoreVisiteur}")
	@JsonView(JsonViews.Arbitre.class)
	public List<Confrontation> findByScoreVisiteur (@PathVariable int scoreVisiteur){
		return confrontationSrv.findByScoreVisiteur(scoreVisiteur);
	}
	
	
	
}
