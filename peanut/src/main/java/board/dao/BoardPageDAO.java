package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.dto.BoardDTO;


public class BoardPageDAO {

	public List selectBoardPage(int start, int end) {
		List list = new ArrayList();
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();
			
			// SQL 준비
			String query =  " select * ";
					query += " from ( ";
					query += "    select rownum rnum, bno, notice, title, ename, crDate ";
					query += "    from ( ";
					query += "        select bno, notice, title, ename, crDate ";
					query += "        from board ";
					query += "        order by notice, bno desc ";
					query += "    ) ";
					query += " ) ";
					query += " where rnum >= ? and rnum <= ?";
					
			PreparedStatement ps = new LoggableStatement(con, query);
		    ps.setInt(1, start);
		    ps.setInt(2, end);
		    
		    System.out.println( ((LoggableStatement)ps).getQueryString() );
		    
		    // SQL 실행 및 결과 확보
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				
				boardDTO.setBno(rs.getInt("bno"));
				boardDTO.setNotice(Boolean.parseBoolean(rs.getString("notice")));
				boardDTO.setTitle(rs.getString("title"));
				boardDTO.setEname(rs.getString("ename"));
				boardDTO.setCrDate(rs.getDate("crDate"));
				
				boardDTO.setRnum(rs.getInt("rnum"));
				
				list.add(boardDTO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int totalBoardPage() {
		int result = -1;
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();
			
			// SQL 준비
			String query =  " select count(*) cnt from board ";
			
			PreparedStatement ps = new LoggableStatement(con, query);
            
            System.out.println( ((LoggableStatement)ps).getQueryString() );
            
            // SQL 실행 및 결과 확보
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
				result = rs.getInt("cnt");
			}
            
            rs.close();
            ps.close();
			con.close();
            
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
