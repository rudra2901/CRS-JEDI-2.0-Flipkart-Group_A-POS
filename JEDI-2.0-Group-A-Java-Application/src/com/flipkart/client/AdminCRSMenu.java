/**
 * 
 */
package com.flipkart.client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;
import com.flipkart.constant.GenderConstant;
import com.flipkart.constant.NotificationTypeConstant;
import com.flipkart.constant.RoleConstant;
import com.flipkart.exception.CourseExistsAlreadyException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import com.flipkart.exception.UserIdAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;
import com.flipkart.service.NotificationInterface;
import com.flipkart.service.NotificationOperation;
import com.flipkart.service.RegistrationInterface;
import com.flipkart.service.RegistrationOperation;

public class AdminCRSMenu {

    AdminInterface adminOperation = AdminOperation.getInstance();
    Scanner in = new Scanner(System.in);
    NotificationInterface notificationInterface = NotificationOperation.getInstance();
    RegistrationInterface registrationInterface = RegistrationOperation.getInstance();

    /**
     * Method to Create Admin Menu
     */
    public void createMenu() {

        while (CRSApplication.loggedin) {
            System.out.println("---- Admin Menu ----");
            System.out.println("\n\n");
            System.out.println("1. View Courses in Catalog");
            System.out.println("2. Add Course to Catalog");
            System.out.println("3. Delete Course from Catalog");
            System.out.println("4. Approve Students");
            System.out.println("5. View Pending Approvals");
            System.out.println("6. Add Professor");
            System.out.println("7. Assign Professor to Courses");
            System.out.println("8. Generate Report Card");
            System.out.println("9. Logout");
            System.out.println("\n\n");

            int choice = in.nextInt();

            switch (choice) {
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
                    CRSApplication.loggedin = false;
                    return;

                default:
                    System.out.println("---- Invalid Choice ----");
            }
        }
    }
    
