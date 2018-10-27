package model;

public class User {

	private String ID;
	private String password;
	private String name;
	
	public User(String id,String Password,String Name)
	{
		ID=id;
		password=Password;
		name=Name;
	}
	
	public String getID()
	{
		return ID;
	}
	public String getPassword()
	{
		return password;
	}
	public String getName()
	{
		return name;
	}
}
