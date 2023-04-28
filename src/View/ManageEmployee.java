package View;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;

import Controller.*;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import Model.*
;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
public class ManageEmployee extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1010605966442702133L;
	private JPanel contentPane;
	private JTextField namet;
	private JTextField idt;
	private JTextField phonet;
	private JTextField searchTf;

	
	public ManageEmployee(Employee user) {
		EmployeeController pr = new EmployeeController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(153, 204, 255), null, null, null));

		setContentPane(contentPane);
		String dataM[][] = {{"", "", "", "",""}};
		String headM[] = {"Employee ID", "Employee Name", "DOB", "Designation","Phone No"};
		contentPane.setLayout(null);
		JTable empTable = new JTable(dataM,headM);
		empTable.setBackground(new Color(204, 255, 255));
		empTable.setForeground(new Color(204, 255, 255));
		empTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		empTable.setColumnSelectionAllowed(true);
		empTable.setCellSelectionEnabled(true);
		JScrollPane empTableSP = new JScrollPane(empTable);
		empTableSP.setBounds(349, 222, 529, 299);
		contentPane.add(empTableSP);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(22, 120, 89, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Verdana", Font.BOLD, 12));
		lblId.setBounds(22, 154, 89, 23);
		contentPane.add(lblId);
		
		JLabel lblDob = new JLabel("DOB:");
		lblDob.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDob.setBounds(22, 182, 89, 23);
		contentPane.add(lblDob);
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDesignation.setBounds(22, 214, 89, 23);
		contentPane.add(lblDesignation);
		
		JLabel lblPhoneNo = new JLabel("Phone No:");
		lblPhoneNo.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPhoneNo.setBounds(22, 248, 89, 23);
		contentPane.add(lblPhoneNo);
		
		namet = new JTextField();
		namet.setBounds(121, 122, 137, 20);
		contentPane.add(namet);
		namet.setColumns(10);
		
		idt = new JTextField();
		idt.setColumns(10);
		idt.setBounds(121, 153, 137, 20);
		contentPane.add(idt);
		
		phonet = new JTextField();
		phonet.setColumns(10);
		phonet.setBounds(121, 248, 137, 20);
		contentPane.add(phonet);
		JTextField datet = new JTextField();
		datet.setToolTipText("YYYY-MM-DD");
		datet.setBounds(121, 184, 137, 20);
		contentPane.add(datet);
		
		JComboBox dest = new JComboBox();
		dest.setModel(new DefaultComboBoxModel(new String[] {"Select", "Manager", "Supervisor", "Staff"}));
		dest.setBounds(121, 215, 137, 22);
		contentPane.add(dest);
		
		searchTf = new JTextField();
		searchTf.setBounds(377, 180, 241, 20);
		contentPane.add(searchTf);
		searchTf.setColumns(10);
		
		JButton searchbt = new JButton("Search");
		searchbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(searchTf.getText().equals("")){
					JOptionPane.showMessageDialog(searchbt, "Empty Text Field", "Empty Value", JOptionPane.ERROR_MESSAGE);
					}
					else{
					String dataM[][] = pr.searchEmployee(searchTf.getText());
					contentPane.remove(empTableSP);
					JTable empTable1 = new JTable(dataM,headM);
					empTable1.setEnabled(false);
					JScrollPane empTableSP1 = new JScrollPane(empTable1);
					empTableSP1.setBounds(349, 222, 529, 299);
					contentPane.add(empTableSP1);
					searchbt.revalidate();
					searchbt.repaint();
					}
			}
		});
		searchbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchbt.setBounds(657, 178, 89, 23);
		contentPane.add(searchbt);
		
		JButton showallbt = new JButton("Show All");
		showallbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dataM[][] = pr.getEmployees();
				contentPane.remove(empTableSP);
				JTable empTable1 = new JTable(dataM,headM);
				empTable1.setEnabled(false);
				JScrollPane empTableSP1 = new JScrollPane(empTable1);
				empTableSP1.setBounds(349, 222, 529, 299);
				contentPane.add(empTableSP1);
				searchbt.revalidate();
				searchbt.repaint();
			}
		});
		showallbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		showallbt.setBounds(772, 178, 89, 23);
		contentPane.add(showallbt);
		
		JLabel lblTypeOfUser = new JLabel("Type of User:");
		lblTypeOfUser.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTypeOfUser.setBounds(22, 278, 89, 23);
		contentPane.add(lblTypeOfUser);
		
		JComboBox tout = new JComboBox();
		tout.setModel(new DefaultComboBoxModel(new String[] {"Select", "user", "admin"}));
		tout.setBounds(121, 279, 137, 22);
		contentPane.add(tout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBounds(0, 0, 888, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton logoutbt = new JButton("Logout");
		logoutbt.setBounds(787, 11, 91, 23);
		panel.add(logoutbt);
		logoutbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				setVisible(false);
			}
		});
		logoutbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton backbt = new JButton("Back");
		backbt.setBounds(787, 45, 91, 23);
		panel.add(backbt);
		backbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminHome(user);
				setVisible(false);
			}
		});
		backbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Employee Management");
		lblNewLabel_1.setForeground(new Color(204, 153, 255));
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 888, 79);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Add/Update/Delete User");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(204, 255, 204));
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_1_1.setBounds(22, 86, 281, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JButton addBt = new JButton("Add");
		addBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idt.getText().equals("") || namet.getText().equals("") || phonet.getText().equals("") || tout.getSelectedItem().equals("Select") || dest.getSelectedItem().equals("Select") || datet.getText().equals(""))
				{
					JOptionPane.showMessageDialog(addBt,"Empty Text Field!!","Error",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					String id = idt.getText();
					String name = namet.getText();
					String phone = phonet.getText();
					String tou = (String) tout.getSelectedItem();
					String des = (String) dest.getSelectedItem();
					String dob = datet.getText();
					Employee user = new Employee(id,name,dob,des,phone,tou);
					pr.addEmployee(user);
					String dataM[][] = pr.searchEmployee(name);
					contentPane.remove(empTableSP);
					JTable empTable1 = new JTable(dataM,headM);
					empTable1.setEnabled(false);
					JScrollPane empTableSP1 = new JScrollPane(empTable1);
					empTableSP1.setBounds(349, 222, 529, 299);
					contentPane.add(empTableSP1);
					searchbt.revalidate();
					searchbt.repaint();
				}
			}
		});
		
		addBt.setFont(new Font("Tahoma", Font.BOLD, 12));
		addBt.setBounds(83, 322, 89, 23);
		contentPane.add(addBt);
		JButton deletebt = new JButton("Delete");
		JButton updatebt = new JButton("Update");
		updatebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idt.getText().equals("") || namet.getText().equals("") || phonet.getText().equals("") || tout.getSelectedItem().equals("Select") || dest.getSelectedItem().equals("Select") || datet.getText().equals(""))
				{
					JOptionPane.showMessageDialog(updatebt,"Empty Text Field!!","Error",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					String id = idt.getText();
					String name = namet.getText();
					String phone = phonet.getText();
					String tou = (String) tout.getSelectedItem();
					String des = (String) dest.getSelectedItem();
					String dob = datet.getText();
					Employee user = new Employee(id,name,dob,des,phone,tou);
					pr.updateEmployee(user);
					String dataM[][] = pr.searchEmployee(name);
					contentPane.remove(empTableSP);
					JTable empTable1 = new JTable(dataM,headM);
					empTable1.setEnabled(false);
					JScrollPane empTableSP1 = new JScrollPane(empTable1);
					empTableSP1.setBounds(349, 222, 529, 299);
					contentPane.add(empTableSP1);
					searchbt.revalidate();
					searchbt.repaint();
					updatebt.setEnabled(false);
					deletebt.setEnabled(false);
				}
			}
		});
		updatebt.setFont(new Font("Tahoma", Font.BOLD, 12));
		updatebt.setBounds(22, 399, 89, 23);
		contentPane.add(updatebt);
		updatebt.setEnabled(false);
		
		
		deletebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idt.getText();
				pr.deleteEmployee(id);
				JOptionPane.showMessageDialog(deletebt,"Employee Removed Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
				String dataM[][] = pr.getEmployees();
				contentPane.remove(empTableSP);
				JTable empTable1 = new JTable(dataM,headM);
				empTable1.setEnabled(false);
				JScrollPane empTableSP1 = new JScrollPane(empTable1);
				empTableSP1.setBounds(349, 222, 529, 299);
				contentPane.add(empTableSP1);
				searchbt.revalidate();
				searchbt.repaint();
			}
		});
		deletebt.setFont(new Font("Tahoma", Font.BOLD, 12));
		deletebt.setBounds(169, 399, 89, 23);
		contentPane.add(deletebt);
		deletebt.setEnabled(false);
		JButton loadbt = new JButton("Load");
		loadbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idt.getText().equals(""))
				{
					JOptionPane.showMessageDialog(loadbt,"Employee ID required!!","WARNING",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					Employee emp = pr.searchUser(idt.getText());
					if(emp==null)
					{
						JOptionPane.showMessageDialog(loadbt,"No employee for this id","warning",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						idt.setText(emp.getID());
						namet.setText(emp.getName());
						datet.setText(emp.getDOB());
						phonet.setText(emp.getPhone());
						dest.setSelectedItem(emp.getDes());
						tout.setSelectedItem(emp.getTou());
						deletebt.setEnabled(true);
						updatebt.setEnabled(true);
					}
				}
			}
		});
		loadbt.setFont(new Font("Tahoma", Font.BOLD, 12));
		loadbt.setBounds(83, 356, 89, 23);
		contentPane.add(loadbt);
		
		
		setVisible(true);
	}
}
