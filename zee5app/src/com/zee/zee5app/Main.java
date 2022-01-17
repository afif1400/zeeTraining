package com.zee.zee5app;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.UserService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Register register = new Register();
		//Register : class name
		// register : reference which will refer your object
		// new : is used to create the object 
		// Register() : constructor ===> DC ==> IDC
		
		register.setFirstName("abhi");
		register.setLastName("chivate");
		register.setEmail("abhi@gmail.com");
		register.setPassword("abhi1234");
		
		System.out.println(register);
		// whenever you will print the reference then it 
		// will call toString() method.
		
		System.out.println(register.toString());
	
		System.out.println(register.getEmail());
		
		// can u create the login object?
		// then can u print the login detials?
		
		UserService service = UserService.getInstance();
		// userservice object
		// main is consuming the service ?
		
	}

}
