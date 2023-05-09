package nomdepackage;

import entities.Joueur;
import entities.Poste;
import entities.Statut;
import repositoriesByHand.DaoJoueur;
import repositoriesByHand.JpaContext;

public class AppTest {
	public static void main(String[] args) {

		JpaContext.getEntityManagerFactory();

		JpaContext.destroy();
	}
}
