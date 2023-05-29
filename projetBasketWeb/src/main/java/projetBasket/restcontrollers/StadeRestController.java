package projetBasket.restcontrollers;

import java.util.List;
import java.util.Optional;

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

import entities.Equipe;
import entities.Stade;
import entities.jsonviews.JsonViews;
import services.StadeService;

@RestController
@RequestMapping("/api/stade")
public class StadeRestController {

	@Autowired
	private StadeService stadeSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Stade.class)
	public List<Stade> getAll() {
		return stadeSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Stade.class)
	public Stade getById(@PathVariable("id") Long id) {
		return stadeSrv.getById(id);
	}
	
	@GetMapping("/city/{city}")
	@JsonView(JsonViews.Stade.class)
	public List<Stade> getByVille(@PathVariable String ville){
		return stadeSrv.getByVille(ville);
	}
	
	@GetMapping("/capacity/{capacity}")
	@JsonView(JsonViews.Stade.class)
	public List<Stade> getByCapaciteGreaterThanEqual(@PathVariable int capacite){
		return stadeSrv.getByCapaciteGreaterThanEqual(capacite);
	}
	
	@GetMapping("/name/{name}")
	@JsonView(JsonViews.Stade.class)
	public Stade getByNom(@PathVariable String nom){
		return stadeSrv.getByNom(nom);
	}
	
	
	@GetMapping("/team/{team}")
	@JsonView(JsonViews.StadeWithEquipe.class)
	public List<Stade> getByEquipe(@PathVariable Equipe equipe){
		return stadeSrv.getByEquipe(equipe);
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Stade.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Stade create(@Valid @RequestBody Stade stade,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return stadeSrv.create(stade);
	}
	
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Stade.class)
	public Stade update(@Valid @RequestBody Stade stade,BindingResult br,@PathVariable Long id) {
		stade.setId(id);
		return stadeSrv.update(stade);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		stadeSrv.delete(id);
	}
	
	
}
