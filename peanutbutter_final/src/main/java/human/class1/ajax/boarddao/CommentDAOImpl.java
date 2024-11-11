package human.class1.ajax.boarddao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import human.class1.ajax.boarddto.CommentDTO;

@Repository
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String namespace = "human.class1.ajax.mapper.CommentMapper";

    @Override
    public List<CommentDTO> selectAll(int bno) {
        return sqlSession.selectList(namespace + ".selectAll", bno);
    }

    @Override
    public int insert(CommentDTO commentDTO) {
        return sqlSession.insert(namespace + ".insert", commentDTO);
    }
    
    @Override
    public int delete(int comments_id) {
        return sqlSession.delete(namespace + ".delete", comments_id);
    }
    
    @Override
    public int update(CommentDTO commentDTO) {
        return sqlSession.update(namespace + ".update", commentDTO);
    }
}
