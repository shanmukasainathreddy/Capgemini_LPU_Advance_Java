package com.prac;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class person {
	@Id
	int id;
	String Name;
	String DOB;
	String Address;
	int pincode;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String Name) {
		this.Name=Name;
	}
	
	public void setDOB(String DOB) {
		this.DOB=DOB;
	}
	
	public void setAddress(String Address) {
		this.Address = Address;
	}
	
	public void setPincode(int pincode) {
		this.pincode=pincode;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getDOB() {
		return DOB;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public int getPincode() {
		return pincode;
	}
}
