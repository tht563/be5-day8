package coding.mentor.service;
import java.util.Objects;

import coding.mentor.data.*;
import coding.mentor.db.Database;

public class UserService {
	public static boolean registerNewUser(int id, String password, String name) {
		for (User user : Database.USER_DB) {
			if (user.getId() == id) {
				return (false);
			}
		}
		Database.USER_DB.add(new User(id, password, name));
		return (true);
	}
	
	public static int login (int id, String password) {
		for (int i=0; i<Database.USER_DB.size();i++) {
			if ((Database.USER_DB.get(i).getId() == id)&&(Database.USER_DB.get(i).getPassword().equals(password))) {
				if (Database.USER_DB.get(i).getFailedCount()<2) {
					return (i);
				}
				if (Database.USER_DB.get(i).getFailedCount()<2) {
					return (-2);
				}
			}
			if ((Database.USER_DB.get(i).getId() == id)&&(!Database.USER_DB.get(i).getPassword().equals(password))) {
				Database.USER_DB.get(i).setFailedCount(Database.USER_DB.get(i).getFailedCount()+1);
				break;
			}
		}
		return (-1);
	}
	
	public static void showRegisterCoursesByUser(User user) {
		int i = 1;
		if (user.getRegisteredCourse().size()==0) {
			System.out.println("There is no course in your account.");
			return;
		}
		for (Course course: user.getRegisteredCourse()) {
			System.out.println(i+ ". "+course.getName());
			System.out.print("Mentor: ");
			for (Mentor mentor: course.getTeachingMentor()) {
				System.out.print(mentor.getName() + " - ");
			}
			System.out.println("");
			System.out.println("Begin: " + course.getBegin());
			System.out.println("End: " + course.getEnd());
			System.out.println("Fee: " + course.getFee());
			i++;
		}
		
	}
	
	public static boolean registerNewCourse(User user, Course course) {
		if (!Objects.isNull(user.getRegisteredCourse())) {
			for (Course registeredCourse:user.getRegisteredCourse()) {
				if (registeredCourse.getId() == course.getId()) {
					return (false);
				}
			}
		}	
		user.addNewCourse(course);
		return (true);
		
	}
}
