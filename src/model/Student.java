package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends User{

	private List<Course> courses;
	
	public Student(String id, String Password, String Name) {
		super(id, Password, Name);
		// TODO Auto-generated constructor stub
		courses=new ArrayList<Course>();
	}
	
	public List<Course> getCourses()
	{
		return courses;
	}
	public void addCourse(List<Course> allCourses)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("输入想选的课程名：");
		String read1 = scan.nextLine();
		
		for(int i=0;i<allCourses.size();i++)
		{
			Course c=allCourses.get(i);
			if(c.getName().equals(read1))
			{		
				if(!courses.contains(c))
					courses.add(c);
				c.addStudent(this);
				System.out.println("恭喜你，选课成功！");
				System.out.println("当前已选的课程为：");
				showChoosenCourses();
				return;
			}
		}
		System.out.println("没有这个课程。");	
	}
	public void removeCourse(Course theCourse)
	{
		if(courses.contains(theCourse))
			courses.remove(theCourse);
	}
	public void showChoosenCourses()
	{
		for(int i=0;i<courses.size();i++)
		{
			System.out.println(courses.get(i).getName());
		}
	}

}
