package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Register;
// repo. objects are used to call only repo methods 
// can we do this using 1 object?
public class UserRepository {
	
	private Register[] register = new Register[10];
	private UserRepository() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserRepository userRepository;
	public static UserRepository getInstance() {
		
		if(userRepository==null)
			userRepository = new UserRepository();
		return userRepository;
		
	}

}
