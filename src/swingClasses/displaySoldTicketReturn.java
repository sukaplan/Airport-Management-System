package swingClasses;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import management.Flight;
import management.Passenger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class displaySoldTicketReturn{

	static int index1 = 0;
	static int index2 = 0;
	private JFrame frame;

	public displaySoldTicketReturn(Flight f1, Flight f2) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));

		int size = Login.ticketManagement.getPassengers().size();
		Passenger passenger = Login.ticketManagement.getPassengers().get(size - 1);

		frame.setTitle("Ticket");

		JTextArea seats = new JTextArea();
		seats.setBackground(new Color(255, 228, 225));
		

		for (int i = 0; i < Login.airportManagement.getFlights().size(); i++) {

			Flight compare = Login.airportManagement.getFlights().get(i);
			if (f1.getFlightNo() == compare.getFlightNo()) {
				

				index1 = i;
				break;

			}

		}

		String seat = "";
		for (int i = 0; i < Login.airportManagement.getFlights().get(index1).getPlane().getSeats().length; i++) {
			for (int j = 0; j < Login.airportManagement.getFlights().get(index1).getPlane().getSeats()[0].length; j++) {
				seat += Login.airportManagement.getFlights().get(index1).getPlane().getSeats()[i][j].toBox() + "\t ";
				seats.setText(seat);

			}
			seat += "\n";
			seats.setText(seat);
		}
		seats.setBounds(27, 42, 472, 439);
		frame.getContentPane().add(seats);
		
		
		JTextArea f2Seat = new JTextArea();
		f2Seat.setBackground(new Color(255, 228, 225));
		

		for (int i = 0; i < Login.airportManagement.getFlights().size(); i++) {

			Flight compare = Login.airportManagement.getFlights().get(i);
			if (f2.getFlightNo() == compare.getFlightNo()) {

				index2 = i;
				break;

			}

		}

		String seat2 = "";
		for (int i = 0; i < Login.airportManagement.getFlights().get(index2).getPlane().getSeats().length; i++) {
			for (int j = 0; j < Login.airportManagement.getFlights().get(index2).getPlane().getSeats()[0].length; j++) {
				seat2 += Login.airportManagement.getFlights().get(index2).getPlane().getSeats()[i][j].toBox() + "\t ";
				f2Seat.setText(seat2);

			}
			seat2 += "\n";
			f2Seat.setText(seat2);
		}
		f2Seat.setBounds(511, 50, 515, 431);
		frame.getContentPane().add(f2Seat);
		
		frame.setBounds(100, 100, 1088, 745);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSeat = new JLabel("SEAT ROW");
		lblSeat.setBounds(40, 513, 81, 16);
		frame.getContentPane().add(lblSeat);
		
		JLabel lblSeatColumn = new JLabel("SEAT COLUMN");
		lblSeatColumn.setBounds(141, 513, 98, 16);
		frame.getContentPane().add(lblSeatColumn);
		
		JLabel lblSeatRow = new JLabel("SEAT ROW");
		lblSeatRow.setBounds(528, 510, 98, 23);
		frame.getContentPane().add(lblSeatRow);
		
		JLabel lblSeatColumn_1 = new JLabel("SEAT COLUMN");
		lblSeatColumn_1.setBounds(625, 511, 106, 20);
		frame.getContentPane().add(lblSeatColumn_1);
		
		

		String[] rows = { "A", "B", "C", "D", "E", "F" };
		String[] columns = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24" };
		
		
		JComboBox f1Row = new JComboBox(rows);
		f1Row.setBounds(40, 542, 61, 22);
		frame.getContentPane().add(f1Row);
		
		JComboBox f1Column = new JComboBox(columns);
		f1Column.setBounds(151, 542, 61, 23);
		frame.getContentPane().add(f1Column);
		
		JComboBox f2Row = new JComboBox(rows);
		f2Row.setBounds(528, 542, 61, 22);
		frame.getContentPane().add(f2Row);
		
		JComboBox f2Column = new JComboBox(columns);
		f2Column.setBounds(625, 542, 66, 22);
		frame.getContentPane().add(f2Column);
			
		
		
		JButton btnSellTcket = new JButton("SELL TICKET");
		btnSellTcket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String row1 = f1Row.getSelectedItem().toString();
				int column1 = Integer.parseInt(f1Column.getSelectedItem().toString());
				Login.airportManagement.getFlights().get(index1).getPlane().setSeats(row1, column1);

				String row2 = f2Row.getSelectedItem().toString();
				int column2 = Integer.parseInt(f2Column.getSelectedItem().toString());
				Login.airportManagement.getFlights().get(index2).getPlane().setSeats(row2, column2);
				
				
				JOptionPane.showMessageDialog(frame, "PASSENGER INFORMATION:\n" + passenger.toString() + " \nFLIGHT NO:  "
						+ f1.getFlightNo() + "\nBOARDING TIME : " + f1.getBoardingTime().HourtoString() + " \nARRIVAL TIME: "
						+ f1.getArrivalTime().HourtoString() + "\nFROM: " + f1.getFrom() + "\nTO: " + f1.getTo(),"TICKET INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSellTcket.setBounds(866, 542, 137, 23);
		frame.getContentPane().add(btnSellTcket);
		
		JButton btnNewTcket = new JButton("NEW TICKET");
		btnNewTcket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SellTicket newticket = new SellTicket();
				newticket.getFrame().setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnNewTcket.setBounds(866, 633, 137, 24);
		frame.getContentPane().add(btnNewTcket);
		
		JButton btnBackToMenu = new JButton("BACK TO MENU");
		btnBackToMenu.addActionListener(new ActionListener() {
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
		btnBackToMenu.setBounds(27, 633, 121, 23);
		frame.getContentPane().add(btnBackToMenu);

		
		
		
		
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
