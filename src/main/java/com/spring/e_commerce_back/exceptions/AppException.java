package com.spring.e_commerce_back.exceptions;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4969897418837348410L;
	private final HttpStatus httpStatus;
	
	public AppException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
