package com.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SQLQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		// display all details
		String sql = "select * from product";
		
		Query query = em.createNativeQuery(sql);
		
		List<product> list = query.getResultList();
		
		System.out.println(list);
		
		
		// update the price if it is 10 update to 15
		
		String sql1 = "Update product set price=?1 where price=?2";
		
		et.begin();
		
		Query query1 = em.createNativeQuery(sql1);
		query1.setParameter(1, 15.0);
		query1.setParameter(2, 10.0);
		
		query1.executeUpdate();
		
		et.commit();
		
		
		
		
		
	}

}
