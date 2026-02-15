package com.Hospital;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Patient {
	@Id
	int id;
	String name;
	int age;
	long contact;

	@OneToOne
	MedicalRecord mr;
	
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public MedicalRecord getMr() {
		return mr;
	}

	public void setMr(MedicalRecord mr) {
		this.mr = mr;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", contact=" + contact + ", mr=" + mr + "]";
	}
}
