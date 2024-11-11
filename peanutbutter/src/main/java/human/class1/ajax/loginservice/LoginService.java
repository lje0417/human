package human.class1.ajax.loginservice;

import human.class1.ajax.logindto.LoginDTO;

public interface LoginService {
    LoginDTO loginCheck(LoginDTO loginDTO);
    int insertUser(LoginDTO loginDTO);
    
    // 중복 체크 메소드 추가
    boolean checkDuplicateId(String id);
    boolean checkDuplicatePhoneNum(String phoneNum);
    boolean checkDuplicateEmail(String email);
}
