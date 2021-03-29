
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
	<h1>메일링 리스트(Model 2)</h1>
	
	<%//컨트롤러에서 속성으로 추가해준 리스트객체를 꺼내온다.
	List<EmailVO> list = (List<EmailVO>)request.getAttribute("list");
		
	for(EmailVO vo :list){
		
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
				<form action="<%= request.getContextPath()%>/el">
					<input type="hidden" name="action" value="delete"/>
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
	
	<p>
		<a href = "<%= request.getContextPath() %>/el?action=form">이동</a>
	</p>
</body>
</html>