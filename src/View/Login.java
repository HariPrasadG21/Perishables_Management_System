package View;
import Model.*;
import Controller.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frmLogin;
	private JTextField idt;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(new Color(192, 192, 192));
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(213, 99, 114, 23);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword_1.setForeground(Color.BLACK);
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword_1.setBounds(213, 147, 114, 23);
		frmLogin.getContentPane().add(lblPassword_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 718, 62);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Login");
		lblNewLabel_1.setBounds(254, 11, 243, 29);
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		idt = new JTextField();
		idt.setBounds(353, 102, 120, 20);
		frmLogin.getContentPane().add(idt);
		idt.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(353, 150, 120, 20);
		frmLogin.getContentPane().add(password);
		
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idt.getText().equals(""))
				{
					JOptionPane.showMessageDialog(loginbt, "Username Required","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else if(password.getText().equals(""))
				{
					JOptionPane.showMessageDialog(loginbt, "Password Required","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					EmployeeController cr = new EmployeeController();
					Employee user = new Employee(idt.getText(),password.getText());
					if(cr.loginEmployee(user))
					{
						user = cr.getEmployee();
						String tou =user.getTou();
						if(tou.equalsIgnoreCase("admin"))
						{
							JOptionPane.showMessageDialog(loginbt, "Login Successfull", "Message",JOptionPane.INFORMATION_MESSAGE);
							new AdminHome(user);
							frmLogin.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(loginbt, "Login Successfull", "Message",JOptionPane.INFORMATION_MESSAGE);
							new UserHome(user);
							frmLogin.setVisible(false);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"User not found or Wrong Password","ERROR",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		loginbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		loginbt.setBounds(296, 206, 89, 23);
		frmLogin.getContentPane().add(loginbt);
		
		JButton showbt = new JButton("Show");
		showbt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				password.setEchoChar((char)0);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				password.setEchoChar('*');
			}
		});
		showbt.setBounds(541, 149, 66, 23);
		frmLogin.getContentPane().add(showbt);
		frmLogin.setBounds(100, 100, 732, 380);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setVisible(true);
	}
}
