package com.studentdetails;

public class studentadmin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		studentdao dao= new studentdao();
		student s = new  student();
		s.setSid(102);
		s.setSname("Rohit");
		s.setSemail("rohit@gmail.com");
		s.setSmarks(45.0);
		
		dao.savestudent(s);
	}

}
