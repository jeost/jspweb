package dto;

import dao.memberdao;

public class Reply {
	private int rno;
	private String rcontent;
	private String rdate;
	private int rindex;
	private int bno;
	private int mno;
	private String mid;
	public Reply() {
	}
	public Reply(int rno, String rcontent, String rdate, int rindex, int bno, int mno, String mid) {
		super();
		this.rno = rno;
		this.rcontent = rcontent.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\S)*(/)?","");
		this.rdate = rdate;
		this.rindex = rindex;
		this.bno = bno;
		this.mno = mno;
		this.mid = memberdao.getmemberDao().getmid(mno);
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public int getRindex() {
		return rindex;
	}
	public void setRindex(int rindex) {
		this.rindex = rindex;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
}
