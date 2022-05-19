package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.ProductDao;
import dao.memberdao;
import dto.Cart;
import dto.Stock;

/**
 * Servlet implementation class savecart
 */
@WebServlet("/savecart")
public class savecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public savecart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data=request.getParameter("json");
		int error=-1;
		try {
		JSONArray jsonarray=new JSONArray(data);
		for(int i=0; i<jsonarray.length(); i++) {
			JSONObject jsonobject=jsonarray.getJSONObject(i); // 해당 객체의 키를 이용한 값 호출
			String pname=jsonobject.getString("pname");
			String color=jsonobject.getString("color");
			String size=jsonobject.getString("size");
			int amount=jsonobject.getInt("amount");
			int pprice=jsonobject.getInt("pprice");
			int totalprice=jsonobject.getInt("totalprice");
			int point=jsonobject.getInt("point");
			String mid=(String)request.getSession().getAttribute("login");
			int mno=memberdao.getmemberDao().getmno(mid);
			int pno=Integer.parseInt(request.getParameter("pno"));
			ArrayList<Stock> list=ProductDao.getProductDao().getStock(pno);
			int sno=0;
			for(Stock s: list) {
				if(s.getSsize().equals(size)&&s.getScolor().equals(size)) {
					sno=s.getSno();
				}
			}
			Cart cart=new Cart(0, mno, pno, amount, totalprice);
			System.out.println(cart.toString());
			boolean re=ProductDao.getProductDao().savecart(cart);
			if(re==false) {error=i; System.out.println(i+"번째 카트 오류");}
		}
		if(error==-1) {response.getWriter().print(1);}
		else {response.getWriter().print(error);}
		}catch(Exception e) {e.printStackTrace();}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
