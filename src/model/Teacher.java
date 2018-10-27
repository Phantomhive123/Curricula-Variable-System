package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teacher extends User{

	private List<Course> courses;
	
	public Teacher(String id, String Password, String Name) {
		super(id, Password, Name);
		// TODO Auto-generated constructor stub
		courses=new ArrayList<Course>();
	}
	
	public List<Course> getCourses()
	{
		return courses;
	}
	public Course addCourse()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("输入新开的课程名：");
		String read1 = scan.nextLine();
		System.out.println("输入上课时间：");
		String read2 = scan.nextLine();
		System.out.println("输入上课地点：");
		String read3 = scan.nextLine();
		
		Course c=new Course(read1,this,read2,read3);
		
		if(!courses.contains(c))
		{
			System.out.println("开课成功");
			courses.add(c);
		}
		return c;		
	}
	public void initCourse(Course c)
	{
		if(!courses.contains(c))
		{
			courses.add(c);
		}
	}	

	public Course removeCourse()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("输入删除的课程名：");
		String read1 = scan.nextLine();
		
		for(int i=0;i<courses.size();i++)
		{
			Course c=courses.get(i);
			if(c.getName().equals(read1))
			{
				courses.remove(i);
				return c;
			}
		}
		return null;
	}
	public void printAllCourses()
	{
		for(int i=0;i<courses.size();i++)
		{
			System.out.println(courses.get(i).getName());
		}
	}
}
