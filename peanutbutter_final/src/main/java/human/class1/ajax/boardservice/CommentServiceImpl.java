package human.class1.ajax.boardservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import human.class1.ajax.boarddao.CommentDAO;
import human.class1.ajax.boarddto.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public List<CommentDTO> getCommentList(int bno) {
        return commentDAO.selectAll(bno);
    }

    @Override
    public int insertComment(CommentDTO commentDTO) {
        return commentDAO.insert(commentDTO);
    }
    
    @Override
    public int deleteComment(int comments_id) {
        return commentDAO.delete(comments_id);
    }
    
    @Override
    public int updateComment(CommentDTO commentDTO) {
        return commentDAO.update(commentDTO);
    }

}
