package board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.dto.BoardDTO;

public class BoardDAO {
	
	// 게시판 목록 전체 조회
	public List<BoardDTO> selectAll() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
        
        try {
        	
        	// DB 접속
        	Context ctx = new InitialContext();
        	DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
        	Connection con = dataFactory.getConnection();
        	
        	// SQL 준비
        	String query = "SELECT * FROM board order by bno desc";
        	
        	// 		String을 오라클용으로 컴파일
        	PreparedStatement ps = con.prepareStatement(query);
        	
        	// SQL 실행 및 결과 확보
        	// 		ResultSet에 모든 select 결과가 들어있다
        	// 		executeQuery : select 전용, ResultSet을 반환함
        	// 		executeUpdate : select 외 모든 것, int를 반환함
        	ResultSet rs = ps.executeQuery();
        	
        	
        	// 결과 활용
        	// rs.next() 다음 줄이 있는가?
        	// next가 실행된 이후에는 rs가 한 줄로 바뀜
        	while(rs.next()) {
        		// 전달인자로 컬럼명을 적고 그 내용을 형변환해서 가지고 온다
        		
        		// 번호, 제목, 작성자, 작성일, 조회수를 적으면 되나 ? 조회수 빼는 게 편할 듯
        		int bno = rs.getInt("bno");
        		
        		String title = rs.getString("title");

        		String ename = rs.getString("ename");
        		
        		String notice = rs.getString("notice");
        		
//        		java.sql.Date
        		
        		Date crDate = rs.getDate("crDate");
        		
        		
        		BoardDTO dto = new BoardDTO();
        		dto.setBno(bno);
        		dto.setTitle(title);
        		dto.setEname(ename);
        		dto.setCrDate(crDate);
        		dto.setNotice(notice.equals("true") ? true : false);
        		
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
	
	
	// 게시글 하나 상세페이지
	public BoardDTO selectOne(int bno) {
		BoardDTO boardDTO = null;
		
		try {
			// DB 접속
        	Context ctx = new InitialContext();
        	DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
        	Connection con = dataFactory.getConnection();
        	
        	// SQL 준비
        	String sql = "select * from board where bno = ?";
//        	String sql = "SELECT * FROM board b LEFT OUTER JOIN comments c ON b.bno = c.bno WHERE b.bno = ?";
        	// select * from board b, comments c  where b.bno = c.bno; - 경민쓰 아이디어 left outer join
        	PreparedStatement ps = con.prepareStatement(sql);
        	ps.setInt(1, bno);
        	
        	// SQL 실행 및 결과 확보
        	ResultSet rs = ps.executeQuery();
        	
        	// 결과 활용
        	if(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setBno(rs.getInt("bno"));
				boardDTO.setTitle(rs.getString("title"));
				boardDTO.setEname(rs.getString("ename"));
				boardDTO.setContent(rs.getString("content"));				
//				boardDTO.setReply(rs.getString("reply"));				
//				String reply = rs.getString("reply");
//				dto.setReply(reply);
			}
        	
        	
		} catch(Exception e) {
			e.printStackTrace();
		}
		return boardDTO;
	}
	
	
	// 게시글 등록
	public int insert(BoardDTO boardDTO) {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
			String query = " INSERT INTO board (bno, notice, title, content, ename, crDate)";
					query += " VALUES (seq_board.NEXTVAL, ?, ?, ?, ?, sysdate)";
			
			PreparedStatement ps = new LoggableStatement(con, query);
			
			String notice = boardDTO.isNotice() ? "false" : "true";
            ps.setString(1, notice);
			
            ps.setString(2, boardDTO.getTitle());
			
            ps.setString(3, boardDTO.getContent());
			
            ps.setString(4, boardDTO.getEname());
			
			// SQL 실행
			result = ps.executeUpdate();
			
			ps.close();
			con.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
        
	}
	
	
	// 게시글 수정
	public int updateOne(BoardDTO boardDTO) {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
			String query = " update board";
			   		query += " set title = ?, ename= ?, content = ?";
			   		query += " where bno = ?";
			   		
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, boardDTO.getTitle());
			ps.setString(2, boardDTO.getEname());
			ps.setString(3, boardDTO.getContent());
			ps.setInt(4, boardDTO.getBno());
			
			// SQL 실행
			result = ps.executeUpdate();
			
			ps.close();
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	// 게시글 삭제
	public int deleteOne(int bno) {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
			String query = "delete from board where bno = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, bno);
			
			// SQL 실행
			result = ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
//	// 댓글 추가
//	public int insertComment(BoardDTO boardDTO) {
//		int result = -1;
//		
//		try {
//			// DB 접속
//			Context ctx = new InitialContext();
//			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
//			Connection con = dataFactory.getConnection();
//			
//			// SQL 준비
//			String query = " INSERT INTO comments (bno, ename, reply)";
//					query += " VALUES (seq_board.NEXTVAL, ?, ?)";
//			
//			PreparedStatement ps = new LoggableStatement(con, query);
//			ps.setString(1, boardDTO.getEname());
//			ps.setString(2, boardDTO.getReply());
//			
//			// SQL 실행
//			result = ps.executeUpdate();
//						
//			ps.close();
//			con.close();
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return result;
//	}
	
}
