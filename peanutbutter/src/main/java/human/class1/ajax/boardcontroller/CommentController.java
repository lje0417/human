package human.class1.ajax.boardcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import human.class1.ajax.boarddto.CommentDTO;
import human.class1.ajax.boardservice.CommentService;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 댓글 등록
    @PostMapping("/board/comment")
    public String insertComment(
            @RequestParam("ename") String ename,
            @RequestParam("reply") String reply,
            @RequestParam("bno") int bno,
            HttpServletRequest request) {

        // CommentDTO 객체 생성 및 값 설정
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setEname(ename);
        commentDTO.setBno(bno);
        commentDTO.setReply(reply);

        // 댓글 등록 서비스 호출
        commentService.insertComment(commentDTO);

        // 댓글이 등록된 게시글로 리다이렉트
        return "redirect:/board/detail?bno=" + bno;
    }
    
    // 댓글 삭제
    @PostMapping("/board/comment/delete")
    public String deleteComment(
            @RequestParam("comments_id") int comments_id,
            @RequestParam("bno") int bno,
            HttpServletRequest request) {

        // 댓글 삭제 서비스 호출
        commentService.deleteComment(comments_id);

        // 댓글이 삭제된 게시글로 리다이렉트
        return "redirect:/board/detail?bno=" + bno;
    }
    
}
