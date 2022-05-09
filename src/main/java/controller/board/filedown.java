package controller.board;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/filedown")
public class filedown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public filedown() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bfile=request.getParameter("bfile");
		String uploadpath=request.getSession().getServletContext().getRealPath("/board/upload/"+bfile);
		
		File file=new File(uploadpath); // 파일 객체화
		//다운로드 형식[브라우저마다 다름]
		response.setHeader("content-Disposition", "attachment;filename="+URLEncoder.encode(bfile,"UTF-8")+";");
								//다운로드 형식(html) 		다운로드 화면에서 표시할 파일명
		FileInputStream fis=new FileInputStream(file);
			//바이트배열
		byte[] bytes=new byte[(int)file.length()]; // 파일 길이만큼 배열 선언
			//바이트 읽어오기
		fis.read(bytes);
		//출력스트림
			BufferedOutputStream bout=new BufferedOutputStream(response.getOutputStream());
			bout.write(bytes);
			//스트림 닫기
			fis.close();
			bout.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
