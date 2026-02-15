package com.Hospital;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DoctorDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	public void saveDoctor(Doctor d) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(d);
		
		et.commit();
		
		em.close();
	}
	
	public Doctor findDoctor(int id) {
		EntityManager em = emf.createEntityManager();
		
		Doctor d = em.find(Doctor.class, id);
		
		if(d!=null) {
			d.getName();
		}
		em.close();
		return d;
	}
	
}
