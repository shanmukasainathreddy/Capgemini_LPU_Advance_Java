package com.pacmockito;


// Integration Testing -> service -> DOA -> DB (done testing in 3 layers)
// we want Unit Testing -> Service -> using  fake DAO ( done unit testing in 1 layer)
// we create fake DAO with the help of Mockito 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockitoproject.User;
import com.mockitoproject.Userdao;

@ExtendWith(MockitoExtension.class)
public class Userservicetest {
	
	@Mock
	Userdao daoMock;
	
	@InjectMocks
	Userservicetest service;
	
	@Test
	public void typeOfUser() {
		//UserDao daoMock=mock(UserDao.class);
		 
		// create fake object
		User fackObject=new User();
		fackObject.setId(1);
		fackObject.setBalance(2000); 
		fackObject.setName("Allen");
		
		//mention what object should return 
		when(daoMock.findById(1)).thenReturn(fackObject);
		
		User user1=new User();
		user1.setId(2);
		user1.setBalance(1000);
		user1.setName("Miller");
		when(daoMock.findById(2)).thenReturn(user1);
		
		
		//injecting mock object
//		UserService service=new UserService(daoMock);
		
		String res=service.typeOfUser(1);
		assertEquals("regular user",res);
		
		String res1=service.typeOfUser(2);
		assertEquals("new user",res1);
	}

}