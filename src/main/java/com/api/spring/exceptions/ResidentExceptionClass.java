package com.api.spring.exceptions;

public class ResidentExceptionClass extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResidentExceptionClass(String message) {
		super(message);
	}
	
	public ResidentExceptionClass(String message, Throwable throwable) {
		super(message,throwable);
	}
	
}
