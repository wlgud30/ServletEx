<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일리스트 : 가입폼</title>
</head>
<body>

	<h1>메일링 리스트 가입</h1>
	<p>메일링 리스트에 가입하려면 아래 항목을 작성해야 합니다.</p>
	
	<form action="insert.jsp" method="POST">
		<label for="last_name">성</label>
		<input type="text" id="last_name" name="last_name">
		<br/>
		<label for="first_name">이름</label>
		<input type="text" id="first_name" name="first_name">
		<br/>
		<label for="email">이메일</label>
		<input type="text" id="email" name="email">
		<br/>
		<input type="submit" value="전송" />
	</form>
	
	<p>
		<a href = "index.jsp">목록</a>
	</p>
</body>
</html>