import View.*;
import Controller.*;

public class Main{
	public static void main(String[] args) throws InterruptedException {
		PriceController pc = new PriceController();
		Thread t1 = new Thread(pc);
		ThreadController tc = new ThreadController();
		Thread t = new Thread(tc);
		t.start();
		t1.start();
		Login login = new Login();
	}
}