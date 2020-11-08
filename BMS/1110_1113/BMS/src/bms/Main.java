package bms;

import java.awt.EventQueue;

import bms.LogIn;

public class Main { //DB연결
	public static String url = "jdbc:mysql://localhost:3306/bms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static String user = "root";
	public static String password = "tj102938";
	
	public static void main(String[] args) {
		//Return ret = new Return();
		//ret.setVisible(true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { //첫화면 >> 로그인 화면 띄움
					LogIn frame = new LogIn();
					frame.setVisible(true);
	
				} catch (Exception e) {
					e.printStackTrace(); //실패시 오류메세지 출력
				}
			}
		});
	}
}