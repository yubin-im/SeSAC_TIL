<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="login.html"%>
 <jsp:useBean id="login" type="test.jdbc.BoardDTO" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout.jsp</title>
</head>
<body>
<%=login.getName() %>님이 로그아웃되었습니다.<a href="loginForm.jsp">로그인</a>
<%		session.invalidate();  %>
</body>
</html>