package test.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BoardService {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; // database마다 url은 모두 다르다. 각 DB회사 홈페이지에서 찾아야 함.
	private String user = "hr";
	private String password = "hr";
	private static final String jdbcclass = "oracle.jdbc.OracleDriver";   
	private ConnectionPool pool;
	public BoardService() {
		super();
		//jdbc 1단계
		try {
			Class.forName(jdbcclass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//jdbc Connection 관리 -> ConnectionPool이 관리
		try {
			pool = ConnectionPool.getInstance(url, user, password, 3, 5, true, 500);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public int insert(Board board) throws SQLException, ClassNotFoundException {
		//jdbc 2~ 7단계(connection 반납)
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
		System.out.println(sql);
		System.out.println(board);
		
		// * 4. execute Update(sql) : insert, delete, update
		int result = stmt.executeUpdate(sql);
		stmt.close();
		pool.releaseConnection(conn);
		return result;
	}
	public int update(int num, Board board) throws SQLException {
		Connection conn = pool.getConnection(); 
		Statement stmt = conn.createStatement();
		String sql = "update board set name="
				+ "'"+board.getName()+"',"
				+ "email="
				+ "'"+board.getEmail()+"', "
				+ " subject="
				+ "'"+board.getSubject()+"', "
				+ " content="
				+ "'"+board.getContent()+"'"
				+ "     where num = "+num;
		int result = stmt.executeUpdate(sql);
		stmt.close();
		pool.releaseConnection(conn);
		return result;
	}

	public Board select(int num) throws SQLException {
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
	
	public int delete(int num) throws SQLException {
		Connection conn = pool.getConnection(); 
		Statement stmt = conn.createStatement();
		String sql = "delete from board where num ="+num;
		int result = stmt.executeUpdate(sql);
		stmt.close();
		pool.releaseConnection(conn);
		return result;
	}
	
	public ArrayList<Board> selectAll() throws SQLException {
		Connection conn = pool.getConnection(); 
		Statement stmt = conn.createStatement();
		String sql = "select * from board";
		
		// * 4. execute (sql)
		ResultSet result = stmt.executeQuery(sql);
		//execute : execute(anySQL-callableSQL), executeUpdate(otherSQL), executeQuery(selectSQL) 
		Board board = null;
		ArrayList<Board> boards = new ArrayList<Board>();
		
		// * 5. result ( , int, recordset)
		// * 6. get data
		while (result.next()) {
			board  = new Board(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), 
					result.getString(5), result.getString(6), result.getDate(7), result.getInt(8), 
					result.getInt(9), result.getInt(10), result.getInt(11), result.getString(12));
			boards .add(board);
		}
		System.out.println(board);
		result.close();
		stmt.close();
		pool.releaseConnection(conn);
		return boards;
	}
	
}
