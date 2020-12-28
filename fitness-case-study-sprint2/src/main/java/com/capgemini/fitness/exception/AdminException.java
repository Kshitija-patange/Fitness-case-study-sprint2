package com.capgemini.fitness.exception;

public class AdminException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public AdminException()
	{
		
	}

	public AdminException(String message) {
		super();
		this.message = message;
	}
	
	public AdminException(String message,Exception e) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "AdminException [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	

}
