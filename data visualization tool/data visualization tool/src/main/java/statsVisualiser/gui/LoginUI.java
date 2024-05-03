package statsVisualiser.gui;


import java.util.HashMap;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;

public class LoginUI extends JFrame implements ActionListener{
	
	HashMap<String, String> logininfo = new HashMap<String, String>();

	private JPanel contentPane;
	JTextField tfUserName;
	JPasswordField tfPassword;
	JButton btnSubmit = new JButton("Login");
	JLabel messageLabel = new JLabel("This is a test");
	private JPanel panel;
	
	

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI(loginfo);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public LoginUI(HashMap<String, String> loginInfoOriginal) {
		contentPane = new JPanel();
		logininfo = loginInfoOriginal;
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 434, 201);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setBounds(7, 51, 81, 28);
		contentPane.add(lblUserName);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(73, 52, 341, 28);
		contentPane.add(tfUserName);
		tfUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(7, 98, 81, 26);
		contentPane.add(lblPassword);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(73, 98, 341, 28);
		tfPassword.setColumns(10);
		contentPane.add(tfPassword);
		
		
		
		
		
		btnSubmit.setBounds(164, 133, 92, 23);
		/*
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);
		
		panel = new JPanel();
		panel.setBounds(150, 17, 149, 28);
		contentPane.add(panel);
		panel.setLayout(null);
		messageLabel.setBounds(0, 0, 149, 28);
		panel.add(messageLabel);
		messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == btnSubmit) {
			String userID = tfUserName.getText();
			String password = String.valueOf(tfPassword.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login successful");
					//contentPane.disable();
					//after this go to MAIN UI
					setVisible(false);
					MainUI mainui = new MainUI(); 
					mainui.setVisible(true);
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong credentials");
				}
			}
			
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username not found");
				
			}
		}
		
	}
}