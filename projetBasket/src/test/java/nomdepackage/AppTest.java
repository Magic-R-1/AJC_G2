package nomdepackage;

import entities.Joueur;
import entities.Poste;
import entities.Statut;
import repositories.DaoJoueur;
import repositories.JpaContext;

public class AppTest {
	public static void main(String[] args) {

		JpaContext.getEntityManagerFactory();

		JpaContext.destroy();
	}
}
