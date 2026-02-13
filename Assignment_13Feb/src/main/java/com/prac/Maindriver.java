package com.prac;

import java.sql.Date;

public class Maindriver {

		public static void main(String[] args) {

			StudentEntityDao dao = new StudentEntityDao();

	        // Create AadharCard
	        AdharCardEntity card = new AdharCardEntity();
	        card.setAadharId(101);
	        card.setAadharNumber(9876543210L);
	        card.setAddress("Andhra Pradesh");
	        card.setIssuedate(new Date(20));
	        dao.saveAadharCard(card);

	        // Create HostelRoom
	        HostelRoomEntity room = new HostelRoomEntity();
	        room.setRoomnumber(1015);
	        room.setFloornumber(10);   
	        room.setBlockname("Block B");
	        room.setFloornumber(121);
	        dao.saveHostelRoom(room);

	        // Create Student
	        StudentEntity student = new StudentEntity();
	        student.setStudentid(101);
	        student.setName("Virat");
	        student.setGmail("Virat@email.com");
	        student.setBranch("ECE");
	        student.setAc(card);
	        student.setHostelRo(room);

	        dao.saveStudent(student);

	        // Fetch Student details
	        StudentEntity fetched = dao.fetchstudentdetails(student.getStudentid());

	        if (fetched != null) {
	            System.out.println("Student Details: ");
	            System.out.println("ID: " + fetched.getStudentid());
	            System.out.println("Name: " + fetched.getName());
	            System.out.println("Email: " + fetched.getGmail());
	            System.out.println("Branch: " + fetched.getBranch());

	            System.out.println("\n Aadhar Details: ");
	            System.out.println("Aadhar Number: " +
	                    fetched.getAc().getAadharNumber());
	            System.out.println("Address: " +
	                    fetched.getAc().getAddress());
	            System.out.println("Issue Date: " +
	                    fetched.getAc().getIssuedate());

	            System.out.println("\n Hostel Details: ");
	            System.out.println("Room Number: " +
	                    fetched.getHostelRo().getRoomnumber());
	            System.out.println("Block Name: " +
	                    fetched.getHostelRo().getBlockname());
	            System.out.println("Floor Number: " +
	                    fetched.getHostelRo().getFloornumber());
	        }

	        // Delete Student
	        dao.deletestudent(student.getStudentid());
	    }

}
