package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.boardDao;
import dao.memberdao;
import dto.Reply;

@WebServlet("/board/replywrite")
public class replywrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public replywrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int bno=Integer.parseInt(request.getParameter("bno"));
		String rcontent=request.getParameter("rcontent");
		String mid=(String)request.getSession().getAttribute("login");
		int mno=memberdao.getmemberDao().getmno(mid);
		
		Reply reply=new Reply(0, rcontent, null, 0, bno, mno, null);
		
		boolean result=boardDao.getboarddao().replywrite(reply);
		if(result) {response.getWriter().print("1");}
		else {response.getWriter().print("2");}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
