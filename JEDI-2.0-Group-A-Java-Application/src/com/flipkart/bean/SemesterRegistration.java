/**
 * 
 */
package com.flipkart.bean;

import java.util.Date;

/**
 * @author rudra.tiwari
 *
 */
public class SemesterRegistration {
	
	private int studentID;
	private int semester;
	private Date dateOfRegistration;
	
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}
	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

}
