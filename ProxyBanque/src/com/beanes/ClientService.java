package com.beanes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClientService {
	
	private static EntityManagerFactory factory;
	private static EntityManager em;	
	
	public Client LoginClient(String email, String password) {
		Query query = em.createQuery("Select c from Client c where c.clt_email = :email and c.clt_mot_de_passe = :password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		try {
			Client c = (Client) query.getSingleResult();
			return c;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void addClient(Client client) {
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		em.persist(client);
		entityTransaction.commit();
	}
	
	public void removeCompte(Client client) {
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		em.remove(client);
		entityTransaction.commit();
	}
	
	public void updateCompte(Client client) {
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		em.merge(client);
		entityTransaction.commit();
	}
	
	public List<Client> Clients(){
		Query query = em.createQuery("Select c from Client c");
		
		try {
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public Client getAdminClient() {
		Query query = em.createQuery("Select c from Client c where c.clt_profile = 'Admin'");
		
		try {
			Client c = (Client) query.getSingleResult();
			return c;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public ClientService() {
		factory = Persistence.createEntityManagerFactory("banque_db");
		em = factory.createEntityManager();
		// TODO Auto-generated constructor stub
	}
}
