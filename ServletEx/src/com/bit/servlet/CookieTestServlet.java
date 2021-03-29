package com.bit.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies")
public class CookieTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("a");
		
		if("delete".equals(action)) {
			Cookie[] cookies= req.getCookies();
			
			if(cookies !=null) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("example")) {
						//쿠키삭제 -> 유효시간을 0으로 맞춘다
						cookie.setMaxAge(0);
						resp.addCookie(cookie);
						break;
					}
				}
			}
			
		}else {
			Cookie[] cookies= req.getCookies();
			
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("example")) {
						String cookieVal = URLDecoder.decode(cookie.getValue());
						
						req.setAttribute("example", cookieVal);
						break;
					}
				}
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/cookies/cookie_form.jsp");
		rd.forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value = req.getParameter("example");
		value = URLEncoder.encode(value, "UTF-8");
		//cookie 생성
		Cookie cookie = new Cookie("example",value);
		
		cookie.setMaxAge(3600);	//3600초
		
		//사용자 브라우저에 쿠키 저장
		resp.addCookie(cookie);
		
		resp.sendRedirect(req.getContextPath()+"/cookies");
		
	}
	
	
	
}
