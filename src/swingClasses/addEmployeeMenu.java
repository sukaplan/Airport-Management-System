package swingClasses;

import management.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class addEmployeeMenu {

	private JFrame frame;
	private JFrame superF;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public addEmployeeMenu() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 235));

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				superF.setVisible(true);
				try {
					this.finalize();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		frame.setTitle("Add Employee");
		frame.setBounds(100, 100, 499, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(43, 47, 56, 16);
		frame.getContentPane().add(lblName);

		JLabel lblSurname = new JLabel("Surname: ");
		lblSurname.setBounds(43, 88, 61, 16);
		frame.getContentPane().add(lblSurname);

		JLabel lblBirthdate = new JLabel("Birthdate:");
		lblBirthdate.setBounds(43, 134, 66, 16);
		frame.getContentPane().add(lblBirthdate);

		JLabel lblPhone = new JLabel("Phone: ");
		lblPhone.setBounds(43, 175, 56, 16);
		frame.getContentPane().add(lblPhone);

		textField_1 = new JTextField();
		textField_1.setBackground(new Color(224, 255, 255));
		textField_1.setBounds(125, 85, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBackground(new Color(224, 255, 255));
		textField_2.setBounds(125, 172, 66, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBackground(new Color(224, 255, 255));
		textField_3.setBounds(203, 172, 76, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBackground(new Color(224, 255, 255));
		textField_4.setBounds(291, 172, 116, 22);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		String[] day = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		JComboBox comboBox = new JComboBox(day);
		comboBox.setBackground(new Color(224, 255, 255));
		comboBox.setBounds(125, 134, 42, 19);
		frame.getContentPane().add(comboBox);

		String[] month = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		JComboBox comboBox_1 = new JComboBox(month);
		comboBox_1.setBackground(new Color(224, 255, 255));
		comboBox_1.setBounds(179, 133, 48, 18);
		frame.getContentPane().add(comboBox_1);

		String[] birthYear = { "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930",
				"1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943",
				"1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956",
				"1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
				"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982",
				"1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995",
				"1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008",
				"2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019" };
		JComboBox comboBox_2 = new JComboBox(birthYear);
		comboBox_2.setBackground(new Color(224, 255, 255));
		comboBox_2.setBounds(233, 134, 56, 19);
		frame.getContentPane().add(comboBox_2);

		textField = new JTextField();
		textField.setBackground(new Color(224, 255, 255));
		textField.setBounds(125, 44, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		String[] inCharge = { "Pilot", "Flight Attendant", "Salesman" };
		JComboBox comboBox_6 = new JComboBox(inCharge);
		comboBox_6.setBounds(125, 223, 116, 22);
		frame.getContentPane().add(comboBox_6);

		JLabel lblInCharge = new JLabel("In charge:");
		lblInCharge.setBounds(44, 226, 66, 16);
		frame.getContentPane().add(lblInCharge);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Phone p1 = new Phone((String) textField_2.getText(), (String) textField_3.getText(),
						(String) textField_3.getText());
				Date d1 = new Date(Integer.parseInt((String) comboBox.getSelectedItem()),
						Integer.parseInt((String) comboBox_1.getSelectedItem()),
						Integer.parseInt((String) comboBox_2.getSelectedItem()));

				if (comboBox_6.getSelectedItem() == "Pilot") {
					Pilot emp = new Pilot(textField.getText(), textField_1.getText(), d1, p1);
					Login.airportManagement.getManager().addEmployee(emp, Login.airportManagement.getPilots());
					Login.airportManagement.getManager().addEmployee(emp, Login.airportManagement.getEmployees());
				}

				else if (comboBox_6.getSelectedItem() == "Flight Attendant") {
					FlightAttendant emp = new FlightAttendant(textField.getText().toString(),
							textField_1.getText().toString(), d1, p1);
					Login.airportManagement.getManager().addEmployee(emp, Login.airportManagement.getFlightAttendants());
					Login.airportManagement.getManager().addEmployee(emp, Login.airportManagement.getEmployees());
				}

				else {
					Salesman emp = new Salesman(textField.getText(), textField_1.getText(), d1, p1);
					Login.airportManagement.getManager().addEmployee(emp, Login.airportManagement.getSalesmans());
					Login.airportManagement.getManager().addEmployee(emp, Login.airportManagement.getEmployees());
				}

				JOptionPane.showMessageDialog(frame, "Employee succesfully added");

			}
		});
		btnOk.setBounds(353, 293, 97, 25);
		frame.getContentPane().add(btnOk);

		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MenuPageManager menuPageManager = new MenuPageManager();
					menuPageManager.getFrame().setVisible(true);
					frame.setVisible(false);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		btnNewButton.setBounds(33, 293, 97, 25);
		frame.getContentPane().add(btnNewButton);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}