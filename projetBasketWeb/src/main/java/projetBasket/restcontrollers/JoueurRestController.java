package projetBasket.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import entities.Joueur;
import entities.jsonviews.JsonViews;
import services.JoueurService;

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
	

}
