/**
 * 
 */
package com.flipkart.client;

import com.flipkart.business.*;

/**
 * @author harsh.garg
 *
 */
public class ClientProfessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProffBuisness profBusiness = new ProffBuisness();
		
		profBusiness.addGrade();
		profBusiness.viewEnrolledStudent();
	}


}
