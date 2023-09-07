<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="viewUpdateEmpActionError.jsp"%>
<jsp:useBean id="emp" type="test.jdbc.EmpDTO" scope="request"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int result = (Integer)request.getAttribute("result");
//result 값에 따라 결과 화면을 html로 만들어 출력
	if(result == 1){
%>
[<%=emp.getName() %>]직원정보가 변경되었습니다.<br>
<a href="viewEmp.jsp?id=<%=emp.getId() %>">변경정보보기</a>
<%
	}
%>
</body>
</html>