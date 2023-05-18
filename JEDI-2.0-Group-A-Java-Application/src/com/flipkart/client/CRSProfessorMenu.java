/**
 * 
 */
package com.flipkart.client;
import java.util.Scanner;

/**
 * @author harsh.garg
 *
 */
public class CRSProfessorMenu {

	/**
	 * @param args
	 */
	public void createMenu(String profID) {
		Scanner in = new Scanner(System.in);
		
		int input;
		boolean loggedin = false;
		while (loggedin) {
			System.out.println("--------------------------------");
			System.out.println("-------Professor Menu-----------");
			System.out.println("--------------------------------");
			System.out.println("1. view Courses");
			System.out.println("2. view Enrolled Students");
			System.out.println("3. add Grades");
			System.out.println("4. logout");
			System.out.println("--------------------------------");
			System.out.printf("Choose From Menu: ");
			
			input = in.nextInt();
			switch (input) {
			case 1:
				getCourses();
				break;
			case 2:
				viewEnrolledStudents();
				break;
			case 3:
				addGrade();
				break;
			case 4:
				loggedin = false;
				return;
			default:
				System.out.println("Please select appropriate option...");
			}
		}
		in.close();
	}

	private void addGrade() {
		// TODO Auto-generated method stub
		
	}

	private void viewEnrolledStudents() {
		// TODO Auto-generated method stub
		
	}

	private void getCourses() {
		// TODO Auto-generated method stub
		
	}

}
