package com.in28minutes.rest.webservices.restwebservices.expection;

import java.util.Date;

public class ExceptionDetails  {

	private String message;
	
	private Date timestam;
	
	private String details;

	public ExceptionDetails(String message, Date timestam, String details) {
		super();
		this.message = message;
		this.timestam = timestam;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestam() {
		return timestam;
	}

	public void setTimestam(Date timestam) {
		this.timestam = timestam;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	

		
}
