package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Model.*
;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
public class AdminHome {

	private JFrame frmAdminHome;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public AdminHome(Employee user) {
		frmAdminHome = new JFrame();
		frmAdminHome.setTitle("Admin Home");
		frmAdminHome.getContentPane().setBackground(new Color(204, 204, 255));
		frmAdminHome.getContentPane().setLayout(null);
		
		JButton logoutbt = new JButton("Logout");
		logoutbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminHome.setVisible(false);
				new Login();
			}
		});
		logoutbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		logoutbt.setBounds(656, 10, 89, 23);
		frmAdminHome.getContentPane().add(logoutbt);
		
		JButton employeebt = new JButton("Employee Management");
		employeebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManageEmployee(user);
				frmAdminHome.setVisible(false);
			}
		});
		employeebt.setFont(new Font("Tahoma", Font.BOLD, 12));
		employeebt.setBounds(236, 188, 212, 41);
		frmAdminHome.getContentPane().add(employeebt);
		
		JButton inventorybt = new JButton("Inventory");
		inventorybt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Inventory(user);
				frmAdminHome.setVisible(false);
			}
		});
		inventorybt.setFont(new Font("Tahoma", Font.BOLD, 12));
		inventorybt.setBounds(236, 259, 212, 41);
		frmAdminHome.getContentPane().add(inventorybt);
		
		JButton changepasswordbt = new JButton("Change Password");
		changepasswordbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangePassword(user);
				frmAdminHome.setVisible(false);
			}
		});
		changepasswordbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		changepasswordbt.setBounds(236, 330, 212, 41);
		frmAdminHome.getContentPane().add(changepasswordbt);
		
		JLabel namelb = new JLabel("Name");
		namelb.setFont(new Font("Verdana", Font.PLAIN, 12));
		namelb.setBounds(96, 12, 147, 18);
		frmAdminHome.getContentPane().add(namelb);
		
		JLabel idlb = new JLabel("ID");
		idlb.setFont(new Font("Verdana", Font.PLAIN, 12));
		idlb.setBounds(96, 29, 147, 18);
		frmAdminHome.getContentPane().add(idlb);
		
		JLabel phonelb = new JLabel("Contact");
		phonelb.setFont(new Font("Verdana", Font.PLAIN, 12));
		phonelb.setBounds(96, 71, 147, 18);
		frmAdminHome.getContentPane().add(phonelb);
		
		JLabel agelb = new JLabel("Age");
		agelb.setFont(new Font("Verdana", Font.PLAIN, 12));
		agelb.setBounds(96, 51, 147, 18);
		frmAdminHome.getContentPane().add(agelb);
		frmAdminHome.setBounds(100, 100, 789, 505);
		frmAdminHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminHome.setVisible(true);
		namelb.setText(user.getName());
		idlb.setText(user.getID());
		phonelb.setText(user.getPhone());
		agelb.setText(Integer.toString(user.getAge()));
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblName.setBounds(10, 13, 78, 18);
		frmAdminHome.getContentPane().add(lblName);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblId.setBounds(10, 32, 78, 18);
		frmAdminHome.getContentPane().add(lblId);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblAge.setBounds(8, 51, 78, 18);
		frmAdminHome.getContentPane().add(lblAge);
		
		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPhoneNo.setBounds(8, 71, 78, 18);
		frmAdminHome.getContentPane().add(lblPhoneNo);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setForeground(new Color(204, 255, 204));
		lblNewLabel.setBackground(new Color(204, 255, 204));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(234, 15, 234, 74);
		frmAdminHome.getContentPane().add(lblNewLabel);
	}
}
