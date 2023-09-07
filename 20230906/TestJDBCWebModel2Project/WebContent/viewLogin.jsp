<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="loginError.html"%>
 <jsp:useBean id="login" type="test.jdbc.BoardDTO" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewLogin.jsp</title>
</head>
<body>
id : <%=login.getEmail() %><br>
pwd : <%=login.getPwd() %>
<a href="loginForm.jsp">로그인완료</a>
</body>
</html>