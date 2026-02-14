package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	private int id;
	private String name;
	private String email;
	
	@OneToOne
	Profile p;
	
	@OneToMany
	List<PurchaseOrder> po = new ArrayList<>();

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Profile getP() {
		return p;
	}

	public void setP(Profile p) {
		this.p = p;
	}

	public List<PurchaseOrder> getPo() {
		return po;
	}

	public void setPo(List<PurchaseOrder> po) {
		this.po = po;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", p=" + p + ", po=" + po + "]";
	}
	
	
	
	
	
}
