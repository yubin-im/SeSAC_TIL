<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="registerEmp.html"%>
<jsp:useBean id="resultData" type="java.lang.String" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewRegisterEmp.jsp</title>
</head>
<body>
<%=resultData %>
<a href="listEmp.jsp">직원목록보기</a>
</body>
</html>