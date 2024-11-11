package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.dto.CommentDTO;

public class CommentDAO {

	public List<CommentDTO> selectAll(int bno) {
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		
		
		try {
			// DB 접속
        	Context ctx = new InitialContext();
        	DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
        	Connection con = dataFactory.getConnection();
        	
        	
        	// SQL 준비
        	String query = "SELECT * FROM comments WHERE bno = ?";
        	PreparedStatement ps = con.prepareStatement(query);
        	ps.setInt(1, bno);
        	ResultSet rs = ps.executeQuery();
        	
        	while(rs.next()) {
        		String ename = rs.getString("ename");
        		String reply = rs.getString("reply");
        		
        		CommentDTO dto = new CommentDTO();
        		dto.setEname(ename);
        		dto.setReply(reply);
        		
        		list.add(dto);
        	}
        	
        	rs.close();
        	ps.close();
        	con.close();
        	
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insert(CommentDTO commentDTO) {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
			String query = " INSERT INTO comments (comments_id, bno, parent_id, ename, reply)";
					query += " VALUES (seq_comments.NEXTVAL, ?, ?, ?, ?)";
			
			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setInt(1, commentDTO.getBno());
			ps.setInt(2, commentDTO.getParent_id());
			ps.setString(3, commentDTO.getEname());
			ps.setString(4, commentDTO.getReply());
			
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
