package com.product;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity (name = "table name u want)
@Entity
public class product {
	@Id
	private int id;
	private String name;
	private double price;
	private int Quantity;
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
