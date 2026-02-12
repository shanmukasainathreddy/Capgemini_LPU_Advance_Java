package com.practice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPQLDemp4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
				

				//to insert into tables
				EntityManager em = emf.createEntityManager();
				
				
				//entity transaction object -> SQL
				
				EntityTransaction et = em.getTransaction();
				
				String jpql = "select s from Student s";
				
				Query query = em.createQuery(jpql); // convert string->query
				
				List<Student> list = query.getResultList() ;
				
				list.forEach(System.out::println);
	}

}
