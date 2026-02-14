package com.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Orderdao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	public void saveorder(PurchaseOrder o) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(o);
		et.commit();
		
		em.close();
	}
	
	public PurchaseOrder findorder(long id) {
		EntityManager em = emf.createEntityManager();

		PurchaseOrder po = em.find(PurchaseOrder.class, id);
		
		if(po!=null) {
			po.getOrderdate();
		}
		
		em.close();
		return po;
		
	}
	
	public User findordersbyuser(long userid) {
		EntityManager em = emf.createEntityManager();
		
//		PurchaseOrder po = em.find(PurchaseOrder.class, userid);
//		
		User u = em.find(User.class, userid);
		if(u.getPo()!=null) {
			u.getPo().size();
		}
		
		em.close();
		return u;
		
	}
}
