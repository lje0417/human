package human.class1.ajax.logindto;

public class LoginDTO {

    private String ename;     // 사원명
    private String id;        // 사원번호 - 아이디
    private String password;  // 로그인 비밀번호
    private String phoneNum;  // 전화번호
    private String email;     // 이메일

    // 기본 생성자
    public LoginDTO() {}

    // 매개변수를 받는 생성자
    public LoginDTO(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public LoginDTO(String ename, String id, String password, String phoneNum, String email) {
        this.ename = ename;
        this.id = id;
        this.password = password;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    @Override
    public String toString() {
        return "LoginDTO [ename=" + ename + ", id=" + id + ", password=" + password + 
               ", phoneNum=" + phoneNum + ", email=" + email + "]";
    }

    // Getter & Setter
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
