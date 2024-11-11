package human.class1.ajax.boarddao;

import java.util.List;

import human.class1.ajax.boarddto.CommentDTO;

public interface CommentDAO {
    List<CommentDTO> selectAll(int bno);
    int insert(CommentDTO commentDTO);
	int delete(int comments_id);
	int update(CommentDTO commentDTO);
}
