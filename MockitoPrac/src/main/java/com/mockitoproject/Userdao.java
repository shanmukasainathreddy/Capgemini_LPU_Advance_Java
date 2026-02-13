package com.mockitoproject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Userdao {

	//EntityManagerFactory
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	//EntityManager
	EntityManager em = emf.createEntityManager();
	
	
	public void insertUser() {
		
		//EntityTransaction
		EntityTransaction et = em.getTransaction();
		
		User u = new User();
		u.setId(102);
		u.setName("Dingiluu");
		u.setBalance(5000);
		
		et.begin();
		em.persist(u);
		et.commit();
	}
	
	public User findById(int id) {
		return em.find(User.class, 101);
	}
}
