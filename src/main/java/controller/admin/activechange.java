package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

@WebServlet("/admin/activechange")
public class activechange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public activechange() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int active=Integer.parseInt(request.getParameter("active"));
		int pno=Integer.parseInt(request.getParameter("pno"));
		boolean result=ProductDao.getProductDao().activeChange(active,pno);
		if(result) {
			response.getWriter().write(1);
		}else {
			response.getWriter().write(2);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
