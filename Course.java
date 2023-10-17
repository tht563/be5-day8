package coding.mentor.data;

import java.util.ArrayList;
import java.util.Date;

public class Course {
	private int id;
	private String name;
	private ArrayList<Mentor> teachingMentor;
	private Date begin;
	private Date end;
	private int fee;
	
	public Course() {
		
	}
	
	public Course(int id, String name, ArrayList<Mentor> teachingMentor, Date begin, Date end, int fee) {
		super();
		this.id = id;
		this.name = name;
		this.teachingMentor = teachingMentor;
		this.begin = begin;
		this.end = end;
		this.fee = fee;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Mentor> getTeachingMentor() {
		return teachingMentor;
	}
	public void setTeachingMentor(ArrayList<Mentor> teachingMentor) {
		this.teachingMentor = teachingMentor;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	
	
}
