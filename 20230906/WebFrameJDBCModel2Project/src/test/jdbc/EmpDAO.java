package test.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpDAO {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; // database마다 url은 모두 다르다. 각 DB회사 홈페이지에서 찾아야 함.
	private String user = "hr";
	private String password = "hr";
	private static final String jdbcclass = "oracle.jdbc.OracleDriver";   
	private ConnectionPool pool;
	private EmpDTO emp;
	public EmpDAO() {
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
	public int insert(EmpDTO emp) throws SQLException, ClassNotFoundException {
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
	public int update(EmpDTO board) throws SQLException {
		Connection conn = pool.getConnection(); 
		Statement stmt = conn.createStatement();
		//position, e_Mail, hobby)
		String sql = "update TBL_USER  set name="
				+ "'"+board.getName()+"',"
				+ "gender="
				+ "'"+board.getGender()+"', "
				+ " pwd="
				+ "'"+board.getPwd()+"'"
				+ "phone="
				+ "'"+board.getPhone()+"', "
				+ " position="
				+ "'"+board.getPosition()+"', "
				+ " e_Mail="
				+ "'"+board.getEmail()+"'"
				+ " hobby="
				+ "'"+board.getHobby()+"'"
				+ "     where id = '"+board.getId() + "'";
		int result = stmt.executeUpdate(sql);
		stmt.close();
		pool.releaseConnection(conn);
		return result;
	}
	public int delete(EmpDTO emp) throws SQLException {
		Connection conn = pool.getConnection(); 
		Statement stmt = conn.createStatement();
		String sql = "delete from TBL_USER  where id ='"+emp.getId() + "'";
		int result = stmt.executeUpdate(sql);
		stmt.close();
		pool.releaseConnection(conn);
		return result;
	}

	public EmpDTO select(EmpDTO emp) throws SQLException {
		Connection conn = pool.getConnection(); 
		Statement stmt = conn.createStatement();
		String sql = "select * from TBL_USER where id ='"+emp.getId() + "'";
		// * 4. execute (sql)
		ResultSet result = stmt.executeQuery(sql);
		//execute : execute(anySQL-callableSQL), executeUpdate(otherSQL), executeQuery(selectSQL) 
		EmpDTO board = null;
		// * 5. result ( , int, recordset)
		// * 6. get data
		while (result.next()) {
			board  = new EmpDTO(result.getString("NAME"), result.getString("GENDER"), result.getString("ID"), result.getDate("REGDT"), 
					result.getString("PWD"), result.getString("PHONE"), result.getInt("POSITION"), result.getString("E_MAIL"), 
					result.getString("HOBBY"));
		}
		System.out.println(board);
		result.close();
		stmt.close();
		pool.releaseConnection(conn);
		return board;
	}
	public ArrayList<EmpDTO> selectAll() throws SQLException {
		Connection conn = pool.getConnection(); 		Statement stmt = conn.createStatement();
		String sql = "select * from TBL_USER";
		// * 4. execute (sql)
		ResultSet result = stmt.executeQuery(sql);
		//execute : execute(anySQL-callableSQL), executeUpdate(otherSQL), executeQuery(selectSQL) 
		EmpDTO board = null;
		ArrayList<EmpDTO> boards = new ArrayList<EmpDTO>();
		// * 5. result ( , int, recordset)		// * 6. get data
		while (result.next()) {
			board  = new EmpDTO(result.getString("NAME"), result.getString("GENDER"), 
					result.getString("ID"), result.getDate("REGDT"), result.getString("PWD"), 
					result.getString("PHONE"), result.getInt("POSITION"), result.getString("E_MAIL"), 
					result.getString("HOBBY"));
			boards.add(board);
		}
		System.out.println(board);
		result.close();
		stmt.close();
		pool.releaseConnection(conn);
		return boards;
	}
	public void setEmp(EmpDTO emp) {
		this.emp = emp;
	}
}
