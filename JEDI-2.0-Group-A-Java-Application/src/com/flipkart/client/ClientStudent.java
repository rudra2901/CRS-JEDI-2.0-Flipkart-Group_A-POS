/**
 * 
 */
package com.flipkart.client;

import com.flipkart.business.*;

/**
 * @author harsh.garg
 *
 */
public class ClientStudent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudentBusiness student = new StudentBusiness();
		student.register();
		student.veiwGradeCard();
		

	}
	
	public void registerCourse() {
		SemesterRegistrationBusiness semReg = new SemesterRegistrationBusiness();
		semReg.registerCourses();
		
	}
	
	public void payFee() {
		
	}

}
