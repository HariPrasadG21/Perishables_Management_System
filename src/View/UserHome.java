package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Model.*;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class UserHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public UserHome(Employee user) {
		setTitle("User Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 489);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton logoutbt = new JButton("Logout");
		logoutbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login();
			}
		});
		logoutbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		logoutbt.setBounds(696, 11, 89, 23);
		contentPane.add(logoutbt);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblName.setBounds(10, 11, 78, 18);
		contentPane.add(lblName);
		
		JLabel namelb = new JLabel((String) null);
		namelb.setFont(new Font("Verdana", Font.PLAIN, 12));
		namelb.setBounds(98, 11, 147, 18);
		contentPane.add(namelb);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblId.setBounds(10, 40, 78, 18);
		contentPane.add(lblId);
		
		JLabel idlb = new JLabel((String) null);
		idlb.setFont(new Font("Verdana", Font.PLAIN, 12));
		idlb.setBounds(98, 40, 147, 18);
		contentPane.add(idlb);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblAge.setBounds(10, 69, 78, 18);
		contentPane.add(lblAge);
		
		JLabel agelb = new JLabel("0");
		agelb.setFont(new Font("Verdana", Font.PLAIN, 12));
		agelb.setBounds(98, 69, 147, 18);
		contentPane.add(agelb);
		
		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPhoneNo.setBounds(10, 97, 78, 18);
		contentPane.add(lblPhoneNo);
		
		JLabel phonelb = new JLabel((String) null);
		phonelb.setFont(new Font("Verdana", Font.PLAIN, 12));
		phonelb.setBounds(98, 98, 147, 18);
		contentPane.add(phonelb);
		
		namelb.setText(user.getName());
		idlb.setText(user.getID());
		phonelb.setText(user.getPhone());
		agelb.setText(Integer.toString(user.getAge()));
		
		JButton changepasswordbt = new JButton("Change Password");
		changepasswordbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangePassword(user);
				setVisible(false);
			}
		});
		changepasswordbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		changepasswordbt.setBounds(312, 282, 212, 41);
		getContentPane().add(changepasswordbt);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setForeground(new Color(244, 164, 96));
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(312, 11, 164, 60);
		contentPane.add(lblNewLabel);
		
		JButton inventorybt = new JButton("Inventory");
		inventorybt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Inventory(user);
				setVisible(false);
			}
		});
		inventorybt.setFont(new Font("Tahoma", Font.BOLD, 12));
		inventorybt.setBounds(312, 209, 212, 41);
		contentPane.add(inventorybt);
		setVisible(true);
	}

}
