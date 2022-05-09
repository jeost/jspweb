package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.memberdao;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid=request.getParameter("mid");
		String mpassword=request.getParameter("mpassword");
		
		int result =memberdao.getmemberDao().login(mid,mpassword);
		if(result==1) {
			//로그인 성공시 섹션 부여
			HttpSession session=request.getSession(); // http 내장 세션 호출(JSP는 내장되어있으니 호출 x)
			session.setAttribute("login", mid); // 세션에 값 저장
			response.sendRedirect("/jspweb/main.jsp");
		}else if(result==2){
			response.sendRedirect("/jspweb/member/login.jsp?result=2");
		}else {
			response.sendRedirect("/jspweb/error.jsp");
		}
		doGet(request, response);
	}

}
