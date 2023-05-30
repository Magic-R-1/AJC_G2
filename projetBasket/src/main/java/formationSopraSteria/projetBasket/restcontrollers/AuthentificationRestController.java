package formationSopraSteria.projetBasket.restcontrollers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formationSopraSteria.projetBasket.entities.Compte;
import formationSopraSteria.projetBasket.entities.jsonviews.JsonViews;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthentificationRestController {

	@GetMapping("")
	@JsonView(JsonViews.Compte.class)
	public Compte authentification(@AuthenticationPrincipal Compte compte) {
		return compte;
	}
}
