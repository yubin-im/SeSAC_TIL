<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="login.html" %>
<jsp:useBean id="login" type="test.jdbc.BoardDTO" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm.jsp</title>
</head>
<body>
<%=login.getName()%>님 반갑습니다.[<a href="logout.jsp" >로그아웃</a>]
</body>
</html>