package swingClasses;
import management.*;
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
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChangeEmployeeSalary {

	private JFrame frame;
	private JFrame superF;
	private JScrollPane pane;
	private JTable jTable1;
	private JTableHeader header;
	private DefaultTableModel model;

	private JPanel panel;
	private JTextField newSlary;

	public ChangeEmployeeSalary() {
		frame = new JFrame();
		panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
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

		String col[] = { "Name", "Surname", "Birtdate", "Phone", "Salary" };

		model = new DefaultTableModel();
		model.setColumnIdentifiers(col);
		jTable1.setModel(model);
		jTable1.setBackground(new Color(216, 191, 216));
		jTable1.setForeground(new Color(0, 0, 0));
		jTable1.setRowHeight(30);
		for (int i = 0; i < Login.airportManagement.getEmployees().size(); i++) {
			String name = Login.airportManagement.getEmployees().get(i).getName();
			String surname = Login.airportManagement.getEmployees().get(i).getSurname();
			String date = Login.airportManagement.getEmployees().get(i).getBirthdate().displayDate();
			String phone = Login.airportManagement.getEmployees().get(i).getPhoneNumber().displayPhone();
			String salary = Double.toString(Login.airportManagement.getEmployees().get(i).getSalary());
			String data[] = { name, surname, date, phone, salary };
			model.addRow(data);

		}
		// model.addRow(data);

		header = jTable1.getTableHeader();
		header.setBackground(Color.yellow);
		panel.setLayout(null);

		pane = new JScrollPane(jTable1);
		pane.setBounds(22, 37, 452, 655);
		jTable1.setBounds(21, 45, 452, 655);

		panel.add(pane);
		frame.getContentPane().add(panel);

		JLabel lblNew = new JLabel("NEW SALARY");
		lblNew.setBounds(498, 124, 86, 25);
		panel.add(lblNew);

		newSlary = new JTextField();
		newSlary.setBounds(585, 124, 112, 25);
		panel.add(newSlary);
		newSlary.setColumns(10);

		JButton btnChangeSalary = new JButton("BACK");
		btnChangeSalary.setBackground(new Color(205, 92, 92));
		btnChangeSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MenuPageManager menuPageManager = new MenuPageManager();
					menuPageManager.getFrame().setVisible(true);
					frame.setVisible(false);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnChangeSalary.setBounds(585, 242, 112, 25);
		panel.add(btnChangeSalary);

		frame.setSize(721, 778);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JButton btnRemoveSelectedRow = new JButton("CHANGE");
		btnRemoveSelectedRow.setBackground(new Color(205, 92, 92));
		btnRemoveSelectedRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model2 = (DefaultTableModel) jTable1.getModel();
				int selectedRowIndex = jTable1.getSelectedRow();
				try {
					// model2.removeRow(selectedRowIndex);
					String name = model.getValueAt(selectedRowIndex, 0).toString();
					String surname = model.getValueAt(selectedRowIndex, 1).toString();
					Date birtdate = new Date(
							Integer.parseInt(model.getValueAt(selectedRowIndex, 2).toString().split("/")[0]),
							Integer.parseInt(model.getValueAt(selectedRowIndex, 2).toString().split("/")[1]),
							Integer.parseInt(model.getValueAt(selectedRowIndex, 2).toString().split("/")[2]));
					for (int i = 0; i < Login.airportManagement.getEmployees().size(); i++) {
						if (Login.airportManagement.getEmployees().get(i).getName() == name
								&& Login.airportManagement.getEmployees().get(i).getSurname() == surname) {
							Login.airportManagement.getManager().changeSalary(Login.airportManagement.getEmployees().get(i),
									Double.parseDouble(newSlary.getText().toString()));
							model.setValueAt(newSlary.getText(), selectedRowIndex, 4);
							JOptionPane.showMessageDialog(frame, "Salary Changed");

						}

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnRemoveSelectedRow.setBounds(585, 162, 112, 25);
		panel.add(btnRemoveSelectedRow);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}