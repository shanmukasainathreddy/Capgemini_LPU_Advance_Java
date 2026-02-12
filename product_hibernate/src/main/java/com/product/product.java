package com.product;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class product {
	@Id
	int id;
	String name;
	double price;
	int Quantity;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		this.Quantity=quantity;
	}
	
	
}
