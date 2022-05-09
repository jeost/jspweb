package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.memberdao;
import dto.member;

@WebServlet("/member/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public signup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		String mname = request.getParameter("mname");
		String mphone = request.getParameter("mphone");
		String memail = request.getParameter("memail");
		String memailaddress = request.getParameter("memailaddress");
		String email=memail+"@"+memailaddress;
		String add1 = request.getParameter("address1");
		String add2 = request.getParameter("address2");
		String add3 = request.getParameter("address3");
		String add4 = request.getParameter("address4");
			String address=add1+"_"+add2+"_"+add3+"_"+add4;
			member member = new member(0, mid, mpassword, mname, mphone, email, address, 0, null);
			System.out.println(member.toString()); // 확인용
			boolean result=memberdao.getmemberDao().signup(member);
			if(result) {response.sendRedirect("/jspweb/member/signupsuccess.jsp");}
			else {response.sendRedirect("/jspweb/error.jsp");}
			doGet(request, response);
	}

}
