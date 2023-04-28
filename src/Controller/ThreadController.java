package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDateTime;

public class ThreadController implements Runnable{

	DatabaseConnection dc = DatabaseConnection.get();
	ProductController pc = new ProductController();
	PProductController ppc = new PProductController();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			if(dc.con==null)
			{
				String data[][] = pc.getPProducts();
				int col = data.length;
				for(int i=0;i<col;i++)
				{
					int pid = Integer.parseInt(data[i][0]);
					String top = data[i][1];
					String pname = data[i][2];
					float price = Float.parseFloat(data[i][3]);
					String md = data[i][4].replace(' ','T');
					String ed = data[i][5].replace(' ','T');
					int noexp = Integer.parseInt(data[i][6]);
					float quantity = Float.parseFloat(data[i][7]);
					LocalDateTime dateBefore = LocalDateTime.now();
					LocalDateTime dateAfter =  LocalDateTime.parse(ed);
					dc.openConnection();
					boolean before = dateBefore.isAfter(dateAfter);
					int noOfHours = (int) Duration.between(dateBefore, dateAfter).toHours();
					if(before==true)
					{
						try {
							dc.stmt.execute("delete from product where pid='"+pid+"'");
							dc.stmt.execute("delete from perishable_product where pid='"+pid+"'");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(noOfHours<=noexp)
					{
						try
						{
							dc.stmt.execute("insert into perishable_product(pid,type_of_product,product_name,price_per_kg,stored_date,expiry_date,no_expiry,quantity,decrease_p) values('"+pid+"','"+top+"','"+pname+"','"+price+"','"+md+"','"+ed+"','"+noexp+"','"+quantity+"','0.05')");
						}
						catch(Exception e)
						{
							System.out.println(e.getMessage());
						}
					}
					dc.closeConnection();
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
