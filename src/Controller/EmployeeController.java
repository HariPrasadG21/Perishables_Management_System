package Controller;
import Model.*;
import View.*;
import java.sql.*; 
import java.sql.Connection;
import java.util.ArrayList;
public class EmployeeController 
{
	Connection con;
	private Employee user;
	private Statement stmt;
	private ResultSet result;
	DatabaseConnection dc = DatabaseConnection.get();
	public boolean loginEmployee(Employee emp) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/perishables_management_system","root","welcome"); 
			stmt=con.createStatement();  
			String query1 = "Select * FROM Employee WHERE ID='"+emp.getID()+"' and password='"+emp.getPwd()+"'" ;
			result = stmt.executeQuery(query1);
			if(result.next())
			{
				user = new Employee(result.getString(2),result.getString(1),result.getString(4),result.getInt(3),result.getString(5),result.getString(6),result.getString(8),result.getString(7));
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	public void updatePassword(Employee user){
		try{
		dc.openConnection();
		dc.stmt.executeUpdate("update employee set password = '"+user.getPwd()+"'  where ID='"+user.getID()+"';");
		dc.closeConnection();
		}
		catch(Exception e){
		System.out.println(e.getMessage());
		}
	}
	public Employee getEmployee()
	{
		return user;
	}
	public String[][] searchEmployee(String name)
	{
		ArrayList<Employee> ar = new ArrayList<Employee>();
		try 
		{
			dc.openConnection();
			dc.result = dc.stmt.executeQuery("select id,name,dob,designation,phoneno from employee where name like '%"+name+"%'");
			while(dc.result.next())
			{
				String empid = dc.result.getString(1);
				String empname = dc.result.getString(2);
				String empdob = dc.result.getString(3);
				String empdes = dc.result.getString(4);
				String empphone = dc.result.getString(5);
				Employee emp = new Employee(empid,empname,empdob,empdes,empphone);
				ar.add(emp);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dc.closeConnection();
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Employee)obj[i]).getID()+"";
			data[i][1] = ((Employee)obj[i]).getName()+"";
			data[i][2] = ((Employee)obj[i]).getDOB()+"";
			data[i][3] = ((Employee)obj[i]).getDes()+"";
			data[i][4] = ((Employee)obj[i]).getPhone()+"";
		}
		return data;
	}
	public String[][] getEmployees()
	{
		ArrayList<Employee> ar = new ArrayList<Employee>();
		try 
		{
			dc.openConnection();
			dc.result = dc.stmt.executeQuery("select id,name,dob,designation,phoneno from employee");
			while(dc.result.next())
			{
				String empid = dc.result.getString(1);
				String empname = dc.result.getString(2);
				String empdob = dc.result.getString(3);
				String empdes = dc.result.getString(4);
				String empphone = dc.result.getString(5);
				Employee emp = new Employee(empid,empname,empdob,empdes,empphone);
				ar.add(emp);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dc.closeConnection();
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Employee)obj[i]).getID()+"";
			data[i][1] = ((Employee)obj[i]).getName()+"";
			data[i][2] = ((Employee)obj[i]).getDOB()+"";
			data[i][3] = ((Employee)obj[i]).getDes()+"";
			data[i][4] = ((Employee)obj[i]).getPhone()+"";
		}
		return data;
	}
	public void addEmployee(Employee user)
	{
		try
		{
			dc.openConnection();
			dc.stmt.executeUpdate("insert into Employee(Name,ID,DOB,Designation,tou,phoneno) values('"+user.getName()+"','"+user.getID()+"','"+user.getDOB()+"','"+user.getDes()+"','"+user.getTou()+"','"+user.getPhone()+"')");
			dc.stmt.execute("call update_ages('"+user.getID()+"','"+user.getDOB()+"')");
			dc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
	public Employee searchUser(String id)
	{
		Employee user = null;
		try
		{
			dc.openConnection();
			dc.result = dc.stmt.executeQuery("select id,name,dob,designation,tou,phoneno from employee where id='"+id+"'");
			while(dc.result.next())
			{
				String name = dc.result.getString(2);
				String id1 = dc.result.getString(1);
				String dob = dc.result.getString(3);
				String designation = dc.result.getString(4);
				String tou = dc.result.getString(6);
				String phone = dc.result.getString(5);
				user = new Employee(id1,name,dob,designation,tou,phone);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dc.closeConnection();
		return user;
	}
	public void updateEmployee(Employee emp)
	{
		try
		{
			dc.openConnection();
			dc.stmt.execute("update employee set name='"+emp.getName()+"',dob='"+emp.getDOB()+"',designation='"+emp.getDes()+"',tou='"+emp.getTou()+"',phoneno='"+emp.getPhone()+"' where id='"+emp.getID()+"'");
			dc.stmt.execute("call update_ages('"+user.getID()+"','"+user.getDOB()+"'");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dc.closeConnection();
	}
	public void deleteEmployee(String id)
	{
		try
		{
			dc.openConnection();
			dc.stmt.execute("delete from employee where id='"+id+"'");
			dc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
