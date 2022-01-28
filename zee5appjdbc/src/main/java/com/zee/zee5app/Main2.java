package com.zee.zee5app;
import java.io.IOException;
import java.math.BigDecimal; 
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.Impl.UserServiceImpl;
import com.zee.zee5app.service.Impl.LoginServiceImpl;
import com.zee.zee5app.service.Impl.MovieServiceImpl;
import com.zee.zee5app.service.Impl.SeriesServiceImpl;
import com.zee.zee5app.service.Impl.SubscriptionServiceImpl;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		Register register = null;
//		UserService service = null;
//		try {
//			register = new Register("ab00014","mehak","dharma","tanya21@gmail.com","S3jns2",null);
//			register.setContactnumber(new BigDecimal("9813973123"));
//			
//			service = UserServiceImpl.getInstance();
//			
//			String result = service.addUser(register);
//			System.out.println(result);
//		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		
//		}
//		
		try {
			LoginService service2 = LoginServiceImpl.getInstance();
			System.out.println(service2.changeRole("tanya21@gmail.com", ROLE.ROLE_ADMIN));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//		Optional<Register> register = null;
//		UserService service = null;
//		try {
//			service = UserServiceImpl.getInstance();
//			register = service.getUserById("ab0001");
//			
//			System.out.println(register.get());
//		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			UserService service = UserServiceImpl.getInstance();
//			Optional<List<Register>> optional = service.getAllUserDetails();
//			
//			if(optional.isEmpty()) {
//				System.out.println("there are no records");
//			}
//			else {
//				optional.get().forEach(e-> System.out.println(e));
//			}	
//			
//		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		UserService service;
//		
//		try {
//			service = UserServiceImpl.getInstance();
//			service.deleteUserById("ab0001");
//		} catch (IOException | IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			service = UserServiceImpl.getInstance();
//         	for (Register register2 : service.getAllUsers()) {
//				if(register2!= null)
//					System.out.println(register2);
//			}
//			
//		} catch (IOException | InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
	}


