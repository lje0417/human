package human.class1.ajax.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import human.class1.ajax.dto.FmDTO;

import java.util.List;

@Repository
public class FmDAO {

    private final SqlSession sqlSession;

    @Autowired
    public FmDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<FmDTO> getProcesses() {
        return sqlSession.selectList("human.class1.ajax.mapper.FmMapper.getProcesses");
    }
}