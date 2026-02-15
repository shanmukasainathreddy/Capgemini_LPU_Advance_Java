package com.Hospital;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor {
	@Id
	int id;
	String name;
	String Specialization;
	
	@OneToMany
	List<Appointment> list  = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return Specialization;
	}

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

	public List<Appointment> getList() {
		return list;
	}

	public void setList(List<Appointment> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", Specialization=" + Specialization + ", list=" + list + "]";
	}
	
	
	
}
