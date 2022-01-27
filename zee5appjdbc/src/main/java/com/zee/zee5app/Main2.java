package com.zee.zee5app;
import java.io.IOException;
import java.math.BigDecimal; 
import java.util.Iterator;
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
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.Impl.UserServiceImpl;
import com.zee.zee5app.service.Impl.MovieServiceImpl;
import com.zee.zee5app.service.Impl.SeriesServiceImpl;
import com.zee.zee5app.service.Impl.SubscriptionServiceImpl;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		Register register = null;
//		UserService service = null;
//		try {
//			register = new Register("ab0001","mehak","dharma","tanya21@gmail.com","S3jns2");
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
//	}
	
		Optional<Register> register = null;
		UserService service = null;
		try {
			service = UserServiceImpl.getInstance();
			register = service.getUserById("ab0001");
			
			System.out.println(register.get());
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
