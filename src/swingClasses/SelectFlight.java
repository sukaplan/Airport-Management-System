package swingClasses;

import management.*;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class SelectFlight {
	private JFrame frame;
	private JFrame superF;
	private JScrollPane pane;
	private JScrollPane pane2;
	private JTable jTable1;
	private JTable jTable2;
	private JTableHeader header;
	private DefaultTableModel model;
	private DefaultTableModel model2;
	private JPanel panel;
	private JButton btnNext;
	private JButton btnNext2;

	public SelectFlight(Date date, String from, String to, boolean flag) {

		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(230, 230, 250));
		frame.getContentPane().setBackground(new Color(70, 130, 180));
		
		
		panel = new JPanel();
		jTable1 = new JTable();

		jTable2 = new JTable();

		frame.addWindowListener(new WindowAdapter() {
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

		String col[] = { "Flight No", "Departure", "Arrival", "From", "To", "Date" };

		if (!flag) {

			model = new DefaultTableModel();
			model.setColumnIdentifiers(col);
			jTable1.setModel(model);
			jTable1.setBackground(Color.GRAY);
			jTable1.setForeground(Color.white);
			jTable1.setRowHeight(30);

			for (int i = 0; i < Login.airportManagement.getFlights().size(); i++) {
				Flight flight = Login.airportManagement.getFlights().get(i);
				if (flight.getFrom().equals(from) && flight.getTo().equals(to) && flight.getFlightdate().getMonth() == date.getMonth()) {
					String[] row = { Login.airportManagement.getFlights().get(i).getFlightNo(),
							Login.airportManagement.getFlights().get(i).getBoardingTime().HourtoString(),
							Login.airportManagement.getFlights().get(i).getArrivalTime().HourtoString(),
							Login.airportManagement.getFlights().get(i).getFrom(),
							Login.airportManagement.getFlights().get(i).getTo(), Login.airportManagement.getFlights().get(i).getFlightdate().displayDate()};
					model.addRow(row);
				}

			}

			header = jTable1.getTableHeader();
			header.setBackground(Color.yellow);
			panel.setLayout(null);

			pane = new JScrollPane(jTable1);
			pane.setBounds(22, 37, 452, 261);
			jTable1.setBounds(21, 45, 452, 655);

			panel.add(pane);
			frame.getContentPane().add(panel);

			btnNext = new JButton("Next");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
					int selected = jTable1.getSelectedRow();

					String flightno = model.getValueAt(selected, 0).toString();
					Date boarding = new Date(Integer.parseInt(model.getValueAt(selected, 1).toString().split(":")[0]),
							(Integer.parseInt(model.getValueAt(selected, 1).toString().split(":")[1])));
					Date arrival = new Date(Integer.parseInt(model.getValueAt(selected, 2).toString().split(":")[0]),
							(Integer.parseInt(model.getValueAt(selected, 2).toString().split(":")[1])));
					String from = model.getValueAt(selected, 3).toString();
					String to = model.getValueAt(selected, 4).toString();

					
					Flight newflight = new Flight(flightno, boarding, arrival, from, to);
					displaySoldTicket displaySoldTicket = new displaySoldTicket(newflight);

					displaySoldTicket.getFrame().setVisible(true);
					frame.setVisible(false);

				}
			});

			btnNext.setBounds(204, 305, 97, 25);
			panel.add(btnNext);

		} else if (flag) {

			model = new DefaultTableModel();
			model.setColumnIdentifiers(col);
			jTable1.setModel(model);
			jTable1.setBackground(Color.GRAY);
			jTable1.setForeground(Color.white);
			jTable1.setRowHeight(30);

			for (int i = 0; i < Login.airportManagement.getFlights().size(); i++) {
				Flight flight = Login.airportManagement.getFlights().get(i);
				if (flight.getFrom().equals(from) && flight.getTo().equals(to)&& flight.getFlightdate().getMonth() == date.getMonth()) {
					String[] row = { Login.airportManagement.getFlights().get(i).getFlightNo(),
							Login.airportManagement.getFlights().get(i).getBoardingTime().HourtoString(),
							Login.airportManagement.getFlights().get(i).getArrivalTime().HourtoString(),
							Login.airportManagement.getFlights().get(i).getFrom(),
							Login.airportManagement.getFlights().get(i).getTo() , Login.airportManagement.getFlights().get(i).getFlightdate().displayDate()};
					model.addRow(row);
				}

			}

			header = jTable1.getTableHeader();
			header.setBackground(Color.yellow);
			panel.setLayout(null);

			pane = new JScrollPane(jTable1);
			pane.setBounds(22, 37, 452, 261);
			jTable1.setBounds(21, 45, 452, 655);

			panel.add(pane);
			frame.getContentPane().add(panel);

			model2 = new DefaultTableModel();
			model2.setColumnIdentifiers(col);

			jTable2.setModel(model2);
			jTable2.setBackground(Color.GRAY);
			jTable2.setForeground(Color.white);
			jTable2.setRowHeight(30);

			for (int i = 0; i < Login.airportManagement.getFlights().size(); i++) {
				Flight flight = Login.airportManagement.getFlights().get(i);
				if (flight.getFrom().equals(to) && flight.getTo().equals(from) && flight.getFlightdate().getMonth() == date.getMonth()) {
					String[] row = { Login.airportManagement.getFlights().get(i).getFlightNo(),
							Login.airportManagement.getFlights().get(i).getBoardingTime().HourtoString(),
							Login.airportManagement.getFlights().get(i).getArrivalTime().HourtoString(),
							Login.airportManagement.getFlights().get(i).getFrom(),
							Login.airportManagement.getFlights().get(i).getTo(),Login.airportManagement.getFlights().get(i).getFlightdate().displayDate()};
					model2.addRow(row);
				}

			}

			pane2 = new JScrollPane(jTable2);
			pane2.setBounds(22, 325, 452, 261);
			jTable2.setBounds(21, 330, 452, 655);

			panel.add(pane2);
			frame.getContentPane().add(panel);

			btnNext2 = new JButton("Next");
			btnNext2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
					int selected = jTable1.getSelectedRow();

					DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
					int selected2 = jTable2.getSelectedRow();

					String flightno = model.getValueAt(selected, 0).toString();
					String retFlightno = model2.getValueAt(selected2, 0).toString();

					Date boarding = new Date(Integer.parseInt(model.getValueAt(selected, 1).toString().split(":")[0]),
							(Integer.parseInt(model.getValueAt(selected, 1).toString().split(":")[1])));
					Date boarding2 = new Date(
							Integer.parseInt(model2.getValueAt(selected2, 1).toString().split(":")[0]),
							(Integer.parseInt(model2.getValueAt(selected2, 1).toString().split(":")[1])));
					Date arrival = new Date(Integer.parseInt(model.getValueAt(selected, 2).toString().split(":")[0]),
							(Integer.parseInt(model.getValueAt(selected, 2).toString().split(":")[1])));
					Date arrival2 = new Date(Integer.parseInt(model2.getValueAt(selected2, 2).toString().split(":")[0]),
							(Integer.parseInt(model2.getValueAt(selected2, 2).toString().split(":")[1])));

					
					String from = model.getValueAt(selected, 3).toString();
					String from2 = model2.getValueAt(selected2, 3).toString();
					String to = model.getValueAt(selected, 4).toString();
					String to2 = model2.getValueAt(selected2, 4).toString();
					Flight newflight = new Flight(flightno, boarding, arrival, from, to);
					Flight newflightret = new Flight(retFlightno,boarding2, arrival2, from2, to2);
					displaySoldTicketReturn displaySoldTicketret = new displaySoldTicketReturn(newflight, newflightret);

					displaySoldTicketret.getFrame().setVisible(true);
					frame.setVisible(false);

				}
			});

			btnNext2.setBounds(204, 705, 97, 25);
			panel.add(btnNext2);

		}

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SellTicket sellTicket = new SellTicket();
				sellTicket.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnBack, BorderLayout.SOUTH);
		
		frame.setSize(500, 750);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}