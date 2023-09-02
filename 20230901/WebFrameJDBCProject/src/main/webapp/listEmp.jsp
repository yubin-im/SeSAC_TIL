<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.jdbc.*,java.util.*"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원목록</title>
<%
int result = 0;
ArrayList<Board> boards = null;
BoardService service = new BoardService();
boards = service.selectAll();
System.out.println("selectAll :: " + boards.size());
%>
</head>
<body>
	<center>
		<font face="Gothic" size="5">직원목록</font><br>
		<table border="1" cellspacing="4" 
									cellpadding="3">
			<tr>
				<th>no</th>
				<th>사번</th>
				<th>이름</th>
				<th>이메일</th>
				<th>제목</th>
				<th>등록일</th>
			</tr>
<%
int i = 1;
if(boards.size() == 0) {
%>
<tr><td colspan="6">직원이 없습니다.</td></tr>
<%
}
for(Board board: boards) {
%>
			<tr>
				<td align="justify"><%=i++ %></td>
				<td align="right"><%=board.getNum() %></td>
				<td><a href="viewEmp.jsp?num=<%=board.getNum() %>" target="right"><%=board.getName() %></a></td>
				<td><%=board.getEmail() %></td>
				<td><%=board.getSubject() %></td>
				<td><%=board.getRegdate() %></td>
			</tr>
<%
}
%>
		</table>
	</center> 
</body>
</html>