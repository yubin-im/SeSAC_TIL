<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	직원이 존재하지 않습니다. 확인하시고 사번을 다시 입력하세요.
	<%= exception.getMessage() %>
	<a href="listEmp.jsp">직원목록</a>
</body>
</html>