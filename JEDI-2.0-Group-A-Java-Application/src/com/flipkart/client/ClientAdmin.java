/**
 * 
 */
package com.flipkart.client;

import com.flipkart.business.*;

/**
 * @author rudra.tiwari
 *
 */
public class ClientAdmin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdminBusiness admin = new AdminBusiness();
		
		admin.addProff();
		admin.approveStudent();
		admin.assignCource();
	}
	
	public void generateReportCard() {
		StudentBusiness student = new StudentBusiness();
		
		student.veiwGradeCard();
	}
	
	public void removeCourse() {
		CourseCatalogBusiness courseCatalog = new CourseCatalogBusiness();
		
		courseCatalog.deleteCourse();
	}

}
