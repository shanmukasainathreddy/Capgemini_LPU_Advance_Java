package com.prac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.studentdetails.student;
import com.studentdetails.studentdao;

public class studentdaotest {
	static EntityManagerFactory emf;
	static EntityManager em;
	static studentdao dao;
	
	@BeforeAll
	public static void initEmf() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	}
	
	@BeforeEach
	public  void initEm() {
		EntityManager em = emf.createEntityManager();
	}
	
	@Test
	public void savestudent() {
		studentdao dao= new studentdao();
		student s = new student();
		s.setSid(102);
		s.setSname("Rohit");
		s.setSemail("rohit2gmail.com");
		s.setSmarks(45.0);
		
		dao.savestudent(s);
		
		student res = dao.findbyid(102);
		assertNotNull(res);
		assertEquals("Rohit",res.getSname());
		
	}
	
	@Test
	public void FindStudentByid() {
		student s = dao.findbyid(102);
		assertNotNull(s);
		assertEquals(102,s.getSid());
	}
	
	@Test
	public void findallstudents() {
		List<student> list = dao.findallstudents();
		
		student s = dao.findbyid(102);
		assertEquals("Rohit",s.getSname());
	}
	
	@Test
	public void UpdateStudent() {
		dao.updatestudent(102, "Rohit Sharma");
		student s = dao.findbyid(102);
		assertEquals("Rohit Sharma" , s.getSname());
	}
	
	@Test
	public void deletestudent() {
		dao.deletestudent(102);
        student s = dao.findbyid(102);
        assertEquals(null, s);
	}
	
	@Test
	public void studentcount() {
		List<student> list = dao.findallstudents();
        int count = list.size();
        System.out.println("Student Count = " + count);
	}
	@AfterEach
	public void destoryEm() {
		em.close();
	}
	
	@AfterAll
	public static void  destoryEmf() {
		emf.close();
	}
	
	
}
