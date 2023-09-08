<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.jdbc.*" errorPage="registerEmp.html"%>
<jsp:useBean id="boards" type="java.util.ArrayList" scope="request"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
right
	<center>
		<font face="Gothic" size="5">직원목록</font><br>
		<table border="1" cellspacing="4" 
									cellpadding="3">
			<tr>
				<th>번호</th>
				<th>id</th>
				<th>이름</th>
				<th>직급</th>
				<th>전화</th>
				<th>이메일</th>
				<th>등록일</th>
			</tr>
<%	int i = 1;
	if(boards.size() == 0)
	{
%>
 <tr><td colspan="6">직원이 없습니다.</td></tr>
<%
	}
	for(Object o : boards)
	{	EmpDTO board = (EmpDTO)o;
%>
			<tr>
				<td align="justify"><%=i++ %></td>
				<td align="right"><%=board.getId() %></td>
				<td><a href="viewEmpAction.jsp?id=<%=board.getId() %>" target="right">
				<%=board.getName() %></a></td>
				<td><%=board.getPosition() %></td>
				<td><%=board.getPhone() %></td>
				<td><%=board.getEmail() %></td>
				<td><%=board.getRegdate() %></td>
			</tr>
<%
	}
%>
		</table>
	</center> 
</body>
</html>