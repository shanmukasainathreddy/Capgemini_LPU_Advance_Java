package com.CRM;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Order {
	@Id
	private long id;
	private String Date;
	private double totalampunt;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Lead> lead;
	
//	@ManyToMany
//	private List<Product> p;
	
	
	
}
