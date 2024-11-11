package human.class1.ajax.loginservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import human.class1.ajax.logindao.LoginDAO;
import human.class1.ajax.logindto.LoginDTO;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDAO loginDAO;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public LoginDTO loginCheck(LoginDTO loginDTO) {
        // 먼저 ID로 사용자 정보를 조회
        LoginDTO storedUser = loginDAO.selectById(loginDTO.getId());
        
        // ID로 조회한 사용자가 null이 아닐 경우 비밀번호 비교
        if (storedUser != null && passwordEncoder.matches(loginDTO.getPassword(), storedUser.getPassword())) {
            return storedUser;  // 로그인 성공
        } else {
            return null;  // 로그인 실패
        }
    }




    @Override
    public int insertUser(LoginDTO loginDTO) {
        return loginDAO.insertUser(loginDTO);
    }

    // 아이디 중복 체크 구현
    @Override
    public boolean checkDuplicateId(String id) {
        return loginDAO.checkDuplicateId(id);
    }

    // 전화번호 중복 체크 구현
    @Override
    public boolean checkDuplicatePhoneNum(String phoneNum) {
        return loginDAO.checkDuplicatePhoneNum(phoneNum);
    }

    // 이메일 중복 체크 구현
    @Override
    public boolean checkDuplicateEmail(String email) {
        return loginDAO.checkDuplicateEmail(email);
    }
}
