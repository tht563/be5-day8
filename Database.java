package coding.mentor.db;

import java.util.*;

import coding.mentor.data.*;

public class Database {
	public static ArrayList<Mentor> MENTOR_DB = new ArrayList<>();
	public static ArrayList<Course> COURSE_DB = new ArrayList<>();
	public static ArrayList<User> USER_DB = new ArrayList<>();
	
	public static void initDB() {
		MENTOR_DB.add(new Mentor(1, "Dung", "dung@gmail.com", "0909"));
		MENTOR_DB.add(new Mentor(2, "Jayden", "jayden@gmail.com", "0808"));
		MENTOR_DB.add(new Mentor(3, "Toni", "tony@gmail.com", "0707"));
		
		
		ArrayList<Mentor> teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTOR_DB.get(0));
		COURSE_DB.add(new Course(1,"BE 1", teachingMentors, new Date(), new Date(), 3000));
		
		teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTOR_DB.get(0));
		teachingMentors.add(MENTOR_DB.get(1));
		COURSE_DB.add(new Course(2,"BE 2", teachingMentors, new Date(), new Date(), 3100));
		
		teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTOR_DB.get(2));	
		COURSE_DB.add(new Course(3,"DATA 1", teachingMentors, new Date(), new Date(), 2500));
		
		
	}
}
