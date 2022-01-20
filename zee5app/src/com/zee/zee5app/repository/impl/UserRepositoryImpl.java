package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
	
	private ArrayList<Register> arrayList = new ArrayList<>();
	// when u will use DC for AL then by default it will hold 10 elements
	// of type Register.
	
	//private static int count=-1;
	
	private UserRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserRepository repository;
	
	public static UserRepository getInstance() {
		if(repository==null) {
			repository = new UserRepositoryImpl();
		}
		return repository;
	}

	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		boolean result = this.arrayList.add(register);
		
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
	public Optional<Register> getUserById(String id) {
		// TODO Auto-generated method stub
		// do we need to traverse the AL?
		// yes 
		Register register2 = null;
		for (Register register : arrayList) {
			if(register.getId().equals(id)) {
				register2= register;
			}
		}
		return Optional.ofNullable(register2);
		// if register2 is holding null it will act like an empty
		// if register2 is holding object it will act like of
		
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
