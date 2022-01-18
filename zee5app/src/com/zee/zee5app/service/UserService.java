package com.zee.zee5app.service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;
// service objects are used to just call the services inside the main method
//can we do this using 1 object?
// TO fix they provided a solution called singleton Design pattern
// one ==> to get only one object for the specific type.


public class UserService {

	private UserRepository repository = UserRepository.getInstance();
	// service is consuming the repository
	
	private UserService() {
		// TODO Auto-generated constructor stub
	}
	// if we want ot create that single object then we have to create it
	// inside the same class
	// and we have to share ref with others
	// to do the same we have to declare a method.
	private static UserService  service = null;
	// this would be a static 
	// only one copy.
	
	public static UserService getInstance() {
		// it  becomes object independant?
		// static will make it independant on the object for execution.
		
		// static method will access only static ref
		if(service==null)
		service = new UserService();
		return service;
		
	}
	
	public String addUser(Register register) {
		// do we need to consume the addUser method from repo.
		return this.repository.addUser(register);
	}
	
	public Register getUserById(String id) {
		return repository.getUserById(id);
	}
	public Register[] getUsers() {
		return repository.getUsers();
	}
}
