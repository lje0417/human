package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.CommentDTO;
import board.service.CommentService;


@WebServlet("/board/comment")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		String ename = request.getParameter("ename");
		String reply = request.getParameter("reply");
		String bno = request.getParameter("bno");
		System.out.println(ename);
		
		CommentDTO commentDTO = new CommentDTO();
		
		
//		commentDTO.setEname(ename);
		commentDTO.setEname(ename);
		commentDTO.setBno(Integer.parseInt(bno));
		commentDTO.setReply(reply);
		System.out.println(ename);
		
		CommentService commentService = new CommentService();
		int result = commentService.insert(commentDTO);
		System.out.println("insert 결과 : " + result);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/board/detail?bno=" + bno);
		
	}

}
