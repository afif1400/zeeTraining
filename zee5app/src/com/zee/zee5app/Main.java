package com.zee.zee5app;

import java.util.Iterator;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Register register = new Register();
		//Register : class name
		// register : reference which will refer your object
		// new : is used to create the object 
		// Register() : constructor ===> DC ==> IDC
		// hello 
		try {
			register.setFirstName("abhi");
			register.setLastName("chivate");
		} catch (InvalidNameException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		register.setEmail("abhi@gmail.com");
		register.setPassword("abhi1234");
		try {
			register.setId("ab00001");
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(register);
		// whenever you will print the reference then it 
		// will call toString() method.
		
		System.out.println(register.toString());
	
		System.out.println(register.getEmail());
		
		// can u create the login object?
		// then can u print the login detials?
		
		UserService service = UserServiceImpl.getInstance();
		
		for(int i=1;i<=20;i++) {
		
			Register register2 = new Register();
			try {
				register2.setId("ab0000"+i);
				register2.setFirstName("abhi"+i);
				register2.setLastName("chivate"+i);
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			catch (Throwable e) {
				// TODO: handle exception
			}	
			
			register2.setPassword("abhi");
			String result = service.addUser(register2);
			System.out.println(result);
		}
		
	
		for(int i=1;i<=20;i++) {
			
			Register register2 = new Register();
			try {
				register2.setId("ab0000"+i);
				register2.setFirstName("abhi"+i);
				register2.setLastName("chivate"+i);
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			catch (Throwable e) {
				// TODO: handle exception
			}	
			
			register2.setPassword("abhi");
			String result = service.addUser(register2);
			System.out.println(result);
		}
		
	
		
		
		// userservice object
		// main is consuming the service ?
		
		Optional<Register> optional;
		try {
			optional = service.getUserById("ab00001");
			if(optional.isPresent()) {
				
				System.out.println("getUserById"+optional.get());
			}
			else {
				System.out.println("id not found/available");
			}
			
		
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.getAllUserDetails().forEach(e->System.out.println(e));
		
		
	}

}
