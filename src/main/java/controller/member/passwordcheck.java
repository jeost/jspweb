package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.memberdao;

@WebServlet("/passwordcheck")
public class passwordcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public passwordcheck() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid=request.getParameter("mid");
		String mpassword=request.getParameter("mpassword");
		boolean result=memberdao.getmemberDao().passwordcheck(mid,mpassword);
		System.out.println("아이디 : "+mid);
		System.out.println("비밀번호 : "+mpassword);
		System.out.println("비밀번호 체크 결과 : "+result);
		if(result) {
			response.getWriter().print(1);
		}else {
			response.getWriter().print(2);
		}
		System.out.println("POST통신");
	}

}
