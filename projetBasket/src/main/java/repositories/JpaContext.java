package repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaContext {

	private static EntityManagerFactory entityManagerFactory = null;
	private static DaoAchat daoAchat = new DaoAchatJpaImpl();

	public static DaoAchat getDaoAchat() {
		return daoAchat;
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("eshop_olivier");
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
