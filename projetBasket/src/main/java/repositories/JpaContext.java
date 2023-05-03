package repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaContext {

	private static EntityManagerFactory entityManagerFactory = null;
	private static DaoPersonnel daoPersonnel = new DaoPersonnelJpaImpl();
	private static DaoReservation daoReservation = new DaoReservationJpaImpl();

	public static DaoPersonnel getDaoPersonnel() {
		return daoPersonnel;
	}
	public static DaoReservation getDaoReservation() {
		return daoReservation;
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
