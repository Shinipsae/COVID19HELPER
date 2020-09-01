package javamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
	// �̱��� ���� ���
	private static ConnectDB instance = new ConnectDB();
	
	public static ConnectDB getInstance() {
		return instance;
	}
	
	public ConnectDB() {
		
	}
	
	private String jdbcUrl = "jdbc:mysql://localhost:3306/COVID19HELPER";
	private String dbId = "root";
	private String dbPw = "1234";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private PreparedStatement pstmt2 = null;
	private ResultSet rs = null;
	private String sql = "";
	private String sql2 = "";
	String returns = "";
	String returns2 = "";
	
	// �����ͺ��̽��� ����ϱ� ���� �ڵ尡 ����ִ� �޼���
	public String joindb(String id, String pw) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			sql = "select id from client where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("id").equals(id)) { // �̹� ���̵� �ִ� ���
					returns = "id";
				}
			} else { // �Է��� ���̵� ���� ���
				sql2 = "insert into client values(?,?)";
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, id);
				pstmt2.setString(2, pw);
				pstmt2.executeUpdate();
				returns = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {}
			}
			if(pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (SQLException ex) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {}
			}
		}
		return returns;
		
	}
	
	public String logindb(String id, String pw) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			sql = "select id, pw from client where id=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if (rs.getString("id").equals(id) && rs.getString("pw").equals(pw)) {
					returns2 = "true"; // �α��� ����
				} else {
					returns2 = "false"; // �α��� ����
				}
			} else {
				returns2 = "noId"; // ���̵� �Ǵ� ��й�ȣ ���� x
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {}
			}
		}
		return returns2;
	}
}