package com.Hospital;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AppointmentDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	public void saveAppointment(Appointment ap) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(ap);
		et.commit();
		
		em.close();
	}
	
	public List<Appointment> findAppointmentByDoctor(int d_id) {
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select a from Appointment a where a.doctor.id = :did");
		q.setParameter("did", d_id);

		List<Appointment> list = q.getResultList();

		em.close();
		return list;
	}
	
	public void updateFee(int id,double newFee) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		
		Appointment ap = em.find(Appointment.class, id);
		if(ap!=null) {
			ap.setFee(newFee);
		}
				
		et.commit();
		
		em.close();

		
	}

}
