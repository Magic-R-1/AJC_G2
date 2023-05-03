package repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaContext {

	private static EntityManagerFactory entityManagerFactory = null;
	private static DaoEquipe daoEquipe = new DaoEquipeJpaImpl();
	private static DaoStade doaStade = new DaoStadeJpaImpl();
	
	


	public static DaoEquipe getDaoEquipe() {
		return daoEquipe;
	}
	
	public static DaoStade getDaoStade() {
		return doaStade;
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("projetbasket");
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
