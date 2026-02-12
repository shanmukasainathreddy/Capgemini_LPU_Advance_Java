package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


//to delete record by using id pk
public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		

		//to insert into tables
		EntityManager em = emf.createEntityManager();
		
		
		//entity transaction object -> SQL
		
		EntityTransaction et = em.getTransaction();
		
		Student student =  em.find(Student.class,101);
		
		et.begin();
		em.remove(student);
		et.commit();
		
		emf.close();
	}

}
