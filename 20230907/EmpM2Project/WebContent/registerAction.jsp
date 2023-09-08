<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="test.jdbc.*,java.util.Date" %>
<jsp:useBean id="service" class="test.jdbc.EmpService" scope="request"/>
<jsp:useBean id="emp" class="test.jdbc.EmpDTO" scope="request"/>
<jsp:setProperty property="*" name="emp"/>
<%
	String result = service.insert(emp);
	request.setAttribute("resultData", result);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerAction.jsp</title>
</head>
<body>
<jsp:forward page="viewRegisterEmp.jsp"/>
</body>
</html>