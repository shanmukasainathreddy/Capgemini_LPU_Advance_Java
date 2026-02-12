package com.studentdetails;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class studentdao {

		// TODO Auto-generated method stub
		static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		static EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		
		//insert students
		public void savestudent(student s) {
			et.begin();
			em.persist(s);
			et.commit();
			System.out.println("Student Data saved");
		}
		
		//find students by id
		public student findbyid(int id) {
			student s = em.find(student.class, id);
			return s;
		}
		
		// listing students data from using list
		public List<student> findallstudents() {
			TypedQuery<student> query = em.createQuery("select s from student s" , student.class);
			List<student> list = query.getResultList();
			return list;
			
		}
		
		// updating student name by id
		public void updatestudent(int id,String newName) {
			student s = em.find(student.class, id);
			
			if(s!=null) {
				et.begin();
				s.setSname(newName);
				et.commit();
				System.out.println("Student updated");
			}
			else
				System.out.println("Student not found");
		}
		
		
		//delete student by using id
		public void deletestudent(int id) {
			student s = em.find(student.class, id);
			
			if(s!=null) {
				et.begin();
				em.remove(s);
				et.commit();
				System.out.println("Student deleted");
			}else {
				System.out.println("Student not found");
			}
		}
		
		//close emf
		public void close() {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}

}
