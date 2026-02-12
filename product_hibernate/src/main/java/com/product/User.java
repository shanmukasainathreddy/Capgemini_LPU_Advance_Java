package com.product;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		productDao dao = new productDao();
		
		product p = new product();
		
		p.setId(4);
		p.setName("Duster");
		p.setPrice(10.0);
		p.setQuantity(6);
		
		dao.insertProduct(p);
		
	}

}
