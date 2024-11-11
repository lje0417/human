package login.dto;

public class LoginDTO {
	
	private String ename; // 사원명
	private String id; // 사원번호 - 아이디
	private String password; // 로그인 비밀번호
	
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
	
	
}
