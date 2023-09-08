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
<title>deleteEmpAction.jsp</title>
<%
int result = service.delete(emp);
request.setAttribute("result", result);
%>
<jsp:forward page="viewDeleteEmpAction.jsp"/>
</head>
<body>
</body>
</html>