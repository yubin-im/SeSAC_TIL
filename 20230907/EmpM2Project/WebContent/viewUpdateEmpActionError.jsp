<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<jsp:useBean id="emp" type="test.jdbc.EmpDTO" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewUpdateEmpActionError.jsp</title>
</head>
<body>
	[<jsp:getProperty property="name" name="emp"/>]직원변경이 실패되었습니다.
	<a href='updateEmp.jsp?id=<jsp:getProperty property="id" name="emp"/>'>이전으로</a>
</body>
</html>