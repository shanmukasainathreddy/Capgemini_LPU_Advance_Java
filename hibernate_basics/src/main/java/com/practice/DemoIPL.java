package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DemoIPL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		//entity transaction object -> SQL
		
		EntityTransaction et = em.getTransaction();
		IPL ipl = new IPL();
		ipl.setTeam_id(101);
		ipl.setTeam_name("Royal Challengers Banglore");
		ipl.setMatches(18);
		ipl.setWin(16);
		ipl.setLose(2);
		ipl.setNet_run_rate(3.45);
		
		et.begin();
		em.persist(ipl);
		et.commit();
		
		em.close();
	}

}
