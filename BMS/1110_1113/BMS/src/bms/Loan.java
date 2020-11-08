package bms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Loan extends JFrame { 
	

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loan frame = new Loan(); //���� â ���
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); //���н� �����޼��� ���
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Loan() {
		setTitle("\uB300\uCD9C & \uAC80\uC0C9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String columnNames[] = { "ISBN(å�ڵ�)", "����", "�۰�", "���ǻ�"};
		Object rowData[][] = { };
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C\uAC80\uC0C9");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("HY������M", Font.PLAIN, 30));
		lblNewLabel.setBounds(22, 10, 146, 74);
		contentPane.add(lblNewLabel);
		
		DefaultTableModel defaultTableModel = new DefaultTableModel(rowData, columnNames);	
		DefaultTableModel defaultTableModel2 = new DefaultTableModel(rowData, columnNames);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(42, 85, 367, 434);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTable jTable = new JTable(defaultTableModel);
		JScrollPane jScollPane = new JScrollPane(jTable);
		jScollPane.setBounds(12, 95, 343, 261);
		panel.add(jScollPane);
		jScollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		
		JLabel label = new JLabel("[ \uCD94\uCC9C\uB3C4\uC11C ] ");
		label.setBounds(116, 10, 140, 74);
		panel.add(label);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("HY������M", Font.PLAIN, 25));
		
		JButton btnLoan = new JButton("Loan");
		btnLoan.setBounds(12, 366, 343, 43);
		panel.add(btnLoan);
		btnLoan.setFont(new Font("HY������M", Font.PLAIN, 20));
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Test test = new Test();
							test.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});	
			}
		});
		
		textField = new JTextField();
		textField.setBounds(434, 85, 272, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(421, 85, 1, 434);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("HY������M", Font.PLAIN, 20));
		btnNewButton.setBounds(718, 85, 178, 43);
		contentPane.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(434, 138, 462, 381);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTable jTable2 = new JTable(defaultTableModel2);
		JScrollPane jScollPane2 = new JScrollPane(jTable2);
		jScollPane2.setBounds(12, 20, 438, 340);
		jScollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_2.add(jScollPane2);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("HY������M", Font.PLAIN, 20));
		btnBack.setBounds(795, 30, 101, 43);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try { //Back ��ư >> ���θ޴�â���� �̵�
							LogInSub frame = new LogInSub();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace(); //���н� �����޼��� ���
						}
					}
				});
			}
		});
		
		
		try {
			String sql = "SELECT * FROM book";  //��õ ���� DB������ ���
			Connection conn= DriverManager.getConnection(Main.url, Main.user, Main.password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				String bookName = rs.getString("ISBN");
				String bookISBN = rs.getString("name");
				String bookAuthor = rs.getString("author");
				String bookPublisher = rs.getString("publisher");
				
				Object data[] = {bookName, bookISBN, bookAuthor, bookPublisher};
				defaultTableModel.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace(); //���н� �����޼��� ���
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = textField.getText();
					String sql = "SELECT * FROM book WHERE name = '" + name + "'"; //book���� ���� �˻� ��� ����
					
					Connection conn = DriverManager.getConnection(Main.url, Main.user, Main.password);
					Statement stmt = conn.createStatement();
	
					stmt.executeQuery(sql);
					ResultSet rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						String bookName = rs.getString("ISBN");
						String bookISBN = rs.getString("name");
						String bookAuthor = rs.getString("author");
						String bookPublisher = rs.getString("publisher");
						
						Object data[] = {bookName, bookISBN, bookAuthor, bookPublisher};
						defaultTableModel2.addRow(data);
					}
					
					stmt.close();
					conn.close();
				
				} catch (SQLException e1) {
					e1.printStackTrace(); //���н� �����޼��� ���
				}
			}
		});
	}
} //end of Loan