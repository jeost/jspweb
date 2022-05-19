package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Stock;

@WebServlet("/product/getamount")
public class getamount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getamount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int pno=Integer.parseInt(request.getParameter("pno"));
		String color=request.getParameter("color").trim();
		String size=request.getParameter("size").trim();
		ArrayList<Stock> stocks=ProductDao.getProductDao().getStock(pno);
		for(Stock s:stocks) {
			if(s.getScolor().equals(color)&&s.getSsize().equals(size)) {
				response.getWriter().print(s.getSamount());
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
