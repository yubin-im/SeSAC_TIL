<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="viewUpdateEmpError.jsp"%>
<jsp:useBean id="emp" type="test.jdbc.EmpDTO" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=emp.getName() %>의 정보<p>
<form action="updateAction.jsp">
<table border="1">
	<tr>
		<td>이름</td><td><input name="name" value="<%=emp.getName() %>"></td>
	</tr>
	<tr>
		<td>성별</td><td><input name="gender" value="<%=emp.getGender() %>"></td>
	</tr>
	<tr>
		<td>ID</td><td><input name="id" value="<%=emp.getId() %>"></td>
	</tr>
	<tr>
		<td>등록일</td><td><input name="regdate" value="<%=emp.getRegdate() %>"></td>
	</tr>
	<tr>
		<td>전화</td><td><input name="phone" value="<%=emp.getPhone() %>"></td>
	</tr>
	<tr>
		<td>직급</td><td><input name="position" value="<%=emp.getPosition() %>"></td>
	</tr>
	<tr>
		<td>이메일</td><td><input name="email" value="<%=emp.getEmail() %>"></td>
	</tr>
	<tr>
		<td>취미</td>
		<td><td><input name="hobby" value="<%=emp.getHobby() %>"></td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="updateEmpAction.jsp?id=<input name="name" value="<%=emp.getId() %>">"><input type="button" value="변경"></a>
			<a href="deleteAction.jsp?id=<input name="name" value="<%=emp.getId() %>">
												&name=<input name="name" value="<%=emp.getName() %>">"><input type="button" value="삭제"></a>
		</td>
	</tr>
</table>
</form>
</body>
</html>