package board.dto;

public class CommentDTO {
	
	private int comments_id;
	private int bno;
	private int parent_id;
	private String ename;
	private String reply;
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
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
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
