package com.onetomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College {
	@Id
	private int college_id;
	private String name;
	private String location;
	private String pincode;
	
	@OneToMany
	private List<Student_Onetomany> st;


	public int getId() {
		return college_id;
	}


	public void setId(int college_id) {
		this.college_id = college_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public List<Student_Onetomany> getSt() {
		return st;
	}


	public void setSt(List<Student_Onetomany> st) {
		this.st = st;
	}


	@Override
	public String toString() {
		return "College [id=" + college_id + ", name=" + name + ", location=" + location + ", pincode=" + pincode + ", st=" + st
				+ "]";
	}

	
}
