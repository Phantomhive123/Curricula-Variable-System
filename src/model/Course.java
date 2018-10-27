package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
	
	private String name;
	private Teacher teacher;
	private String time;
	private String place;	
	private List<Student> students;
	
	public Course(String Name,Teacher theTeacher,String Time,String Place)
	{
		name=Name;
		teacher=theTeacher;
		time=Time;
		place=Place;
		students=new ArrayList<Student>();
		
		teacher.initCourse(this);
	}
	
	public String getName()
	{
		return name;
	}
	public Teacher getTeacher()
	{
		return teacher;
	}
	public String getTime()
	{
		return time;
	}
	public String getPlace()
	{
		return place;
	}
	public List<Student> getStudents()
	{
		return students;
	}
	public void setTime(String Time)
	{
		time=Time;
	}
	public void setPlace(String Place)
	{
		place=Place;
	}
	public void addStudent(Student theStudent)
	{
		if(!students.contains(theStudent))
			students.add(theStudent);
	}
	public void reMoveStudent(Student theStudent)
	{
		if(students.contains(theStudent))
			students.remove(theStudent);
	}
	
}
