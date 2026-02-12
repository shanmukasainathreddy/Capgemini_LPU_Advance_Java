package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demoupdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		

		//to insert into tables
		EntityManager em = emf.createEntityManager();
		
		
		//entity transaction object -> SQL
		
		EntityTransaction et = em.getTransaction();
		
		Student student =  em.find(Student.class,101);
		
		if(student!=null) {
			student.setPercentage(99);
			et.begin();
			em.merge(student);
			et.commit();
			emf.close();
		}
	}

}
