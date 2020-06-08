package swingClasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayPassengers {

	private JFrame frame;
	private JFrame superF;
	private JScrollPane pane;
	private JTable jTable1;
	private JTableHeader header;
	private DefaultTableModel model;
	private JPanel panel;

public DisplayPassengers() {
		
		frame = new JFrame();
		panel = new JPanel();
		panel.setBackground(new Color(153, 153, 153));
		jTable1 = new JTable();

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

		String col[] = { "Name", "Surname", "Birtdate", "Phone" };

		model = new DefaultTableModel();
		model.setColumnIdentifiers(col);
		jTable1.setModel(model);
		jTable1.setBackground(new Color(255, 255, 255));
		jTable1.setForeground(new Color(0, 0, 0));
		jTable1.setRowHeight(30);
		for(int i = 0; i < Login.ticketManagement.getPassengers().size(); i++) {
			String name = Login.ticketManagement.getPassengers().get(i).getName();
			String surname =  Login.ticketManagement.getPassengers().get(i).getSurname();
			String birthdate = Login.ticketManagement.getPassengers().get(i).getBirthdate().displayDate();
			String phone = Login.ticketManagement.getPassengers().get(i).getPhoneNumber().displayPhone();
			String data[] = {name,surname, birthdate, phone};
		
			model.addRow(data);
			
		}

		header = jTable1.getTableHeader();
		header.setBackground(Color.gray);
		panel.setLayout(null);

		pane = new JScrollPane(jTable1);
		pane.setBounds(22, 37, 452, 548);
		jTable1.setBounds(21, 45, 452, 655);

		panel.add(pane);
		frame.getContentPane().add(panel);
		frame.setSize(500, 750);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
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
		btnOk.setBounds(200, 609, 97, 25);
		panel.add(btnOk);

		

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
