package controller;

import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Manager;
import model.Student;
import model.Teacher;
import model.User;

public class UsersController {
	
	//private List<User> users;
	private List<Student> students;
	private List<Teacher> teachers;
	private List<Manager> managers;
	
	public UsersController()
	{
		this.students=new ArrayList<Student>();
		this.teachers=new ArrayList<Teacher>();
		this.managers=new ArrayList<Manager>();
	}
	
	/*
	public void addUsers(User user)
	{
		if(!users.contains(user))
			users.add(user);
	}
	public List<User> getAllUser()
	{
		return users;
	}
	*/
	
	public void addStudent(Student student)
	{
		pullFromDB();
		if(!students.contains(student))
		{
			students.add(student);
			System.out.println("学生"+student.getName()+"已加入数据库");
		}
		else
		{
			System.out.println("加入失败");
		}
		pushToDB();
	}
	public List<Student> getAllStudents()
	{
		pullFromDB();
		return students;
	}
	public void addTeacher(Teacher teacher)
	{
		pullFromDB();
		if(!teachers.contains(teacher))
		{
			teachers.add(teacher);
			System.out.println("教师"+teacher.getName()+"已加入数据库");
		}
		else
		{
			System.out.println("加入失败");
		}
		pushToDB();
	}
	public List<Teacher> getAllTeachers()
	{
		pullFromDB();
		return teachers;
	}
	public void addManager(Manager manager)
	{
		pullFromDB();
		if(!managers.contains(manager))
		{
			managers.add(manager);
			System.out.println("管理员"+manager.getName()+"已加入数据库");
		}
		else
		{
			System.out.println("加入失败");
		}
		pushToDB();
	}
	public List<Manager> getAllManagers()
	{
		pullFromDB();
		return managers;
	}
	
	//因为登录需要查询学生数据库，因此是从MainController传指令到这里
	public User signIn(String str1, String str2)
	{
		pullFromDB();
		User currentUser;
		
		for(int i=0;i<this.getAllManagers().size();i++)
		{
			if(this.getAllManagers().get(i).getID().equals(str1)
				&&this.getAllManagers().get(i).getPassword().equals(str2))
			{
				currentUser=this.getAllManagers().get(i);
				System.out.println("欢迎你，管理员："+currentUser.getName());
				return currentUser;
			}
		}
		
		for(int i=0;i<this.getAllStudents().size();i++)
		{
			if(this.getAllStudents().get(i).getID().equals(str1)
				&&this.getAllStudents().get(i).getPassword().equals(str2))
			{
				currentUser=this.getAllStudents().get(i);
				System.out.println("欢迎你，同学："+currentUser.getName());
				return currentUser;
			}
		}
		
		for(int i=0;i<this.getAllTeachers().size();i++)
		{
			if(this.getAllTeachers().get(i).getID().equals(str1)
				&&this.getAllTeachers().get(i).getPassword().equals(str2))
			{
				currentUser=this.getAllTeachers().get(i);
				System.out.println("欢迎你，老师："+currentUser.getName());
				return currentUser;
			}
		}
		
		System.out.println("账号或密码错误！");
		return null;
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
