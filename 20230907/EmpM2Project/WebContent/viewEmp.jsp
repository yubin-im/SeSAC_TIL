<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="viewEmpError.jsp"%>
<%@ page import="test.jdbc.*,java.util.Date" %>
<jsp:useBean id="emp" type="test.jdbc.EmpDTO" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewEmp.jsp</title>

</head>
<body>
<%=emp.getName() %>의 정보<p>
<table border="1">
	<tr>
		<td>이름</td><td><%=emp.getName() %></td>
	</tr>
	<tr>
		<td>성별</td><td><%=emp.getGender() %></td>
	</tr>
	<tr>
		<td>ID</td><td><%=emp.getId()%></td>
	</tr>
	<tr>
		<td>등록일</td><td><%=emp.getRegdate() %></td>
	</tr>
	<tr>
		<td>전화</td><td><%=emp.getPhone() %></td>
	</tr>
	<tr>
		<td>직급</td><td><%=emp.getPosition() %></td>
	</tr>
	<tr>
		<td>이메일</td><td><%=emp.getEmail() %></td>
	</tr>
	<tr>
		<td>취미</td>
		<td><%=emp.getHobby() %></td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="updateEmp.jsp?id=<%=emp.getId() %>"><input type="button" value="변경"></a>
			<a href="deleteEmpAction.jsp?id=<%=emp.getId() %>
												&name=<%=emp.getName() %>"><input type="button" value="삭제"></a>
		</td>
	</tr>
</table>
</body>
</html>