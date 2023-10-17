package coding.mentor.data;

import java.util.ArrayList;
import java.util.Objects;

public class User {
	private int id;
	private String password;
	private String name;
	private ArrayList <Course> registeredCourse;
	private int failedCount;
	
	public User() {
		
	}
	
	public User(int id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		registeredCourse = new ArrayList<Course>();
		failedCount = 0;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Course> getRegisteredCourse() {
		return registeredCourse;
	}
	public void setRegisteredCourse(ArrayList<Course> registeredCourse) {
		this.registeredCourse = registeredCourse;
	}
	public int getFailedCount() {
		return failedCount;
	}
	public void setFailedCount(int failedCount) {
		this.failedCount = failedCount;
	}
	public void addNewCourse(Course course) {
			registeredCourse.add(course);		
	}
	
}
