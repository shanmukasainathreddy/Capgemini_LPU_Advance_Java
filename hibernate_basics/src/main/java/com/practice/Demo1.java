package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

// retrival of data
public class Demo1 {
	public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");  
	
	//to insert into tables
	EntityManager em = emf.createEntityManager();
	
	
	//entity transaction object -> SQL
	
	EntityTransaction et = em.getTransaction();
	
	Student student =  em.find(Student.class,101);
	System.out.println(student.getId() + " " + student.getName() + " " + student.getPercentage());
}
}