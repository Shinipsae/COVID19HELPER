package bms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bms.LogIn;
import bms.LogInSub;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInSub extends JFrame {

	private JPanel contentPane;
	public LogInSub() {
		setTitle("\uBA54\uC778\uBA54\uB274");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 794, 565);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("\uB300\uCD9C & \uAC80\uC0C9");
		button.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		button.setBackground(Color.WHITE);
		button.setBounds(197, 98, 400, 60);
		panel.add(button);
		button.addActionListener(new ActionListener() { //대출 버튼
			public void actionPerformed(ActionEvent e) {
				Loan loan = new Loan(); //대출 창 띄움
				loan.setVisible(true);	
				dispose();
			}
		});
		
		JButton button_1 = new JButton("\uBC18\uB0A9");
		button_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(197, 226, 400, 60);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener() { //반납 버튼
			public void actionPerformed(ActionEvent e) {
					Return ret = new Return(); //반납 창 띄움
					ret.setVisible(true);		
					dispose();
			}
		});

		
		JButton button_2 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //로그아웃 버튼
				LogInSub frame = new LogInSub();  
				frame.setVisible(false);
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다."); //성공 메세지 출력
				LogIn frame1 = new LogIn(); //이후 로그인 창 띄움
				frame1.setVisible(true);
				dispose();
			}
		});
		button_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(197, 356, 400, 60);
		panel.add(button_2);
		
		JButton button_3 = new JButton("EXIT");
		button_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 35));
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(586, 473, 127, 40);
		panel.add(button_3);
		button_3.addActionListener(new ActionListener() { //로그인 버튼
			public void actionPerformed(ActionEvent e) {
				LogIn login = new LogIn(); //로그인 창 띄움
				login.setVisible(true);			
			}
		});
		
		this.setResizable(false);
		this.setBounds(100, 100, 450, 300);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
