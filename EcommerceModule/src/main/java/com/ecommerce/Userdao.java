package com.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Userdao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	public void saveuser(User u) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(u);
		et.commit();
		
		em.close();
	}
	
	public User finduser(long id) {
		EntityManager em = emf.createEntityManager();
		
		User u = em.find(User.class,id);
		
		if(u.getPo()!=null) {
			u.getP().getId();
			u.getPo().size();
		}
		
		em.close();
		return u;
	}
	public void deleteuser(long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		User u = em.find(User.class, id);
		
		if(u!=null) {
			em.remove(u);
		}
		et.commit();
		em.close();
	}
	public void updateUser(User u) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		User u1 = em.find(User.class, u.getId());
		
		if(u1!=null) {
			u1.setName(u.getName());
		}
		
		//can also do with query
		
//		String sql = "update User u u.setName=?1 where u.id=?2";
//		
//		Query q1 = em.createQuery(sql);
//		
//		q1.setParameter(1, "Mohan");
//		q1.setParameter(2, u.getId());
//		
//		q1.executeUpdate();
		
		
		// can also be done using merge
//		em.merge(u);
		et.commit();
		em.close();
	}
}
