/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;

/**
 * @author rudra.tiwari
 *
 */
public class CRSAdminMenu {
	
	Scanner in = new Scanner(System.in);

	/**
	 * @param args
	 */
public void createMenu(){
		
		boolean loggedin = true;
		while(loggedin) {
			System.out.println("*****************************");
			System.out.println("**********Admin Menu*********");
			System.out.println("*****************************");
			System.out.println("1. View course in catalog");
			System.out.println("2. Add Course to catalog");
			System.out.println("3. Delete Course from catalog");
			System.out.println("4. Approve Students");
			System.out.println("5. View Pending Approvals");
			System.out.println("6. Add Professor");
			System.out.println("7. Assign Professor To Courses");
			System.out.println("8. Generate Report Card");
			System.out.println("9. Logout");
			System.out.println("*****************************");
			
			int choice = in.nextInt();
			
			switch(choice) {
			case 1:
				viewCoursesInCatalogue();
				break;
				
			case 2:
				addCourseToCatalogue();
				break;
				
			case 3:
				removeCourse();
				break;
				
			case 4:
				approveStudent();
				break;
			
			case 5:
				viewPendingAdmissions();
				break;
			
			case 6:
				addProfessor();
				break;
			
			case 7:
				assignCourseToProfessor();
				break;
				
			case 8:
				generateReportCard();
				break;
			
			case 9:
				loggedin = false;
				return;

			default:
				System.out.println("***** Wrong Choice *****");
			}
		}
	}

	private void generateReportCard() {
		// TODO Auto-generated method stub
		
	}

	private void assignCourseToProfessor() {
		// TODO Auto-generated method stub
		
	}

	private void addProfessor() {
		// TODO Auto-generated method stub
		
	}

	private void viewPendingAdmissions() {
		// TODO Auto-generated method stub
		
	}

	private void approveStudent() {
		// TODO Auto-generated method stub
		
	}

	private void removeCourse() {
		// TODO Auto-generated method stub
		
	}

	private void addCourseToCatalogue() {
		// TODO Auto-generated method stub
		
	}

	private void viewCoursesInCatalogue() {
		// TODO Auto-generated method stub
		
	}

}
