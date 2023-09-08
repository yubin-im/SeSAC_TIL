<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage='listEmp.jsp'%>
<jsp:useBean id="emp" type="test.jdbc.EmpDTO" scope="request"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewDeleteEmpAction.jsp</title>
</head>
<body>
<%
	int result = (Integer)request.getAttribute("result");
//result 값에 따라 결과 화면을 html로 만들어 출력
	System.out.print("delete result = " + result);
	
	if(result >= 1){
%>
[<jsp:getProperty property="name" name="emp"/>]직원정보가 삭제되었습니다.<br>
<a href='listEmp.jsp'>목록보기</a>
<%
	}else{
%>
<jsp:forward page="viewDeleteEmpActionError.jsp"/>
<%
	}
%>
</body>
</html>