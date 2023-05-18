/**
 * 
 */
package com.flipkart.bean;

import java.util.List;

/**
 * @author rudra.tiwari
 *
 */
public class GradeCard {

	private int studentID;
	private int semester;
	private float cpi;
	List<RegisteredCourse> reg_list;

	public List<RegisteredCourse> getReg_list() {
		return reg_list;
	}

	public void setReg_list(List<RegisteredCourse> reg_list) {
		this.reg_list = reg_list;
	}

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

	public float getCpi() {
		return cpi;
	}

	public void setCpi(float cpi) {
		this.cpi = cpi;
	}

}
