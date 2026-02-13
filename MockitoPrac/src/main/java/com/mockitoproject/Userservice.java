package com.mockitoproject;


//Bussiness Logic
public class Userservice {
	Userdao dao; // null value
	
	public Userservice(Userdao dao){
		this.dao = dao;
	}
	
	public String typeofaccountholder(int id) {
		User u = dao.findById(id);
		
		if(u.getBalance() > 0 && u.getBalance() <=  1000) return "New Account Holder";
		else if(u.getBalance() > 1001 && u.getBalance() <=2000) return "Regular Account Holder";
		else return "Premium Account Holder";
	}
}
