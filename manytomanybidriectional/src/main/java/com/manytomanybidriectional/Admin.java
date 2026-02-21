package com.manytomanybidriectional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Admin {
	
	public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	EntityManager em = emf.createEntityManager();
	

	EntityTransaction et = em.getTransaction();
	
	Student s = new Student();
	s.setId(1);
	s.setName("Miller");
	s.setBranch("CSE");
	
	Student s1 = new Student();
	s1.setId(2);
	s1.setName("Virat");
	s1.setBranch("CSE");
	
	Subject su = new Subject();
	su.setId(100);
	su.setName("Micro-Processor");
	
	Subject su1 = new Subject();
	su1.setId(101);
	su1.setName("Machine Learning");
	
	
	Subject su2 = new Subject(); 
	su2.setId(102);
	su2.setName("Software Engineering");
	

	List<Student> stu = List.of(s,s1);
	List<Subject> sub = List.of(su,su1,su2);
	
	//student -> subject
	s.setSubject(sub);
	
	s1.setSubject(sub);
	
	//subject -> student
	
	su.setStudent(stu);
	su1.setStudent(stu);
	su2.setStudent(stu);
	
	et.begin();
	em.persist(s1);
	em.persist(s);
	et.commit();
	
	}
}
