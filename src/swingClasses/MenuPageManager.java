package swingClasses;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MenuPageManager {

	private JFrame frame;
	private JRadioButton rdbtnDisplayEmployees;
	private JRadioButton rdbtnDisplayFlights;
	private JRadioButton rdbtnAddEmployee;
	private JRadioButton rdbtnDeleteEmployee;
	private JRadioButton rdbtnChangeEmployeeSalary;

	public MenuPageManager() {

		Login.airportManagement.ManagerOp();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(205, 92, 92));
		frame.setForeground(new Color(119, 136, 153));
		frame.setBackground(new Color(0, 0, 0));
		frame.setTitle("Manager Menu");
		frame.setBounds(100, 100, 389, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMenu = new JLabel("MANAGER MENU");
		lblMenu.setForeground(new Color(255, 255, 240));
		lblMenu.setBounds(144, 13, 100, 42);
		frame.getContentPane().add(lblMenu);

		rdbtnDisplayEmployees = new JRadioButton("Display Employees");
		rdbtnDisplayEmployees.setForeground(new Color(255, 255, 240));
		rdbtnDisplayEmployees.setBackground(new Color(205, 92, 92));
		rdbtnDisplayEmployees.setBounds(33, 64, 168, 25);
		frame.getContentPane().add(rdbtnDisplayEmployees);

		rdbtnDisplayFlights = new JRadioButton("Display Flight Schedule");
		rdbtnDisplayFlights.setForeground(new Color(255, 255, 240));
		rdbtnDisplayFlights.setBackground(new Color(205, 92, 92));
		rdbtnDisplayFlights.setBounds(33, 111, 168, 25);
		frame.getContentPane().add(rdbtnDisplayFlights);

		rdbtnAddEmployee = new JRadioButton("Add Employee");
		rdbtnAddEmployee.setForeground(new Color(255, 255, 240));
		rdbtnAddEmployee.setBackground(new Color(205, 92, 92));
		rdbtnAddEmployee.setBounds(33, 158, 127, 25);
		frame.getContentPane().add(rdbtnAddEmployee);

		rdbtnDeleteEmployee = new JRadioButton("Delete Employee");
		rdbtnDeleteEmployee.setForeground(new Color(255, 255, 240));
		rdbtnDeleteEmployee.setBackground(new Color(205, 92, 92));
		rdbtnDeleteEmployee.setBounds(33, 210, 127, 25);
		frame.getContentPane().add(rdbtnDeleteEmployee);

		rdbtnChangeEmployeeSalary = new JRadioButton("Change Employee Salary");
		rdbtnChangeEmployeeSalary.setForeground(new Color(255, 255, 240));
		rdbtnChangeEmployeeSalary.setBackground(new Color(205, 92, 92));
		rdbtnChangeEmployeeSalary.setBounds(33, 256, 202, 25);
		frame.getContentPane().add(rdbtnChangeEmployeeSalary);

		ButtonGroup btnG = new ButtonGroup();
		btnG.add(rdbtnDisplayEmployees);
		btnG.add(rdbtnDisplayFlights);
		btnG.add(rdbtnAddEmployee);
		btnG.add(rdbtnDeleteEmployee);
		btnG.add(rdbtnChangeEmployeeSalary);

		JButton btnOk = new JButton("OK");
		btnOk.setBackground(new Color(255, 160, 122));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnDisplayEmployees.isSelected()) {

					DisplayEmployee displayEmployees = new DisplayEmployee();
					displayEmployees.getFrame().setVisible(true);
					frame.setVisible(false);

				} else if (rdbtnDisplayFlights.isSelected()) {

					DisplayFlightSchedule displayFlights = new DisplayFlightSchedule();
					displayFlights.getFrame().setVisible(true);
					frame.setVisible(false);

				} else if (rdbtnAddEmployee.isSelected()) {
					addEmployeeMenu addEmployee = new addEmployeeMenu();
					addEmployee.getFrame().setVisible(true);
					frame.setVisible(false);

				} else if (rdbtnDeleteEmployee.isSelected()) {
					deleteEmployee deleteEmployee = new deleteEmployee();
					deleteEmployee.getFrame().setVisible(true);
					frame.setVisible(false);

				} else if (rdbtnChangeEmployeeSalary.isSelected()) {
					ChangeEmployeeSalary changeEmployeeSalary = new ChangeEmployeeSalary();
					changeEmployeeSalary.getFrame().setVisible(true);
					frame.setVisible(false);

				} 
			}
		});
		btnOk.setBounds(63, 328, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JButton btnExt = new JButton("EXIT");
		btnExt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnExt.setBackground(new Color(233, 150, 122));
		btnExt.setBounds(212, 328, 89, 24);
		frame.getContentPane().add(btnExt);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}