package human.class1.ajax.logindao;

import human.class1.ajax.logindto.LoginDTO;

public interface LoginDAO {
    LoginDTO selectLogin(String id, String password);
    int insertUser(LoginDTO loginDTO);
    
    // 중복 체크 메소드 추가
    boolean checkDuplicateId(String id);
    boolean checkDuplicatePhoneNum(String phoneNum);
    boolean checkDuplicateEmail(String email);
	LoginDTO selectById(String id);
}
