package repositoriesByHand;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Joueur;

class DaoJoueurImpl implements DaoJoueur{

	@Override
	public void insert(Joueur obj) {
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
	public Joueur update(Joueur obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Joueur joueur = null;
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
	public void delete(Joueur obj) {
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
			em.remove(em.find(Joueur.class, key));
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}

	@Override
	public Joueur findByKey(Integer key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Joueur joueurs = em.find(Joueur.class, key);
		em.close();
		return joueurs;
	}

	@Override
	public List<Joueur> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Joueur> query = em.createQuery("from Joueur",Joueur.class);
		List<Joueur> joueurs = query.getResultList();
		em.close();
		return joueurs;
	}
	
}
