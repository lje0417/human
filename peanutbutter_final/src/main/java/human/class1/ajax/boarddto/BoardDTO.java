package human.class1.ajax.boarddto;

import java.sql.Date;

public class BoardDTO {

	private int bno; // 번호 ㄴ
	private boolean notice; // 공지사항 여부
	private String title; // 제목
	private String content; // 내용
	private String ename; // 작성자
	private Date crDate; // 작성일 ㄴ
	
	private int rnum; // rownum : 페이징에서 사용
	
	private int start; // 시작 : 페이징에서 사용
	private int end; // 끝 : 페이징에서 사용
	
public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
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
