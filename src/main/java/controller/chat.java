package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.chatDao;

@WebServlet("/chat")
public class chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public chat() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html);charset-UTF-8");
		
		String cName=request.getParameter("cName");
		String cContent=request.getParameter("cContent");
		if(cName==null||cName.equals("")||cContent==null||cContent.equals("")) {
			boolean result=chatDao.chatdao.submit(cName, cContent);
			if(result) {
				System.out.println(result);
				response.getWriter().write("1");
			}else{response.getWriter().write("2");}
		}else {
			response.getWriter().write(new chatDao().submit(cName, cContent)+"");
		}
	}

}
