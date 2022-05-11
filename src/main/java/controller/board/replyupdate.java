package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.boardDao;

@WebServlet("/board/replyupdate")
public class replyupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public replyupdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int rno=Integer.parseInt(request.getParameter("rno"));
		String rcontent=request.getParameter("reupdate");
		
		boolean result=boardDao.getboarddao().replyupdate(rcontent,rno);
		if(result) {response.getWriter().print("1");}
		else {response.getWriter().print("2");}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
