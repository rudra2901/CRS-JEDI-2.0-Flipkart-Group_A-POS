package com.flipkart.exception;

/**
 * Exception to check if the professor is not added successfully by admin
 * @author Group-A
 * Aaryan Pawar
 * Harsh Garg
 * Pulkit Bhargava
 * Rudra Tiwari
 * Shruti Sharma
 * Vedant Patel
 *
 */
public class ProfessorNotAddedException extends Exception{
	private String professorId;
	
	public ProfessorNotAddedException(String id) {
		professorId = id;
	}
	
	/**
	 * Getter function for professorId
	 * @return
	 */
	public String getUserId() {
		return this.professorId;
	}
	

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "professorId: " + professorId + " not added!";
	}
}