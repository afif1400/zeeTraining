package com.zee.zee5app.repository.impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
	
	private TreeSet<Register> set = new TreeSet<>();
	// when u will use DC for AL then by default it will hold 16 elements
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
		boolean result = this.set.add(register);
		System.out.println(this.set.size());
		if(result) {
			return "success";
		}
		return "fail";
	}

	@Override // assignment
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		// do we need to traverse the AL?
		// yes 
		Register register2 = null;
		for (Register register : set) {
			if(register.getId().equals(id)) {
				register2= register;
			}
		}
		return Optional.ofNullable(Optional
				.of(register2)
				.orElseThrow(()-> new IdNotFoundException("id not found")));
				//.orElseThrow(()-> new IdNotFoundException("id not found"));
		// if register2 is holding null it will act like an empty
		// if register2 is holding object it will act like of
		
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		// transform the collection to array
		
		Register register[] = new Register[set.size()];
		
		return set.toArray(register);
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		// 
		Optional<Register> optional = this.getUserById(id);
		
		if(optional.isPresent()) {
			// removal
			
			boolean result = set.remove(optional.get());
			
			if(result) {
				return "success";
			}
			else
				return "fail";
		}
		return "fail";
		
	}

	@Override
	public List<Register> getAllUserDetails() {
		
		//Collections.sort(set);
		// to convert the set to list
		//return set;
		// descending order 
		// here we need to share the result in terms of asc. 
		// desc===> asc
		
		return new ArrayList<>(set.descendingSet());
	}
	
}
