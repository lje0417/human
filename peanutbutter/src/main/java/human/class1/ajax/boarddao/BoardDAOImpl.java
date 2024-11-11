package human.class1.ajax.boarddao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import human.class1.ajax.boarddto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "human.class1.ajax.boarddao.BoardDAO";

    @Override
    public List<BoardDTO> selectAll() {
        return sqlSession.selectList(NAMESPACE + ".selectAll");
    }

    @Override
    public BoardDTO selectOne(int bno) {
        return sqlSession.selectOne(NAMESPACE + ".selectOne", bno);
    }

    @Override
    public int insert(BoardDTO boardDTO) {
        return sqlSession.insert(NAMESPACE + ".insert", boardDTO);
    }

    @Override
    public int updateOne(BoardDTO boardDTO) {
        return sqlSession.update(NAMESPACE + ".updateOne", boardDTO);
    }

    @Override
    public int deleteOne(int bno) {
        return sqlSession.delete(NAMESPACE + ".deleteOne", bno);
    }

    @Override
//    public List<BoardDTO> selectBoardPage(int start, int end) {
//        return sqlSession.selectList(NAMESPACE + ".selectBoardPage", new int[]{start, end});
//    }
    public List<BoardDTO> selectBoardPage(int start, int end) {
        Map<String, Integer> paramMap = new HashMap<String, Integer>();
        paramMap.put("start", start);
        paramMap.put("end", end);
        return sqlSession.selectList("selectBoardPage", paramMap);
    }


    @Override
    public int totalBoardCount() {
        return sqlSession.selectOne(NAMESPACE + ".totalBoardCount");
    }
}
