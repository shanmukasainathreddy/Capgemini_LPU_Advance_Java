package com.ManyToOne;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	@Id
	private int d_id;
	private String name;
	private String managername;
	private int noofemp;
	
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public int getNoofemp() {
		return noofemp;
	}
	public void setNoofemp(int noofemp) {
		this.noofemp = noofemp;
	}
	@Override
	public String toString() {
		return "Department [d_id=" + d_id + ", name=" + name + ", managername=" + managername + ", noofemp=" + noofemp
				+ "]";
	}
	
	
}
