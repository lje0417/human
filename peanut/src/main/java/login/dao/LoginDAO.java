package login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.dao.LoggableStatement;
import login.dto.LoginDTO;


public class LoginDAO {

	public LoginDTO selectLogin(LoginDTO loginDTO) {
		LoginDTO resultDTO = null;
		
		try {
			
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();
			
			// SQL 준비
			String query = " select * from pb_login";
					query += " where id = ? and password = ?";
					
			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setString(1, loginDTO.getId());
			ps.setString(2, loginDTO.getPassword());
			
			// 실제 실행되는 sql을 출력해볼 수 있다
			System.out.println( ((LoggableStatement)ps).getQueryString() );
			
			// SQL 실행
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				resultDTO = new LoginDTO();
				resultDTO.setId(rs.getString("id"));
				resultDTO.setPassword(rs.getString("password"));
				resultDTO.setEname(rs.getString("ename"));				
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return resultDTO;
		
	}
	
	public int insertUser(LoginDTO loginDTO) {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
            String query = "INSERT INTO pb_login (ename, id, password) VALUES (?, ?, ?)";
            
            PreparedStatement ps = new LoggableStatement(con, query);
            ps.setString(1, loginDTO.getEname());
            ps.setString(2, loginDTO.getId());
            ps.setString(3, loginDTO.getPassword());
            
            // SQL 실행
         	result = ps.executeUpdate();
         			
         	ps.close();
         	con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}

