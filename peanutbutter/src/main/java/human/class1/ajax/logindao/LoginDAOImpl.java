package human.class1.ajax.logindao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import human.class1.ajax.logindto.LoginDTO;

@Repository
public class LoginDAOImpl implements LoginDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "human.class1.ajax.mapper.LoginMapper";

    @Override
    public LoginDTO selectLogin(String id, String password) {
        // ID로 사용자 정보만 조회 (암호화된 비밀번호 포함)
        return sqlSession.selectOne(NAMESPACE + ".selectLogin", new LoginDTO(id, password));
    }
    
    public LoginDTO selectById(String id) {
        return sqlSession.selectOne(NAMESPACE + ".selectById", id);
    }



    @Override
    public int insertUser(LoginDTO loginDTO) {
        return sqlSession.insert(NAMESPACE + ".insertUser", loginDTO);
    }

    // 아이디 중복 체크
    @Override
    public boolean checkDuplicateId(String id) {
        int count = sqlSession.selectOne(NAMESPACE + ".checkDuplicateId", id);
        return count > 0; // 중복이 있으면 true 반환
    }

    // 전화번호 중복 체크
    @Override
    public boolean checkDuplicatePhoneNum(String phoneNum) {
        int count = sqlSession.selectOne(NAMESPACE + ".checkDuplicatePhoneNum", phoneNum);
        return count > 0;
    }

    // 이메일 중복 체크
    @Override
    public boolean checkDuplicateEmail(String email) {
        int count = sqlSession.selectOne(NAMESPACE + ".checkDuplicateEmail", email);
        return count > 0;
    }
}
