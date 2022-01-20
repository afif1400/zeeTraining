package com.zee.zee5app.repository.Impl;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;

// this can be used for 1st database
//similary make another file and use it for 2nd database and so on
// here UserRepository act as an interface which has 5 specific functionalities
public class UserRepositoryImpl implements UserRepository {
	
	//private Register[] registers = new Register[10];
	
	//we will now implement arraylist
	//java by default uses doubly linked list
	
	//this will only hold Register type specfications
	//to hold hetro specifications use: private ArrayList<> arraylist = new ArrayList<>()
	private ArrayList<Register> arraylist = new ArrayList<>();
	
	//when you will use DC for AL then by default it will construct list with capacity of 10 elements
	
	//private static int count = -1;
	
	
	//now we make an singleton object for this
	private UserRepositoryImpl() {
		
	}
	
	//we cant declare/create objects for interface
	// we can declare only references
	/// when we will refer the object whose class is implementing the interface
	// then object will behave like interface i.e.
	//w we can only access the interface overridden methods
	
	//we use UserRepository here coz we need reference sfrom UserRepository(interface class) not the impl thing.
	private static UserRepository repository;
	public static UserRepository getInstance() {
		if(repository ==null)
			//but we refer using interface only i.e.
			//repository = new UserRepository()
			// we can only access interface methods
			
			// this will use functionalities of the interface and both class only
			repository = new UserRepositoryImpl();
		return repository;
	}
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		boolean result = this.arraylist.add(register);
		if(result) {
			return "success";
		}
		return "fail";
	}
	
	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	//Optional : used to handle null pointer exception
	public Optional<Register> getUserById(String id) {
		// TODO Auto-generated method stub
		//we need to traverse the arraylist
		
//		for (Register register : arraylist) {
//			if(register.getId().equals(id)) {
//				return Optional.of(register);
//		    }
//		}
//		return Optional.empty();
		
		Register register2 = null;
		for (Register register : arraylist) {
			if(register.getId().equals(id)) {
				register2 = register;
		    }
		}
		return Optional.ofNullable(register2);
//if register2 is holding null it will act like an empty
//if register2 is holfing object it will act like Of
	}
	
	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		//return this.arraylist.register;
		return null;
	}
	
	@Override
	public String deleteUserById(String id) {
		// TODO Auto-generated method stub
//		for (Register register : arraylist) {
//			if(register!=null && register.getId().equals(id)) {
//				//remove register;
//		    }
//		}
		return null;
		
	}
	

//	@Override
//	public String addUser(Register register) {
//		// TODO Auto-generated method stub
//		if(count==registers.length-1) {
//			// array is full or we should go for dynamically increasing the size of array
//			Register temp[] = new Register[registers.length*4];
//			
//			//now we need to copy the contents from old to new array
//			System.arraycopy(registers, 0, temp, 0, registers.length);
//			registers = temp;
//			registers[++count] = register;
//			
//			
//			return "sucesss";
//		}
//		// count is -1 initially, then here it will start with 0
//		registers[++count]= register;
//		return "success";
//	}
//
//	@Override
//	public String updateUser(String id, Register register) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Register getUserById(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Register[] getAllUsers() {
//		// TODO Auto-generated method stub
//		return registers;
//	}
//
//	@Override
//	public String deleteUserById(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	

}
