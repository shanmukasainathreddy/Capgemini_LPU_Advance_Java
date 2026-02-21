package com.CRM;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SalesEmployee {
	@Id
	private long id;
	private String name;
	private String department;
	
	@ManyToOne
	private Address ad;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Address getAd() {
		return ad;
	}

	public void setAd(Address ad) {
		this.ad = ad;
	}

	
	@Override
	public String toString() {
		return "SalesEmployee [id=" + id + ", name=" + name + ", department=" + department + ", ad=" + ad + "]";
	}
	
	
	
}
