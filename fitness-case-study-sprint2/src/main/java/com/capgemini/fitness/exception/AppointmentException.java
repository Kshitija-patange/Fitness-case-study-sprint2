package com.capgemini.fitness.exception;



public class AppointmentException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public AppointmentException()
	{

	}

	public AppointmentException(String message) {
		super();
		this.message = message;
	}

	public AppointmentException(String message,Exception e) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "AppointmentException [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}
}
