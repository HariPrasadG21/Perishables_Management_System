package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDateTime;

public class PriceController implements Runnable{
	DatabaseConnection dc = DatabaseConnection.get();
	ProductController pc = new ProductController();
	PProductController ppc = new PProductController();
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			if(dc.con==null)
			{
				String data[][] = ppc.getProducts();
				int col = data.length;
				for(int i=0;i<col;i++)
				{
					int pid = Integer.parseInt(data[i][0]);
					String top = data[i][1];
					String pname = data[i][2];
					Double price = Double.parseDouble(data[i][3]);
					String md = data[i][4].replace(' ','T');
					String ed = data[i][5].replace(' ','T');
					Double noexp = Double.parseDouble(data[i][6]);
					float quantity = Float.parseFloat(data[i][7]);
					double dec = Double.parseDouble(data[i][8]);
					LocalDateTime dateBefore = LocalDateTime.now();
					LocalDateTime dateAfter =  LocalDateTime.parse(ed);
					Double noOfHours = (double) Duration.between(dateBefore, dateAfter).toHours();
					if(noOfHours<noexp)
					{
						try
						{
							dc.openConnection();
							double ded = price - ((noexp-noOfHours)*(dec/100) * price);
							float decr = (float) ded;
							dc.stmt.executeUpdate("update perishable_product set price_per_kg='"+decr+"' where pid='"+pid+"'");
							dc.stmt.executeUpdate("update product set price_per_kg='"+decr+"' where pid='"+pid+"'");
							dc.closeConnection();
						}
						catch(Exception e)
						{
							System.out.println(e.getMessage());
						}
					}
				}
				try
				{
					Thread.sleep(10000);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				dc.closeConnection();
			}
		}
	}
}
