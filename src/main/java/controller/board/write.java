package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.boardDao;
import dao.memberdao;
import dto.Board;

/**
 * Servlet implementation class write
 */
@WebServlet("/board/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public write() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//개발중인 프로젝트 경로
		//String uploadpath = "C:\\Users\\504\\eclipse-workspace\\jspweb\\src\\main\\webapp\\board\\upload";
		//서버 경로
		 String uploadpath = "C:\\Users\\504\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\jspweb\\board\\upload" ;
		//첨부파일 업로드
		MultipartRequest multi=new MultipartRequest(request, uploadpath,1024*1024*10,"UTF-8",new DefaultFileRenamePolicy());
		
		String btitle=multi.getParameter("btitle");
		String bcontent=multi.getParameter("bcontent");
		String bfile=multi.getFilesystemName("bfile");
		
		HttpSession session=request.getSession();
		String mid=(String)session.getAttribute("login");
		
		int mno=memberdao.getmemberDao().getmno(mid);
		//객체화
		Board board=new Board(0, btitle, bcontent, mno, bfile, 0, null, null);
		System.out.println(board.toString());
		//DB처리
		boolean result=boardDao.getboarddao().write(board);
		if(result) {
			response.sendRedirect("/jspweb/board/boardlist.jsp");
		}else {
			response.sendRedirect("/jspweb/board/boardwrite.jsp");
		}
	}

}
