<%@page import="com.bit.servlet.dao.EmailDao"%>
<%@page import="com.bit.servlet.dao.EmailDaoOrcImpl"%>
<%@page import="com.bit.servlet.dao.EmailVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%//요청 피라미터 받기

String first_name = request.getParameter("first_name");
String last_name = request.getParameter("last_name");
String email = request.getParameter("email");

//VO객체
EmailVO vo = new EmailVO(last_name,first_name,email);
EmailDao dao = new EmailDaoOrcImpl();

dao.insert(vo);

//리스트 페이지로 돌려보내기 : 302->Redirect

response.sendRedirect(request.getContextPath()+"/emaillist/");

%>