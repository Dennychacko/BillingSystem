package tutorial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setTitle("Main Menu");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/tutorial/icons/supermarket_8422849.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setUndecorated(false);
		
		contentPane = new JPanel(null);
		contentPane.setBackground(new Color(0, 0, 255));
		contentPane.setLayout(null);
		contentPane.setPreferredSize(new Dimension(width, height));
		contentPane.setSize(width, height);
		pack();
		setContentPane(contentPane);
		
		JLabel lblSuperMkt = new JLabel("Welcome to ABC SuperMarket ");
		lblSuperMkt.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuperMkt.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSuperMkt.setBounds(449, 0, 496, 54);
		contentPane.add(lblSuperMkt);
		
		JLabel lblMainMenu = new JLabel("MAIN MENU");
		lblMainMenu.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMenu.setBounds(459, 59, 486, 65);
		contentPane.add(lblMainMenu);
		
		JButton btnNewCustomer = new JButton("NewCustomer");
		btnNewCustomer.setForeground(new Color(255, 255, 255));
		btnNewCustomer.setBackground(new Color(0, 0, 0));
		btnNewCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewCustomer.setBounds(619, 170, 176, 39);
		btnNewCustomer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			       NewCustomer Ncus = new NewCustomer();
			       Ncus.setVisible(true);
			}
			}); 
		contentPane.add(btnNewCustomer);
		
		JButton btnNewBill = new JButton("NewBill");
		btnNewBill.setForeground(new Color(255, 255, 255));
		btnNewBill.setBackground(new Color(0, 0, 0));
		btnNewBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewBill NBill = new NewBill();
				NBill.setVisible(true);
			}
		});
		btnNewBill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewBill.setBounds(619, 233, 176, 39);
		contentPane.add(btnNewBill);
		
		JButton btnCustomerInfo = new JButton("CustomerInfo");
		btnCustomerInfo.setForeground(new Color(255, 255, 255));
		btnCustomerInfo.setBackground(new Color(0, 0, 0));
		btnCustomerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CustomerInfo info = new CustomerInfo();
				info.setVisible(true);
				
				
			}
		});
		btnCustomerInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCustomerInfo.setBounds(619, 295, 176, 39);
		contentPane.add(btnCustomerInfo);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(0, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnExit, "Thank You for Using Our Software");
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.setBounds(619, 360, 176, 39);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/tutorial/icons/supermarket_8422849.png")));
		lblNewLabel.setBounds(0, 0, 1366, 768);
		contentPane.add(lblNewLabel);

	}
}
