package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Product;

@WebServlet("/admin/getproduct")
public class getproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getproduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String type=request.getParameter("type");
		int cno=Integer.parseInt(request.getParameter("cno"));
		ArrayList<Product> list=ProductDao.getProductDao().getProductList();
		String html="";
		if( type != null && type.equals("option") ) {
			for( Product temp : list ) {
				if( temp.getCno() == cno ) {
					html +=
						"<option value=\""+temp.getPno()+"\">"+temp.getPname()+"</option>";	
				}
			}
		}else { }
		
		// 반환
		out.print( html );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
