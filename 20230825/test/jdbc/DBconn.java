package test.jdbc;
// JDBC와 오라클 연결 확인
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:hr";
		String user = "SYSTEM";
		String password = "hr";
		
		try {
			//driver 로딩
			Class.forName(driver);
			System.out.println("jdbc driver 로딩 성공");
			//DB와 연결
			DriverManager.getConnection(url, user, password);
			System.out.println("오라클 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
		}
	}
}