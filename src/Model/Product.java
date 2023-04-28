package Model;

public class Product 
{
	private int pid;
	private String top;
	private String pname;
	private float price;
	private String md;
	private String ed;
	private int noe;
	private float quantity;
	public Product(int pid, String top, String pname, float price, String md, String ed, int noe, float quantity) {
	    this.pid = pid;
	    this.top = top;
	    this.pname = pname;
	    this.price = price;
	    this.md = md;
	    this.ed = ed;
	    this.noe = noe;
	    this.quantity = quantity;
	}
	public Product(String top, String pname, float price, String md, String ed, int noe, float quantity) {
	    this.top = top;
	    this.pname = pname;
	    this.price = price;
	    this.md = md;
	    this.ed = ed;
	    this.noe = noe;
	    this.quantity = quantity;
	}
	public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getEd() {
        return ed;
    }

    public void setEd(String ed) {
        this.ed = ed;
    }

    public int getNoe() {
        return noe;
    }

    public void setNoe(int noe) {
        this.noe = noe;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
