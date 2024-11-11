package human.class1.ajax.boardservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import human.class1.ajax.boarddao.BoardDAO;
import human.class1.ajax.boarddto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public List<BoardDTO> getList() {
        return boardDAO.selectAll();
    }

    @Override
    public BoardDTO get(int bno) {
        return boardDAO.selectOne(bno);
    }

    @Override
    public int insert(BoardDTO boardDTO) {
        return boardDAO.insert(boardDTO);
    }

    @Override
    public int modify(BoardDTO boardDTO) {
        return boardDAO.updateOne(boardDTO);
    }

    @Override
    public int delete(int bno) {
        return boardDAO.deleteOne(bno);
    }

    @Override
    public List<BoardDTO> getBoardPage(int countPerPage, int page) {
        int start = ((page - 1) * countPerPage) + 1;
        int end = page * countPerPage;
        return boardDAO.selectBoardPage(start, end);
    }

    @Override
    public int totalBoardCount() {
        return boardDAO.totalBoardCount();
    }
}
