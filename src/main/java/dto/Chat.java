package dto;

public class Chat {

	int cId;
	String cName;
	String cContent;
	String cTime;
	public Chat(int cId, String cName, String cContent, String cTime) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cContent = cContent;
		this.cTime = cTime;
	}public Chat() {
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public String getcTime() {
		return cTime;
	}
	public void setcTime(String cTime) {
		this.cTime = cTime;
	}
}
