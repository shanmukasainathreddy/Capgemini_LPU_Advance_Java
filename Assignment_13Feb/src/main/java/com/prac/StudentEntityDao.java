package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentEntityDao {

		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		
		
		//save Aadharcard
		public void saveAadharCard(AdharCardEntity ac) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			em.persist(ac);
			et.commit();
			em.close();
			System.out.println("Adhar Card saved");
		}
		
		//save HostelRoom
		public void saveHostelRoom(HostelRoomEntity hr) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			em.persist(hr);
			et.commit();
			em.close();
			System.out.println("Hostel Room saved");
		}
		
		//save Student
		public void saveStudent(StudentEntity se) {
			
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			em.persist(se);
			et.commit();
			em.close();
			System.out.println("Student data saved");
		}
		
		//fecting student and details
		
		public StudentEntity fetchstudentdetails(int id){
			EntityManager em = emf.createEntityManager();
			
			StudentEntity se = em.find(StudentEntity.class, id);
			
			if(se!=null) {
				se.getAc().getAadharId();
				se.getHostelRo().getRoomid();
			}
			em.close();
			return se;			
		}
		
		//delete student (Aadhar remains)
		public  void deletestudent(int id) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			StudentEntity se = em.find(StudentEntity.class,id);
			if(se!=null) {
				em.remove(se);
			}
			et.commit();
			em.close();
		}

		

}
