package repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Equipe;

public class DaoEquipeJpaImpl implements DaoEquipe{

	@Override
	public void insert(Equipe obj) {
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
	public Equipe update(Equipe obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Equipe equipe = null;
		tx.begin();
		try {
			equipe = em.merge(obj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
		return equipe;
	}

	@Override
	public void delete(Equipe obj) {
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
			em.remove(em.find(Equipe.class, key));
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}

	@Override
	public Equipe findByKey(Integer key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Equipe equipes = em.find(Equipe.class, key);
		em.close();
		return equipes;
	}

	@Override
	public List<Equipe> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Equipe> query = em.createQuery("from Equipe", Equipe.class);
		List<Equipe> equipes = query.getResultList();
		em.close();
		return equipes;
	}

}
