package coding.mentor;
import java.util.Objects;
import java.util.Scanner;
import coding.mentor.db.Database;
import coding.mentor.service.*;
import coding.mentor.data.*;
public class Main {
	public static void main (String[] args) {
		Database.initDB();
		User user = null;
		do {
			do {
				switch(mainMenu()){
					case 1:
						user = login();
						break;
					case 2:
						register();
						break;
					default:
						System.out.println("Invalid input. Please try again");
				}
				if (!Objects.isNull(user)) {
					courseList(user);
				}
			}while(Objects.isNull(user));
		}while (true);
	}
	
	public static void courseList(User user) {
		Scanner scan = new Scanner (System.in);
		do {
			System.out.println("--------------------------------------------------");
			System.out.println("-1. Logout");
			System.out.println("0. Your courses");
			CourseService.showAllCourses();
			System.out.print("Your selection: ");
			int selection = scan.nextInt();
			switch (selection) {
				case (-1):
					user = null;
					return;
				case (0):
					yourCourse(user);
					return;
				default:
					showCourseDetails(user,Database.COURSE_DB.get(selection-1));
			}
		}while(true);
		
	}
	
	public static void showCourseDetails(User user, Course course) {
		Scanner scan = new Scanner (System.in);
		

		CourseService.showCourseDetails(course);
		System.out.println("Do you want to enroll this course?");
		System.out.println("1. Register");
		System.out.println("2. No");
		System.out.println("3. View Mentor Detail");
		System.out.print("Your selection: ");
		int selection = scan.nextInt();
		if (selection == 1) {
			if (UserService.registerNewCourse(user, course)) {
				System.out.println("Your new course has been added.");
				return;
			}
			System.out.println("Something went wrong. Please try again.2");
		}
		if (selection==3) {
			CourseService.showMentorByCourse(course);
		}

	}
	
	public static void yourCourse(User user) {
		Scanner scan = new Scanner (System.in);
		
		System.out.println("--------------------------------------------------");
		UserService.showRegisterCoursesByUser(user);
		
	}
	
	public static void register() {
		Scanner scan = new Scanner (System.in);
		
		System.out.println("--------------------------------------------------");
		System.out.println("Please enter your register information.");
		System.out.print("UserID: ");
		int id = scan.nextInt();
		System.out.print("Password: ");
		String password = scan.next();
		System.out.print("Name: ");
		String name = scan.next();
		
		if (UserService.registerNewUser(id,password,name) == true) {
			System.out.println("Successfully registered.");
		}
		
		if (UserService.registerNewUser(id,password,name) == false) {
			System.out.println("User ID has been used. Please try again with another.");
		}
	}
	
	public static User login() {
		Scanner scan = new Scanner (System.in);

		System.out.println("--------------------------------------------------");
		System.out.println("Please enter your userID and password.");
		System.out.print("UserID: ");
		int id = scan.nextInt();
		System.out.print("Password: ");
		String password = scan.next();
		
		int index = UserService.login(id, password);
		if (index == -1) {
			System.out.println("Your login has been failed. Please try agin");
			return (null);
		}
		if (index == -2) {
			System.out.println("Your account has been locked.");
			return (null);
		}
		if (index >=0) {
			return (Database.USER_DB.get(index));
		}
		return null;
		
	}
	
	public static int mainMenu() {
		Scanner scan = new Scanner (System.in);
		System.out.println("Welcome to Coding Mentor.");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.print("Your selection: ");
		return(scan.nextInt());
	}
}
