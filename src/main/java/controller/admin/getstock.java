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
import dto.Stock;

@WebServlet("/admin/getstock")
public class getstock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getstock() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int pno=Integer.parseInt(request.getParameter("pno"));
		ArrayList<Stock> list=ProductDao.getProductDao().getStock(pno);
		String field=request.getParameter("field");
		if(field!=null&&field.equals("amount")) {
			String scolor=request.getParameter("scolor");
			String ssize=request.getParameter("ssize");
			for(Stock temp:list) {
				if(temp.getScolor().equals(scolor)&&temp.getSsize().equals(ssize)) {
					out.print(temp.getSamount()+","+temp.getUpdatedate());
				}
			}
		}
		String html="";
		
			for(Stock temp : list) {
				html+="<tr>"+"<td>"+temp.getScolor()+"</td>"+
						"<td>"+temp.getSsize()+"</td>"+
						"<td>"+temp.getSamount()+"</td>"+
						"<td><button onclick=\'showupdate("+temp.getSno()+")\'>수정</button><button>삭제</button></td></tr>";
			}out.print(html);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
