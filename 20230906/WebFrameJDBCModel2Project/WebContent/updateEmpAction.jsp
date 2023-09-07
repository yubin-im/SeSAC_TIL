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
<meta http-equiv="refresh" content="3; url=viewEmp.jsp?id=<%=emp.getId() %>">
<title>Insert title here</title>
<%
int result = service.update(emp);
request.setAttribute("result", result);
%>
<jsp:forward page="viewUpdateEmpAction.jsp"/>
</head>
<body>
</body>
</html>