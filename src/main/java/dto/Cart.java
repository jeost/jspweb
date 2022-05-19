package dto;

public class Cart {
	int cartno;
	int mno;
	int pno;
	int samount;
	int totalprice;
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public Cart(int cartno, int mno, int pno, int samount, int totalprice) {
		super();
		this.cartno = cartno;
		this.mno = mno;
		this.pno = pno;
		this.samount = samount;
		this.totalprice = totalprice;
	}
	public int getCartno() {
		return cartno;
	}
	public void setCartno(int cartno) {
		this.cartno = cartno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getSamount() {
		return samount;
	}
	public void setSamount(int samount) {
		this.samount = samount;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public String toString() {
		return "Cart [cartno=" + cartno + ", mno=" + mno + ", pno=" + pno + ", samount=" + samount + ", totalprice="
				+ totalprice + "]";
	}
}
