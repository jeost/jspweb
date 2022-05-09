package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.boardDao;

@WebServlet("/board/filedelete")
public class filedelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public filedelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno=Integer.parseInt(request.getParameter("bno"));
		String bfile=boardDao.getboarddao().getboard(bno).getBfile();
		boolean result=boardDao.getboarddao().filedelete(bno);
		if(result) {
			String uploadpath=request.getSession().getServletContext().getRealPath("/board/upload/"+bfile);
			File file=new File(uploadpath);
			file.delete();
			response.getWriter().print("1");
		}else {
			response.getWriter().print("2");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
