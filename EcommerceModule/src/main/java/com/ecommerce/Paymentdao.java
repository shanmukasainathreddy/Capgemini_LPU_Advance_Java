package com.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Paymentdao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	public static void savepayment(Payment p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(p);
		et.commit();
		
		em.close();
	}
	
	public Payment findpayment(long id) {
		EntityManager em = emf.createEntityManager();
		
		Payment p = em.find(Payment.class, id);
		
		if(p!=null) {
			p.getMode();
		}
		
		em.close();

		return p;		
	}
}
