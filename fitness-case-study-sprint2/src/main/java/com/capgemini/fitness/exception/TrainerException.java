package com.capgemini.fitness.exception;

public class TrainerException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public TrainerException()
	{
		
	}
	
	public TrainerException(String message) {
		super();
		this.message = message;
	}
	
	public TrainerException(String message,Exception e) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return "TrainerException [message=" + message + "]";
	}
}
