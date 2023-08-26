package test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC : Java Database Conectivity Framework
 * 1. Driver class load & register (DriverManager)
 * 2. get Connection (url, user, pwd)
 * 3. create Statement
 * 4. execute (sql)
 * 5. result ( , int, recordset)
 * 6. get data
 * 7. close (5, 3, 2)
 * 
 * @author gaiasun
 *
 */
public class TestJDBC_ans {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
// * 1. Driver class load & register (DriverManager)
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // database마다 url은 모두 다르다. 각 DB회사 홈페이지에서 찾아야 함.
		String user = "hr";
		String password = "hr";
		// * 2. get Connection (url, user, pwd)
		Connection conn = DriverManager.getConnection(url, user, password); 
		//tr관리는 connection(commit(), rollback())
		//conn.getMetadata() :: DatabaseMetaData, DBA권한이 필요.
// * 3. create Statement
		Statement stmt = conn.createStatement(); //db session (1 stmt : 1 resultset)
		// statement : 3종류(Statement, PreparedStatement, CallableStatement)
		String sql = "select * from employees";
		// * 4. execute (sql)
		ResultSet result = stmt.executeQuery(sql);
		//execute : execute(anySQL-callableSQL), executeUpdate(otherSQL), executeQuery(selectSQL) 
String resultStr = "";
		// * 5. result ( , int, recordset)
		ResultSetMetaData meta = result.getMetaData();// 전체 컬럼 값을 접근해서 모든 데이터를 출력
		System.out.println(meta.getColumnCount());
		// result.getMetadata() :: ResultSetMetaData
// * 6. get data
		while (result.next()) {
			resultStr  += result.getString(3)+"\n";
		}
		System.out.println(resultStr);
// * 7. close (5, 3, 2)
		result.close();
		stmt.close();
		conn.close();
	}

}
