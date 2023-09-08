<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="viewUpdateEmpError.jsp"%>
<jsp:useBean id="emp" type="test.jdbc.EmpDTO" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewUpdateEmp.jsp</title>
</head>
<body>
<jsp:getProperty property="name" name="emp"/>의 정보<p>
<form action="updateEmpAction.jsp">
<table border="1">
	<tr>
		<td>이름</td><td><input name="name" value='<jsp:getProperty property="name" name="emp"/>'></td>
	</tr>
	<tr>
		<td>성별</td><td><input name="gender" value='<jsp:getProperty property="gender" name="emp"/>'></td>
	</tr>
	<tr>
		<td>ID</td><td><input name="id" value='<jsp:getProperty property="id" name="emp"/>' readonly></td>
	</tr>
	<tr>
		<td>전화</td><td><input name="phone" value='<jsp:getProperty property="phone" name="emp"/>'></td>
	</tr>
	<tr>
		<td>직급</td><td><input name="position" value='<jsp:getProperty property="position" name="emp"/>'></td>
	</tr>
	<tr>
		<td>이메일</td><td><input name="email" value='<jsp:getProperty property="email" name="emp"/>'></td>
	</tr>
	<tr>
		<td>취미</td>
		<td><input name="hobby" value='<jsp:getProperty property="hobby" name="emp"/>'></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="변경">
			<a href='deleteAction.jsp?id=<jsp:getProperty property="id" name="emp"/>
			&name=<jsp:getProperty property="name" name="emp"/>'>
				<input type="button" value="삭제"></a>
		</td>
	</tr>
</table>
</form>
</body>
</html>