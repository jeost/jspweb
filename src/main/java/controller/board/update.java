package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.boardDao;
import dto.Board;

/**
 * Servlet implementation class write
 */
@WebServlet("/board/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public update() {
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
		int bno=Integer.parseInt(multi.getParameter("bno"));
		String btitle=multi.getParameter("btitle");
		String bcontent=multi.getParameter("bcontent");
		String bfile=multi.getFilesystemName("bfile");
		
		//객체화
		Board temp=boardDao.getboarddao().getboard(bno);
		String oldfile=temp.getBfile();
				if(bfile==null) {
				bfile=oldfile;
		}else {
			String upload=request.getSession().getServletContext().getRealPath("/board/upload/"+oldfile);
			File file=new File(upload);
			file.delete();
		}
				
		Board board=new Board(bno, btitle, bcontent, 0, bfile, 0, null, null);
		//DB처리
		boolean result=boardDao.getboarddao().update(board);
		if(result) {
			response.sendRedirect("/jspweb/board/boardlist.jsp");
		}else {
			response.sendRedirect("/jspweb/board/update.jsp?bno="+bno);
		}
	}

}
