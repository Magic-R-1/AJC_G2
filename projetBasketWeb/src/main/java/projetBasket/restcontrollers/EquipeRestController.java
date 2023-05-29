package projetBasket.restcontrollers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import entities.Compte;
import entities.Confrontation;
import entities.Equipe;
import entities.Personnel;
import entities.Poste;
import entities.Stade;
import entities.jsonviews.JsonViews;
import services.EquipeService;

@RestController
@RequestMapping("/api/team")
public class EquipeRestController {
	
	@Autowired
	private EquipeService equipeSrv;
	
	@GetMapping("/city/{city}")
	@JsonView(JsonViews.Equipe.class)
	public List<Equipe> getByVille(@PathVariable String ville){
		return equipeSrv.getByVille(ville);
	}
	
	
	@GetMapping("/playername/{player}")
	@JsonView(JsonViews.Equipe.class)
	public List<Equipe> getByJoueurNom(@PathVariable String nom){
		return equipeSrv.getByJoueurNom(nom);
	}
	
	@GetMapping("/franchise/{franchise}")
    @JsonView(JsonViews.Equipe.class)
    public Optional<Equipe> getByFranchise(@PathVariable String franchise) {
		return Optional.ofNullable(equipeSrv.getByFranchise(franchise));
}

	
	@GetMapping("/confrontation/{confrontation}")
	@JsonView(JsonViews.EquipeWithConfrontation.class)
	public List<Equipe> getByConfrontation(@PathVariable Confrontation confrontation){
		return equipeSrv.getByConfrontation(confrontation);
	}
	
	
	@GetMapping("/stadium/{stadium}")
	@JsonView(JsonViews.EquipeWithStade.class)
	public List<Equipe> getByStade(@PathVariable Stade stade){
		return equipeSrv.getByStade(stade);
	}
	
	
	@GetMapping("/staff/{staff}")
	@JsonView(JsonViews.EquipeWithPersonnel.class)
	public List<Equipe> getByPersonnel(@PathVariable Personnel personnel){
		return equipeSrv.getByPersonnel(personnel);
	}
	
	
	@GetMapping("/account/{account}")
	@JsonView(JsonViews.EquipeWithCompte.class)
	public Optional<Equipe> getByCompte(@PathVariable Compte compte){
		return Optional.ofNullable(equipeSrv.getByCompte(compte));
	}
	
	@GetMapping("/confrontationdate/{date}")
	@JsonView(JsonViews.EquipeWithConfrontation.class)
	public List<Equipe> findByConfrontations_DateConfrontation(@PathVariable LocalDate dateConfrontation){
		return equipeSrv.getByConfrontations_DateConfrontation(dateConfrontation);
	}
	
	
	@GetMapping("/greatersalary/{salary}")
	@JsonView(JsonViews.EquipeWithJoueur.class)
	public List<Equipe> getByJoueur_SalaireGreaterThan(@PathVariable double salaire){
		return equipeSrv.getByJoueur_SalaireGreaterThan(salaire);
	}
	
	
	@GetMapping("/lesssalary/{salary}")
	@JsonView(JsonViews.EquipeWithJoueur.class)
	public List<Equipe> getByPersonnel_SalaireLessThan(@PathVariable double salaire){
		return equipeSrv.getByPersonnel_SalaireLessThan(salaire);
	}
	
	@GetMapping("/player_position/{player_position}")
	@JsonView(JsonViews.EquipeWithJoueur.class)
	public List<Equipe> getByJoueur_Poste(@PathVariable Poste poste){
		return equipeSrv.getByJoueur_Poste(poste);
	}
	
	
	@GetMapping("")
	@JsonView(JsonViews.Equipe.class)
	public List<Equipe> getAll() {
		return equipeSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Equipe.class)
	public Equipe getById(@PathVariable("id") Long id) {
		return equipeSrv.getById(id);
	}
	
	
	@PostMapping("")
	@JsonView(JsonViews.Equipe.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Equipe create(@Valid @RequestBody Equipe equipe,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return equipeSrv.create(equipe);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Equipe.class)
	public Equipe update(@Valid @RequestBody Equipe equipe,BindingResult br,@PathVariable Long id) {
		equipe.setId(id);
		return equipeSrv.update(equipe);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		equipeSrv.delete(id);
	}
	
	
	
}
