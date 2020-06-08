package swingClasses;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayEmployee {

	private JFrame frame;
	private JFrame superF;
	private JScrollPane pane;
	private JTable jTable1;
	private JTableHeader header;
	private DefaultTableModel model;

	private JPanel panel;
	private JButton btnBack;

	public DisplayEmployee() {

		
		frame = new JFrame();
		panel = new JPanel();
		panel.setBackground(new Color(102, 102, 153));
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
		jTable1.setBackground(new Color(255, 204, 153));
		jTable1.setForeground(new Color(0, 0, 0));
		jTable1.setRowHeight(30);
		// String data[] = { "ali", "cagatay", "213412", "324234" };
		for (int i = 0; i < Login.airportManagement.getEmployees().size(); i++) {
			String name = Login.airportManagement.getEmployees().get(i).getName();
			String surname = Login.airportManagement.getEmployees().get(i).getSurname();
			String date = Login.airportManagement.getEmployees().get(i).getBirthdate().displayDate();
			String phone = Login.airportManagement.getEmployees().get(i).getPhoneNumber().displayPhone();
			String data[] = { name, surname, date, phone };
			model.addRow(data);

		}
		// model.addRow(data);

		header = jTable1.getTableHeader();
		header.setBackground(Color.yellow);
		panel.setLayout(null);

		pane = new JScrollPane(jTable1);
		pane.setBounds(22, 37, 452, 622);
		jTable1.setBounds(21, 45, 452, 655);

		panel.add(pane);
		frame.getContentPane().add(panel);

		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnBack.setBounds(208, 690, 97, 25);
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