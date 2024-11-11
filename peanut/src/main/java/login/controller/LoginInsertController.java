package login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dto.LoginDTO;
import login.service.LoginService;


@WebServlet("/login/insert")
public class LoginInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		String ename = request.getParameter("ename");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println(ename);
		
		LoginDTO loginDTO = new LoginDTO();
		
		loginDTO.setEname(ename);
		loginDTO.setId(id);
		loginDTO.setPassword(password);
		System.out.println(loginDTO);
		
		LoginService loginService = new LoginService();
		int result = loginService.insertUser(loginDTO);
		System.out.println("insert 결과 : " + result);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/login");
		
	}

}
