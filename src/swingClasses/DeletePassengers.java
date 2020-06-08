
package swingClasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeletePassengers {

	private JFrame frame;
	private JFrame superF;
	private JScrollPane pane;
	private JTable jTable1;
	private JTableHeader header;
	private DefaultTableModel model;
	private JPanel panel;
	private JButton btnBack;

	public DeletePassengers() {
	
		frame = new JFrame();
		panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
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
		jTable1.setBackground(new Color(153, 204, 204));
		jTable1.setForeground(new Color(0, 0, 0));
		jTable1.setRowHeight(30);
	
		for (int i = 0; i < Login.ticketManagement.getPassengers().size(); i++) {
			String name = Login.ticketManagement.getPassengers().get(i).getName();
			String surname = Login.ticketManagement.getPassengers().get(i).getSurname();
			String date = Login.ticketManagement.getPassengers().get(i).getBirthdate().displayDate();
			String phone = Login.ticketManagement.getPassengers().get(i).getPhoneNumber().displayPhone();
			String data[] = { name, surname, date, phone };
			model.addRow(data);

		}

		header = jTable1.getTableHeader();
		header.setBackground(Color.yellow);
		panel.setLayout(null);

		pane = new JScrollPane(jTable1);
		pane.setBounds(22, 37, 452, 614);
		jTable1.setBounds(21, 45, 452, 655);

		panel.add(pane);
		frame.getContentPane().add(panel);

		JButton btnRemoveSelectedRow = new JButton("Remove Selected Row");
		btnRemoveSelectedRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model2 = (DefaultTableModel) jTable1.getModel();
				int selectedRowIndex = jTable1.getSelectedRow();
				try {
					model2.removeRow(selectedRowIndex);
					for (int i = 0; i < Login.ticketManagement.getPassengers().size(); i++) {
						if (Login.airportManagement.getFlightAttendants().get(i).getName().equals(Login.airportManagement.getEmployees().get(selectedRowIndex).getName()))
							Login.airportManagement.getFlightAttendants().remove(i);

					}
					
					Login.ticketManagement.getPassengers().remove(selectedRowIndex);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnRemoveSelectedRow.setBounds(293, 667, 181, 25);
		panel.add(btnRemoveSelectedRow);

		btnBack = new JButton("BACK");
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
		btnBack.setBounds(22, 667, 97, 25);
		panel.add(btnBack);

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