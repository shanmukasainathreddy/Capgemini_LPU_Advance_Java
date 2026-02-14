package com.ecommerce;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.*;

public class EcommerceTest {

	private static Userdao userDao;
	private static Orderdao orderDao;
	private static Paymentdao paymentDao;
	private static ServiceLayer service;

	@BeforeAll
	public static void setup() {
		userDao = new Userdao();
		orderDao = new Orderdao();
		paymentDao = new Paymentdao();
		service = new ServiceLayer();
	}

	// Test 1 - OneToOne Persist Test
	@Test
	public void testOneToOnePersist_UserWithProfile() {

		Profile p = new Profile();
		p.setId(1001);
		p.setPhone("9999999999");
		p.setAddress("Tirupati");

		User u = new User();
		u.setId(1);
		u.setName("Shannu");
		u.setEmail("shannu@gmail.com");

		service.registerUserWithProfile(u, p);

		User fetched = userDao.finduser(1);

		assertNotNull(fetched);
		assertNotNull(fetched.getP());
		assertEquals("Tirupati", fetched.getP().getAddress());
	}

	// Test 2 - OneToMany Persist Test
	@Test
	public void testOneToManyPersist_UserWithMultipleOrders() {

		PurchaseOrder o1 = new PurchaseOrder();
		o1.setId(2001);
		o1.setOrderdate(new Date());
		o1.setTotalamount(5000);

		PurchaseOrder o2 = new PurchaseOrder();
		o2.setId(2002);
		o2.setOrderdate(new Date());
		o2.setTotalamount(8000);

		service.addOrderToUser(1, o1);
		service.addOrderToUser(1, o2);

		User fetched = userDao.finduser(1);

		assertNotNull(fetched);
		assertEquals(2, fetched.getPo().size()); // ✅ getPo()
	}

	// Test 3 - ManyToOne Persist Test
	@Test
	public void testManyToOnePersist_PaymentLinkedToOrder() {

		Payment pay = new Payment();
		pay.setId(3001);
		pay.setMode("UPI");

		service.addPaymentToOrder(2001, pay);

		Payment fetchedPay = paymentDao.findpayment(3001);

		assertNotNull(fetchedPay);
		assertEquals("UPI", fetchedPay.getMode());
		assertNotNull(fetchedPay.getPo1()); // ✅ because in Payment class it's po1
		assertEquals(2001, fetchedPay.getPo1().getId());
	}

	// Test 4 - DAO Update Test
	@Test
	public void testDAOUpdate_UpdateOrderAmount() {

		service.updateOrderAmount(2001, 9999);

		PurchaseOrder updated = orderDao.findorder(2001);

		assertNotNull(updated);
		assertEquals(9999, updated.getTotalamount());
	}

	// Test 5 - DAO Delete Test
	@Test
	public void testDAODelete_DeleteUser() {

		service.deleteUser(1);

		User fetched = userDao.finduser(1);

		assertNull(fetched);
	}

	// Test 6 - Service Layer Integration
	@Test
	public void testServiceLayerIntegration_FullWorkflow() {

		Profile p = new Profile();
		p.setId(5001);
		p.setPhone("8888888888");
		p.setAddress("MBU");

		User u = new User();
		u.setId(2);
		u.setName("Ravi");
		u.setEmail("ravi@gmail.com");

		service.registerUserWithProfile(u, p);

		PurchaseOrder o1 = new PurchaseOrder();
		o1.setId(6001);
		o1.setOrderdate(new Date());
		o1.setTotalamount(2500);

		PurchaseOrder o2 = new PurchaseOrder();
		o2.setId(6002);
		o2.setOrderdate(new Date());
		o2.setTotalamount(3500);

		service.addOrderToUser(2, o1);
		service.addOrderToUser(2, o2);

		Payment pay = new Payment();
		pay.setId(7001);
		pay.setMode("CARD");

		service.addPaymentToOrder(6001, pay);

		User fetched = service.fetchUserWithOrders(2);

		assertNotNull(fetched);
		assertEquals(2, fetched.getPo().size()); 
		assertNotNull(fetched.getP());
		assertEquals("MBU", fetched.getP().getAddress());
	}
}