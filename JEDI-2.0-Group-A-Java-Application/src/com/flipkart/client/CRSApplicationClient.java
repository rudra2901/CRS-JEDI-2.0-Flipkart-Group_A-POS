package com.flipkart.client;

import java.util.Scanner;

public class CRSApplicationClient {

	
	public static boolean loggedin;
	
	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		CRSApplicationClient crsApplication = new CRSApplicationClient();
		int userInput;
		// create the main menu
		createMainMenu();
		userInput = sc.nextInt();
		try {

			// until user do not exit the application
			while (userInput != 4) {
				switch (userInput) {
				case 1:
					// login
					crsApplication.loginUser();
					break;
				case 2:
					// student registration
					crsApplication.registerStudent();
					break;
				case 3:
					crsApplication.updatePassword();
					break;
				default:
					System.out.println("Invalid Input");
				}
				createMainMenu();
				userInput = sc.nextInt();
			}
		} catch (Exception ex) {
			System.out.println("Error occured " + ex);
		} finally {
			sc.close();
		}

	}

	public static void createMainMenu() {
		System.out.println("----------Welcome to Course Management System---------");
		System.out.println("1. Login");
		System.out.println("2. Student Registration");
		System.out.println("3. Update password");
		System.out.println("4. Exit");
		System.out.println("Enter user input");
	}

	public void loginUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------------Login------------------");
		System.out.println("Email:");
		String userId = sc.next();
		System.out.println("Password:");
	    String password = sc.next();
	    System.out.println("Role:");
	    String role = sc.next();
		loggedin = true;
		

		if (loggedin) {

//			String role = null;

			switch (role) {
			case "ADMIN":
				CRSAdminMenu adminMenu = new CRSAdminMenu();
				adminMenu.createMenu();
				break;
			case "PROFESSOR":
				CRSProfessorMenu professorMenu = new CRSProfessorMenu();
				professorMenu.createMenu(role);
				break;
			case "STUDENT":
				CRSStudentMenu studentMenu = new CRSStudentMenu();
				studentMenu.create_menu(role);
				break;
			}

		} else {
			System.out.println("Invalid Credentials!");
		}

	}

	/**
	 * Method to help Student register themselves, pending admin approval
	 */
	public void registerStudent() {

	}

	/**
	 * Method to update password of User
	 */
	public void updatePassword() {

	}

}