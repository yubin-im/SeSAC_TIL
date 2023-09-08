<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.jdbc.*,java.util.Date" %>
<jsp:useBean id="service" class="test.jdbc.EmpDAO" scope="application"/>
<jsp:useBean id="emp" class="test.jdbc.EmpDTO" scope="request"/>
<jsp:setProperty property="*" name="emp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
int result = 0;
EmpDTO board = service.select(emp);
System.out.println("select :: " + board); // 존재하면 해당 board 객체 출력, 존재하지 않으면 null
request.setAttribute("emp", board);
%>
<jsp:forward page="viewEmp.jsp"/>
</head>
<body>
</body>
</html>