<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.jdbc.*,java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원등록 처리화면</title>
</head>
<body>
<%
// web request data -> java data로 변환
String name = request.getParameter("name");
String email = request.getParameter("email");
String pwd = request.getParameter("pwd");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

// java data -> Board 객체 생성
Board emp = new Board(0, name, email, "1111", subject, content, new Date(), 0, 0, 0, 0, "1");

// insert: jdbc 2~7단계(connection 반납)
BoardService service = new BoardService();
int result = service.insert(emp);

// result 값에 따라 결과 화면을 html로 만들어 출력
if(result == 1) {
%>
[<%=name %>]직원등록이 완료되었습니다.
<%
	} else { 
%>
[<%=name %>]직원등록이 실패하였습니다.
<%
}
%>
<a href="listEmp.html">직원목록보기</a>
</body>
</html>