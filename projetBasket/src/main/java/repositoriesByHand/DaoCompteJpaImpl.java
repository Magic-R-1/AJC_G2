package repositoriesByHand;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Compte;

public class DaoCompteJpaImpl implements DaoCompte{
	@Override
	public void insert(Compte obj) {
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
	public Compte update(Compte obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Compte compte = null;
		tx.begin();
		try {
			compte = em.merge(obj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
		return compte;
	}

	@Override
	public void delete(Compte obj) {
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
	public void deleteByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.remove(em.find(Compte.class, key));
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}

	@Override
	public Compte findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Compte compte = em.find(Compte.class, key);
		em.close();
		return compte;
	}

	@Override
	public List<Compte> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Compte> query = em.createQuery("from Compte",Compte.class);
		List<Compte> comptes = query.getResultList();
		em.close();
		return comptes;
	}

}