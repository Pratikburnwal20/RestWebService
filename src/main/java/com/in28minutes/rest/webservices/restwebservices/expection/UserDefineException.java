package com.in28minutes.rest.webservices.restwebservices.expection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserDefineException extends RuntimeException {


	public UserDefineException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	
}
