<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.jdbc.*,java.util.Date"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//web request data -> java data로 변환
int num = Integer.parseInt(request.getParameter("num"));
String name = request.getParameter("name");
//insert : jdbc 2 ~ 7단계(connection 반납)
BoardService service = new BoardService();
int result = service.delete(num);
//result 값에 따라 결과 화면을 html로 만들어 출력
	if(result == 1){
%>
[<%=name %>]직원정보가 삭제되었습니다.<br>
<a href="listEmp.jsp">직원목록보기</a>
<%
	}else{
%>
[<%=name %>]직원삭제가 실패되었습니다.
<a href="viewEmp.jsp?num=<%=num%>">직원정보보기</a>
<%
	}
%>
</body>
</html>