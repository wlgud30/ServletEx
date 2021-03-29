package com.bit.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.servlet.dao.UserDao;
import com.bit.servlet.dao.UserDaoOrcImpl;
import com.bit.servlet.dao.UserVO;

@WebServlet("/users")
public class UserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자 요청 파라미터처리
		String action = req.getParameter("a");
		
		if("joinform".equals(action)) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/users/joinform.jsp");
			rd.forward(req, resp);
		}else if("joinsuccess".equals(action)){
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/users/joinsuccess.jsp");
			rd.forward(req, resp);
		}else if("loginform".equals(action)){
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/users/loginform.jsp");
			rd.forward(req, resp);
		}else if("logout".equals(action)){
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect(req.getContextPath()+"/");
		}else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자 요청 파라미터처리
		String action = req.getParameter("a");
		
		if("join".equals(action)) {
			//a hidden필드가 join 일때
			String name = req.getParameter("name");
			String pw = req.getParameter("pw");
			String email = req.getParameter("email");
			String gender = req.getParameter("gender");
			
			UserVO vo = new UserVO(name,pw,email,gender);
			
			UserDao dao = new UserDaoOrcImpl();
			
			int insertedCount = dao.insert(vo);
			System.out.println("abc");
			if(insertedCount==1) {
				resp.sendRedirect(req.getContextPath()+"/users?a=joinsuccess");
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/users/joinform.jsp");
				rd.forward(req, resp);
			}
			
		}else if("login".equals(action)){
			UserDao dao = new UserDaoOrcImpl();
			
			String email = req.getParameter("email");
			String pw = req.getParameter("pw");
			
			UserVO vo = dao.getUserByEmailAndPW(email, pw);
			
			if(vo != null) {
				HttpSession session = req.getSession();
				
				session.setAttribute("user", vo);
				
				resp.sendRedirect(req.getContextPath()+"/");
			}else {
				resp.sendRedirect(req.getContextPath()+"/users?a=loginform");
			}
			
			
		}else {
			//에러페이지 전송
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		
	}
	
	

}
