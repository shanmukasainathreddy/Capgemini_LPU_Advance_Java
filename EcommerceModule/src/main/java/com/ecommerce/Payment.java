package com.ecommerce;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Payment {
	private int id;
	private String mode;
	
	@ManyToOne
	PurchaseOrder po1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public PurchaseOrder getPo1() {
		return po1;
	}

	public void setPo1(PurchaseOrder po1) {
		this.po1 = po1;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", mode=" + mode + ", po1=" + po1 + "]";
	}
	
	
	
}
