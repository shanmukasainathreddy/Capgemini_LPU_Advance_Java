package com.pacmockito;


// Integration Testing -> service -> DOA -> DB (done testing in 3 layers)
// we want Unit Testing -> Service -> using  fake DAO ( done unit testing in 1 layer)
// we create fake DAO with the help of Mockito 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.mockitoproject.Calculator;
import com.mockitoproject.Calculatorservice;
import com.mockitoproject.Userdao;
import com.mockitoproject.Userservice;

public class Userservicetest {
	
	
	@Test
	public void testgettypeofaccountholder() {
		Userdao dao = new Userdao();
		Userservice us = new Userservice(dao);
		
		String actual_res = us.typeofaccountholder(101);
		
		assertEquals(actual_res , "Regular Account Holder");
		
		
	}
	
	public void testdoubleadd() {
		
		//step-1 : mock an object to create fake object
		Calculator cmock = mock(Calculator.class);
		
		//step-2 : what mock object should return
		when(cmock.add(5,5)).thenReturn(20);
		
		//step-3 : inject the mock reference
		
		Calculatorservice service = new Calculatorservice(cmock);
		
		int res = service.doubleadd(5, 5);
		
		assertEquals(20,res);
		
		
	}

	
}
