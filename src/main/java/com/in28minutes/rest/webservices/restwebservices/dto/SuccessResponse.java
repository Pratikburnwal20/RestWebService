package com.in28minutes.rest.webservices.restwebservices.dto;

public class SuccessResponse<T> extends ResponseClass {

	private T datset;
	public SuccessResponse(int statuscode, T datset, String message) {
		super(statuscode,message);
		this.datset = datset;
		// TODO Auto-generated constructor stub
	}
	
	public SuccessResponse(int statuscode, T datset, String message, String uri) {
		super(statuscode, uri, message);
		this.datset = datset;
	}

	public T getDatset() {
		return datset;
	}

	public void setDatset(T datset) {
		this.datset = datset;
	}
	
	

}
