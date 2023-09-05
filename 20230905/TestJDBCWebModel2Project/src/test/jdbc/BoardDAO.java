package test.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BoardDAO {
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe"; // database마다 url은 모두 다르다. 각 DB회사 홈페이지에서 찾아야 함.
	private static String user = "hr";
	private static String password = "hr";
	private static final String jdbcclass = "oracle.jdbc.OracleDriver";
	private ConnectionPool pool;   
	public BoardDAO() throws ClassNotFoundException, SQLException
	{	Class.forName(jdbcclass);
		pool = ConnectionPool.getInstance(url, user, password, 3, 5, true, 500);
	}

	public Board select(Board input) throws SQLException, ClassNotFoundException {
		Connection conn = pool.getConnection(); 
		Statement stmt = conn.createStatement();
		String sql = "select * from board where email = '" + input.getEmail() 
							+ "' and pwd = '" + input.getPwd() + "'";
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

}
