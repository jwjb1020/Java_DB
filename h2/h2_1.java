package h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// select 문 ==> 
public class h2_1 {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	private void insertDeptStatement(String dno, String dname, int budget) {
		String sql = String.format("insert into dept (dno, dname, budget) values ('%s','%s','%d')", dno, dname, budget);

		try {
			Statement st = con.createStatement();
			int cnt = st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private void insertDept(String dno, String dname, int budget) {
		String sql = "insert into dept(dno, dname, budget) values (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, dno);
			ps.setString(2, dname);
			ps.setInt(3, budget);

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("입력");
	}

	private void selectDisplay() {
		String sql = String.format("select * from dept");

		try {
			Statement st = con.createStatement();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(
						String.format("%s,%s,%d", rs.getString("dno"), rs.getString("dname"), rs.getInt("budget")));
				// 타입에 맞는 메소드 사용해야함
				// %s 문자열, %c 문자, %d int, %l log ....
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private boolean connectH2() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:~/telephone", "scott", "tiger");
			System.out.println("연결");
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private void closeH2() {
		try {
			con.close();
			System.out.println("닫힘");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		h2_1 tt = new h2_1();
		if (tt.connectH2()) {
//			for (int i = 0; i < 100; i++) {
//				tt.insertDept("d"+i, "dname", i);
//			}
			tt.selectDisplay();

			tt.closeH2();
		}

	}

}
