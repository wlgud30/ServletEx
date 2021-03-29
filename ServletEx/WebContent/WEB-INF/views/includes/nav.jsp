<%@page import="com.bit.servlet.dao.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 네비게이션 -->
<% UserVO user = (UserVO)session.getAttribute("user"); %>
<%= user %>
<ul>
	<%
	if(user == null){
		
	%>
	<li>
		<a href="<%=request.getContextPath()%>/users?a=loginform">로그인</a>
	</li>
	<li>
		<a href="<%=request.getContextPath()%>/users?a=joinform">회원가입</a>
	</li>
	<%
	}else{
	%>
	<li><%=user.getName() %>님 환영합니다.</li>
	<li><a href="<%=request.getContextPath()%>/users?a=logout">로그아웃</a></li>
	<%
	}
	%>
</ul>