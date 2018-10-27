package controller;

import java.util.Scanner;

import model.Course;
import model.Student;
import model.Teacher;
import model.User;
import model.Manager;

public class MainController {

	private CoursesController coursesController;
	private UsersController usersController;
	private User currentUser;
	
	public MainController()
	{
		System.out.println("欢迎使用选课系统！");
		this.coursesController=new CoursesController();
		this.usersController=new UsersController();
		test();
		unsignedLoop();
	}
	
	//登录涉及到当前用户，关系到之后界面的显示，所以放在主控制中。
	public int signIn()
	{	
		Scanner scan = new Scanner(System.in);
		System.out.println("输入账号：");	
		String read1 = scan.nextLine();
		System.out.println("输入密码：");	
		String read2 = scan.nextLine();
		
		currentUser=usersController.signIn(read1, read2);
		
		if(currentUser instanceof Student)
			return 1;
		if(currentUser instanceof Teacher)
			return 2;
		if(currentUser instanceof Manager)
			return 3;
		
		return 0;
	}
	
	//未登录时的主循环
	public void unsignedLoop()
	{	
		int userFlag=-1;
		Scanner scan = new Scanner(System.in);
		boolean loopFlag=true;
		while(loopFlag)
		{			
			System.out.println("输入1登录，输入2查询所有课程，输入3按教师查询课程，输入4按照课程名查询,输入0退出：");	
			String read1 = scan.nextLine();			
			switch(read1)
			{
			case "1":userFlag=signIn();break;
			case "0":return;
			}
			normalChoose(read1);
			
			switch(userFlag)
			{
			case -1:break;
			case 0:break;
			case 1:loopFlag=false;studentLoop();return;
			case 2:loopFlag=false;teacherLoop();return;
			case 3:loopFlag=false;managerLoop();return;
			}
		}
	}
	
	//当前用户为教师时的主循环
	
	public void teacherLoop()
	{
		Scanner scan = new Scanner(System.in);
		boolean loopFlag=true;
		while(loopFlag)
		{			
			System.out.println("输入1查询所开课程，输入2查询所有课程，输入3按教师查询课程，输入4按照课程名查询");	
			System.out.println("输入5开新课,输入6删除所属的一门课,输入0退出：");
			String read1 = scan.nextLine();
			switch(read1)
			{
			case "1":((Teacher)currentUser).printAllCourses();break;
			case "5":coursesController.addCourse(((Teacher)currentUser).addCourse());break;
			case "6":coursesController.removeCourse(((Teacher)currentUser).removeCourse());break;
			case "0":return;
			}
			normalChoose(read1);
		}
	}
	
	//当前用户为学生时的主循环
	
	public void studentLoop()
	{
		Scanner scan = new Scanner(System.in);
		boolean loopFlag=true;
		while(loopFlag)
		{			
			System.out.println("输入1选课，输入2查询所有课程，输入3按教师查询课程，输入4按照课程名查询,输入5查询所有已选课程，输入0退出：");	
			String read1 = scan.nextLine();
			switch(read1)
			{
			case "1":((Student)currentUser).addCourse(coursesController.getAllCourses());;break;
			case "5":((Student)currentUser).showChoosenCourses();break;
			case "0":return;
			}
			normalChoose(read1);
		}
	}
	
	//当前用户是管理员时的主循环，待补充
	
	public void managerLoop()
	{
		
	}
	
	//任何用户下（含未登录）最基层的功能
	
	public void normalChoose(String str1)
	{
		switch(str1)
		{
		case "2":coursesController.showAllCourses();break;
		case "3":coursesController.searchCourseByTeacher();break;
		case "4":coursesController.searchCourseByName();break;
		}
	}
	
	//测试用例，加入了几个教师、学生、课程
	//账号为姓名拼音，密码为123
	
	public void test()
	{
		Teacher t1=new Teacher("jinjianhua","123","金建华");
		Teacher t2=new Teacher("geguoqin","123","葛国勤");
		Teacher t3=new Teacher("luli","123","卢力");		
		Course c1=new Course("微积分",t1,"周二","东九");
		Course c2=new Course("大物",t2,"周一","东九");
		Course c3=new Course("离散数学",t3,"周三","东九");
		Student s1=new Student("lilongde","123","李隆德");
		Student s2=new Student("wangqianqian","123","王千千");
		Student s3=new Student("liweijie","123","黎维婕");
		
		usersController.addTeacher(t1);
		usersController.addTeacher(t2);
		usersController.addTeacher(t3);
		coursesController.addCourse(c1);
		coursesController.addCourse(c2);
		coursesController.addCourse(c3);
		usersController.addStudent(s1);
		usersController.addStudent(s2);
		usersController.addStudent(s3);
	}
}
