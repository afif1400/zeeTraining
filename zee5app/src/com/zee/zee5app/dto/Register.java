package com.zee.zee5app.dto;

import lombok.Data;

//write @Data and then press ctrl+space then enter to get the lombok
@Data

public class Register {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public Register() {
		//EDC
		// any kind of customization during the initialization of object then its better
		// to introduce ECD or PC or both as per need.
		System.out.println("hello");
	}
	
	//private stuff will be accessible only within the class
	
	//setter function : is used to set the value for a particular field
	//getter function : to get/return the value of a specific field

}
