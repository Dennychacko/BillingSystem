package tutorial;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Color;

public class NewCustomer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtNumber;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCustomer frame = new NewCustomer();
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
	public NewCustomer() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewCustomer.class.getResource("/tutorial/icons/supermarket_8422849.png")));
		setTitle("NewCustomer");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(10, 11, 72, 23);
		btnBack.addActionListener(e ->{
			dispose();
			});
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 60, 66, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(9, 91, 67, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 122, 66, 19);
		contentPane.add(lblNewLabel_2);
		
		txtName = new JTextField();
		txtName.setBounds(123, 63, 169, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtNumber = new JTextField();
		txtNumber.setBounds(123, 93, 169, 20);
		contentPane.add(txtNumber);
		txtNumber.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(123, 123, 169, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.LIGHT_GRAY);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(txtNumber.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(txtNumber, "You Have Not Entered Number");
					
				}else {
					
					String name = txtName.getText();
					String phone = txtNumber.getText();
					String email = txtEmail.getText();
					try {
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root","ROOT");
						
						String sql = "INSERT INTO customers (name, email, phone) VALUES (?, ?, ?)";
						PreparedStatement stmt = conn.prepareStatement(sql);
						stmt.setString(1, name);
						stmt.setString(2, email);
						stmt.setString(3, phone);
						
						int result = stmt.executeUpdate();
						if(result > 0) {
							JOptionPane.showMessageDialog(null, "customer saved successfully!");
							
							txtName.setText("");
							txtNumber.setText("");
							txtEmail.setText("");
						}
						
						stmt.close();
						conn.close();
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(104, 187, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtNumber.setText("");
				txtEmail.setText("");
			}
		});	
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(203, 187, 89, 23);
		contentPane.add(btnReset);

	}
}
