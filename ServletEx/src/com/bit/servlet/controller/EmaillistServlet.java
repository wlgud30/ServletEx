package com.bit.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.servlet.dao.EmailDao;
import com.bit.servlet.dao.EmailDaoOrcImpl;
import com.bit.servlet.dao.EmailVO;
//@WebServlet("/el") //현재 클래스를 /el url 패넡에 반응하는 서블릿으로등록
//web.xml에 <servlet> 과 <servlet-mapping>을 등록한것과 동일
@WebServlet(name="Emaillist",urlPatterns="/el")
public class EmaillistServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// View 처리를 위한 RequestDispatcher을 확인
		//자신이 처리하고 있던 요청 객체와 응답 객체를 다른 서블릿 혹은 jsp 로 전달하여 추가작업을 진행 
		String action = req.getParameter("action");
		if("form".equals(action)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/form.jsp");
			rd.forward(req, resp);
		}else if("delete".equals(action)){
			Long no = Long.valueOf(req.getParameter("no"));
			
			EmailDao dao = new EmailDaoOrcImpl();
			
			int res = dao.delete(no);
			System.out.println("딜리트된 숫자 : "+res);
			resp.sendRedirect(req.getContextPath()+"/el");
			
		}else {
			//리스트를 불러와 req에 attribute로 추가
			EmailDao dao = new EmailDaoOrcImpl();
			//전달 객체 생성
			List<EmailVO> list = dao.getList();
			
			//요청 객체에 속성으로 추가
			req.setAttribute("list", list);
			//전달받은 서블릿은 요청으로부터 이 속성을 꺼내 쓸 수 있다.
			
			//Dispatcher 확보
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/index.jsp");
			
			//요청과 응답 객체 전달
			rd.forward(req, resp);
		}
		System.out.println(action);
		//리스트
		//등록 폼 : 파라미터에서 a를 확인 분기
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		System.out.println("post : "+action);
		if("insert".equals(action)) {
			String firstName = req.getParameter("first_name");
			String lastName = req.getParameter("last_name");
			String email = req.getParameter("email");
			
			EmailVO vo = new EmailVO();
			vo.setLast_name(lastName);
			vo.setFirst_name(firstName);
			vo.setEmail(email);
			
			EmailDao dao = new EmailDaoOrcImpl();
			
			dao.insert(vo);
			resp.sendRedirect(req.getContextPath()+"/el");
		} else {
			doGet(req, resp);
		}
	}
	
	
	

}
