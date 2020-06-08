package swingClasses;

import management.*;
import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JRadioButton;
import java.awt.Color;

public class SellTicket {

	static int passengerCount = 1;
	static int baggageCount = 1;
	private JFrame frame;
	private JFrame superF;
	private JTextField textName;
	private JTextField textSurname;
	private JTextField countryTxt;
	private JTextField area;
	private JTextField numberField;
	private JTextField bggWeight;
	private JTextField quantity;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox cbxDate;
	private JComboBox cbxDate2;

	private JButton btnOk;
	private JTextField textField;

	public SellTicket() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 196, 222));

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

		frame.setTitle("Sell Ticket");
		frame.setBounds(100, 100, 733, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(118, 169, 56, 16);
		frame.getContentPane().add(lblName);

		JLabel lblSurname = new JLabel("Surname: ");
		lblSurname.setBounds(118, 198, 61, 16);
		frame.getContentPane().add(lblSurname);

		JLabel lblBirthdate = new JLabel("Birthdate:");
		lblBirthdate.setBounds(118, 227, 66, 16);
		frame.getContentPane().add(lblBirthdate);

		JLabel lblPhone = new JLabel("Phone: ");
		lblPhone.setBounds(118, 256, 56, 16);
		frame.getContentPane().add(lblPhone);

		JLabel lblBaggageWeight = new JLabel("Baggage Weight:");
		lblBaggageWeight.setBounds(118, 307, 112, 16);
		frame.getContentPane().add(lblBaggageWeight);

		JLabel lblNewLabel = new JLabel("Quantity:");
		lblNewLabel.setBounds(118, 336, 95, 16);
		frame.getContentPane().add(lblNewLabel);

		textName = new JTextField();
		textName.setBounds(191, 166, 116, 22);
		frame.getContentPane().add(textName);
		textName.setColumns(10);

		textSurname = new JTextField();
		textSurname.setBounds(191, 195, 116, 22);
		frame.getContentPane().add(textSurname);
		textSurname.setColumns(10);

		countryTxt = new JTextField();
		countryTxt.setBounds(191, 254, 44, 20);
		frame.getContentPane().add(countryTxt);
		countryTxt.setColumns(10);

		area = new JTextField();
		area.setBounds(242, 254, 44, 20);
		frame.getContentPane().add(area);
		area.setColumns(10);

		numberField = new JTextField();
		numberField.setBounds(298, 253, 93, 22);
		frame.getContentPane().add(numberField);
		numberField.setColumns(10);

		bggWeight = new JTextField();
		bggWeight.setBounds(242, 304, 65, 22);
		frame.getContentPane().add(bggWeight);
		bggWeight.setColumns(10);

		quantity = new JTextField();
		quantity.setBounds(242, 332, 65, 25);
		frame.getContentPane().add(quantity);
		quantity.setColumns(10);

		String[] birthYear = { "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930",
				"1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943",
				"1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956",
				"1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
				"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982",
				"1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995",
				"1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008",
				"2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019" };
		comboBox = new JComboBox(birthYear);
		comboBox.setBounds(298, 227, 66, 18);
		frame.getContentPane().add(comboBox);

		String[] month = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		comboBox_1 = new JComboBox(month);
		comboBox_1.setBounds(242, 226, 44, 19);
		frame.getContentPane().add(comboBox_1);

		String[] day = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		comboBox_2 = new JComboBox(day);
		comboBox_2.setBounds(191, 226, 44, 19);
		frame.getContentPane().add(comboBox_2);

		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(118, 70, 56, 16);
		frame.getContentPane().add(lblFrom);

		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(387, 70, 56, 16);
		frame.getContentPane().add(lblTo);

		JLabel lblDate = new JLabel("Date: ");
		lblDate.setBounds(118, 127, 56, 16);
		frame.getContentPane().add(lblDate);

		cbxDate = new JComboBox(day);
		cbxDate.setBounds(177, 126, 44, 19);
		frame.getContentPane().add(cbxDate);

		cbxDate2 = new JComboBox(month);
		cbxDate2.setBounds(233, 126, 47, 19);
		frame.getContentPane().add(cbxDate2);

		String[] cities = { "Ankara", "Istanbul", "Izmir", "Trabzon", "Antalya", "Milano", "Barcelona", "Paris",
				"Manchester", "Viyana" };

		JComboBox fromBox = new JComboBox(cities);
		JComboBox toBox = new JComboBox(cities);

		fromBox.setBounds(177, 67, 155, 22);
		frame.getContentPane().add(fromBox);

		toBox.setBounds(422, 67, 165, 22);
		frame.getContentPane().add(toBox);

		textField = new JTextField();
		textField.setText("2019");
		textField.setBounds(292, 124, 55, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JRadioButton rdbtnOneWay = new JRadioButton("One Way");
		rdbtnOneWay.setBackground(new Color(176, 196, 222));
		rdbtnOneWay.setBounds(177, 35, 127, 25);
		frame.getContentPane().add(rdbtnOneWay);

		JRadioButton rdbtnReturn = new JRadioButton("Return");
		rdbtnReturn.setBackground(new Color(176, 196, 222));
		rdbtnReturn.setBounds(422, 36, 127, 25);
		frame.getContentPane().add(rdbtnReturn);

		btnOk = new JButton("OK");

		frame.getContentPane().add(btnOk);
		btnOk.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Date date = new Date(Integer.parseInt(comboBox.getSelectedItem().toString()),
						Integer.parseInt(comboBox_1.getSelectedItem().toString()),
						Integer.parseInt(comboBox_2.getSelectedItem().toString()));
				Phone phone = new Phone(countryTxt.getText().toString(), area.getText().toString(),
						numberField.getText().toString());
				Passenger p = new Passenger(passengerCount, textName.getText().toString(),
						textSurname.getText().toString(), date, phone);
				p.getBaggage().setBaggageID(baggageCount);
				p.getBaggage().setBaggageWeight(Integer.parseInt(bggWeight.getText().toString()));
				p.getBaggage().setQuantity(Integer.parseInt(quantity.getText().toString()));

				Login.ticketManagement.addPassenger(p);

				Date flightDate = new Date((Integer.parseInt(cbxDate.getSelectedItem().toString())),
						(Integer.parseInt(cbxDate2.getSelectedItem().toString())), 2019);

				JOptionPane.showMessageDialog(frame, Login.ticketManagement.addBaggage(p));
				if (rdbtnOneWay.isSelected()) {

					SelectFlight sFlight = new SelectFlight(flightDate, fromBox.getSelectedItem().toString(),
							toBox.getSelectedItem().toString(), false);
					sFlight.getFrame().setVisible(true);
					frame.setVisible(false);
				}

				else if (rdbtnReturn.isSelected()) {

					SelectFlight selectFlight = new SelectFlight(flightDate, fromBox.getSelectedItem().toString(),
							toBox.getSelectedItem().toString(), true);

					selectFlight.getFrame().setVisible(true);
					frame.setVisible(false);

				}

			}

		});
		btnOk.setBounds(581, 400, 97, 25);
		frame.getContentPane().add(btnOk);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					MenuPageSalesman menuPageSalesman = new MenuPageSalesman();
					menuPageSalesman.getFrame().setVisible(true);
					frame.setVisible(false);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnBack.setBounds(30, 400, 97, 25);
		frame.getContentPane().add(btnBack);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}