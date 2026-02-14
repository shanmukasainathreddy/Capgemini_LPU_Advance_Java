package com.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Admin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Student_Onetomany sm = new Student_Onetomany();
		sm.setId(101);
		sm.setName("Dingaa");
		sm.setBranch("CSE");
		
		Student_Onetomany sm2 = new Student_Onetomany();
		sm2.setId(102);
		sm2.setName("Tingaa");
		sm2.setBranch("ECE");
		
		
		College c = new College();
		c.setId(1);
		c.setName("LPU");
		c.setLocation("Punjab");
		c.setPincode("144411");
		
		College c2 = new College();
		c2.setId(2);
		c2.setName("MBU");
		c2.setLocation("Tirupati");
		c2.setPincode("518002");
//		c.setSt(null);
		
		List<Student_Onetomany> list = new ArrayList<>();
		list.add(sm);
		list.add(sm2);
		c.setSt(list);
		
		et.begin();
		em.persist(sm);
		em.persist(sm2);
		em.persist(c);
		em.persist(c2);
		et.commit();
		
		
		
		
		
		
	}

}
