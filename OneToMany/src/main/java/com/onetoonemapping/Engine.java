package com.onetoonemapping;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Engine {
	@Id
	private int id;
	private String type;
	private String fueltype;
	private double mileage;
	private int cc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFueltype() {
		return fueltype;
	}
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	
	@Override
	public String toString() {
		return "Engine [id=" + id + ", type=" + type + ", fueltype=" + fueltype + ", mileage=" + mileage + ", cc=" + cc
				+ "]";
	}

}
