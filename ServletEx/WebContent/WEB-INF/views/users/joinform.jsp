<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<jsp:include page="/WEB-INF/views/includes/nav.jsp"/>
	<h1>회원 가입</h1>
	
	<form name = "joinform" method="post" action="<%= request.getContextPath() %>/users">
		<input type="hidden" name="a" value="join">
		<label id = "name">이름</label>
		<input id="name" name="name" type="text"/><br/>
		
		<label id = "pw">비밀번호</label>
		<input id="pw" name="pw" type="password"/><br/>
		
		<label id = "email">이메일</label>
		<input id="email" name="email" type="text"/><br/>
		
		<fieldset>
			<legend>성별</legend>
			<label>여</label>
			<input type="radio" name="gender" value="F" checked="checked"/>
			<label>남</label>
			<input type="radio" name="gender" value="M"/>
		</fieldset>
		
		<input type="submit" value="가입하기">
	</form>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>