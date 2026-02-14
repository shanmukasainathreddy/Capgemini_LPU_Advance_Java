package com.mockitoproject;

//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;

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
