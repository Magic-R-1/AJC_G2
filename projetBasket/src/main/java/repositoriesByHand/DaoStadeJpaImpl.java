package repositoriesByHand;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Stade;

public class DaoStadeJpaImpl implements DaoStade{

	@Override
	public void insert(Stade obj) {
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
	public Stade update(Stade obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Stade stade = null;
		tx.begin();
		try {
			stade = em.merge(obj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
		return stade;
	}

	@Override
	public void delete(Stade obj) {
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
			em.remove(em.find(Stade.class, key));
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}

	@Override
	public Stade findByKey(Integer key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Stade stades = em.find(Stade.class, key);
		em.close();
		return stades;
	}

	@Override
	public List<Stade> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Stade> query = em.createQuery("from Stade", Stade.class);
		List<Stade> stades = query.getResultList();
		em.close();
		return stades;
	}

}
