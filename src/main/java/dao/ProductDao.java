package dao;

import java.util.ArrayList;

import dto.Cart;
import dto.Category;
import dto.Product;
import dto.Stock;

public class ProductDao extends Dao{
	public ProductDao() {
		super();
	}
	public static ProductDao productdao=new ProductDao();
	public static ProductDao getProductDao() {
		return productdao;
	}
	//카테고리 등록
	public boolean csave(String cname) {
		String sql="insert into category (cname) values ('"+cname+"')";
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate(); return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	//카테고리 호출
	public ArrayList<Category> getCategoryList(){
		ArrayList<Category> list=new ArrayList<Category>();
		String sql="select*from category";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Category category=new Category(rs.getInt(1),rs.getString(2));
				list.add(category);
			}return list;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	//카테고리 수정
	
	//카테고리 삭제
	
	/////////////////////////////////////////////////////////////////////////
	
	//제품 등록
	public boolean psave(Product product) {
		String sql="insert into product(pname, pprice, pdiscount, pimg, cno) values(?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setInt(2, product.getPprice());
			ps.setFloat(3, product.getPdiscount());
			ps.setString(4, product.getPimg());
			ps.setInt(5, product.getCno());
			ps.executeUpdate(); return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;}
	//제품 호출
	public ArrayList<Product> getProductList(){
		String sql="select*from product";
		ArrayList<Product> pList=new ArrayList<Product>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Product product=new Product(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
				pList.add(product);}return pList;
	}catch(Exception e) {e.printStackTrace();}
		return null;}
	//제품 개별 호출
	public Product getProduct(int pno) {
		String sql="select*from product where pno="+pno;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				Product product=new Product(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
				return product;
			}
		}catch(Exception e) {e.printStackTrace();}
		return null;}
	//제품 수정
	
	//제품 삭제
	
	/////////////////////////////////////////////////////////////////////////

	//특정제품 재고 등록
	public boolean ssave(Stock stock) {
		String sql="insert into stock(scolor, ssize, samount, pno) values(?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, stock.getScolor());
			ps.setString(2, stock.getSsize());
			ps.setInt(3, stock.getSamount());
			ps.setInt(4, stock.getPno());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;}
	//제품 재고 호출
	public ArrayList<Stock> getStock(int pno) {
		ArrayList<Stock> list=new ArrayList<Stock>();
		String sql="select*from stock where pno="+pno;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Stock stock=new Stock(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7));
				list.add(stock);
			}return list;
		}catch(Exception e) {e.printStackTrace();}
		return null;}
	//특정제품 재고 수정
	public boolean stockupdate(int sno, int amount) {
		String sql="update stock set samount = '"+amount+"' where sno="+sno;
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	//특정제품 재고 삭제
	
	//특정제품 상태 변경
	public boolean activeChange(int active,int pno) {
		String sql="update product set pactive= "+active+" where pno="+pno;
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	////////////////////////////////찜하기/////////////////////////////////////////
	public int saveplike(int pno, int mno) {
		//검색
		String sql="select plikeno from plike where pno="+pno+"and mno="+mno;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {//존재하면 삭제
				sql="delete from plike where plikeno="+rs.getInt(1);
				ps=con.prepareStatement(sql);
				ps.executeUpdate();
				return 2;
			}else {//없으면 등록
				sql="insert into plike(pno,mno) values("+pno+","+mno+")";
				ps=con.prepareStatement(sql);
				ps.executeUpdate();
				return 1;
			}
		//그외 오류
		}catch(Exception e) {e.printStackTrace();}
		return 3; // DB오류
	}
	public boolean getplike(int pno,int mno) {
		String sql="select*from plike where pno="+pno+" and mno="+mno;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next())return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	public boolean savecart(Cart cart) {
		String sql="select*from cart where sno="+cart.getPno()+ "and mno="+cart.getMno();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				sql="update cart samount=samount + "+cart.getSamount()+" where cartno = "+rs.getInt(1);
				
			}else {
				sql="insert into cart(samount, totalprice, sno, mno) values (?,?,?,?)";
				ps=con.prepareStatement(sql);
				ps.setInt(1, cart.getSamount());
				ps.setInt(2, cart.getTotalprice());
				ps.setInt(3, cart.getPno());
				ps.setInt(4, cart.getMno());
				ps.executeUpdate();
				return true;
			}
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
}
