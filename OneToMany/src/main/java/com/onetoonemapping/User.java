package com.onetoonemapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class User {

	public static void main(String[] args) {
		
		
		findbyCarid();
		deleteByEngineId();
		
		
		
	}
		
		public static void findbyCarid() {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction et = em.getTransaction();
			
			Car c = em.find(Car.class, 1);
			System.out.println(c);
			
			//it will give engine object 
			System.out.println(c.getEngine());
			
		}
		
		
		public static void deleteByEngineId() {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction et = em.getTransaction();
			
			Engine e = em.find(Engine.class, 101);
			
			String jpql1 = "update Car set engine_id = null where engine_id = ?1";
			String jpql2 = "delete from Engine where id = ?1";
			
			
			Query updatequery = em.createQuery(jpql1);
			updatequery.setParameter(1, 101);
			
			Query deletequery = em.createQuery(jpql2);
			deletequery.setParameter(1, 101);
			
			et.begin();
			updatequery.executeUpdate();
			deletequery.executeUpdate();
			
//			em.remove(e);
			et.commit();
			
		}
		
		public static void insertCarandEngine() {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Engine e = new Engine();
		e.setId(101);
		e.setType("V8");
		e.setFueltype("Petrol");
		e.setMileage(12.5);
		e.setCc("3000");
		
		
		Car c = new Car();
		c.setId(1);
		c.setBrand("BMW");
		c.setModel("M3");
		c.setModelYear("2023");
		c.setPrice(8000000);
		
		c.setEngine(e);
		
		et.begin();
		em.persist(e);
		em.persist(c);
		et.commit();
		}
	}
