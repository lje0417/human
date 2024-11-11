package board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardPageService;
import board.service.BoardService;


@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/board doGet 실행");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		BoardService boardService = new BoardService();
		List<BoardDTO> boardList = boardService.getList();
		
		// 한페이지당 보여줄 개수
		String countPerPage = request.getParameter("countPerPage");
		// 현재 페이지
		String page = request.getParameter("page");
		
		// 혹시 받은 것이 없다면 기본값 세팅
		if(countPerPage == null) countPerPage = "10";
		if(page == null) page = "1";
		
		BoardPageService bps = new BoardPageService();
		Map map = bps.getBoardPage(countPerPage, page);
		
		request.setAttribute("list", boardList);
		request.setAttribute("map", map);
		request.setAttribute("countPerPage", countPerPage);
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/WEB-INF/board/board.jsp").forward(request, response);
		
	}

}
