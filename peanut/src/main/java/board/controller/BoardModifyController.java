package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardService;


@WebServlet("/board/modify")
public class BoardModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("수정페이지 실행");
		
		String str_bno = request.getParameter("bno");
		System.out.println("str_bno : " + str_bno);
		
		int bno = Integer.parseInt(str_bno);
		
		BoardService boardService = new BoardService();
		BoardDTO dto = boardService.get(bno);
		
		request.setAttribute("boardDTO", dto);
		request.getRequestDispatcher("/WEB-INF/board/boardModify.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("수정");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		String str_bno = request.getParameter("bno");
		int bno = Integer.parseInt(str_bno);
		System.out.println(bno);
		
		String title = request.getParameter("title");
		String ename = request.getParameter("ename");
		String content = request.getParameter("content");
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBno(bno);
		boardDTO.setTitle(title);
		boardDTO.setEname(ename);
		boardDTO.setContent(content);
		
		BoardService boardService = new BoardService();
		int result = boardService.modify(boardDTO);
		System.out.println("수정 결과 : " + result);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/board");
		
	}

}
