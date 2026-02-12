package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class persondao {

		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager() ;
		
		EntityTransaction et = em.getTransaction();

		
		public void insertdata(person p) {
			et.begin();
			em.persist(p);
			et.commit();
		}
		
		public person findById(int id) {
			person p = em.find(person.class, id);
			return p;
		}
		
		public boolean deletedata(int id) {
			person p = findById(id);
			
			if(p!=null) {
				et.begin();
				em.remove(p);
				et.commit();
				return true;
			}
			else return false;
		}
		
		public void close() {
			if(em!=null)em.close();
			if(emf!=null) emf.close();
		}


public static void main(String[] args) {
	// TODO Auto-generated method stub
	persondao dao = new persondao();
	 person p = new person();
	 
	 p.setId(18);
	 p.setName("Virat");
	 
	 dao.insertdata(p);
	 
}
}
