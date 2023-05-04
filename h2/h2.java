package h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class h2 {
	public static void main(String[] args) {
		Connection con = null;
		try {
			String driver = "org.h2.Driver";
			String url = "jdbc:h2:tcp://localhost/~/telephone";
			String username = "scott";
			String password = "tiger";
			//로드하는 명령문
			Class.forName(driver);
			//커넥션할 수 있는 객체 얻기
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connetion Succes");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}


