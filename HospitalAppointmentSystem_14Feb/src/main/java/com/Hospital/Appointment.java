package com.Hospital;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
	@Id
	int id;
	Date visitdate;
	double fee;
	
	 @ManyToOne
	 Patient p;
	 
	 @ManyToOne
	 Doctor d;

	 public Doctor getD() {
		return d;
	}

	 public void setD(Doctor d) {
		 this.d = d;
	 }

	 public int getId() {
		 return id;
	 }

	 public void setId(int id) {
		 this.id = id;
	 }

	 public Date getVisitdate() {
		 return visitdate;
	 }

	 public void setVisitdate(Date visitdate) {
		 this.visitdate = visitdate;
	 }

	 public double getFee() {
		 return fee;
	 }

	 public void setFee(double fee) {
		 this.fee = fee;
	 }

	 public Patient getP() {
		 return p;
	 }

	 public void setP(Patient p) {
		 this.p = p;
	 }

	 @Override
	 public String toString() {
		return "Appointment [id=" + id + ", visitdate=" + visitdate + ", fee=" + fee + ", p=" + p + "]";
	 }
	 
	 
	
}
