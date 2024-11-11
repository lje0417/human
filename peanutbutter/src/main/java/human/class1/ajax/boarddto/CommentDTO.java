package human.class1.ajax.boarddto;

public class CommentDTO {
	
	private int comments_id; // 댓글 번호
	private int bno; // 게시글 번호
	private String ename; // 작성자 이름
	private String reply; // 댓글
	
	public int getComments_id() {
		return comments_id;
	}
	public void setComments_id(int comments_id) {
		this.comments_id = comments_id;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	
}
