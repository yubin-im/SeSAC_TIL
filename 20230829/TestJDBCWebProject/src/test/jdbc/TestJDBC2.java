package test.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * JDBC : Java Database Conectivity Framework
 * make method(transaction method) : single thread, API로 사용하지 않는다.
 * 4. execute (sql)
 * 5. result ( , int, recordset)
 * 6. get data
 * 
 * make method(transaction method) : multi-thread, API(= common module)
 * 2. get Connection (url, user, pwd)
 * 3. create Statement
 * 4. execute (sql)
 * 5. result ( , int, recordset)
 * 6. get data
 * 7. close (5, 3, 2)
 * 
 * total process
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
public class TestJDBC2 {
	/* 
	 * 컨넥션 풀을 메인 함수에 넣어 한개 생성해서 사용? -> 정답
	 * 컨넥션 풀을 필드(static 멤버로 선언해서 각 함수에서 생성 또는 특정함수에서 생성해서 사용?
	 */
	static String url = "jdbc:oracle:thin:@localhost:1521:xe"; // database마다 url은 모두 다르다. 각 DB회사 홈페이지에서 찾아야 함.
	static String user = "hr";
	static String password = "hr";
//	private static Statement stmt;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		String s = "1";
//		int i = (Integer) s;  // literal class
		Object o = s;
		Integer iI = (Integer) o;
		iI = new Integer(s);
		int i = Integer.parseInt(s);
		i = iI;
		System.out.println(i);
		
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader br = null;
		br.readLine();
		
		
		ConnectionPool pool = ConnectionPool.getInstance(url, user, password, 3, 5, true, 500);
		int result = 0;
		Board board1 = new Board(0, "홍길동1", "mrhong1@mt.co.kr", "1111", "나는 산에 산다",
				"자연인이다, 산에 산다. 좋다...", new Date(), 0, 0,0,0,"1");
		Board board2 = new Board("홍길동2", "mrhong2@mt.co.kr", "1111", "나도 산에 산다",
				"자연인이다, 산에 산다. 좋을걸?...", 0, 0, 0,"1");
		result = insert(board1);	
		result += insert(board2);
		System.out.println("insert :: " + result);
		board1 = null;
		int num = 5;
		board1 = select(num);
		System.out.println("select :: " + board1);
		board1.setName("고길동");
		board1.setEmail("gdkoh@ssangmun.com");
		/* 한 쓰레드가 업데이트 처리 중에 다른 쓰레드가 삭제처리를 먼저 수행할 경우 
		 * 업데이트를 하는 쓰레드에서 exception이 발생하여 해당 쓰레드가 종료됨.
		 * -> 그래서, 각 트랜젝션 함수들은 Connection을 따로 관리(생성)해야 함. 
		 * result = update(num, board1, conn); result = delete(num, conn);
		 */
		result = update(num, board1);
		board1 = select(num);
		System.out.println("select :: " + board1);
//		result = delete(num, pool);
//		board1 = select(num, pool);
//		System.out.println("select :: " + board1);
	}
	/**
	 * Thread에 안정적인 코드 : JDBC 2 ~ 7까지 모두 갖춰야 함
	 * 함수가 너무 느려진다. -> Connection -> Pool로 관리해야 함.
	 * @param num
	 * @param pool 
	 * @return
	 * @throws SQLException
	 */
	private static int delete(int num) throws SQLException {
		ConnectionPool pool = ConnectionPool.getInstance(url, user, password, 3, 5, true, 500);
		Connection conn = pool.getConnection(); 
		Statement stmt = conn.createStatement();
		String sql = "delete from board where num ="+num;
		int result = stmt.executeUpdate(sql);
		stmt.close();
		pool.releaseConnection(conn);
		return result;
	}

	private static int update(int num, Board board) throws SQLException {
		ConnectionPool pool = ConnectionPool.getInstance(url, user, password, 3, 5, true, 500);
		Connection conn = pool.getConnection(); 
		Statement stmt = conn.createStatement();
		String sql = "update board set name="
				+ "'"+board.getName()+"',"
				+ "email="
				+ "'"+board.getEmail()+"', "
				+ " subject="
				+ "'"+board.getSubject()+"', "
				+ " content="
				+ "'"+board.getContent()+"',"
				+ " regdate = sysdate" + 
				"     where num = "+num;
		int result = stmt.executeUpdate(sql);
		stmt.close();
		pool.releaseConnection(conn);
		return result;
	}

	private static Board select(int num) throws SQLException {
		ConnectionPool pool = ConnectionPool.getInstance(url, user, password, 3, 5, true, 500);
		Connection conn = pool.getConnection(); 
		Statement stmt = conn.createStatement();
		String sql = "select * from board where num = " + num;
		// * 4. execute (sql)
		ResultSet result = stmt.executeQuery(sql);
		//execute : execute(anySQL-callableSQL), executeUpdate(otherSQL), executeQuery(selectSQL) 
		Board board = null;
		// * 5. result ( , int, recordset)
		// * 6. get data
		while (result.next()) {
			board  = new Board(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), 
					result.getString(5), result.getString(6), result.getDate(7), result.getInt(8), 
					result.getInt(9), result.getInt(10), result.getInt(11), result.getString(12));
		}
		System.out.println(board);
		result.close();
		stmt.close();
		pool.releaseConnection(conn);
		return board;
	}

	private static int insert(Board board) throws SQLException {
		ConnectionPool pool = ConnectionPool.getInstance(url, user, password, 3, 5, true, 500);
		Connection conn = pool.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "insert into board(num, name, email, pwd, subject, content, regdate, hit, "
				+ "parent, sort, tab, originalfile)\r\n" + 
				"	values( (select NVL(max(num),0)+1 from board), "
				+ "'"+board.getName()+"',"
				+ "'"+board.getEmail()+"', "
				+ "'"+board.getPwd()+"',"
				+ "'"+board.getSubject()+"', "
				+ "'"+board.getContent()+"',"
				+ "SYSDATE,"
				+ board.getHit()+","
				+ "(select NVL(max(num),0)+1 from board),"
				+ board.getSort()+","
				+ board.getTab()+","
				+ "'"+board.getOriginal()+"')";
		// * 4. execute Update(sql) : insert, delete, update
		int result = stmt.executeUpdate(sql);
		stmt.close();
		pool.releaseConnection(conn);
		return result;
	}

}
