package test.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpService {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; // database마다 url은 모두 다르다. 각 DB회사 홈페이지에서 찾아야 함.
	private String user = "hr";
	private String password = "hr";
	private static final String jdbcclass = "oracle.jdbc.OracleDriver";   
	private ConnectionPool pool;
	private Emp emp;
	public EmpService() {
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
	public int getInsert() throws SQLException, ClassNotFoundException {
		Connection conn = pool.getConnection();
		String sql = "insert into TBL_USER(name, gender, id, regdt, pwd, "
				+ "phone, position, e_Mail, hobby) " + 
				"	VALUES (?, ?, ?, sysdate, ?, ?, ?, ?, ?)";
		 PreparedStatement stmt = conn.prepareStatement(sql);
		
		System.out.println(sql);
		stmt.setString(1, emp.getName());
		stmt.setString(2, emp.getGender());
		stmt.setString(3, emp.getId());
		stmt.setString(4, emp.getPwd());
		stmt.setString(5, emp.getPhone());
		stmt.setInt(6, emp.getPosition());
		stmt.setString(7, emp.getEmail());
		stmt.setString(8, emp.getHobby());
		
		// * 4. execute Update(sql) : insert, delete, update
		int result = stmt.executeUpdate();
		stmt.close();
		pool.releaseConnection(conn);
		return result;
	}
	public int insert(Emp emp) throws SQLException, ClassNotFoundException {
		Connection conn = pool.getConnection();
		String sql = "insert into TBL_USER(name, gender, id, regdt, pwd, "
				+ "phone, position, e_Mail, hobby) " + 
				"	VALUES (?, ?, ?, sysdate, ?, ?, ?, ?, ?)";
		 PreparedStatement stmt = conn.prepareStatement(sql);
		
		System.out.println(sql);
		stmt.setString(1, emp.getName());
		stmt.setString(2, emp.getGender());
		stmt.setString(3, emp.getId());
		stmt.setString(4, emp.getPwd());
		stmt.setString(5, emp.getPhone());
		stmt.setInt(6, emp.getPosition());
		stmt.setString(7, emp.getEmail());
		stmt.setString(8, emp.getHobby());
		
		// * 4. execute Update(sql) : insert, delete, update
		int result = stmt.executeUpdate();
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
	public int delete(int num) throws SQLException {
		Connection conn = pool.getConnection(); 
		Statement stmt = conn.createStatement();
		String sql = "delete from board where num ="+num;
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
			boards.add(board);
		}
		System.out.println(board);
		result.close();
		stmt.close();
		pool.releaseConnection(conn);
		return boards;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
}
