<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.jdbc.*,java.util.Date"
 %>
<!DOCTYPE html>
<html>
<head>
<%
//web request data -> java data로 변환
int num = Integer.parseInt(request.getParameter("num"));
String name = request.getParameter("name");
String email = request.getParameter("email");
String subject = request.getParameter("subject");
String content = request.getParameter("content");
%>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3; url=viewEmp.jsp?num=<%=num %>">
<title>Insert title here</title>
</head>
<body>
<%
//java data -> Board객체 생성
Board emp = new Board(num, name, email, subject, content);
//insert : jdbc 2 ~ 7단계(connection 반납)
BoardService service = new BoardService();
int result = service.update(num, emp);
//result 값에 따라 결과 화면을 html로 만들어 출력
	if(result == 1){
%>
[<%=name %>]직원정보가 변경되었습니다.<br>
<a href="viewEmp.jsp?num=<%=num %>">변경정보보기</a>
<%
	}else{
%>
[<%=name %>]직원변경이 실패되었습니다.
<%
	}
%>
</body>
</html>