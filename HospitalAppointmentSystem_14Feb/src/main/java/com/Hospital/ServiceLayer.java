package com.Hospital;

import java.util.List;

public class ServiceLayer {

	private PatientDao patientDao = new PatientDao();
	private DoctorDao doctorDao = new DoctorDao();
	private AppointmentDao appointmentDao = new AppointmentDao();

	//Register patient with medical record
	public void registerPatientWithMedicalRecord(Patient p, MedicalRecord mr) {
		p.setMr(mr);
		patientDao.savePatient(p);
	}

	// Add multiple appointments to doctor
	public void addMultipleAppointmentsToDoctor(int doctorId, List<Appointment> apps) {

		Doctor d = doctorDao.findDoctor(doctorId);

		if (d != null) {
			for (Appointment a : apps) {
				a.setD(d);    
				d.getList().add(a);
			}
			doctorDao.saveDoctor(d); 
		}
	}

	// Assign appointment to patient
	public void assignAppointmentToPatient(Appointment a, int patientId) {

		Patient p = patientDao.findPatient(patientId);

		if (p != null) {
			a.setP(p);
			appointmentDao.saveAppointment(a);
		}
	}

	// Update appointment fee
	public void updateAppointmentFee(int appointmentId, double newFee) {
		appointmentDao.updateFee(appointmentId, newFee);
	}

	//Fetch doctor with appointments
	public Doctor fetchDoctorWithAppointments(int doctorId) {
		return doctorDao.findDoctor(doctorId);
	}

	//Delete patient and verify behavior
	public void deletePatient(int patientId) {
		patientDao.deletePatient(patientId);
	}
}