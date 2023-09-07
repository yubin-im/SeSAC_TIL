<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.jdbc.*,java.util.Date" %>
<jsp:useBean id="emp" class="test.jdbc.EmpDTO" scope="page"/>
<jsp:useBean id="service" class="test.jdbc.EmpDAO" scope="application"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="emp"/>
<jsp:setProperty property="regdate" name="emp" value="<%=new Date() %>"/>
<jsp:setProperty property="emp" name="service" value="<%=emp %>"/>
<jsp:getProperty property="insert" name="service"/>
<%
int result = service.insert(emp);
//result 값에 따라 결과 화면을 html로 만들어 출력
	if(result == 1){
%>
[<jsp:getProperty property="name" name="emp"/>]직원등록이 완료되었습니다.
<%
	}else{
%>
[<jsp:getProperty property="name" name="emp"/>]직원등록이 실패하였습니다.
<%
	}
%>
<a href="listEmp.jsp">직원목록보기</a>
</body>
</html>