package formationSopraSteria.projetBasket.restcontrollers;

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

import formationSopraSteria.projetBasket.entities.Arbitre;
import formationSopraSteria.projetBasket.entities.jsonviews.JsonViews;
import formationSopraSteria.projetBasket.services.ArbitreService;

@RestController
@RequestMapping("/api/arbitre")
public class ArbitreRestController {

	
	@Autowired
	private ArbitreService arbitreSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Stade.class)
	public List<Arbitre> getAll() {
		return arbitreSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Arbitre.class)
	public Arbitre getById(@PathVariable("id") Long id) {
		return arbitreSrv.getById(id);
	}
	
	@GetMapping("/nom/{nom}")
	@JsonView(JsonViews.Arbitre.class)
	public List<Arbitre> getByNom(@PathVariable String nom){
		return arbitreSrv.getByNom(nom);
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Arbitre.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Arbitre create(@Valid @RequestBody Arbitre arbitre,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return arbitreSrv.create(arbitre);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Arbitre.class)
	public Arbitre update(@Valid @RequestBody Arbitre arbitre,BindingResult br,@PathVariable Long id) {
		arbitre.setId(id);
		return arbitreSrv.update(arbitre);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		arbitreSrv.delete(id);
	}
}
