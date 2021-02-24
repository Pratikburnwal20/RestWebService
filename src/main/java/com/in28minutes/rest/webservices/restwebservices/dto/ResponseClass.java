package com.in28minutes.rest.webservices.restwebservices.dto;

public class ResponseClass {
	
	private int statuscode;
	
	private String message;
	private String uri;
	
	public ResponseClass(int statuscode, String message) {
		super();
		this.statuscode = statuscode;
		
		this.message = message;
	}
	
	
	public ResponseClass(int statuscode, String message, String uri) {
		super();
		this.statuscode = statuscode;
		
		this.message = message;
		this.uri = uri;
	}


	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	

	 

}
