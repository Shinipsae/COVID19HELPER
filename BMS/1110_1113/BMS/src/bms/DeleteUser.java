package bms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeleteUser extends JFrame { //회원탈퇴를 위한 클래스 생성

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	Connection conn;
	
	public DeleteUser() {
		setTitle("\uD68C\uC6D0\uD0C8\uD1F4");
		conn = DBManager.getConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 794, 565);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("ID");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 45));
		label.setBounds(199, 123, 54, 53);
		panel.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 25));
		textField.setColumns(10);
		textField.setBounds(199, 175, 313, 48);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("PASSWORD");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 45));
		label_1.setBounds(199, 245, 200, 53);
		panel.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("굴림", Font.PLAIN, 25));
		passwordField.setBounds(199, 299, 313, 45);
		panel.add(passwordField);
		
		JButton button = new JButton("\uD68C\uC6D0\r\n\uC0AD\uC81C"); //회원탈퇴버튼
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText(); // 입력받은 값 변수에 저장
				String pw = passwordField.getText(); // 입력받은 값 변수에 저장
				
				try {
					deleteCheck(id,pw); //회원정보 삭제 
					LogIn frame = new LogIn();
					frame.setVisible(true); //LogIn 화면으로  이동
					dispose();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					
				}
				
			}
		});
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		button.setBackground(Color.WHITE);
		button.setBounds(526, 175, 137, 169);
		panel.add(button);
		
		JButton btnNewButton = new JButton("Back"); //뒤로가기
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LogIn frame = new LogIn();
							frame.setVisible(true); //LogIn 화면으로 이동
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});	
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 25));
		btnNewButton.setBounds(25, 506, 105, 35);
		panel.add(btnNewButton);
	
		this.setResizable(false);
		this.setBounds(100, 100, 450, 300);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//end of DeleteUser()
	
	private void deleteCheck(String id, String password) throws SQLException { //회원정보 삭제 메서드
			PreparedStatement pstmt = null; 
				String sql = "";
				ResultSet rs = null;
				
				sql = "select password from client where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id); //물음표의 값지정

				rs=(ResultSet) pstmt.executeQuery();
			try {
				if(rs.next()) {
					rs.getString(1);
					//String dbpw = rs.getString("password"); !!!!!!!!!!!!
					if(password.contentEquals(password)) {
						sql="delete from client where id =?"; 
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, id); //물음표의 값지정
						pstmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "회원정보가 삭제되었습니다.");
						Join frame = new Join();
						frame.setVisible(true);	 //회원가입 화면으로 이동 
					}else {
						JOptionPane.showMessageDialog(null, "비밀번호 틀림");
					}
				}else {
					JOptionPane.showMessageDialog(null, "id가 없습니다");
				}
			
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					   if(rs!=null)try{rs.close();}catch(SQLException ex){}
					   if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
					   if(conn!=null)try{conn.close();}catch(SQLException ex){}
				}
	}//end of deleteCheck
}//end of DeleteUser