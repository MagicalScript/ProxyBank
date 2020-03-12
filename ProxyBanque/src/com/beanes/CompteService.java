package com.beanes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CompteService {
	
	private static EntityManagerFactory factory;
	private static EntityManager em;	
	
	public void addCompte(Compte compte) {
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		em.persist(compte);
		entityTransaction.commit();
	}
	
	public void removeCompte(Compte compte) {
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		em.remove(compte);
		entityTransaction.commit();
	}
	
	public void updateCompte(Compte compte) {
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		em.merge(compte);
		entityTransaction.commit();
	}
	
	public List<Compte> Comptes(Client client){
		Query query = em.createQuery("Select cpt from Compte cpt where cpt.cpt_client = :clientid");
		query.setParameter("clientid",client);
		try {
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public CompteService() {
		factory = Persistence.createEntityManagerFactory("banque_db");
		em = factory.createEntityManager();
		// TODO Auto-generated constructor stub
	}

}
