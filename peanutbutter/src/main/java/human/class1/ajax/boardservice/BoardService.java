package human.class1.ajax.boardservice;

import java.util.List;

import human.class1.ajax.boarddto.BoardDTO;

public interface BoardService {
    List<BoardDTO> getList();   // 전체 목록 조회
    BoardDTO get(int bno);      // 게시글 상세 조회
    int insert(BoardDTO boardDTO);   // 게시글 등록
    int modify(BoardDTO boardDTO);   // 게시글 수정
    int delete(int bno);   // 게시글 삭제
    List<BoardDTO> getBoardPage(int countPerPage, int page);   // 페이징 처리된 게시글 목록 조회
    int totalBoardCount();   // 총 게시글 수 조회
}
