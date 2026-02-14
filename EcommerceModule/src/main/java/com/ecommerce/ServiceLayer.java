package com.ecommerce;

import java.util.Date;

public class ServiceLayer {

	private Userdao userDao = new Userdao();
	private Orderdao orderDao = new Orderdao();
	private Paymentdao paymentDao = new Paymentdao();

	// 1) Register User with Profile
	public void registerUserWithProfile(User u, Profile p) {
		u.setP(p);
		userDao.saveuser(u);
	}

	// 2) Add Multiple Orders to User
	public void addOrderToUser(int userId, PurchaseOrder order) {

		User u = userDao.finduser(userId);

		if (u != null) {
			u.getPo().add(order);
			userDao.saveuser(u); 
		}
	}

	// 3) Add Payment to Order
	public void addPaymentToOrder(int orderId, Payment payment) {

		PurchaseOrder po = orderDao.findorder(orderId);

		if (po != null) {
			payment.setPo1(po);
//			po.getPayments().add(payment);
			paymentDao.savepayment(payment); 
		}
	}

	// 4) Fetch User with Orders
	public User fetchUserWithOrders(int userId) {
		return userDao.finduser(userId);
	}

	// 5) Delete User and verify cascade
	public void deleteUser(int userId) {
		userDao.deleteuser(userId);
	}

	// 6) Update Order Amount
	public void updateOrderAmount(int orderId, double newAmount) {

		// DAO lo updateOrderAmount method ledu kabatti:
		// find order -> update -> save

		PurchaseOrder po = orderDao.findorder(orderId);

		if (po != null) {
			po.setTotalamount(newAmount);
			orderDao.saveorder(po);
		}
	}

	// Extra helper method: create order quickly
	public PurchaseOrder createOrder(int id, double amount) {
		PurchaseOrder po = new PurchaseOrder();
		po.setId(id);
		po.setOrderdate(new Date());
		po.setTotalamount(amount);
		return po;
	}
}