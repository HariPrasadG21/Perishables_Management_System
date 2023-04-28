package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.*;
import Model.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField oldpassword;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	EmployeeController pr = new EmployeeController();
	public ChangePassword(Employee user) {
		setTitle("Change Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Old Password:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(107, 79, 117, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterNewPassword = new JLabel("Enter New Password:");
		lblEnterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEnterNewPassword.setBounds(107, 119, 117, 14);
		contentPane.add(lblEnterNewPassword);
		
		JButton backbt = new JButton("Back");
		backbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminHome(user);
				setVisible(false);
			}
		});
		backbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		backbt.setBounds(480, 11, 89, 23);
		contentPane.add(backbt);
		
		oldpassword = new JPasswordField();
		oldpassword.setBounds(254, 77, 129, 20);
		contentPane.add(oldpassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(254, 117, 129, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				oldpassword.setEchoChar((char)0);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				oldpassword.setEchoChar('*');
			}
		});
		btnNewButton.setBounds(420, 76, 71, 17);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Show");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				passwordField.setEchoChar((char)0);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				passwordField.setEchoChar('*');
			}
		});
		btnNewButton_2.setBounds(420, 119, 71, 17);
		contentPane.add(btnNewButton_2);
		
		JButton Donebt = new JButton("Done");
		Donebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(oldpassword.getText().equals(passwordField.getText()))
				{
					JOptionPane.showMessageDialog(Donebt, "New Password same as Old Password", "Password Same", JOptionPane.ERROR_MESSAGE);
				}
				else if(passwordField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(Donebt, "Password cannot be empty", "Password Empty", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					user.setPwd(passwordField.getText());
					pr.updatePassword(user);
					JOptionPane.showMessageDialog(Donebt, "Password Changed Successfully", "Password Changed", JOptionPane.INFORMATION_MESSAGE);
					if(user.getTou().equals("admin"))
					{
						new AdminHome(user);
					}
					else
					{
						
					}
					setVisible(false);
				}
			}
		});
		Donebt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		Donebt.setBounds(227, 182, 99, 30);
		contentPane.add(Donebt);
		setVisible(true);
	}
}
