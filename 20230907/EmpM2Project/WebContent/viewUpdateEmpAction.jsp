<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage='listEmp.jsp'%>
<jsp:useBean id="emp" type="test.jdbc.EmpDTO" scope="request"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewUpdateEmpAction.jsp</title>
</head>
<body>
<%
	int result = (Integer)request.getAttribute("result");
//result 값에 따라 결과 화면을 html로 만들어 출력
	System.out.print("update result = " + result);
	
	if(result >= 1){
%>
[<jsp:getProperty property="name" name="emp"/>]직원정보가 변경되었습니다.<br>
<a href='viewEmpAction.jsp?id=<jsp:getProperty property="id" name="emp"/>'>변경정보보기</a>
<%
	}else{
%>
<jsp:forward page="viewUpdateEmpActionError.jsp"/>
<%
	}
%>
</body>
</html>