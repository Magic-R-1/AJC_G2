package projetBasket.restcontrollers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/ville/{ville}")
	@JsonView(JsonViews.Stade.class)
	public List<Stade> findByVille(@PathVariable String ville){
		return stadeSrv.findByVille(ville);
	}
	
	@GetMapping("/capacite/{capacite}")
	@JsonView(JsonViews.Stade.class)
	public List<Stade> findByCapaciteGreaterThanEqual(@PathVariable int capacite){
		return stadeSrv.findByCapaciteGreaterThanEqual(capacite);
	}
	
	@GetMapping("/nom/{nom}")
	@JsonView(JsonViews.Stade.class)
	public Stade findByNom(@PathVariable String nom){
		return stadeSrv.findByNom(nom);
	}
	
	
	@GetMapping("/equipe/{equipe}")
	@JsonView(JsonViews.Stade.class)
	public List<Stade> findByEquipe(@PathVariable Equipe equipe){
		return stadeSrv.findByEquipe(equipe);
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
	
	
	
}
