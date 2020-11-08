package bms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LogIn extends JFrame {

	private JPanel contentPane;
	JPanel panel;
	JPanel panel_1;
	private JTextField textField;
	private JPasswordField passwordField;
	Connection conn;
	
	public LogIn() {
		setTitle("\uB85C\uADF8\uC778");
		
		conn = DBManager.getConnection();
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 794, 565);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(177, 144, 54, 53);
		lblId.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 45));
		lblId.setForeground(Color.WHITE);
		panel.add(lblId);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(177, 258, 200, 53);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 45));
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 25));
		textField.setBounds(177, 198, 313, 48);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("굴림", Font.PLAIN, 25));
		passwordField.setBounds(177, 311, 313, 45);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setBounds(515, 198, 137, 158);
	
		btnNewButton.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 45));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Join Us");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	//Join Us 버튼 >> 회원가입창 이동
							Join frame = new Join();
							frame.setVisible(true);
							dispose();
							
						} catch (Exception e) {
							e.printStackTrace(); // 실패시 오류메세지 출력
							
						}
					} //end of run
				});
			}
		});
		btnNewButton_1.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 30));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(653, 505, 127, 48);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uD68C\uC6D0 \uD0C8\uD1F4");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try { //회원탈퇴 버튼 >> 회원탈퇴창 이동
							DeleteUser frame = new DeleteUser();
							frame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace(); //실패시 오류메세지 출력
							
						}
					} //end of run
				});
				
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		btnNewButton_2.setBounds(503, 505, 127, 48);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\uB85C\uADF8\uC778");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		lblNewLabel.setBounds(38, 31, 206, 53);
		panel.add(lblNewLabel);
		

		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String password = passwordField.getText();
				
				try {
					loginCheck(id,password); //아이디 비밀번호 확인
					dispose();
					
				} catch (SQLException e1) {
					e1.printStackTrace(); //실패시 오류메세지 출력
				}
				
			}
		}); 
		this.setResizable(false);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void loginCheck(String id, String password) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	     String sjoinID = id;
		 String sjoinPS = password;
		 
		 String SQL = "SELECT * FROM client WHERE id=? and password= ?"; //client DB연결하여 로그인 확인
		 pstmt = conn.prepareStatement(SQL);
		 
		 pstmt.setString(1, sjoinID);
		 pstmt.setString(2, sjoinPS);
		 rs = pstmt.executeQuery();
		 
		 if(rs.next()) {
			 clearText(); // 아이디와 비밀번호가 일치할 경우
			 JOptionPane.showMessageDialog(null, "로그인 완료"); //완료 창 띄움
			LogInSub frame = new LogInSub();
			frame.setVisible(true);
		 } else { //아이디와 비밀번호가 일치하지 않을 경우
			 clearText();
			 JOptionPane.showMessageDialog(null, "로그인  실패"); 
		 }
		 
		 pstmt.close();
		 rs.close();
		 conn.close();
		 
	} //end of loginCheck
	private void clearText() {
		textField.setText("");
		passwordField.setText("");
	} //end of clearText
} //end of LogIn
