package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import Model.*;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;

import com.itextpdf.awt.geom.Dimension;

import Controller.*;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.time.*;
public class Inventory {

	private JFrame frmInventory;
	private JTextField storeddate;
	private JTextField expirydate;
	private JTextField productid;
	ProductController pd = new ProductController();
	PProductController ppd = new PProductController();
	private JTextField dp;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	Product pdl = null;
	public Inventory(Employee user) {
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frmInventory = new JFrame();
		frmInventory.setTitle("Inventory Admin");
		frmInventory.getContentPane().setBackground(new Color(153, 204, 204));
		frmInventory.setBounds(100, 100, 1479, 784);
		frmInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventory.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1465, 61);
		panel.setBackground(new Color(3, 124, 124));
		panel.setForeground(new Color(3, 124, 124));
		frmInventory.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inventory");
		lblNewLabel.setForeground(new Color(128, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(174, 11, 925, 39);
		panel.add(lblNewLabel);
		
		JButton backbt = new JButton("Back");
		backbt.setBounds(1334, 11, 121, 23);
		panel.add(backbt);
		backbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminHome(user);
				frmInventory.setVisible(false);
			}
		});
		backbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton deletebt = new JButton("Delete Product");
		deletebt.setFont(new Font("Tahoma", Font.BOLD, 12));
		deletebt.setBounds(223, 578, 135, 33);
		frmInventory.getContentPane().add(deletebt);
		deletebt.setEnabled(false);
		
		JComboBox typesb = new JComboBox();
		typesb.setModel(new DefaultComboBoxModel(new String[] {"Select", "Fruit", "Vegetable"}));
		typesb.setToolTipText("");
		typesb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		typesb.setBounds(194, 112, 137, 22);
		frmInventory.getContentPane().add(typesb);
		
		JLabel lblNewLabel_1_1 = new JLabel("Add/Update Product");
		lblNewLabel_1_1.setForeground(new Color(128, 0, 64));
		lblNewLabel_1_1.setBackground(new Color(128, 0, 64));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1.setBounds(70, 72, 201, 23);
		frmInventory.getContentPane().add(lblNewLabel_1_1);
		
		
		
		JComboBox<?> namesb = new JComboBox();
		namesb.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		namesb.setToolTipText("");
		namesb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		namesb.setBounds(194, 158, 137, 22);
		frmInventory.getContentPane().add(namesb);
		
		typesb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String top = (String) typesb.getSelectedItem();
				if(top.equals("Fruit"))
				{
					namesb.setModel(new DefaultComboBoxModel(new String[] {"Select", "Apples", "Bananas", "Oranges", "Grapes", "Strawberries", "Blueberries", "Raspberries", "Mangoes", "Pineapples", "Papayas", "Kiwis", "Peaches", "Plums", "Cherries", "Pears", "Watermelons", "Cantaloupes", "Honeydews", "Lemons", "Limes", "Grapefruits", "Avocados"}));
				}
				else if(top.equals("Vegetable"))
				{
					namesb.setModel(new DefaultComboBoxModel(new String[] {"Select", "Carrots", "Broccoli", "Cauliflower", "Spinach", "Lettuce", "Cucumbers", "Tomatoes", "Peppers (bell peppers, jalapenos, etc.)", "Onions", "Garlic", "Green beans", "Peas", "Corn", "Potatoes", "Sweet potatoes", "Squash (zucchini, butternut squash, etc.)", "Eggplant", "Asparagus", "Brussels sprouts", "Cabbage", "Celery", "Radishes", "Beets", "Artichokes", "Mushrooms"}));
				}
				else
				{
					namesb.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
				}
			}
		});
		
		JLabel lblNewLabel_1_2 = new JLabel("Type");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_2.setBounds(35, 112, 61, 23);
		frmInventory.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Name");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_2_1.setBounds(35, 158, 61, 23);
		frmInventory.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Quantity (Kg)");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_2_1_1.setBounds(23, 201, 100, 23);
		frmInventory.getContentPane().add(lblNewLabel_1_2_1_1);
		
        JTextField quantity = new JTextField();
		quantity.setBounds(194, 203, 137, 20);
		frmInventory.getContentPane().add(quantity);
		
		storeddate = new JTextField();
		storeddate.setToolTipText("YYYY-MM-DD hh:mm:ss");
		storeddate.setBounds(194, 254, 137, 20);
		frmInventory.getContentPane().add(storeddate);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Stored Date & Time");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_2_1_1_1.setBounds(23, 252, 135, 23);
		frmInventory.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		expirydate = new JTextField();
		expirydate.setToolTipText("YYYY-MM-DD hh:mm:ss");
		expirydate.setBounds(194, 299, 137, 20);
		frmInventory.getContentPane().add(expirydate);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Expiry Date & Time");
		lblNewLabel_1_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_2_1_1_1_1.setBounds(23, 297, 135, 23);
		frmInventory.getContentPane().add(lblNewLabel_1_2_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1 = new JLabel("Price");
		lblNewLabel_1_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_2_1_1_1_1_1.setBounds(23, 345, 100, 23);
		frmInventory.getContentPane().add(lblNewLabel_1_2_1_1_1_1_1);
		
		JTextField price = new JTextField();
		price.setBounds(194, 347, 137, 20);
		frmInventory.getContentPane().add(price);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1_1 = new JLabel("Number of Hours for trigger of price update");
		lblNewLabel_1_2_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_2_1_1_1_1_1_1.setBounds(23, 398, 340, 22);
		frmInventory.getContentPane().add(lblNewLabel_1_2_1_1_1_1_1_1);
		
		JTextField no_expiry = new JTextField();
		no_expiry.setBounds(135, 431, 137, 20);
		frmInventory.getContentPane().add(no_expiry);
		
		productid = new JTextField();
		productid.setBounds(103, 547, 96, 20);
		frmInventory.getContentPane().add(productid);
		productid.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1_1_1 = new JLabel("Enter Product id to update or delete or add to perishables");
		lblNewLabel_1_2_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_2_1_1_1_1_1_1_1.setBounds(23, 514, 396, 22);
		frmInventory.getContentPane().add(lblNewLabel_1_2_1_1_1_1_1_1_1);
		
		String dataM[][] = pd.getProducts();
		String headM[] = {"Product ID","Type of Product","Product Name","Price","Stored Date","Expiry Date","Trigger","Quantity"};
		JTable produtTable = new JTable(dataM,headM);
		JScrollPane productTableSP = new JScrollPane(produtTable);
		productTableSP.setBounds(470, 100, 985, 299);
		frmInventory.getContentPane().add(productTableSP);
		JButton addbt = new JButton("Add Product");
		addbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typesb.getSelectedItem().equals("Select") || namesb.getSelectedItem().equals("Select") || quantity.getText().equalsIgnoreCase("")  || storeddate.getText().equalsIgnoreCase("") || expirydate.getText().equalsIgnoreCase("") || price.getText().equalsIgnoreCase("") || no_expiry.getText().equalsIgnoreCase(""))
				{
					JOptionPane.showMessageDialog(addbt,"Empty Text Field!!","Error",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					String top = (String) typesb.getSelectedItem();
					String name = (String) namesb.getSelectedItem();
					float quantity1 = Float.parseFloat(quantity.getText());
					String sd = storeddate.getText().replace(' ','T');;
					String ed = expirydate.getText().replace(' ','T');;;
					float price1 = Float.parseFloat(price.getText());
					int noe1 = Integer.parseInt(no_expiry.getText());
					LocalDateTime sdateTime = LocalDateTime.parse(sd);
					LocalDateTime edateTime = LocalDateTime.parse(ed);
					if(sdateTime.isAfter(edateTime) || sdateTime.isEqual(edateTime))
					{
						JOptionPane.showMessageDialog(addbt,"Dates are equal or not valid","Error",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						Product product = new Product(top,name,price1,sd,ed,noe1,quantity1);
						pd.addProduct(product);
						String dataM[][] = pd.getProducts();
						frmInventory.getContentPane().remove(productTableSP);
						JTable productTable1 = new JTable(dataM,headM);
						productTable1.setEnabled(false);
						JScrollPane productTableSP1 = new JScrollPane(productTable1);
						productTableSP1.setBounds(470, 100, 985, 299);
						frmInventory.getContentPane().add(productTableSP1);
					}
				}
			}
		});
		addbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		addbt.setBounds(145, 462, 121, 33);
		frmInventory.getContentPane().add(addbt);
		
		
		
		JComboBox typesb_1 = new JComboBox();
		typesb_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Fruit", "Vegetable"}));
		typesb_1.setToolTipText("");
		typesb_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		typesb_1.setBounds(910, 72, 137, 22);
		frmInventory.getContentPane().add(typesb_1);
		
		
		JComboBox namesb_1 = new JComboBox();
		namesb_1.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		namesb_1.setToolTipText("");
		namesb_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		namesb_1.setBounds(1057, 72, 137, 22);
		frmInventory.getContentPane().add(namesb_1);
		typesb_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String top = (String) typesb_1.getSelectedItem();
				if(top.equals("Fruit"))
				{
					namesb_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Apples", "Bananas", "Oranges", "Grapes", "Strawberries", "Blueberries", "Raspberries", "Mangoes", "Pineapples", "Papayas", "Kiwis", "Peaches", "Plums", "Cherries", "Pears", "Watermelons", "Cantaloupes", "Honeydews", "Lemons", "Limes", "Grapefruits", "Avocados"}));
				}
				else if(top.equals("Vegetable"))
				{
					namesb_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Carrots", "Broccoli", "Cauliflower", "Spinach", "Lettuce", "Cucumbers", "Tomatoes", "Peppers (bell peppers, jalapenos, etc.)", "Onions", "Garlic", "Green beans", "Peas", "Corn", "Potatoes", "Sweet potatoes", "Squash (zucchini, butternut squash, etc.)", "Eggplant", "Asparagus", "Brussels sprouts", "Cabbage", "Celery", "Radishes", "Beets", "Artichokes", "Mushrooms"}));
				}
				else
				{
					namesb_1.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
				}
			}
		});
		
		JButton searchbt = new JButton("Search");
		searchbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String) namesb_1.getSelectedItem();
				String dataM[][] = pd.searchProducts(name);
				frmInventory.getContentPane().remove(productTableSP);
				JTable productTable1 = new JTable(dataM,headM);
				productTable1.setEnabled(false);
				JScrollPane productTableSP1 = new JScrollPane(productTable1);
				productTableSP1.setBounds(470, 100, 985, 299);
				frmInventory.getContentPane().add(productTableSP1);
				searchbt.revalidate();
				searchbt.repaint();
			}
		});
		searchbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchbt.setBounds(1215, 72, 89, 23);
		frmInventory.getContentPane().add(searchbt);
		
		JButton showallbt = new JButton("Show All");
		showallbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dataM[][] = pd.getProducts();
				frmInventory.getContentPane().remove(productTableSP);
				JTable productTable1 = new JTable(dataM,headM);
				productTable1.setEnabled(false);
				JScrollPane productTableSP1 = new JScrollPane(productTable1);
				productTableSP1.setBounds(470, 100, 985, 299);
				frmInventory.getContentPane().add(productTableSP1);
				searchbt.revalidate();
				searchbt.repaint();
			}
		});
		
		JButton updatebt = new JButton("Update Product");
		updatebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typesb.getSelectedItem().equals("Select") || namesb.getSelectedItem().equals("Select") || quantity.getText().equalsIgnoreCase("")  || storeddate.getText().equalsIgnoreCase("") || expirydate.getText().equalsIgnoreCase("") || price.getText().equalsIgnoreCase("") || no_expiry.getText().equalsIgnoreCase(""))
				{
					JOptionPane.showMessageDialog(addbt,"Empty Text Field!!","Error",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					int id = Integer.parseInt(productid.getText());
					String top = (String) typesb.getSelectedItem();
					String name = (String) namesb.getSelectedItem();
					float quantity1 = Float.parseFloat(quantity.getText());
					String sd = storeddate.getText().replace(' ','T');;;
					String ed = expirydate.getText().replace(' ','T');;;
					float price1 = Float.parseFloat(price.getText());
					int noe1 = Integer.parseInt(no_expiry.getText());
					LocalDateTime sdateTime = LocalDateTime.parse(sd);
					LocalDateTime edateTime = LocalDateTime.parse(ed);
					if(sdateTime.isAfter(edateTime) || sdateTime.isEqual(edateTime))
					{
						JOptionPane.showMessageDialog(addbt,"Dates are equal or not valid","Error",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						Product product = new Product(id,top,name,price1,sd,ed,noe1,quantity1);
						pd.updateProduct(product);
						String dataM[][] = pd.getProducts();
						frmInventory.getContentPane().remove(productTableSP);
						JTable productTable1 = new JTable(dataM,headM);
						productTable1.setEnabled(false);
						JScrollPane productTableSP1 = new JScrollPane(productTable1);
						productTableSP1.setBounds(470, 100, 985, 299);
						frmInventory.getContentPane().add(productTableSP1);
						updatebt.setEnabled(false);
						deletebt.setEnabled(false);
					}
				}
			}
		});
		updatebt.setFont(new Font("Tahoma", Font.BOLD, 12));
		updatebt.setBounds(35, 578, 161, 33);
		frmInventory.getContentPane().add(updatebt);
		updatebt.setEnabled(false);
		
		showallbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		showallbt.setBounds(1314, 72, 121, 23);
		frmInventory.getContentPane().add(showallbt);
		JButton loadbt = new JButton("Load");
		loadbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(productid.getText().equals(""))
				{
					JOptionPane.showMessageDialog(loadbt,"Product ID Required","WARNING",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					Product pdr = pd.searchProduct(productid.getText());
					PerishableProduct pdf = ppd.searchProduct(productid.getText());
					if(pdr==null)
					{
						JOptionPane.showMessageDialog(loadbt,"No product of this id","warning",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						typesb.setSelectedItem(pdr.getTop());
						if(pdr.getTop().equals("Fruit"))
						{
							namesb.setModel(new DefaultComboBoxModel(new String[] {"Select", "Apples", "Bananas", "Oranges", "Grapes", "Strawberries", "Blueberries", "Raspberries", "Mangoes", "Pineapples", "Papayas", "Kiwis", "Peaches", "Plums", "Cherries", "Pears", "Watermelons", "Cantaloupes", "Honeydews", "Lemons", "Limes", "Grapefruits", "Avocados"}));
						}
						else
						{
							namesb_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Carrots", "Broccoli", "Cauliflower", "Spinach", "Lettuce", "Cucumbers", "Tomatoes", "Peppers (bell peppers, jalapenos, etc.)", "Onions", "Garlic", "Green beans", "Peas", "Corn", "Potatoes", "Sweet potatoes", "Squash (zucchini, butternut squash, etc.)", "Eggplant", "Asparagus", "Brussels sprouts", "Cabbage", "Celery", "Radishes", "Beets", "Artichokes", "Mushrooms"}));
						}
						namesb.setSelectedItem(pdr.getPname());
						quantity.setText(Float.toString(pdr.getQuantity()));
						price.setText(Float.toString(pdr.getPrice()));
						storeddate.setText(pdr.getMd());
						expirydate.setText(pdr.getEd());
						no_expiry.setText(Integer.toString(pdr.getNoe()));
						if(pdf!=null)
						{
							dp.setText(Double.toString(pdf.getDp()));
						}
						deletebt.setEnabled(true);
						updatebt.setEnabled(true);
						dp.enable(true);
						pdl=pdr;
					}
				}
			}
		});
		loadbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		loadbt.setBounds(223, 545, 100, 22);
		deletebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pid = Integer.parseInt(productid.getText());
				pd.deleteProduct(pid);
				JOptionPane.showMessageDialog(deletebt,"Product Removed Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
				String dataM[][] = pd.getProducts();
				frmInventory.getContentPane().remove(productTableSP);
				JTable productTable1 = new JTable(dataM,headM);
				productTable1.setEnabled(false);
				JScrollPane productTableSP1 = new JScrollPane(productTable1);
				productTableSP1.setBounds(470, 100, 985, 299);
				frmInventory.getContentPane().add(productTableSP1);
				updatebt.setEnabled(false);
				deletebt.setEnabled(false);
			}
		});
		frmInventory.getContentPane().add(loadbt);
		
		String datapM[][] = ppd.getProducts();
		String headpM[] = {"Product ID","Type of Product","Product Name","Price","Stored Date","Expiry Date","Trigger","Quantity","Decrease Percentage"};
		JTable pproductTable = new JTable(datapM,headpM);
		JScrollPane perishableTableSP = new JScrollPane(pproductTable);
		perishableTableSP.setBounds(470, 484, 985, 244);
		frmInventory.getContentPane().add(perishableTableSP);
		
		JButton addpbt = new JButton("Add to Perishables");
		addpbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typesb.getSelectedItem().equals("Select") || namesb.getSelectedItem().equals("Select") || quantity.getText().equalsIgnoreCase("")  || storeddate.getText().equalsIgnoreCase("") || expirydate.getText().equalsIgnoreCase("") || price.getText().equalsIgnoreCase("") || no_expiry.getText().equalsIgnoreCase("") || dp.getText().equals(""))
				{
					JOptionPane.showMessageDialog(addbt,"Empty Text Field!!","Error",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					String top = (String) typesb.getSelectedItem();
					String name = (String) namesb.getSelectedItem();
					float quantity1 = Float.parseFloat(quantity.getText());
					String sd = storeddate.getText().replace(' ','T');;;
					String ed = expirydate.getText().replace(' ','T');;;
					float price1 = Float.parseFloat(price.getText());
					int noe1 = Integer.parseInt(no_expiry.getText());
					LocalDateTime sdateTime = LocalDateTime.parse(sd);
					LocalDateTime edateTime = LocalDateTime.parse(ed);
					double dps = Double.parseDouble(dp.getText());
					if(sdateTime.isAfter(edateTime) || sdateTime.isEqual(edateTime))
					{
						JOptionPane.showMessageDialog(addbt,"Dates are equal or not valid","Error",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						int pid = pdl.getPid();
						PerishableProduct product = new PerishableProduct(pid,top,name,price1,sd,ed,noe1,quantity1,dps);
						ppd.addProduct(product);
						String datapM[][] = ppd.getProducts();
						frmInventory.getContentPane().remove(perishableTableSP);
						JTable productTable1 = new JTable(datapM,headpM);
						productTable1.setEnabled(false);
						JScrollPane productTableSP1 = new JScrollPane(productTable1);
						productTableSP1.setBounds(470, 484, 985, 244);
						frmInventory.getContentPane().add(productTableSP1);
						searchbt.revalidate();
						searchbt.repaint();
					}
				}
			}
		});
		addpbt.setEnabled(false);
		addpbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		addpbt.setBounds(35, 695, 167, 33);
		frmInventory.getContentPane().add(addpbt);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Products");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setForeground(new Color(128, 0, 64));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1_1.setBackground(new Color(128, 0, 64));
		lblNewLabel_1_1_1.setBounds(470, 66, 201, 23);
		frmInventory.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Perishable Products");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setForeground(new Color(128, 0, 64));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1_1_1.setBackground(new Color(128, 0, 64));
		lblNewLabel_1_1_1_1.setBounds(470, 434, 201, 23);
		frmInventory.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JButton updatepbt = new JButton("Update to Perishables");
		updatepbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typesb.getSelectedItem().equals("Select") || namesb.getSelectedItem().equals("Select") || quantity.getText().equalsIgnoreCase("")  || storeddate.getText().equalsIgnoreCase("") || expirydate.getText().equalsIgnoreCase("") || price.getText().equalsIgnoreCase("") || no_expiry.getText().equalsIgnoreCase("") || dp.getText().equals(""))
				{
					JOptionPane.showMessageDialog(addbt,"Empty Text Field!!","Error",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					String top = (String) typesb.getSelectedItem();
					String name = (String) namesb.getSelectedItem();
					float quantity1 = Float.parseFloat(quantity.getText());
					String sd = storeddate.getText().replace(' ','T');;;
					String ed = expirydate.getText().replace(' ','T');;;
					float price1 = Float.parseFloat(price.getText());
					int noe1 = Integer.parseInt(no_expiry.getText());
					LocalDateTime sdateTime = LocalDateTime.parse(sd);
					LocalDateTime edateTime = LocalDateTime.parse(ed);
					double dps = Double.parseDouble(dp.getText());
					if(sdateTime.isAfter(edateTime) || sdateTime.isEqual(edateTime))
					{
						JOptionPane.showMessageDialog(addbt,"Dates are equal or not valid","Error",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						int pid = pdl.getPid();
						PerishableProduct product = new PerishableProduct(pid,top,name,price1,sd,ed,noe1,quantity1,dps);
						ppd.updateProduct(product);
						String datapM[][] = ppd.getProducts();
						frmInventory.getContentPane().remove(perishableTableSP);
						JTable productTable1 = new JTable(datapM,headpM);
						productTable1.setEnabled(false);
						JScrollPane productTableSP1 = new JScrollPane(productTable1);
						productTableSP1.setBounds(470, 484, 985, 244);
						frmInventory.getContentPane().add(productTableSP1);
						updatepbt.setEnabled(false);
						addpbt.setEnabled(false);
					}
				}
			}
		});
		updatepbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		updatepbt.setEnabled(false);
		updatepbt.setBounds(223, 695, 167, 33);
		frmInventory.getContentPane().add(updatepbt);
		
		JComboBox typepsb = new JComboBox();
		typepsb.setModel(new DefaultComboBoxModel(new String[] {"Select", "Fruit", "Vegetable"}));
		typepsb.setToolTipText("");
		typepsb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		typepsb.setBounds(910, 451, 137, 22);
		frmInventory.getContentPane().add(typepsb);
		
		JComboBox namepsb = new JComboBox();
		namepsb.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		namepsb.setToolTipText("");
		namepsb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		namepsb.setBounds(1057, 451, 137, 22);
		frmInventory.getContentPane().add(namepsb);
		typepsb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String top = (String) typepsb.getSelectedItem();
				if(top.equals("Fruit"))
				{
					namesb_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Apples", "Bananas", "Oranges", "Grapes", "Strawberries", "Blueberries", "Raspberries", "Mangoes", "Pineapples", "Papayas", "Kiwis", "Peaches", "Plums", "Cherries", "Pears", "Watermelons", "Cantaloupes", "Honeydews", "Lemons", "Limes", "Grapefruits", "Avocados"}));
				}
				else if(top.equals("Vegetable"))
				{
					namesb_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Carrots", "Broccoli", "Cauliflower", "Spinach", "Lettuce", "Cucumbers", "Tomatoes", "Peppers (bell peppers, jalapenos, etc.)", "Onions", "Garlic", "Green beans", "Peas", "Corn", "Potatoes", "Sweet potatoes", "Squash (zucchini, butternut squash, etc.)", "Eggplant", "Asparagus", "Brussels sprouts", "Cabbage", "Celery", "Radishes", "Beets", "Artichokes", "Mushrooms"}));
				}
				else
				{
					namesb_1.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
				}
			}
		});
		
		JButton searchpbt = new JButton("Search");
		searchpbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String) namepsb.getSelectedItem();
				String datapM[][] = ppd.searchProducts(name);
				frmInventory.getContentPane().remove(perishableTableSP);
				JTable productTable1 = new JTable(datapM,headpM);
				productTable1.setEnabled(false);
				JScrollPane productTableSP1 = new JScrollPane(productTable1);
				productTableSP1.setBounds(470, 484, 985, 244);
				frmInventory.getContentPane().add(productTableSP1);
				searchbt.revalidate();
				searchbt.repaint();
			}
		});
		searchpbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchpbt.setBounds(1215, 450, 89, 23);
		frmInventory.getContentPane().add(searchpbt);
		
		JButton showallpbt = new JButton("Show All");
		showallpbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String datapM[][] = ppd.getProducts();
				frmInventory.getContentPane().remove(perishableTableSP);
				JTable productTable1 = new JTable(datapM,headpM);
				productTable1.setEnabled(false);
				JScrollPane productTableSP1 = new JScrollPane(productTable1);
				productTableSP1.setBounds(470, 484, 985, 244);
				frmInventory.getContentPane().add(productTableSP1);
				searchbt.revalidate();
				searchbt.repaint();
			}
		});
		showallpbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		showallpbt.setBounds(1314, 450, 121, 23);
		frmInventory.getContentPane().add(showallpbt);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1_1_2 = new JLabel("Enter Decrease Percentage per hour");
		lblNewLabel_1_2_1_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_2_1_1_1_1_1_1_2.setBounds(18, 632, 401, 22);
		frmInventory.getContentPane().add(lblNewLabel_1_2_1_1_1_1_1_1_2);
		
		dp = new JTextField();
		dp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addpbt.setEnabled(true);
				updatepbt.setEnabled(true);
			}
		});
		dp.setEnabled(false);
		dp.setColumns(10);
		dp.setBounds(159, 665, 96, 20);
		frmInventory.getContentPane().add(dp);
		frmInventory.setVisible(true);
	}
}
