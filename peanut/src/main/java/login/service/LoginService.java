package login.service;

import login.dao.LoginDAO;
import login.dto.LoginDTO;

public class LoginService {

	
	public LoginDTO loginCheck(LoginDTO loginDTO) {
		
		LoginDAO loginDAO = new LoginDAO();
		
		LoginDTO resultDTO = loginDAO.selectLogin(loginDTO);
		return resultDTO;
	}
	
	public int insertUser(LoginDTO loginDTO) {
		
		LoginDAO loginDAO = new LoginDAO();
		return loginDAO.insertUser(loginDTO);	
	}
	
}
