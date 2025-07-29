package tutorial;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class NewBill extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtProductName;
	private JTextField txtQuantity;
	private JTextField txtPricePerUnit;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBill frame = new NewBill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewBill() {
		setTitle("NewBill");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		Dimension Screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = Screensize.width;
	    int height = Screensize.height;
	    setUndecorated(false);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setPreferredSize(new Dimension(width, height));
		contentPane.setSize(width, height);
		pack();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("*NB:: Only Staff's And Admins Can Only Use This Software ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 1346, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblProductName = new JLabel("ProductName");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductName.setBounds(50, 123, 99, 28);
		contentPane.add(lblProductName);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantity.setBounds(50, 186, 99, 28);
		contentPane.add(lblQuantity);
		
		JLabel lblPricePerUnit = new JLabel("PricePerUnit");
		lblPricePerUnit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPricePerUnit.setBounds(50, 248, 99, 28);
		contentPane.add(lblPricePerUnit);
		
		txtProductName = new JTextField();
		txtProductName.setBounds(222, 123, 200, 28);
		contentPane.add(txtProductName);
		txtProductName.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(222, 186, 200, 28);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		txtPricePerUnit = new JTextField();
		txtPricePerUnit.setBounds(222, 248, 200, 28);
		contentPane.add(txtPricePerUnit);
		txtPricePerUnit.setColumns(10);
		
		JButton btnNewButton = new JButton("Add +");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txtProductName.getText();
				int quantity = Integer.parseInt(txtQuantity.getText());
				double price = Double.parseDouble(txtPricePerUnit.getText());
				double total = quantity * price;
				double grandtotal;
				Connection conn = null;
				
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "ROOT");
					String sql = "INSERT INTO bill_items(product_name, quantity, price) VALUES (?, ?, ?)";
					PreparedStatement stmt = conn.prepareStatement(sql);
					
					stmt.setString(1, name);
					stmt.setInt(2, quantity);
					stmt.setDouble(3, total);
					int result = stmt.executeUpdate();
					
					if(result > 0) {
						JOptionPane.showMessageDialog(null, "Item Added!");
						txtProductName.setText("");
						txtQuantity.setText("");
						txtPricePerUnit.setText("");
					}
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Product Name");
					model.addColumn("Quantity");
					model.addColumn("Price");
					
					try {
						Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "ROOT");
						String sql1 = "SELECT * FROM bill_items";
						PreparedStatement stmt1 = conn1.prepareStatement(sql1);
						ResultSet rs = stmt1.executeQuery();			
						while (rs.next()) {
							model.addRow(new Object[] {
									rs.getString("product_name"),
									rs.getInt("quantity"),
									rs.getDouble("price")
									
							});
						}
						table.setModel(model);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					DefaultTableModel model1 = new DefaultTableModel();
					model1.addColumn("Product Name");
					model1.addColumn("Quantity");
					model1.addColumn("Price");
					
					try {
						model.setRowCount(0);
						Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "ROOT");
						String sql1 = "SELECT * FROM bill_items";
						PreparedStatement stmt1 = conn1.prepareStatement(sql1);
						ResultSet rs = stmt1.executeQuery();			
						while (rs.next()) {
							model1.addRow(new Object[] {
									rs.getString("product_name"),
									rs.getInt("quantity"),
									rs.getDouble("price")
									
							});
						}
						table.setModel(model1);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(50, 336, 99, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(222, 336, 99, 35);
		contentPane.add(btnNewButton_1);
	
		
		
		table = new JTable();
		table.setBounds(559, 87, 476, 284);
		contentPane.add(table);

	
}
}
