package human.class1.ajax.boardcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import human.class1.ajax.boarddto.BoardDTO;
import human.class1.ajax.boarddto.CommentDTO;
import human.class1.ajax.boardservice.BoardService;
import human.class1.ajax.boardservice.CommentService;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;
    
    @Autowired
    private CommentService commentService;

    // 게시판 목록 조회
    @GetMapping("/board")
    public String boardList(
            @RequestParam(defaultValue = "8") int countPerPage,
            @RequestParam(defaultValue = "1") int page,
            Model model) {

        List<BoardDTO> boardList = boardService.getBoardPage(countPerPage, page);
        int totalBoardCount = boardService.totalBoardCount();
        int totalPageCount = (int) Math.ceil((double) totalBoardCount / countPerPage);

        model.addAttribute("list", boardList);
        model.addAttribute("totalBoardCount", totalBoardCount);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("currentPage", page);
        model.addAttribute("countPerPage", countPerPage);

        return "board/board";
    }

    // 게시글 상세 조회
    @GetMapping("/board/detail")
    public String boardDetail(@RequestParam("bno") int bno, Model model) {
        BoardDTO boardDTO = boardService.get(bno);
        List<CommentDTO> commentList = commentService.getCommentList(bno);

        model.addAttribute("boardDTO", boardDTO);
        model.addAttribute("commentList", commentList);

        return "board/boardDetail";
    }

    // 게시글 등록 페이지 이동 (GET)
    @GetMapping("/board/reg")
    public String boardRegForm(Model model) {
    	
        return "board/boardReg";
    }

    // 게시글 등록 처리 (POST)
    @PostMapping("/board/reg")
    public String boardReg(@RequestParam("title") String title,
                           @RequestParam("ename") String ename,
                           @RequestParam("content") String content,
                           @RequestParam(value = "notice", required = false) String notice) {

    	BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle(title);
        boardDTO.setEname(ename);
        boardDTO.setContent(content);
        boardDTO.setNotice("공지".equals(notice));

        boardService.insert(boardDTO);

        return "redirect:/board";
    }

    // 게시글 삭제 처리 (POST)
    @PostMapping("/board/delete")
    public String boardDelete(@RequestParam("bno") int bno) {
        boardService.delete(bno);
        return "redirect:/board";
    }

    // 게시글 수정 페이지 이동 (GET)
    @GetMapping("/board/modify")
    public String boardModifyForm(@RequestParam("bno") int bno, Model model) {
        BoardDTO boardDTO = boardService.get(bno);
        model.addAttribute("boardDTO", boardDTO);
        return "board/boardModify";
    }

    // 게시글 수정 처리 (POST)
    @PostMapping("/board/modify")
    public String boardModify(@RequestParam("bno") int bno,
                              @RequestParam("title") String title,
                              @RequestParam("ename") String ename,
                              @RequestParam("content") String content) {

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBno(bno);
        boardDTO.setTitle(title);
        boardDTO.setEname(ename);
        boardDTO.setContent(content);

        boardService.modify(boardDTO);

        return "redirect:/board";
    }
    
    // 댓글 수정
    @PostMapping("/board/comment/edit")
    public String editComment(
            @RequestParam("comments_id") int comments_id,
            @RequestParam("reply") String reply,
            @RequestParam("bno") int bno) {

        // CommentDTO 객체 생성 및 수정할 내용 설정
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setComments_id(comments_id);
        commentDTO.setReply(reply);

        // 댓글 수정 서비스 호출
        commentService.updateComment(commentDTO);

        // 수정된 댓글이 포함된 게시글로 리다이렉트
        return "redirect:/board/detail?bno=" + bno;
    }
}
