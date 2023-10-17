package coding.mentor.service;
import java.util.ArrayList;

import coding.mentor.data.*;
import coding.mentor.db.Database;
public class CourseService {
	public static void showAllCourses() {
		for (int i=0; i<Database.COURSE_DB.size(); i++) {
			System.out.print(i+1+". "+Database.COURSE_DB.get(i).getName()+" --- ");
			for (int j=0; j< Database.COURSE_DB.get(i).getTeachingMentor().size(); j++ ) {
				System.out.print(Database.COURSE_DB.get(i).getTeachingMentor().get(j).getName());
				if (j <Database.COURSE_DB.get(i).getTeachingMentor().size()-1 ) {
					System.out.print(" + ");
				}
				
			}
			System.out.println("");
		}
	}
	
	public static void showCourseDetails(Course course) {
		System.out.println("--------------------------------------------------");
		System.out.println(course.getName());
		for (Mentor mentor: course.getTeachingMentor()) {
			System.out.print(mentor.getName() + " - ");
		}
		System.out.println(course.getBegin());
		System.out.println(course.getEnd());
		System.out.println(course.getFee());
	}
	
	public static void showMentorByCourse(Course course) {
		System.out.println("--------------------------------------------------");
		int i=1;
		for(Mentor mentor : course.getTeachingMentor()) {
			System.out.println(i+".");
			System.out.println("Name: "+ mentor.getName());		
			System.out.println("Email: "+ mentor.getEmail());		
			System.out.println("Phone: "+ mentor.getPhone());	
			i++;
		}
		
	}
}

