package com.Hospital;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicalRecord {
	@Id
	int id;
	String bloodgroup;
	String allergies;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	
	@Override
	public String toString() {
		return "MedicalRecord [id=" + id + ", bloodgroup=" + bloodgroup + ", allergies=" + allergies + "]";
	}
	
}
