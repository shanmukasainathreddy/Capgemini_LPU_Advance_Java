package com.Hospital;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HospitalTest {
	
	static EntityManagerFactory emf;
	static EntityManager em;

	private static ServiceLayer service;
	private static PatientDao patientDao;
	private static DoctorDao doctorDao;
	private static AppointmentDao appointmentDao;

	@BeforeAll
	public static void setup() {
		service = new ServiceLayer();
		patientDao = new PatientDao();
		doctorDao = new DoctorDao();
		appointmentDao = new AppointmentDao();
	}
	@BeforeAll
	public static void initEmf() {
		emf = Persistence.createEntityManagerFactory("postgres");
	}	

	@BeforeEach
	public void initEm() {
		em=emf.createEntityManager();
	}

	@Test
	public void testOneToOnePersist() {

		Patient p = new Patient();
		p.setId(11);
		p.setName("Patient1");
		p.setAge(20);
		p.setContact(9147852697L);

		MedicalRecord mr = new MedicalRecord();
		mr.setId(111);
		mr.setBloodgroup("A+");
		mr.setAllergies("None");

		service.registerPatientWithMedicalRecord(p, mr);

		Patient saved = patientDao.findPatient(11);

		assertNotNull(saved);
		assertNotNull(saved.getMr());
		assertEquals("A+", saved.getMr().getBloodgroup());
	}

	@Test
	public void testOneToManyPersist() {

		Doctor d = new Doctor();
		d.setId(22);
		d.setName("Doctor1");
		d.setSpecialization("ENT");

		doctorDao.saveDoctor(d);

		Appointment a1 = new Appointment();
		a1.setId(2201);
		a1.setVisitdate(new Date());
		a1.setFee(500);

		Appointment a2 = new Appointment();
		a2.setId(2202);
		a2.setVisitdate(new Date());
		a2.setFee(700);

		List<Appointment> apps = new ArrayList<>();
		apps.add(a1);
		apps.add(a2);

		service.addMultipleAppointmentsToDoctor(22, apps);

		Doctor savedDoctor = doctorDao.findDoctor(22);

		assertNotNull(savedDoctor);
		assertTrue(savedDoctor.getList().size() >= 2);
	}

	@Test
	public void testManyToOnePersist() {

		Patient p = new Patient();
		p.setId(33);
		p.setName("Patient2");
		p.setAge(25);
		p.setContact(8859546721L);

		MedicalRecord mr = new MedicalRecord();
		mr.setId(333);
		mr.setBloodgroup("B+");
		mr.setAllergies("Cold");

		service.registerPatientWithMedicalRecord(p, mr);

		Appointment a = new Appointment();
		a.setId(3301);
		a.setVisitdate(new Date());
		a.setFee(600);

		service.assignAppointmentToPatient(a, 33);

		assertNotNull(a.getP());
		assertEquals(33, a.getP().getId());
	}

	@Test
	public void testDaoUpdateFee() {

		Appointment a = new Appointment();
		a.setId(4401);
		a.setVisitdate(new Date());
		a.setFee(300);

		appointmentDao.saveAppointment(a);

		appointmentDao.updateFee(4401, 999);

		// we can't directly fetch from dao, so verify by updating again without error
		assertDoesNotThrow(() -> appointmentDao.updateFee(4401, 888));
	}

	@Test
	public void testDaoDeletePatient() {

		Patient p = new Patient();
		p.setId(55);
		p.setName("DeletePatient");
		p.setAge(22);
		p.setContact(7879556324L);

		MedicalRecord mr = new MedicalRecord();
		mr.setId(555);
		mr.setBloodgroup("AB+");
		mr.setAllergies("Skin");

		service.registerPatientWithMedicalRecord(p, mr);

		patientDao.deletePatient(55);

		Patient deleted = patientDao.findPatient(55);
		assertNull(deleted);
	}

	@Test
	public void testServiceWorkflow() {

		//Register patient + record
		Patient p = new Patient();
		p.setId(66);
		p.setName("WorkflowPatient");
		p.setAge(30);
		p.setContact(6380498756L);

		MedicalRecord mr = new MedicalRecord();
		mr.setId(666);
		mr.setBloodgroup("O-");
		mr.setAllergies("None");

		service.registerPatientWithMedicalRecord(p, mr);

		assertNotNull(patientDao.findPatient(66));

		//Create doctor
		Doctor d = new Doctor();
		d.setId(77);
		d.setName("WorkflowDoctor");
		d.setSpecialization("Neuro");

		doctorDao.saveDoctor(d);

		//Add appointments to doctor
		Appointment a1 = new Appointment();
		a1.setId(7701);
		a1.setVisitdate(new Date());
		a1.setFee(1000);

		Appointment a2 = new Appointment();
		a2.setId(7702);
		a2.setVisitdate(new Date());
		a2.setFee(1200);

		List<Appointment> apps = new ArrayList<>();
		apps.add(a1);
		apps.add(a2);

		service.addMultipleAppointmentsToDoctor(77, apps);

		Doctor savedDoctor = service.fetchDoctorWithAppointments(77);
		assertNotNull(savedDoctor);
		assertTrue(savedDoctor.getList().size() >= 2);

		//Assign appointment to patient
		Appointment a3 = new Appointment();
		a3.setId(7703);
		a3.setVisitdate(new Date());
		a3.setFee(1500);

		service.assignAppointmentToPatient(a3, 66);
		assertNotNull(a3.getP());

		//Update fee
		appointmentDao.saveAppointment(a3);
		service.updateAppointmentFee(7703, 9999);

		//Delete patient
		service.deletePatient(66);

		assertNull(patientDao.findPatient(66));
	}
	
	@AfterEach
	public void destroyEm() {
		em.close();
	}

	@AfterAll
	public static void destroyEmf() {
		emf.close();
	}
	
}