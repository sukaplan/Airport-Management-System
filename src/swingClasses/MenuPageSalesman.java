package swingClasses;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MenuPageSalesman {

	private JFrame salesmanMenuFrame;
	private JRadioButton rdbtnSellTicket;
	private JRadioButton rdbtnDisplayFlights;
	private JRadioButton rdbtnDisplayPassengers;
	private JRadioButton rdbtnDeletePassenger;
	private JButton btnExt;


	public MenuPageSalesman() throws NumberFormatException, IOException {

		salesmanMenuFrame = new JFrame("SALESMAN MENU");
		salesmanMenuFrame.getContentPane().setBackground(new Color(216, 191, 216));
		salesmanMenuFrame.setBounds(100, 100, 360, 412);
		salesmanMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		salesmanMenuFrame.getContentPane().setLayout(null);

		JLabel lblMenu = new JLabel("SALESMAN MENU");
		lblMenu.setBounds(121, 28, 113, 16);
		salesmanMenuFrame.getContentPane().add(lblMenu);

		rdbtnSellTicket = new JRadioButton("Sell Ticket");
		rdbtnSellTicket.setBackground(new Color(216, 191, 216));
		rdbtnSellTicket.setBounds(80, 86, 127, 25);
		salesmanMenuFrame.getContentPane().add(rdbtnSellTicket);

		rdbtnDisplayFlights = new JRadioButton("Display Flights");
		rdbtnDisplayFlights.setBackground(new Color(216, 191, 216));
		rdbtnDisplayFlights.setBounds(80, 138, 127, 25);
		salesmanMenuFrame.getContentPane().add(rdbtnDisplayFlights);

		rdbtnDisplayPassengers = new JRadioButton("Display Passengers");
		rdbtnDisplayPassengers.setBackground(new Color(216, 191, 216));
		rdbtnDisplayPassengers.setBounds(80, 187, 154, 25);
		salesmanMenuFrame.getContentPane().add(rdbtnDisplayPassengers);
		
		rdbtnDeletePassenger = new JRadioButton("Delete Passenger");
		rdbtnDeletePassenger.setBackground(new Color(216, 191, 216));
		rdbtnDeletePassenger.setBounds(80, 231, 127, 25);
		salesmanMenuFrame.getContentPane().add(rdbtnDeletePassenger);
		
		
		ButtonGroup btnG = new ButtonGroup();
		btnG.add(rdbtnDisplayFlights);
		btnG.add(rdbtnSellTicket);
		btnG.add(rdbtnDisplayPassengers);
		btnG.add(rdbtnDeletePassenger);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnSellTicket.isSelected()) {

					SellTicket ticket;
					ticket = new SellTicket();
					ticket.getFrame().setVisible(true);
					salesmanMenuFrame.setVisible(false);

				}

				else if (rdbtnDisplayFlights.isSelected()) {

					DisplayFlightSchedule flightSchedule = new DisplayFlightSchedule();

					flightSchedule.getFrame().setVisible(true);
					salesmanMenuFrame.setVisible(false);

				}
				
				else if(rdbtnDisplayPassengers.isSelected()) {
					
					DisplayPassengers displayPassengers = new DisplayPassengers();
					salesmanMenuFrame.setVisible(false);
					displayPassengers.getFrame().setVisible(true);
					
					
				}
				else if(rdbtnDeletePassenger.isSelected()) {
					DeletePassengers deletePassengers = new DeletePassengers();
					deletePassengers.getFrame().setVisible(true);
					salesmanMenuFrame.setVisible(false);
				}

			}
		});
		btnOk.setBounds(48, 299, 81, 25);
		salesmanMenuFrame.getContentPane().add(btnOk);
		
		btnExt = new JButton("EXIT");
		btnExt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salesmanMenuFrame.dispose();
				
			}
		});
		btnExt.setBounds(202, 299, 81, 25);
		salesmanMenuFrame.getContentPane().add(btnExt);
		
		

	}

	public JFrame getFrame() {
		return salesmanMenuFrame;
	}

	public void setFrame(JFrame frame) {
		this.salesmanMenuFrame = frame;
	}
}
