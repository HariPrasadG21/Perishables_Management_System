package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Employee;
import Model.PerishableProduct;

public class PProductController 
{
	Connection con;
	private PerishableProduct product;
	private Statement stmt;
	private ResultSet result;
	DatabaseConnection dc = DatabaseConnection.get();
	public String[][] getProducts()
	{
		ArrayList<PerishableProduct> pd = new ArrayList<PerishableProduct>();
		try 
		{
			dc.openConnection();
			dc.result = dc.stmt.executeQuery("select * from perishable_product");
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
				double dp = dc.result.getDouble(9);
				PerishableProduct pro =  new PerishableProduct(pid,top,pname,price,sd,ed,noe,quantity,dp);
				pd.add(pro);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dc.closeConnection();
		Object obj[] = pd.toArray();
		String data[][] = new String [pd.size()][9];
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((PerishableProduct)obj[i]).getPid()+"";
			data[i][1] = ((PerishableProduct)obj[i]).getTop()+"";
			data[i][2] = ((PerishableProduct)obj[i]).getPname()+"";
			data[i][3] = ((PerishableProduct)obj[i]).getPrice()+"";
			data[i][4] = ((PerishableProduct)obj[i]).getMd()+"";
			data[i][5] = ((PerishableProduct)obj[i]).getEd()+"";
			data[i][6] = ((PerishableProduct)obj[i]).getNoe()+"";
			data[i][7] = ((PerishableProduct)obj[i]).getQuantity()+"";
			data[i][8] = ((PerishableProduct)obj[i]).getDp()+"";
		}
		return data;
	}
	public void addProduct(PerishableProduct product)
	{
		try
		{
			dc.openConnection();
			dc.stmt.execute("update product set type_of_product='"+product.getTop()+"',product_name='"+product.getPname()+"',price_per_kg="+product.getPrice()+",stored_date='"+product.getMd()+"',expiry_date='"+product.getEd()+"',no_expiry="+product.getNoe()+",quantity="+product.getQuantity()+" where pid="+product.getPid()+"");
			dc.stmt.executeUpdate("insert into perishable_product(pid,type_of_product,product_name,price_per_kg,stored_date,expiry_date,no_expiry,quantity,decrease_p) values('"+product.getPid()+"','"+product.getTop()+"','"+product.getPname()+"','"+product.getPrice()+"','"+product.getMd()+"','"+product.getEd()+"','"+product.getNoe()+"','"+product.getQuantity()+"','"+product.getDp()+"')");
			dc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
	public String[][] searchProducts(String product)
	{
		ArrayList<PerishableProduct> pd = new ArrayList<PerishableProduct>();
		try 
		{
			dc.openConnection();
			dc.result = dc.stmt.executeQuery("select * from perishable_product where product_name='"+product+"'");
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
				double dp = dc.result.getDouble(9);
				PerishableProduct pro =  new PerishableProduct(pid,top,pname,price,sd,ed,noe,quantity,dp);
				pd.add(pro);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dc.closeConnection();
		Object obj[] = pd.toArray();
		String data[][] = new String [pd.size()][9];
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((PerishableProduct)obj[i]).getPid()+"";
			data[i][1] = ((PerishableProduct)obj[i]).getTop()+"";
			data[i][2] = ((PerishableProduct)obj[i]).getPname()+"";
			data[i][3] = ((PerishableProduct)obj[i]).getPrice()+"";
			data[i][4] = ((PerishableProduct)obj[i]).getMd()+"";
			data[i][5] = ((PerishableProduct)obj[i]).getEd()+"";
			data[i][6] = ((PerishableProduct)obj[i]).getNoe()+"";
			data[i][7] = ((PerishableProduct)obj[i]).getQuantity()+"";
			data[i][8] = ((PerishableProduct)obj[i]).getDp()+"";
		}
		return data;
	}
	public PerishableProduct searchProduct(String id)
	{
		PerishableProduct prd = null;
		try
		{
			dc.openConnection();
			dc.result = dc.stmt.executeQuery("select * from perishable_product where pid='"+id+"'");
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
				double dp = dc.result.getDouble(9);
				prd = new PerishableProduct(pid,top,pname,price,sdate,edate,noe,quantity,dp); 
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dc.closeConnection();
		return prd;
	}
	public void updateProduct(PerishableProduct product)
	{
		try
		{
			dc.openConnection();
			dc.stmt.execute("update product set type_of_product='"+product.getTop()+"',product_name='"+product.getPname()+"',price_per_kg="+product.getPrice()+",stored_date='"+product.getMd()+"',expiry_date='"+product.getEd()+"',no_expiry="+product.getNoe()+",quantity="+product.getQuantity()+" where pid="+product.getPid()+"");
			dc.stmt.execute("update perishable_product set type_of_product='"+product.getTop()+"',product_name='"+product.getPname()+"',price_per_kg="+product.getPrice()+",stored_date='"+product.getMd()+"',expiry_date='"+product.getEd()+"',no_expiry="+product.getNoe()+",quantity="+product.getQuantity()+",decrease_p="+product.getDp()+" where pid="+product.getPid()+"");
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
			dc.stmt.execute("delete from perishable_product where pid='"+pid+"'");
			dc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
