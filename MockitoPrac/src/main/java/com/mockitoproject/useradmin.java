package com.mockitoproject;

public class useradmin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Userdao dao = new Userdao();
		User u = new User();
		
		u.setId(102);
		u.setName("Dingiluu");
		u.setBalance(5000);
		
		dao.insertUser();

		
	}

}
