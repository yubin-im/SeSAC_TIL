<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewDeleteEmpActionError.jsp</title>
</head>
<body>
	직원이 존재하지 않습니다.
	<%= exception.getMessage() %>
	<a href="listEmp.jsp">직원목록</a>
</body>
</html>