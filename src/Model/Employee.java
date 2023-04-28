package Model;
public class Employee 
{
	private String Name;
	private String DOB;
	private String id;
	private int age;
	private String designation;
	private String tou;
	private String password;
	private String phoneno;
	public Employee(String id,String password)
	{
		this.id=id;
		this.password=password;
	}
	public Employee(String id,String Name,String DOB,int age,String designation,String tou,String password,String phoneno)
	{
		this.Name=Name;
		this.DOB=DOB;
		this.id=id;
		this.age=age;
		this.designation=designation;
		this.password=password;
		this.tou=tou;
		this.phoneno=phoneno;
	}
	public Employee(String id,String Name,String DOB,String designation,String phoneno)
	{
		this.Name=Name;
		this.DOB=DOB;
		this.id=id;
		this.designation=designation;
		this.phoneno=phoneno;
	}
	public Employee(String id,String Name,String DOB,String designation,String phoneno,String tou)
	{
		this.Name=Name;
		this.DOB=DOB;
		this.id=id;
		this.designation=designation;
		this.phoneno=phoneno;
		this.tou=tou;
	}
	public String getName()
	{
		return this.Name;
	}
	public int getAge()
	{
		return this.age;
	}
	public String getDOB()
	{
		return this.DOB;
	}
	public String getDes()
	{
		return this.designation;
	}
	public String getID()
	{
		return this.id;
	}
	public String getTou()
	{
		return this.tou;
	}
	public String getPwd()
	{
		return this.password;
	}
	public String getPhone()
	{
		return this.phoneno;
	}
	public void setPwd(String pwd)
	{
		this.password=pwd;
	}
}

