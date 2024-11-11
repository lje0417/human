package human.class1.ajax.boarddao;

import java.util.List;

import human.class1.ajax.boarddto.BoardDTO;

public interface BoardDAO {
    List<BoardDTO> selectAll();   // 전체 게시글 조회
    BoardDTO selectOne(int bno);   // 게시글 상세 조회
    int insert(BoardDTO boardDTO);   // 게시글 등록
    int updateOne(BoardDTO boardDTO);   // 게시글 수정
    int deleteOne(int bno);   // 게시글 삭제
    List<BoardDTO> selectBoardPage(int start, int end);   // 페이징 처리된 게시글 목록 조회
    int totalBoardCount();   // 총 게시글 수 조회
}
