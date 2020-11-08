package bms;

	import java.beans.Statement;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class DBManager { //데이터베이스 연결 매니저 클래스 생성
		
		static Connection getConnection() {
			Connection conn = null;
			Statement stmt;
			try {
				String url = "jdbc:mysql://localhost:3306/bms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				conn = DriverManager.getConnection(url, "root", "tj102938");
				
			} catch (Exception e) {
				System.out.println("DB 연결 실패");
				e.printStackTrace();
			}
			return conn;
		}//Connection END
	}//end of DBManager