    /**
	 * Method to approve a Student using Student's ID
	 */
	private void approveStudent() {
		
		List<Student> studentList = viewPendingAdmissions();
		if(studentList.size() == 0) {
			System.out.println("No Pending Approval!");
			return;
		}
		int choice = 0;
		
		System.out.println("Select Type of approval. \n 1. Approve all students\n 2. Approve by ID");
		choice = in.nextInt();
		
		String studentUserIdApproval;
		
		if(choice == 1) {
			for(Student it : studentList) {
//				studentUserIdApproval = it.getStudentId();
//				System.out.println(studentUserIdApproval);
//				System.out.println(studentUserIdApproval.getClass());
				try {
					adminOperation.approveStudent(it.getUserId(), studentList);
					System.out.println("\nStudent Id : " +it.getUserId()+ " has been approved\n");
					//send notification from system
					notificationInterface.sendNotification(NotificationTypeConstant.REGISTRATION, it.getUserId(), null,0);
			
				} catch (StudentNotFoundForApprovalException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else if(choice == 2) {
			System.out.println("Enter Student's ID:");
			studentUserIdApproval = in.next();
			
			try {
				adminOperation.approveStudent(studentUserIdApproval, studentList);
				System.out.println("\nStudent Id : " +studentUserIdApproval+ " has been approved\n");
				//send notification from system
				notificationInterface.sendNotification(NotificationTypeConstant.REGISTRATION, studentUserIdApproval, null,0);
		
			} catch (StudentNotFoundForApprovalException e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			System.out.println("\t Incorrect choice!");
		}
		
	}

    private void generateReportCard() {

        List<Grade> gradeCard = null;
        boolean isReportGenerated = true;

        Scanner in = new Scanner(System.in);

        System.out.println("\nEnter the Student ID for report card generation: ");
        String studentId = in.next();

        try {
            adminOperation.setGeneratedReportCardTrue(studentId);
            if (isReportGenerated) {
                gradeCard = registrationInterface.viewGradeCard(studentId);
                System.out.println(String.format("%-20s %-20s %-20s", "COURSE CODE", "COURSE NAME", "GRADE"));

                if (gradeCard.isEmpty()) {
                    System.out.println("You haven't registered for any courses");
                    return;
                }

                for (Grade grade : gradeCard) {
                    System.out.println(String.format("%-20s %-20s %-20s", grade.getCrsCode(), grade.getCrsName(), grade.getGrade()));
                }
            } else {
                System.out.println("Report card not yet generated");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to assign Course to a Professor
     */
    private void assignCourseToProfessor() {
        List<Professor> professorList = adminOperation.viewProfessors();
        System.out.println("---- Professors ---- ");
        System.out.println(String.format("%-20s | %-20s | %-20s ", "Professor ID", "Name", "Designation"));
        for (Professor professor : professorList) {
            System.out.println(String.format("%-20s | %-20s | %-20s ", professor.getUserId(), professor.getName(), professor.getDesignation()));
        }

        System.out.println("\n\n");
        List<Course> courseList = adminOperation.viewCourses();
        System.out.println("---- Courses ----");
        System.out.println(String.format("%-20s | %-20s | %-20s", "Course Code", "Course Name", "Professor ID"));
        for (Course course : courseList) {
            System.out.println(String.format("%-20s | %-20s | %-20s", course.getCourseCode(), course.getCourseName(), course.getInstructorId()));
        }

        System.out.println("Enter Course Code:");
        String courseCode = in.next();

        System.out.println("Enter Professor's User ID:");
        String userId = in.next();

        try {
            adminOperation.assignCourse(courseCode, userId);
        } catch (CourseNotFoundException | UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to add Professor to DB
     */
    private void addProfessor() {

        System.out.println("Enter User ID (integer):");
        String userId = in.next();
        Professor professor = new Professor(userId);

        System.out.println("Enter Professor Name:");
        String professorName = in.next();
        professor.setName(professorName);

        System.out.println("Enter Department:");
        String department = in.next();
        professor.setDepartment(department);

        System.out.println("Enter Designation:");
        String designation = in.next();
        professor.setDesignation(designation);

        System.out.println("Enter Password:");
        String password = in.next();
        professor.setPassword(password);

        System.out.println("Enter Gender (1: Male, 2: Female, 3: Other):");
        int gender = in.nextInt();

        if (gender == 1)
            professor.setGender(GenderConstant.MALE);
        else if (gender == 2)
            professor.setGender(GenderConstant.FEMALE);
        else if (gender == 3)
            professor.setGender(GenderConstant.OTHER);

        System.out.println("Enter Address:");
        String address = in.next();
        professor.setAddress(address);

        professor.setRole(RoleConstant.PROFESSOR);

        try {
            adminOperation.addProfessor(professor);
        } catch (ProfessorNotAddedException | UserIdAlreadyInUseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to view Students who are yet to be approved
     * 
     * @return List of Students whose admissions are pending
     */
    private List<Student> viewPendingAdmissions() {

        List<Student> pendingStudentsList = adminOperation.viewPendingAdmissions();
        if (pendingStudentsList.size() == 0) {
            System.out.println("No students pending approvals");
            return pendingStudentsList;
        }
        System.out.println(String.format("%-20s | %-20s | %-20s", "Student ID", "Name", "Gender"));
        for (Student student : pendingStudentsList) {
            System.out.println(String.format("%-20s | %-20s | %-20s", student.getStudentId(), student.getName(), student.getGender().toString()));
        }
        return pendingStudentsList;
    }

    /**
     * Method to delete Course from catalog
     * 
     * @throws CourseNotFoundException
     */
    private void removeCourse() {
        List<Course> courseList = viewCoursesInCatalogue();
        System.out.println("Enter Course Code:");
        String courseCode = in.next();

        try {
            adminOperation.removeCourse(courseCode, courseList);
            System.out.println("\nCourse Deleted: " + courseCode + "\n");
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (CourseNotDeletedException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to add Course to catalog
     * 
     * @throws CourseExistsAlreadyException
     */
    private void addCourseToCatalogue() {
        List<Course> courseList = viewCoursesInCatalogue();

        in.nextLine();
        System.out.println("Enter Course Code:");
        String courseCode = in.nextLine();

        System.out.println("Enter Course Name:");
        String courseName = in.next();

        Course course = new Course(courseCode, courseName, "", 10);
        course.setCourseCode(courseCode);
        course.setCourseName(courseName);
        course.setSeats(10);

        try {
            adminOperation.addCourse(course, courseList);
        } catch (CourseExistsAlreadyException e) {
            System.out.println("Course already existed " + e.getMessage());
        }
    }

    /**
     * Method to display courses in catalog
     * 
     * @return List of courses in catalog
     */
    private List<Course> viewCoursesInCatalogue() {
        List<Course> courseList = adminOperation.viewCourses();
        if (courseList.size() == 0) {
            System.out.println("Nothing present in the catalog!");
            return courseList;
        }
        System.out.println(String.format("%-20s | %-20s | %-20s", "COURSE CODE", "COURSE NAME", "INSTRUCTOR"));
        for (Course course : courseList) {
            System.out.println(String.format("%-20s | %-20s | %-20s", course.getCourseCode(), course.getCourseName(), course.getInstructorId()));
        }
        return courseList;
    }
}
