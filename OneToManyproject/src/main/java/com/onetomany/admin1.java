package com.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class admin1 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		College c = em.find(College.class, 2);
		
		List<Student_Onetomany> list = c.getSt();
		
		Student_Onetomany st= new Student_Onetomany();
		st.setId(103);
		st.setName("Chengaa");
		st.setBranch("Civil");
		
		list.add(st);
		
		c.setSt(list);
		
		et.begin();
		em.persist(st);
		et.commit();
		
		

	}
	
}
