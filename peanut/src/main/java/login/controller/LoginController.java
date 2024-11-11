package login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.dto.LoginDTO;
import login.service.LoginService;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("/login doGet 실행");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		request.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("/login doPost 실행");
		
		try {
			
			String id = request.getParameter("id");
			String password = request.getParameter("pw");
			
			LoginDTO loginDTO = new LoginDTO();
			loginDTO.setId(id);
			loginDTO.setPassword(password);
			
			LoginService loginService = new LoginService();
			LoginDTO resultDTO = loginService.loginCheck(loginDTO);
			System.out.println(resultDTO);
			
			// 세션에 넣고
			if(resultDTO != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginDTO", resultDTO);
				
				// list 페이지로 sendRedirect
				response.sendRedirect(request.getContextPath() + "/board");
			} else {
				System.out.println("로그인페이지이동");
				// login 페이지로 sendRedirect
				response.sendRedirect(request.getContextPath() + "/login");
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
