package repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaContext {

	private static EntityManagerFactory entityManagerFactory = null;
	private static DaoEquipe daoEquipe = new DaoEquipeJpaImpl();
	private static DaoStade doaStade = new DaoStadeJpaImpl();
	private static DaoBasketMatch daoBasketMatch = new DaoBasketMatchJpaImpl();
	private static DaoArbitre daoArbitre = new DaoArbitreJpaImpl();
	private static DaoCompte daoCompte = new DaoCompteJpaImpl();
	
	
	


	public static DaoEquipe getDaoEquipe() {
		return daoEquipe;
	}
	
	public static DaoStade getDaoStade() {
		return doaStade;
	}
	
	
	public static DaoBasketMatch getDaoBasketMatch () {
		return daoBasketMatch;
	}
	
	

	public static DaoArbitre getDaoArbitre() {
		return daoArbitre;
	}
	

	public static DaoCompte getDaoCompte () {
		return daoCompte;
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
