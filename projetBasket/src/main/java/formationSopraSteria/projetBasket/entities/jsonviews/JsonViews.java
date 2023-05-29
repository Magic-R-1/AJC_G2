package formationSopraSteria.projetBasket.entities.jsonviews;

public class JsonViews {
	
	public class Base {
	}
	
	public class Joueur extends Base {
	}
	
	public class JoueurWithEquipe extends Joueur {
	}
	
	public class Arbitre extends Base {
	}

	public class Confrontation extends Base {
	}
	
	public class Stade extends Base {
	}
	public class StadeWithEquipe extends Stade {
	}
	
	public class Equipe extends Base {
	}
	public class EquipeWithConfrontation extends Equipe {
	}

	public class EquipeWithStade extends Equipe {
	}
	public class EquipeWithPersonnel extends Equipe {
	}

	public class EquipeWithCompte extends Equipe {
	}
	
	public class EquipeWithJoueur extends Equipe {
	}
	
	public class Compte extends Base {
	}
	
	public class Personnel extends Base {
	}
    
	public class Reservation extends Base {
	}

}