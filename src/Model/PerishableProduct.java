package Model;

public class PerishableProduct extends Product{
	
	private double dp;
	public PerishableProduct(int pid, String top, String pname, float price, String md, String ed, int noe,
			float quantity,double dp) {
		super(pid, top, pname, price, md, ed, noe, quantity);
		this.dp=dp;
	}
	public double getDp()
	{	
		return dp;
	}
	public void setDp(double dp)
	{
		this.dp=dp;
	}
}
