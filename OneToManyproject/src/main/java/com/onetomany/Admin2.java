package com.onetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Admin2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		String sqldeletecs = "delete from college_Student_onetomany where  st_s_id = ?1";
		String sqldeletes = "delete from student_onetomany where s_id = ?1";
		
		Query delete_college_student = em.createNativeQuery(sqldeletecs);
		
		Query delete_student = em.createNativeQuery(sqldeletes);
		
		
		delete_college_student.setParameter(1, 101);
		
		delete_student.setParameter(1, 101);
		
		et.begin();
		delete_college_student.executeUpdate();
		delete_student.executeUpdate();
		et.commit();

	}

}
