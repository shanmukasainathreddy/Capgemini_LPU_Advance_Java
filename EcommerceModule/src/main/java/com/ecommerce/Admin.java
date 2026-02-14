package com.ecommerce;

import java.util.Date;

public class Admin {

	public static void main(String[] args) {

		Userdao userDao = new Userdao();

		// Profile
		Profile profile = new Profile();
		profile.setId(101);
		profile.setPhone("9876543210");
		profile.setAddress("Tirupati");

		// User
		User user = new User();
		user.setId(1);
		user.setName("Shannu");
		user.setEmail("shannu@gmail.com");
		user.setP(profile);

		// Order
		PurchaseOrder order1 = new PurchaseOrder();
		order1.setId(201);
		order1.setOrderdate(new Date());
		order1.setTotalamount(2500);

		// Payment
		Payment pay1 = new Payment();
		pay1.setId(301);
		pay1.setMode("UPI");
		pay1.setPo1(order1);

		// Connect payment to order
		pay1.getPo1();

		// Connect order to user
		user.getPo().add(order1);

		userDao.saveuser(user);

		System.out.println("Saved Successfully!");

		// Fetch
		User u = userDao.finduser(1);
		System.out.println("Fetched User: " + u);
		System.out.println("Profile: " + u.getP());
		System.out.println("Orders Count: " + u.getPo().size());
	}
}