package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.dto.CommentDTO;
import board.service.BoardService;
import board.service.CommentService;


@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("상세페이지");
		
		BoardService boardService = new BoardService();
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("bno : " + bno);
		
		BoardDTO dto = boardService.get(bno);
		
		// 댓글 리스트를 가져와야함
		CommentService commentService = new CommentService();
		List<CommentDTO> commentList = commentService.getList(bno);
		
		request.setAttribute("boardDTO", dto); // jsp에서 ${boardDTO.title}로 사용해서 제목을 불러올 수 있음
		// 댓글 리퀘스트 필요함
		request.setAttribute("commentList", commentList);
		
		request.getRequestDispatcher("/WEB-INF/board/boardDetail.jsp").forward(request, response);
		
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8;");
//		
//		String ename = request.getParameter("ename");
//		String reply = request.getParameter("reply");
//		System.out.println(ename);
//		
//		BoardDTO commentDTO = new BoardDTO();
//		
//		commentDTO.setEname(ename);
//		commentDTO.setReply(reply);
//		System.out.println(ename);
//		
//		BoardService boardService = new BoardService();
//		int result = boardService.insertComment(commentDTO);
//		System.out.println("insert 결과 : " + result);
//		
//		System.out.println("댓글 추가 완료");
//		
//		int bno = Integer.parseInt(request.getParameter("bno"));
//		System.out.println("bno : " + bno);
//		
//		BoardDTO dto = boardService.get(bno);
//		
//		request.setAttribute("boardDTO", dto);
//		
//		String contextPath = request.getContextPath();
//		response.sendRedirect(contextPath + "/detail");
//		
//	}


}
