package com.Hospital;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PatientDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	public void savePatient(Patient t) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(t);
		et.commit();
		
		em.close();
	}
	
	public Patient findPatient(int id) {
		EntityManager em = emf.createEntityManager();
		
		Patient p = em.find(Patient.class, id);
		
		if(p!=null) {
			p.getId();
		}
		
		em.close();
		return p;
	}
	
	public void updatePatient(Patient p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Patient p1 = em.find(Patient.class, p.getId());
		
		if(p1!=null) {
			p1.setName(p.getName());
		}
		
		et.commit();
		em.close();
	}
	
	public void deletePatient(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Patient p = em.find(Patient.class, id);
		
		if(p!=null) {
			em.remove(p);
		}
		
		et.commit();
		
		em.close();
		
	}
}
