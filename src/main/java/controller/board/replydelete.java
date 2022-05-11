package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.boardDao;
@WebServlet("/board/replydelete")
public class replydelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public replydelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rno=Integer.parseInt(request.getParameter("rno"));
		boolean result=boardDao.getboarddao().replydelete(rno);
		
		if(result) {
			System.out.println("댓글 삭제 성공");
			response.getWriter().print(1);
		}else {
			response.getWriter().print(2);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
