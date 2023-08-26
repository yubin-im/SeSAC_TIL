package test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

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
public class TestJDBC {
	private static Statement stmt;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// * 1. Driver class load & register (DriverManager)
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// (나) url에서 xe -> hr로 변경함
		String url = "jdbc:oracle:thin:@localhost:1521:hr"; // database마다 url은 모두 다르다. 각 DB회사 홈페이지에서 찾아야 함.
		String user = "SYSTEM";  // (나) hr에서 SYSTEM으로 변경
		String password = "hr";
		
		// * 2. get Connection (url, user, pwd)
		Connection conn = DriverManager.getConnection(url, user, password); 
		// tr관리는 connection(commit(), rollback())
		// conn.getMetadata() :: DatabaseMetaData, DBA권한이 필요.
		
		// * 3. create Statement
		stmt = conn.createStatement(); //db session (1 stmt : 1 resultset)
		// statement : 3종류(Statement, PreparedStatement, CallableStatement)
		
		
		// 20230825 실습
		int result = 0;
		Board board1 = new Board(0, "홍길동", "mrhong@mt.co.kr", "1111", "나는 산에 산다", "자연인이다, 산에 산다. 좋다...", new Date(), 0, 0, 0, 0, "1");
		Board board2 = new Board("홍길동", "mrhong@mt.co.kr", "1111", "나는 산에 산다", "자연인이다, 산에 산다. 좋다...", 0, 0, 0, "1");
		
		result = insert(board1);
		result += insert(board2);
		System.out.println("insert:: " + result);
		
		board1 = null;
		int num = 1;
		
		board1 = select(num);
		System.out.println("select:: " + board1);
		
		board1.setName("고길동");
		board1.setEmail("gdkoh@ssangmun.com");
		
		result = update(num, board1);
		board1 = select(num);
		System.out.println("select:: " + board1);
		
		result = delete(num);
		board1 = select(num);
		System.out.println("select:: " + board1);
		
		// * 7. close (5, 3, 2)
		stmt.close();
		conn.close();
	}
	
	// Thread의 안정적인 코드: JDBC 2~7까지 모두 갖춰야함
	// 함수가 너무 느려진다. -> Connection -> Pool로 관리해야함.
	private static int delete(int num) throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:hr"; // database마다 url은 모두 다르다. 각 DB회사 홈페이지에서 찾아야 함.
		String user = "SYSTEM";
		String password = "hr";
		
		// * 2. get Connection (url, user, pwd)
		Connection conn = DriverManager.getConnection(url, user, password); 
		// tr관리는 connection(commit(), rollback())
		// conn.getMetadata() :: DatabaseMetaData, DBA권한이 필요.
		
		// * 3. create Statement
		Statement stmt = conn.createStatement(); //db session (1 stmt : 1 resultset)
		// statement : 3종류(Statement, PreparedStatement, CallableStatement)
		
		String sql = "delete from board where num =" + num;
		int result = stmt.executeUpdate(sql);
		
		// * 7. close (5, 3, 2)
		stmt.close();
		conn.close();
		
		return result;
	}

	private static int update(int num, Board board) throws SQLException {
		String sql = "update board set name="
				+ "'" + board.getName() + "',"
				+ "email="
				+ "'" + board.getEmail() + "',"
				+ " subject="
				+ "'" + board.getSubject() + "',"
				+ " content="
				+ "'" + board.getContent() + "',"
				+ " regdate = sysdate"
				+ " where num = " + num;

		// * 4. execute Update(sql)
		int result = stmt.executeUpdate(sql);
		return result;
	}

	private static Board select(int num) throws SQLException{
		String sql = "select * from board where num = " + num;
		
		// * 4. execute (sql)
		ResultSet result = stmt.executeQuery(sql);
		//execute : execute(anySQL-callableSQL), executeUpdate(otherSQL), executeQuery(selectSQL) 
		Board board = null;
		
		// * 5. result ( , int, recordset)
		// 전체 컬럼 값을 접근해서 모든 데이터를 출력
		// ResultSetMetaData meta = result.getMetaData();
		// result.getMetadata() :: ResultSetMetaData

		// * 6. get data
		while (result.next()) {
			board = new Board(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getDate(7), result.getInt(8), result.getInt(9), result.getInt(10), result.getInt(11), result.getString(12));
		}
		System.out.println(board);
		result.close();
		return board;
	}

	private static int insert(Board board) throws SQLException {
		String sql = "insert into board(num, name, email, pwd, subject, content, regdate, hit, parent, sort, tab, originalfile)\r\n"
				+ "values((select NVL(max(num),0)+1 from board), "
				+ "'" + board.getName() + "',"
				+ "'" + board.getEmail() + "',"
				+ "'" + board.getPwd() + "',"
				+ "'" + board.getSubject() + "',"
				+ "'" + board.getContent() + "',"
				+ "SYSDATE,"
				+ board.getHit() + ","
				+ "(select NVL(max(num),0)+1 from board),"
				+ board.getSort() + ","
				+ board.getTab() + ","
				+ "'" + board.getOriginal() + "')";
		
		// * 4. execute Update(sql): insert, delete, update
		int result = stmt.executeUpdate(sql);
		return result;
	}

}
