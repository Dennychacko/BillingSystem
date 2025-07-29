package tutorial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class Billing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtuser;
	private JLabel lbloutput;
	public String Username_id;
	private JPasswordField txtpass;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Billing frame = new Billing();
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
	public Billing() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Billing.class.getResource("/tutorial/icons/login_7856156.png")));
		setResizable(false);
		setTitle("Billing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtuser = new JTextField();
		txtuser.setBounds(169, 48, 177, 28);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		Username_id = txtuser.getText();
		
		txtpass = new JPasswordField();
		txtpass.setBounds(169, 92, 177, 28);
		contentPane.add(txtpass);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(55, 94, 89, 28);
		contentPane.add(lblPassword);
		
		JLabel lbloutput = new JLabel();
		lbloutput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbloutput.setBounds(141, 203, 242, 23);
		contentPane.add(lbloutput);
		
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(55, 48, 89, 33);
		contentPane.add(lblUsername);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(null);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtuser.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(btnLogin, "Please input a username");
					}else if(txtpass.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(btnLogin, "Please input a Password");
				}else if(txtuser.getText().trim().equals("Admin") && txtpass.getText().trim().equals("ADMIN")) {
					JOptionPane.showMessageDialog(btnLogin, "Login Success!!");
					Dashboard dash = new Dashboard();
					dash.setVisible(true);
					
					((JFrame)btnLogin.getTopLevelAncestor()).dispose();
				} else {
					JOptionPane.showMessageDialog(btnLogin, "Wrong Username or Password");
				}
				
				
			}
		});
		btnLogin.setBounds(55, 140, 128, 52);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(null);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(220, 140, 128, 52);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtuser.setText("");
				txtpass.setText("");
			}

		});
		contentPane.add(btnReset);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(122, 11, 185, 26);
		contentPane.add(lblNewLabel);
		
		
		
		

	}
}
