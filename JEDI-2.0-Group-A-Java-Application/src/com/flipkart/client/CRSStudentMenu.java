/**
 * 
 */
package com.flipkart.client;
import java.util.Scanner;


public class CRSStudentMenu {
	
	Scanner sc = new Scanner(System.in);

	/**
	 * @param args
	 */
	public void create_menu(String studentId) {

		
		boolean loggedin = true;
		while (loggedin) {

			System.out.println("*****************************");
			System.out.println("**********Student Menu*********");
			System.out.println("*****************************");
			System.out.println("1. Course Registration");
			System.out.println("2. Add Course");
			System.out.println("3. Drop Course");
			System.out.println("4. View Course");
			System.out.println("5. View Registered Courses");
			System.out.println("6. View grade card");
			System.out.println("7. Make Payment");
			System.out.println("8. Logout");
			System.out.println("*****************************");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				registerCourses(studentId);
				break;

			case 2:
				addCourse(studentId);
				break;

			case 3:
				dropCourse(studentId);
				break;

			case 4:
				viewCourse(studentId);
				break;

			case 5:
				viewRegisteredCourse(studentId);
				break;

			case 6:
				viewGradeCard(studentId);
				break;

			case 7:
				make_payment(studentId);
				break;

			case 8:
				loggedin = false;
				break;

			default:
				System.out.println("Incorrect Choice!");

			}

		}

	}

	private void make_payment(String studentId) {
		// TODO Auto-generated method stub
		
	}

	private void viewGradeCard(String studentId) {
		// TODO Auto-generated method stub
		
	}

	private void viewRegisteredCourse(String studentId) {
		// TODO Auto-generated method stub
		
	}

	private void viewCourse(String studentId) {
		// TODO Auto-generated method stub
		
	}

	private void dropCourse(String studentId) {
		// TODO Auto-generated method stub
		
	}

	private void addCourse(String studentId) {
		// TODO Auto-generated method stub
		
	}

	private void registerCourses(String studentId) {
		// TODO Auto-generated method stub
		
	}

}
