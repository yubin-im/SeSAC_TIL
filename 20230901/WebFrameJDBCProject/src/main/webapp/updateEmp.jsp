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
<form action="updateAction.jsp">
	<table border="1">
		<tr>
			<td>사번</td><td><%=board.getNum() %>
					<input name="num" type="hidden" value="<%=board.getNum() %>">
								</td>
		</tr>
		<tr>
			<td>이름</td><td><input name="name" value="<%=board.getName() %>"></td>
		</tr>
		<tr>
			<td>이메일</td><td><input type="email" name="email" value="<%=board.getEmail() %>"></td>
		</tr>
		<tr>
			<td>제목</td><td><input name="subject" value="<%=board.getSubject() %>"></td>
		</tr>
		<tr>
			<td>등록일</td><td><%=board.getRegdate() %></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content"><%=board.getContent() %></textarea>
			</td>
		</tr>
		<tr>
	<tr>
		<td colspan="2"><input type="submit" value="전송"><input type="reset" value="지우기">
		</td>
	</tr>
	</table>
</form>
<%
	}
%>

</body>
</html>