package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Course;
import model.Teacher;

public class CoursesController {
	
	private List<Course> courses;
	
	public CoursesController()
	{
		this.courses=new ArrayList<Course>();
	}
	
	public void addCourse(Course course)
	{
		if(!courses.contains(course))
		{
			courses.add(course);
			System.out.println("课程"+course.getName()+"已加入数据库");
		}
		else
		{
			System.out.println("加入失败");
		}
	}	
	public List<Course> getAllCourses()
	{
		return courses;
	}
	public void showAllCourses()
	{
		for(int i=0;i<this.getAllCourses().size();i++)
		{
			Course c=this.getAllCourses().get(i);
			System.out.println("课程名："+c.getName());
			System.out.println("教师："+c.getTeacher().getName());
			System.out.println("时间："+c.getTime());
			System.out.println("地点："+c.getPlace()+"\n");
		}
	}
	public void searchCourseByTeacher()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("输入教师姓名：");	
		String read1 = scan.nextLine();
		
		for(int i=0;i<this.getAllCourses().size();i++)
		{
			Course c=this.getAllCourses().get(i);
			if(c.getTeacher().getName().equals(read1))
			{
				System.out.println("课程名："+c.getName());
				System.out.println("教师："+c.getTeacher().getName());
				System.out.println("时间："+c.getTime());
				System.out.println("地点："+c.getPlace()+"\n");
			}
		}
	}
	public void searchCourseByName()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("输入课程名：");	
		String read1 = scan.nextLine();
		
		for(int i=0;i<this.getAllCourses().size();i++)
		{
			Course c=this.getAllCourses().get(i);
			if(c.getName().equals(read1))
			{
				System.out.println("课程名："+c.getName());
				System.out.println("教师："+c.getTeacher().getName());
				System.out.println("时间："+c.getTime());
				System.out.println("地点："+c.getPlace()+"\n");
			}
		}
	}
	//删除需要查询数据库，因此放在此处
	public void removeCourse(Course c)
	{
		pullFromDB();
		if(c!=null)
		{	
			courses.remove(c);
			System.out.println("删除成功！");
		}
		else
			System.out.println("当前教师没有教授所选课程！");
		pushToDB();
	}
	
	//从数据库中获取最新数据，更新该实例中courses，每个修改数据的函数之前调用
	public void pullFromDB()
	{
		
	}
	//有数据改变的时候，将最新数据推至数据库，每个修改数据的函数之后调用
	public void pushToDB()
	{
		
	}
}
