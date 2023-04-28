package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.*;
public class DatabaseConnection {
	private static DatabaseConnection dc = new DatabaseConnection();
	private DatabaseConnection()
	{
		
	}
	public static DatabaseConnection get()
	{
		return dc;
	}
	public Connection con;
	public Statement stmt;
	public ResultSet result;
	public void openConnection()
	{
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/perishables_management_system","root","welcome"); 
			stmt=con.createStatement();  
		}
		catch(Exception e)
		{ 
			System.out.println(e.getMessage());
		}
	}
	public void closeConnection(){
		try{
			if(con!=null){
				con.close();
				con = null;
			}
			if(stmt!=null){
				stmt.close();
				stmt = null;
			}
			if(result!=null){
				result.close();
				result = null;
			}
		}
		
		catch(Exception e){}
	}	
}
