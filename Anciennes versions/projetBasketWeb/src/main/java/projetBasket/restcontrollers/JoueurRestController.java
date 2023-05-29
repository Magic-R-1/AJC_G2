package projetBasket.restcontrollers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import projetBasket.entities.Joueur;
import projetBasket.entities.jsonviews.JsonViews;
import projetBasket.services.JoueurService;

@RestController
@RequestMapping("/api/joueur")
public class JoueurRestController {
	
	@Autowired
	private JoueurService joueurSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Joueur.class)
	public List<Joueur> getAll() {
		return joueurSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Joueur.class)
	public Joueur getById(@PathVariable("id") Long id) {
		return joueurSrv.getById(id);
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Joueur.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Joueur create(@Valid @RequestBody Joueur joueur,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return joueurSrv.create(joueur);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Joueur.class)
	public Joueur update(@Valid @RequestBody Joueur joueur,BindingResult br,@PathVariable Long id) {
		joueur.setId(id);
		return joueurSrv.update(joueur);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		joueurSrv.delete(id);
	}
	
	@GetMapping("/recherchetaille/{min}/{max}")
    public List<Joueur> rechercherJoueurParTaille(
    //        @RequestParam("tailleMini") int tailleMini,
    //        @RequestParam("tailleMaxi") int tailleMaxi)
    // http://localhost:8080/basketRest/api/joueur/recherchetaille?tailleMini=189&tailleMaxi=191
    		@PathVariable("min") int min,
    		@PathVariable("max") int max) {
        return joueurSrv.rechercherJoueurParTaille(min, max);
    }
	
	@GetMapping("/recherchepoids/{min}/{max}")
    public List<Joueur> rechercherJoueurParPoids(
    		@PathVariable("min") int min,
    		@PathVariable("max") int max) {
        return joueurSrv.rechercherJoueurParPoids(min, max);
    }
	
	@GetMapping("/recherchevitesse/{vitesse}")
    public List<Joueur> rechercherJoueurAvecVitesseSuperieureOuEgaleA(
    		@PathVariable("vitesse") int vitesse) {
        return joueurSrv.rechercherJoueurAvecVitesseSuperieureOuEgaleA(vitesse);
    }
	
}
