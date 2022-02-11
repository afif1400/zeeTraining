package com.zee.zee5app.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private LoginService service;
	
	@Autowired
	private LoginRepository loginRepository;
	
	// loginService
	

//	private UserServiceImpl() throws IOException {
//		
//	}
	// getting repository object through spring
//    public UserServiceImpl() throws IOException {
//		
//	}
//	

//	private static UserService service;
//	public static UserService getInstance() throws IOException{
//		if(service==null)
//			service = new UserServiceImpl();
//		return service;
//	}
	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
	public User addUser(User register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		//make exception for the next line
		boolean status =repository.existsByEmail(register.getEmail());
		System.out.println(status);
		if(status) {
			throw new AlreadyExistsException("this record already exists");
			
		}
		User register2 = repository.save(register);
		if (register2 != null) {
			return register2;
//			Login login = new Login("abhi@gmail.com", register.getPassword(), "ab000123", ROLE.ROLE_USER);
//			if(loginRepository.existsByuserName("abhi@gmail.com")) {
//				throw new AlreadyExistsException("record exists");
//			}
			
		}
		else {
			return null;
		}
		
	}


	@Override
	public String updateUser(long id, User register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
		//we dont write here coz update is automatically taken care of
	}

	@Override
	public User getUserById(long id) throws IdNotFoundException  {
		// TODO Auto-generated method stub
		Optional<User> optional=  repository.findById(id);
		
		if(optional.isEmpty()) {
			throw new IdNotFoundException("id doesnot exists");
		}
		else {
			return optional.get();
		}
	}

	@Override
	public User[] getAllUsers()
			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		List<User> list = repository.findAll();
		User[] array = new User[list.size()];
		return list.toArray(array);
	}

	@Override
	public String deleteUserById(long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		//cross check with findbyid
		//use optional here coz findbyid return optional type

			User optional;
			try {
				optional = this.getUserById(id);
				if(optional==null) {
					throw new IdNotFoundException("record not found");
				}
				else {
					repository.deleteById(id);
					return "register record deleted";
				}
			} catch (IdNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new IdNotFoundException(e.getMessage());
			}
		
	}

	@Override
	public Optional<List<User>> getAllUserDetails()
			{
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

}
