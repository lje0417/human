package board.dto;

import java.sql.Date;

public class BoardDTO {

	private int bno; // 번호 ㄴ
	private boolean notice; // 공지사항 여부
	private String title; // 제목
	private String content; // 내용
	private String ename; // 작성자
	private Date crDate; // 작성일 ㄴ
	
	private int rnum; // rownum : 페이징에서 사용
	
//	private String reply; // 댓글
//	
//	public String getReply() {
//		return reply;
//	}
//	public void setReply(String reply) {
//		this.reply = reply;
//	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public boolean isNotice() {
		return notice;
	}
	public void setNotice(boolean notice) {
		this.notice = notice;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getCrDate() {
		return crDate;
	}
	public void setCrDate(Date crDate) {
		this.crDate = crDate;
	}
	
	
}
