
<%@page import="com.bit.servlet.dao.EmailVO"%>
<%@page import="java.util.List"%>
<%@page import="com.bit.servlet.dao.EmailDao"%>
<%@page import="com.bit.servlet.dao.EmailDaoOrcImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일링 리스트 확인</title>
</head>
<body>
	<h1>메일링 리스트</h1>
	
	<%//dao 불러오기 
		EmailDao dao = new EmailDaoOrcImpl();
	
		List<EmailVO> list = dao.getList();
		
		for(EmailVO vo : list){
			
		
	%>
	
	<!-- 정보 테이블 -->
	<table border='1'>
		<tr>
			<th>성</th>
			<td><%= vo.getLast_name() %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%= vo.getFirst_name() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%= vo.getEmail() %></td>
		</tr>
		<!-- 삭제버튼 -->
		<tr>
			<td colspan="2">
				<form action="delete.jsp">
					<!-- 게시물의 no -->
					<input type="hidden" name="no" value = "<%=vo.getNo() %>"/>
					<!-- 전송 -->
					<input type="submit" value="삭제"/>
				</form>
			</td>
		</tr>
	</table>
	
	<%
		}
	%>
</body>
</html>