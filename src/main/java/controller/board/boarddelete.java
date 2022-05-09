package controller.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.boardDao;
import dto.Board;

/**
 * Servlet implementation class boarddelete
 */
@WebServlet("/board/boarddelete")
public class boarddelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public boarddelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno=Integer.parseInt(request.getParameter("bno"));
		Board board=boardDao.getboarddao().getboard(bno);
		String bfile=board.getBfile();
		boolean result=boardDao.getboarddao().delete(bno);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter(); // html로 내보내기 메소드
		if(result) {
			System.out.println("게시글 삭제 성공");
			//java에서 html(js 명령어) 사용하기
			//삭제 성공시 서버에서도 지우기
			String uploadpath=request.getSession().getServletContext().getRealPath("/board/upload/"+bfile);
			File file=new File(uploadpath); // 경로 넣고
			file.delete(); // 삭제하기
			out.println("<html>");
			out.println("<body>");
			out.println("</body>");
			out.println("</html>");
			
			out.println("<script>");
			out.println("alert('해당 게시물이 삭제 되었습니다.')");
			out.println("location.href='boardlist.jsp';");
			out.println("</script>");
		}else {
			out.println("<html>");
			out.println("<body>");
			out.println("<script>");
			out.println("alert('해당 게시물 삭제 실패.')");
			out.println("location.href='boardlist.jsp';");
			out.println("</script>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
