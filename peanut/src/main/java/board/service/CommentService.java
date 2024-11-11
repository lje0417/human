package board.service;

import java.util.List;

import board.dao.CommentDAO;
import board.dto.CommentDTO;

public class CommentService {

	public List<CommentDTO> getList(int bno){
		CommentDAO commentDAO = new CommentDAO();
		
		List<CommentDTO> list = commentDAO.selectAll(bno);
		
		return list;
	}
	
	public int insert(CommentDTO commentDTO) {
		CommentDAO commentDAO = new CommentDAO();
		return commentDAO.insert(commentDTO);
	}
}
