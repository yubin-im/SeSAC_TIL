<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.jdbc.ConnectionPool,test.jdbc.Board,java.sql.*,java.util.Date"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!
static String url = "jdbc:oracle:thin:@localhost:1521:hr"; // database마다 url은 모두 다르다. 각 DB회사 홈페이지에서 찾아야 함.
static String user = "SYSTEM";
static String password = "hr";
static final String jdbcclass = "oracle.jdbc.driver.OracleDriver";

private static Board select(String email, String pwd) throws SQLException {
	ConnectionPool pool = ConnectionPool.getInstance(url, user, password, 3, 5, true, 500);
	Connection conn = pool.getConnection(); 
	Statement stmt = conn.createStatement();
	String sql = "select * from board where email = '" + email + "'and pwd = '" + pwd + "'";
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

%>
<body>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
System.out.print(id + "::" + pwd + "\n");

Class.forName(jdbcclass);
ConnectionPool pool = ConnectionPool.getInstance(url, user, password, 3, 5, true, 500);
int result = 0;

Board board = new Board(0, "홍길동1", id, pwd, "", "", new Date(), 0, 0, 0, 0, "1");
board = select(id, pwd);  // select(num);
System.out.println("select :: " + board);  // 존재하면 해당 board 객체 출력, 존재하지 않으면 null
%>
<%
String msg = "";
if (board == null) {
	msg = "사용자 아이디 또는 비밀번호가 틀렸습니다. 다시 입력하세요.";
%>
<%= msg%>
<%
} else {
%>
id : <%=id %><br>
pwd : <%=pwd %>
<%
}
%>
</body>
</html>