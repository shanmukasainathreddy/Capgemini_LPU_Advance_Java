package com.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres"); 
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		//display which product is higher than 100
		
		String jpql = "select p from product p where p.price>=?1";
		
		Query query = em.createQuery(jpql);
		query.setParameter(1, 100.0);
		
		List<product> list = query.getResultList();
		
		list.forEach(i->System.out.println(i.getName()));
		
		
		// display all detail by name
		String jpql2 = "select p from product p  where p.name = ?1";
		
		Query query1 = em.createQuery(jpql2);
		
		query1.setParameter(1, "Pencil");
		
		List<product> list1 = query1.getResultList();
		   
		for(product p : list1) {
			System.out.println(p);
		}
		
		
		//display all details of product price > 15 and quantity >=20
		
		String jpql3 = "select p from product p  where p.price >= ?1 and p.Quantity >= ?2";
		
		Query query2 = em.createQuery(jpql3);
		
		query2.setParameter(1, 15.0);
		query2.setParameter(2, 20);
		
		List<product> list2 = query2.getResultList();
		
		
		for(product p : list2) {
			System.out.println(p);
		}
		
		
		// update 
		String jpql4 = "Update product p set p.price = ?1 where p.price=?2";
		
		et.begin();
		Query query3 = em.createQuery(jpql4);
		
		query3.setParameter(1, 80.0);
		query3.setParameter(2, 100.0);
		
		query3.executeUpdate();
		
		et.commit();
		
		// variable parameter using 
				String jpql5 = "select p from product p where p.price = :price";
				
				Query query4 = em.createQuery(jpql5);
				
				query4.setParameter("price", 15.0);
				
				List<product> list3 = query4.getResultList();
				
				list3.forEach(i->System.out.println(i.getName()));
				
				
	
				
				
		em.close();
		emf.close();
		
		

		
	}

}
