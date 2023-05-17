package projetBasket.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

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
	
}
