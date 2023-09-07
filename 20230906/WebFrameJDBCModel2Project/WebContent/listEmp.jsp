<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.jdbc.*,java.util.*" %>
<jsp:useBean id="service" class="test.jdbc.EmpDAO" scope="application"/> <%-- session, application --%>
<!--  jsp:useBean id="boards" class="java.util.ArrayList" scope="request"/ -->
<!-- 
useBean사용법
1. 웬만한 객체는 useBean으로 사용(* scope 주의)
2. scriptlet에서 해당 bean를 수정하는 경우 꼭 log 출력할 것!
3. view에서 log 출력해서 내용을 비교(데이터가 같은지 확인)
4. 이상이 발견될 경우 1번은 없애라.
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원목록</title>
<%
int result = 0;
ArrayList<EmpDTO> boards = service.selectAll();
System.out.println("selectAll :: " + boards.size()); // 존재하면 해당 board 객체 출력, 존재하지 않으면 null
request.setAttribute("boards", boards);
%>
</head>
<body>
<jsp:forward page="viewListEmp.jsp"/>
</body>
</html>