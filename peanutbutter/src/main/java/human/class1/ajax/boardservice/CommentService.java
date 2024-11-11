package human.class1.ajax.boardservice;

import java.util.List;

import human.class1.ajax.boarddto.CommentDTO;

public interface CommentService {
    List<CommentDTO> getCommentList(int bno);
    int insertComment(CommentDTO commentDTO);
	int deleteComment(int comments_id);
	int updateComment(CommentDTO commentDTO);
}
