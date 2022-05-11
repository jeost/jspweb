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

@WebServlet("/board/rereplywrite")
public class rereplywrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public rereplywrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int rindex=Integer.parseInt(request.getParameter("rno"));
		int bno=Integer.parseInt(request.getParameter("bno"));
		String rrcontent=request.getParameter("rrcontent");
		String mid=(String)request.getSession().getAttribute("login");
		int mno=memberdao.getmemberDao().getmno(mid);
		Reply reply=new Reply(0, rrcontent, null, rindex, bno, mno, null);
		//db처리
		boolean result = boardDao.getboarddao().replywrite(reply);
		if(result) {
			response.getWriter().print("1");
		}else {
			response.getWriter().print("2");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
