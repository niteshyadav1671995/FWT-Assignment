package com.yash.moviebookingsystem.exception;

public class EmptyFieldException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2069880330656186433L;

	public EmptyFieldException(String message) {
		super(message);
	}
	
}
