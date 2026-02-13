package com.mockito;

import mockito.User;
import mockito.UserDao;

public class UserServiceTest {
	
	UserDao daomock = mock(UserDao.class);
	
	//create fake object
	
	User fakeObject = new User();
	
	fakeObject.setId(1);
}
