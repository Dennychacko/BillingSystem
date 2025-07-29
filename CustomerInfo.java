package tutorial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CustomerInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCustomer;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerInfo frame = new CustomerInfo();
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
	
	
	public CustomerInfo() {
		setTitle("CustomerInfo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblCustomerName = new JLabel("CustomerName Or Phone");
		lblCustomerName.setVerticalAlignment(SwingConstants.TOP);
		lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomerName.setBounds(10, 30, 194, 24);
		contentPane.add(lblCustomerName);
		
		txtCustomer = new JTextField();
		txtCustomer.setBounds(214, 30, 210, 24);
		contentPane.add(txtCustomer);
		txtCustomer.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(153, 102, 153));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keyword = txtCustomer.getText().trim();
				       searchCustomer(keyword);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBounds(214, 120, 100, 33);
		contentPane.add(btnSearch);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(153, 102, 153));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCustomer.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(324, 120, 100, 33);
		contentPane.add(btnReset);
		
		table = new JTable();
		table.setBackground(new Color(102, 102, 255));
		table.setBounds(10, 164, 414, 86);
		contentPane.add(table);

	}

private void searchCustomer(String keyword) {
	DefaultTableModel model = new DefaultTableModel();
	model.addColumn("name");
	model.addColumn("Phone");
	model.addColumn("Email");
	
	
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb",
					"root","ROOT");
			String sql = "SELECT * FROM customers WHERE name LIKE ? OR phone LIKE ? OR email LIKE ?";
			String LikeQuery = "%" + keyword + "%" ;
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, LikeQuery);
			stmt.setString(2, LikeQuery);
			stmt.setString(3, LikeQuery);
			
			ResultSet rs = stmt.executeQuery();
			    while(rs.next()) {
			    	model.addRow(new Object[] {
			    			rs.getString("name"),
			    			rs.getString("phone"),
			    			rs.getString("email")
			    	});
			    }
			
			    table.setModel(model);
			    
			    stmt.close();
			    conn.close();
			    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	
	}
}
