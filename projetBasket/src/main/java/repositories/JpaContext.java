package repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaContext {

	private static EntityManagerFactory entityManagerFactory = null;
	private static DaoJoueur daoJoueur = new DaoJoueurImpl();

	public static DaoJoueur getDaoJoueur() {
		return daoJoueur;
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("projetBasket");
		}
		return entityManagerFactory;
	}

	public static void destroy() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
			entityManagerFactory = null;
		}
	}
}
