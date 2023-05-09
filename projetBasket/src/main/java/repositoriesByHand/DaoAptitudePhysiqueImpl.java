package repositoriesByHand;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.AptitudePhysique;

class DaoAptitudePhysiqueImpl implements DaoAptitudePhysique {


	@Override
	public void insert(AptitudePhysique obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(obj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}
	
	@Override
	public AptitudePhysique update(AptitudePhysique obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		AptitudePhysique joueur = null;
		tx.begin();
		try {
			joueur = em.merge(obj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
		return joueur;
	}
	
	@Override
	public void delete(AptitudePhysique obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}
	
	@Override
	public void deleteByKey(Integer key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.remove(em.find(AptitudePhysique.class, key));
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}

	@Override
	public AptitudePhysique findByKey(Integer key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		AptitudePhysique aptitudePhysiques = em.find(AptitudePhysique.class, key);
		em.close();
		return aptitudePhysiques;
	}

	@Override
	public List<AptitudePhysique> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<AptitudePhysique> query = em.createQuery("from AptitudePhysique",AptitudePhysique.class);
		List<AptitudePhysique> aptitudePhysiques = query.getResultList();
		em.close();
		return aptitudePhysiques;
	}
	
	
}
