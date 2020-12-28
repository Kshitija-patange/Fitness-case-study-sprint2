package com.capgemini.fitness.exception;

public class UserException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message ;

	public UserException()
	{

	}

	public UserException(String message) {
		super();
		this.message = message;
	}

	public UserException(String message,Exception e) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "UserException [message=" + message + "]";
	}
}