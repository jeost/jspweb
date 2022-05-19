package dto;

public class Order {
	int mno;
	int orderactive;
	String orderaddress;
	String orderdate;
	int orderdeliverno;
	String ordername;
	int orderno;
	String orderphone;
	String orderrequest;
	int ordertotalpay;
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(int mno, int orderactive, String orderaddress, String orderdate, int orderdeliverno, String ordername,
			int orderno, String orderphone, String orderrequest, int ordertotalpay) {
		super();
		this.mno = mno;
		this.orderactive = orderactive;
		this.orderaddress = orderaddress;
		this.orderdate = orderdate;
		this.orderdeliverno = orderdeliverno;
		this.ordername = ordername;
		this.orderno = orderno;
		this.orderphone = orderphone;
		this.orderrequest = orderrequest;
		this.ordertotalpay = ordertotalpay;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getOrderactive() {
		return orderactive;
	}
	public void setOrderactive(int orderactive) {
		this.orderactive = orderactive;
	}
	public String getOrderaddress() {
		return orderaddress;
	}
	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public int getOrderdeliverno() {
		return orderdeliverno;
	}
	public void setOrderdeliverno(int orderdeliverno) {
		this.orderdeliverno = orderdeliverno;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public String getOrderphone() {
		return orderphone;
	}
	public void setOrderphone(String orderphone) {
		this.orderphone = orderphone;
	}
	public String getOrderrequest() {
		return orderrequest;
	}
	public void setOrderrequest(String orderrequest) {
		this.orderrequest = orderrequest;
	}
	public int getOrdertotalpay() {
		return ordertotalpay;
	}
	public void setOrdertotalpay(int ordertotalpay) {
		this.ordertotalpay = ordertotalpay;
	}
	
}
