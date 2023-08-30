<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm.jsp</title>
</head>
<body>
<pre>
	<form action="loginAction.jsp">
		ID : <input type="text" name="id">
		Password : <input name="pwd">
		<input type="submit" value="제출">
	</form>
</pre>

	<form action="loginAction.jsp">
		<table>
			<tr><td>ID : </td><td><input type="text" name="id"></td></tr>
			<tr><td>Password : </td><td><input name="pwd"></td></tr>
			<tr><td colspan="2" align="center"><input type="submit" value="제출"></td></tr>
		</table>	
	</form>
	
	<table border="0" margin="0" cellpacing="0" cellpadding="0">
		<tr><td><img alt="첫번째 이미지" src="0002.jpg" size="500"></td></tr>
		<tr><td><img alt="두번째 이미지" src="0002.jpg" size="500"></td></tr>
	</table>
	
	
</body>
</html>