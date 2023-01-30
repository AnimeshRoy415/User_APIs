package com.user.Excption;

public class UserAlreadyExists extends RuntimeException {
	
	
	public UserAlreadyExists() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExists(String message) {
		super(message);
		
	}

}
