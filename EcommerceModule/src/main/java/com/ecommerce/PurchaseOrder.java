package com.ecommerce;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PurchaseOrder {
	@Id
	private int id;
	private Date orderdate;
	private double totalamount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", orderdate=" + orderdate + ", totalamount=" + totalamount + "]";
	}
	
	
	
	
}
