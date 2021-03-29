<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
	
<jsp:include page="/WEB-INF/views/includes/nav.jsp"/>
<!-- jsp:include 는 jsp 에 포함하여 컴파일하지 않고 별도의 서블릿(or jsp)에 요청을 전달하는것 -->


	<h3>Cookie Test</h3>
	<p>
		<a href="<%= request.getContextPath()%>/cookies">쿠키</a>
	</p>
	<!-- <h3>Static HTML Page</h3>
	<p>이것은 정적 HTML로 작성된 페이지 입니다</p> -->
	<!-- img 태그 -->
	<img width=320 height=240 alt="프로필" src="images/img.jfif"/>
	<p>
		<a href="hello.jsp?name=Servlet" >JSP 호출 (Get 방식)</a>
		<a href="hs?name=Servlet">Servlet 호출 (Get 방식)</a>
	</p>
	<h3>테이블연습</h3>
	<p>
		<a href="table.html">테이블 연습</a>
	</p>
	<h3>POST 전송 연습</h3>
	<form action="hs" method="GET">
		<label for="last_name">성</label>
		<input type="text" id="last_name" name="last_name">
		<br/>
		<label for="first_name">이름</label>
		<input type="text" id="first_name" name="first_name">
		<br/>
		<input type="submit" value="전송">
	</form>
	
	<form action="hs" method="POST">
		<label for="last_name">성(Family Name)</label>
		<input type="text" id="last_name" name="last_name">
		<br/>
		<label for="first_name">이름(First Name)</label>
		<input type="text" id="first_name" name="first_name">
		<br/>
		<!-- input 태그에 있는 name 속성으로 데이터가 전송 -->
		<input type="submit" value="전송" /><!-- 누르면 본 폼이 전송된다 -->
	</form>
	
	<h3>라이프사이클 확인</h3>
	<p>
		<a href= "life">라이프사이클 로긓 확인</a>
	</p>
	
	<h3>웹 어플리케이션 모델 1 연습</h3>
	<p>
		<a href = "emaillist/">이메일리스트</a>
	</p>
	<h3>웹 어플리케이션 모델 2 연습</h3>
	<p>
		<a href = "el">이메일리스트</a>
	</p>
	
	<p>
		<a href = "emaillist/form.jsp">이메일리스트</a>
	</p>
	
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>