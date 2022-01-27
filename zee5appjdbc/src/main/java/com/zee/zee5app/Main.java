package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
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

//		try {
//			Register register = new Register("ab000001", "abhi", "chivate", "abhi@gmail.com", "12345678");
//			
//			register.setContactNumber(new BigDecimal("9975477764"));
//			
//			UserService service = UserServiceImpl.getInstance();
//			
//			String result = service.addUser(register);
//			System.out.println(result);
//			
//		} catch (InvalidIdLengthException | InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		try {
			UserService service = UserServiceImpl.getInstance();
			Optional<Register> register = service.getUserById("ab000001");
			System.out.println(register.get());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
