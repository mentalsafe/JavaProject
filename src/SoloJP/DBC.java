package SoloJP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {

		public static Connection DBConnect() {
			Connection con = null;
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "MENTALSAFE";
			String password = "132465";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url,user,password);
				System.out.println("DB접속 성공!");
			} catch (ClassNotFoundException cne) {
				cne.printStackTrace();
				System.out.println("DB접속 실패 : 드라이버 로딩 실패");
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println("DB접속 실패 : 계정정보 확인!");
			}
			return con;	
		}
	
	
	
}
