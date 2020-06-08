package swingClasses;
import management.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class displaySoldTicket {
	static int index = 0;
	private JFrame frame;

	displaySoldTicket(Flight f) {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(205, 92, 92));

		int size = Login.ticketManagement.getPassengers().size();
		Passenger passenger = Login.ticketManagement.getPassengers().get(size - 1);

		JTextArea textArea = new JTextArea("PASSENGER INFORMATION:\n" + passenger.toString() + " \nFLIGHT NO:  "
				+ f.getFlightNo() + "\nBOARDING TIME : " + f.getBoardingTime().HourtoString() + " \nARRIVAL TIME: "
				+ f.getArrivalTime().HourtoString() + "\nFROM: " + f.getFrom() + "\nTO: " + f.getTo());
		textArea.setBackground(new Color(255, 204, 153));

		textArea.setBounds(40, 24, 555, 122);

		frame.setTitle("Ticket");

		JTextArea seats = new JTextArea();
		seats.setBackground(new Color(255, 204, 153));
		seats.setBounds(40, 188, 555, 459);
		frame.getContentPane().add(seats);

		
		for (int i = 0; i < Login.airportManagement.getFlights().size(); i++) {

			Flight compare = Login.airportManagement.getFlights().get(i);
			if (f.getFlightNo() == compare.getFlightNo()) {

				index = i;
				break;

			}

		}

		String seat = "";
		for (int i = 0; i < Login.airportManagement.getFlights().get(index).getPlane().getSeats().length; i++) {
			for (int j = 0; j < Login.airportManagement.getFlights().get(index).getPlane().getSeats()[0].length; j++) {
				seat += Login.airportManagement.getFlights().get(index).getPlane().getSeats()[i][j].toBox() + "\t ";
				seats.setText(seat);

			}
			seat += "\n";
			seats.setText(seat);
		}

		frame.setBounds(100, 100, 1088, 745);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.getContentPane().add(textArea);

		JLabel lblSeatRow = new JLabel("SEAT ROW:");
		lblSeatRow.setBackground(new Color(255, 204, 153));
		lblSeatRow.setBounds(645, 270, 91, 32);
		frame.getContentPane().add(lblSeatRow);

		JLabel lblSeatColumn = new JLabel("SEAT COLUMN");
		lblSeatColumn.setBackground(new Color(255, 204, 153));
		lblSeatColumn.setBounds(645, 335, 91, 24);
		frame.getContentPane().add(lblSeatColumn);

		String[] rows = { "A", "B", "C", "D", "E", "F" };
		String[] columns = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24" };

		JComboBox comboBox = new JComboBox(rows);
		comboBox.setBounds(748, 274, 46, 24);
		frame.getContentPane().add(comboBox);

		JComboBox comboBox_1 = new JComboBox(columns);
		comboBox_1.setBounds(748, 336, 46, 23);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnSellTicket = new JButton("Sell Ticket");
		btnSellTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String row = comboBox.getSelectedItem().toString();
				int column = Integer.parseInt(comboBox_1.getSelectedItem().toString());
				Login.airportManagement.getFlights().get(index).getPlane().setSeats(row, column);
				
				JOptionPane.showMessageDialog(frame, "PASSENGER INFORMATION:\n" + passenger.toString() + " \nFLIGHT NO:  "
						+ f.getFlightNo() + "\nBOARDING TIME : " + f.getBoardingTime().HourtoString() + " \nARRIVAL TIME: "
						+ f.getArrivalTime().HourtoString() + "\nFROM: " + f.getFrom() + "\nTO: " + f.getTo(),"TICKET INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSellTicket.setBounds(872, 304, 111, 32);
		frame.getContentPane().add(btnSellTicket);
		
		

		JButton btnNewTcket = new JButton("NEW TICKET");
		btnNewTcket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SellTicket newticket = new SellTicket();
				newticket.getFrame().setVisible(true);
				frame.setVisible(false);

			}
		});
		btnNewTcket.setBounds(645, 522, 136, 32);
		frame.getContentPane().add(btnNewTcket);

		JButton btnNewButton = new JButton("BACK TO MENU");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(888, 522, 127, 32);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(888, 622, 127, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
