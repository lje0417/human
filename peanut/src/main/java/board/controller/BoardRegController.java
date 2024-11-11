package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardService;


@WebServlet("/board/reg")
public class BoardRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/board/boardReg.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		String title = request.getParameter("title");
		String ename = request.getParameter("ename"); // 로그인한 사람으로 불러올거임
		String content = request.getParameter("content");
		String notice = request.getParameter("notice");
		System.out.println(notice);
		
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setTitle(title);
		boardDTO.setEname(ename); // 로그인 한 사람
		boardDTO.setContent(content);
		if("공지".equals(notice)) {
			boardDTO.setNotice(true);
		} else {
			boardDTO.setNotice(false);
		}
		
		System.out.println(boardDTO);
		
		// DB의 insert까지 실행
		BoardService boardService = new BoardService();
		int result = boardService.insert(boardDTO);
		System.out.println("insert 결과 : " + result);
		
		// 목록으로 보내기
//		response.sendRedirect("list");
//		response.sendRedirect("/Peanutbutter/board");
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/board");
	}

}
