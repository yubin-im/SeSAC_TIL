<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<jsp:useBean id="emp" type="test.jdbc.EmpDTO" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	[<%=emp.getName() %>]직원변경이 실패되었습니다.
	<a href="updateEmp.jsp">이전으로</a>
</body>
</html>