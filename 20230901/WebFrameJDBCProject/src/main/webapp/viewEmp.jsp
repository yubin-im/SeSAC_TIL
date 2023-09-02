<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.jdbc.*,java.util.Date"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
int num = Integer.parseInt(request.getParameter("num"));
int result = 0;
Board board = null;
BoardService service = new BoardService();
board = service.select(num);
System.out.println("select :: " + board); // 존재하면 해당 board 객체 출력, 존재하지 않으면 null
%>
</head>
<body>
<%
	String msg = "";
	if(board == null)
	{	msg = "직원이 존재하지 않습니다. 확인하시고 사번을 다시 입력하세요.";
%>
<%= msg %>
<%
	}else
	{	
%>
<%=board.getName() %>의 정보<p>
<table border="1">
	<tr>
		<td>사번</td><td><%=board.getNum() %></td>
	</tr>
	<tr>
		<td>이름</td><td><%=board.getName() %></td>
	</tr>
	<tr>
		<td>이메일</td><td><%=board.getEmail() %></td>
	</tr>
	<tr>
		<td>제목</td><td><%=board.getSubject() %></td>
	</tr>
	<tr>
		<td>등록일</td><td><%=board.getRegdate() %></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea><%=board.getContent() %></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="updateEmp.jsp?num=<%=board.getNum() %>"><input type="button" value="변경"></a>
			<a href="deleteAction.jsp?num=<%=board.getNum() %>
									&name=<%=board.getName() %>"><input type="button" value="삭제"></a>
		</td>
	</tr>
</table>
<%
	}
%>

</body>
</html>