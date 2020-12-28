package com.capgemini.fitness.exception;
public class LoginException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public LoginException() {

	}
	public LoginException(String message) {
		super();
		this.message=message;
	}

	public LoginException(String message,Exception e) {
		super();
		this.message=message;
	}

	@Override
	public String toString() {
		return "LoginException [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}
}



