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
import dto.Category;

@WebServlet("/admin/getcategory")
public class getcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getcategory() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		
		ArrayList<Category> cList=ProductDao.getProductDao().getCategoryList();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String html="";
		if(type!=null&&type.equals("option")) {
			for(Category temp : cList) {
				html+="<option value=\""+temp.getCno()+"\">"+temp.getCname()+"</option>";
			}
			out.print(html);
		}else {
			
		int i=1;
		for(Category temp : cList) {
			html+="<input type=\"radio\" name=\"cno\" value=\""+temp.getCno()+"\">"+temp.getCname();
			if(i%6==0) {
				html += "<br>";
			}i++;
		}
		out.print(html);
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
