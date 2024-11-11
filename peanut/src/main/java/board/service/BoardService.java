package board.service;

import java.util.List;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BoardService {

	// 게시글 목록 전체 조회
	public List<BoardDTO> getList(){
		// DB에서 select
		
		BoardDAO boardDAO = new BoardDAO();
		
		List<BoardDTO> list = boardDAO.selectAll();
		
		return list;
	}
	
	
	// 게시글 하나 상세페이지
	public BoardDTO get(int bno) {
		BoardDTO dto = new BoardDTO();
		
		BoardDAO dao = new BoardDAO();
		dto = dao.selectOne(bno);
		
		return dto;
	}
	
	
	// 게시글 등록
	public int insert(BoardDTO boardDTO) {
		// DB에 insert
		
		BoardDAO boardDAO = new BoardDAO();
		return boardDAO.insert(boardDTO);
	}
	
	
	// 게시글 수정
	public int modify(BoardDTO boardDTO) {
		BoardDAO boardDAO = new BoardDAO();
		return boardDAO.updateOne(boardDTO);
	}
	
	
	// 게시글 삭제
	public int delete(int bno) {
		BoardDAO dao = new BoardDAO();
		return dao.deleteOne(bno);
	}
	
	
//	// 댓글 추가
//	public int insertComment(BoardDTO boardDTO) {
//		BoardDAO dao = new BoardDAO();
//		return dao.insertComment(boardDTO);
//	}
	
	
	
}
