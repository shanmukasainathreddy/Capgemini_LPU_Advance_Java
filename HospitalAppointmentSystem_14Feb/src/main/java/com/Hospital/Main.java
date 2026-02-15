package com.Hospital;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		ServiceLayer service = new ServiceLayer();

		// Register Patient with Medical Record
		Patient p = new Patient();
		p.setId(1);
		p.setName("Shannu");
		p.setAge(21);
		p.setContact(9876543210L);

		MedicalRecord mr = new MedicalRecord();
		mr.setId(101);
		mr.setBloodgroup("O+");
		mr.setAllergies("Dust");

		service.registerPatientWithMedicalRecord(p, mr);

		// Create Doctor
		Doctor d = new Doctor();
		d.setId(10);
		d.setName("Dr. Reddy");
		d.setSpecialization("Cardiology");

		DoctorDao doctorDao = new DoctorDao();
		doctorDao.saveDoctor(d);

		// Add multiple appointments to doctor
		Appointment a1 = new Appointment();
		a1.setId(1001);
		a1.setVisitdate(new Date());
		a1.setFee(500);

		Appointment a2 = new Appointment();
		a2.setId(1002);
		a2.setVisitdate(new Date());
		a2.setFee(700);

		List<Appointment> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);

		service.addMultipleAppointmentsToDoctor(10, list);

		// Assign appointment to patient
		Appointment a3 = new Appointment();
		a3.setId(2001);
		a3.setVisitdate(new Date());
		a3.setFee(600);

		service.assignAppointmentToPatient(a3, 1);

		// Update appointment fee
		service.updateAppointmentFee(2001, 999);

		// Fetch doctor with appointments
		Doctor doc = service.fetchDoctorWithAppointments(10);
		System.out.println(doc);

		// Delete patient
		service.deletePatient(1);
		System.out.println("Patient Deleted Successfully");
	}
}