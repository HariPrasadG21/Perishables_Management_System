package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Employee;
import Model.*;

public class ProductController 
{
	Connection con;
	private Product product;
	private Statement stmt;
	private ResultSet result;
	DatabaseConnection dc = DatabaseConnection.get();
	public String[][] getProducts()
	{
		ArrayList<Product> pd = new ArrayList<Product>();
		try 
		{
			dc.openConnection();
			dc.result = dc.stmt.executeQuery("select * from product");
			while(dc.result.next())
			{
				int pid = dc.result.getInt(1);
				String top = dc.result.getString(2);
				String pname = dc.result.getString(3);
				float price = dc.result.getFloat(4);
				String sd = dc.result.getString(5);
				String ed = dc.result.getString(6);
				int noe = dc.result.getInt(7);
				float quantity = dc.result.getFloat(8);
				Product pro =  new Product(pid,top,pname,price,sd,ed,noe,quantity);
				pd.add(pro);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dc.closeConnection();
		Object obj[] = pd.toArray();
		String data[][] = new String [pd.size()][8];
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Product)obj[i]).getPid()+"";
			data[i][1] = ((Product)obj[i]).getTop()+"";
			data[i][2] = ((Product)obj[i]).getPname()+"";
			data[i][3] = ((Product)obj[i]).getPrice()+"";
			data[i][4] = ((Product)obj[i]).getMd()+"";
			data[i][5] = ((Product)obj[i]).getEd()+"";
			data[i][6] = ((Product)obj[i]).getNoe()+"";
			data[i][7] = ((Product)obj[i]).getQuantity()+"";
		}
		return data;
	}
	public void addProduct(Product product)
	{
		try
		{
			dc.openConnection();
			dc.stmt.executeUpdate("insert into product(type_of_product,product_name,price_per_kg,stored_date,expiry_date,no_expiry,quantity) values('"+product.getTop()+"','"+product.getPname()+"','"+product.getPrice()+"','"+product.getMd()+"','"+product.getEd()+"','"+product.getNoe()+"','"+product.getQuantity()+"')");
			dc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
	public String[][] searchProducts(String product)
	{
		ArrayList<Product> pd = new ArrayList<Product>();
		try 
		{
			dc.openConnection();
			dc.result = dc.stmt.executeQuery("select * from product where product_name='"+product+"'");
			while(dc.result.next())
			{
				int pid = dc.result.getInt(1);
				String top = dc.result.getString(2);
				String pname = dc.result.getString(3);
				float price = dc.result.getFloat(4);
				String sd = dc.result.getString(5);
				String ed = dc.result.getString(6);
				int noe = dc.result.getInt(7);
				float quantity = dc.result.getFloat(8);
				Product pro =  new Product(pid,top,pname,price,sd,ed,noe,quantity);
				pd.add(pro);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dc.closeConnection();
		Object obj[] = pd.toArray();
		String data[][] = new String [pd.size()][8];
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Product)obj[i]).getPid()+"";
			data[i][1] = ((Product)obj[i]).getTop()+"";
			data[i][2] = ((Product)obj[i]).getPname()+"";
			data[i][3] = ((Product)obj[i]).getPrice()+"";
			data[i][4] = ((Product)obj[i]).getMd()+"";
			data[i][5] = ((Product)obj[i]).getEd()+"";
			data[i][6] = ((Product)obj[i]).getNoe()+"";
			data[i][7] = ((Product)obj[i]).getQuantity()+"";
		}
		return data;
	}
	public Product searchProduct(String id)
	{
		Product prd = null;
		try
		{
			dc.openConnection();
			dc.result = dc.stmt.executeQuery("select * from product where pid='"+id+"'");
			while(dc.result.next())
			{
				int pid = dc.result.getInt(1);
				String top = dc.result.getString(2);
				String pname = dc.result.getString(3);
				float price = dc.result.getFloat(4);
				String sdate = dc.result.getString(5);
				String edate = dc.result.getString(6);
				int noe = dc.result.getInt(7);
				float quantity = dc.result.getFloat(8);
				prd = new Product(pid,top,pname,price,sdate,edate,noe,quantity); 
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dc.closeConnection();
		return prd;
	}
	public void updateProduct(Product product)
	{
		try
		{
			dc.openConnection();
			dc.stmt.execute("update product set type_of_product='"+product.getTop()+"',product_name='"+product.getPname()+"',price_per_kg="+product.getPrice()+",stored_date='"+product.getMd()+"',expiry_date='"+product.getEd()+"',no_expiry="+product.getNoe()+",quantity="+product.getQuantity()+" where pid="+product.getPid()+"");
			dc.stmt.execute("update perishable_product set type_of_product='"+product.getTop()+"',product_name='"+product.getPname()+"',price_per_kg="+product.getPrice()+",stored_date='"+product.getMd()+"',expiry_date='"+product.getEd()+"',no_expiry="+product.getNoe()+",quantity="+product.getQuantity()+" where pid="+product.getPid()+"");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dc.closeConnection();
	}
	public void deleteProduct(int pid)
	{
		try
		{
			dc.openConnection();
			dc.stmt.execute("delete from product where pid='"+pid+"'");
			dc.stmt.execute("delete from perishable_product where pid='"+pid+"'");
			dc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public String[][] getPProducts()
	{
		ArrayList<Product> pd = new ArrayList<Product>();
		try 
		{
			dc.openConnection();
			dc.result = dc.stmt.executeQuery("select * from product pd where not exists(select pid,type_of_product,product_name,price_per_kg,stored_date,expiry_date,no_expiry,quantity from perishable_product where pd.pid=pid)");
			while(dc.result.next())
			{
				int pid = dc.result.getInt(1);
				String top = dc.result.getString(2);
				String pname = dc.result.getString(3);
				float price = dc.result.getFloat(4);
				String sd = dc.result.getString(5);
				String ed = dc.result.getString(6);
				int noe = dc.result.getInt(7);
				float quantity = dc.result.getFloat(8);
				Product pro =  new Product(pid,top,pname,price,sd,ed,noe,quantity);
				pd.add(pro);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dc.closeConnection();
		Object obj[] = pd.toArray();
		String data[][] = new String [pd.size()][8];
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Product)obj[i]).getPid()+"";
			data[i][1] = ((Product)obj[i]).getTop()+"";
			data[i][2] = ((Product)obj[i]).getPname()+"";
			data[i][3] = ((Product)obj[i]).getPrice()+"";
			data[i][4] = ((Product)obj[i]).getMd()+"";
			data[i][5] = ((Product)obj[i]).getEd()+"";
			data[i][6] = ((Product)obj[i]).getNoe()+"";
			data[i][7] = ((Product)obj[i]).getQuantity()+"";
		}
		return data;
	}
}
