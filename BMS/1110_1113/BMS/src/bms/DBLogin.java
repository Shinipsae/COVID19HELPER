package bms;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.Properties;
	 
	public class DBLogin {
	 
	    String id = null;
	    String pw = null;
	 
	    Statement stmt = null;
	    ResultSet rs = null;
	    String url = "jdbc:mysql://localhost:3306/bms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String sql = null;
	    Properties info = null;
	    Connection cnn = null;
	 
	    int checkIDPW(String id, String pw) { //���̵�� ��й�ȣ�� ���޹޾� �α��� 
	        this.id = id;
	        this.pw = pw;
	        int result = 1;
	 
	        try {
	            Class.forName("org.gjt.mm.mysql.Driver"); 
	            info = new Properties();
	            info.setProperty("user", "root");
	            info.setProperty("password", "tj102938");
	            cnn = DriverManager.getConnection(url, info); // ������ ������ �������ִ� ����̹��Ŵ����� ������
	            stmt = cnn.createStatement();
	 
	            sql = "select * from users where id=''" + id + "'"; 
	            rs = stmt.executeQuery(sql); 
	 
	            if (rs.next() == false || (id.isEmpty()) == true) { // id�� ����x
	                result = 1;
	            } else {
	                sql = "select * from (select * from users where id=''" + id + "')";
	                rs = stmt.executeQuery(sql);
	                while (rs.next() == true) {         // ��������
	                    if (rs.getString(2).equals(pw)) { // pw�� ������ ��
	                        result = 0;         // ������ �α��� ����
	                    } else {                // ���̵�� ���� pw�� �ٸ����
	                        result = 1;
	                    }
	                }
	            }
	        } catch (Exception ee) {
	            System.out.println("��������");
	            ee.printStackTrace();
	        }
	        return result;
	    }//end of checkIDPW
	
}//end of DBLogIn