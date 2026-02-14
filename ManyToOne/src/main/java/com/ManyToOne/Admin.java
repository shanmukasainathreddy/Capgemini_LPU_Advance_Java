package com.ManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Admin {

	public void insertdata() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	et.begin();
	Department d = new Department();
	d.setD_id(1);
	d.setName("Development");
	d.setManagername("Dingiluu");
	d.setNoofemp(2);
	
	em.persist(d);

	
	Employeemn e = new Employeemn();
	e.setEmp_id(101);
	e.setName("Dinga");
	e.setSalary(30000.0);
	e.setDesignation("Clerk");
	e.setD(d);	
	
	
	Employeemn e1 = new Employeemn();
	e1.setEmp_id(102);
	e1.setName("Tingaa");
	e1.setSalary(60000.0);
	e1.setDesignation("SDE");
	e1.setD(d);
	
	
	
	
	
	em.persist(e);
	em.persist(e1);
	et.commit();
	
	}
	
	
	
}
