package swingClasses;
import management.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import management.AirportManagement;
import management.TicketManagement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login {
	private JFrame login;
	private JTextField textField;
	private JPasswordField passwordField;

	protected static AirportManagement airportManagement = new AirportManagement();

	protected static TicketManagement ticketManagement = new TicketManagement();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		try {

			airportManagement.readEmployee();
			airportManagement.readFlights();
			ticketManagement.readFile();
			
		} catch (NumberFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		login = new JFrame();
		login.getContentPane().setBackground(new Color(153, 204, 204));
		login.setBackground(new Color(221, 160, 221));
		login.setTitle("AIRPORT MANAGEMENT SYSTEM");
		login.setBounds(100, 100, 487, 230);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(106, 46, 71, 23);
		login.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(189, 46, 116, 22);
		login.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(106, 82, 71, 16);
		login.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(189, 81, 116, 22);
		login.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(new Color(119, 136, 153));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField.getText().equalsIgnoreCase("manager") && passwordField.getText().equals("1234")) {
					
					MenuPageManager mp_manager = new MenuPageManager();
					mp_manager.getFrame().setVisible(true);
					login.setVisible(false);
				}
				
				else if(textField.getText().equalsIgnoreCase("salesman") && passwordField.getText().equals("1234")) {
					
					MenuPageSalesman mp_salesman = null;
					try {
						mp_salesman = new MenuPageSalesman();
					} catch (NumberFormatException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mp_salesman.getFrame().setVisible(true);
					login.setVisible(false);
				}
				
				else { 
					JOptionPane.showMessageDialog(login, "WRONG USERNAME OR PASSWORD");
					
				}
				
				
				
			}
		});
		btnNewButton.setBounds(199, 129, 97, 25);
		login.getContentPane().add(btnNewButton);
		


	}
}
