package formationSopraSteria.projetBasket.restcontrollers;

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

import formationSopraSteria.projetBasket.entities.Personnel;
import formationSopraSteria.projetBasket.entities.jsonviews.JsonViews;
import formationSopraSteria.projetBasket.services.PersonnelService;


@RestController
@RequestMapping("/api/personnel")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonnelRestController {

	
	@Autowired
	private PersonnelService PersonnelSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Personnel.class)
	public List<Personnel> getAll() {
		return PersonnelSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Personnel.class)
	public Personnel getById(@PathVariable("id") Long id) {
		return PersonnelSrv.getById(id);
	}
	
	@GetMapping("/salaire/{salaire}")
	@JsonView(JsonViews.Personnel.class)
	public List<Personnel> findBySalaire(@PathVariable("salaire") double salaire) {
		return  PersonnelSrv.findBySalaire(salaire);
	}

	
	@PostMapping("")
	@JsonView(JsonViews.Personnel.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Personnel create(@Valid @RequestBody Personnel Personnel,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return PersonnelSrv.create(Personnel);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Personnel.class)
	public Personnel update(@Valid @RequestBody Personnel Personnel,BindingResult br,@PathVariable Long id) {
		Personnel.setId(id);
		return PersonnelSrv.update(Personnel);
	}
	
//	
//	 @PutMapping("/{personnelId}/salaire")
//	    public Personnel modifierSalairePersonnel( @Valid @RequestBody Personnel Personnel,BindingResult br,@PathVariable("personnelId") Long personnelId,
//	                                              @RequestParam("nouveauSalaire") int nouveauSalaire) {
//	        Optional<Personnel> personnelOptional = personnelRepo.findById(personnelId);
//
//	        if (personnelOptional.isPresent()) {
//	            Personnel personnel = personnelOptional.get();
//	            personnel.setSalaire(nouveauSalaire);
//	            return personnelRepo.save(personnel);
//	        } else {
//	            throw new IllegalArgumentException("Personnel non trouvé avec l'ID : " + personnelId);
//	        }
//	  
//	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		PersonnelSrv.delete(id);
	}
	
}
	

