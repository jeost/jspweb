package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.memberdao;
import dto.member;

@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public update() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//유효성검사
		String oldpassword=request.getParameter("oldpassword");
		String newpassword=request.getParameter("newpassword");
		
		
			
		
		//수정할 내용
		int mno =Integer.parseInt( request.getParameter("mno"));
		String mname=request.getParameter("mname");
		String mphone=request.getParameter("mphone");
		String memail=request.getParameter("memail");
		String memailaddress=request.getParameter("memailaddress");
		String email=memail+"@"+memailaddress;
		String maddress1=request.getParameter("address1");
		String maddress2=request.getParameter("address2");
		String maddress3=request.getParameter("address3");
		String maddress4=request.getParameter("address4");
			String address=maddress1+"_"+maddress2+"_"+maddress3+"_"+maddress4;
			//객체화
			member member=null;
			if(oldpassword.equals("")||newpassword.equals("")) { // 비밀번호 변경이 없을 때
				member = new member(mno, null, null, mname, mphone, email, address, 0, null);
			}else { // 변경을 할 때
				//기존 패스워드 체크
				HttpSession session=request.getSession();
				String mid=(String)session.getAttribute("login");
				boolean result=memberdao.getmemberDao().passwordcheck(mid, oldpassword);
				if(result) {
					member = new member(mno, null, newpassword, mname, mphone, email, address, 0, null);
				}else {
					response.sendRedirect("/jspweb/member/update.jsp?result=3"); return;
				}
			}
			
			//DB처리
			boolean result2 = memberdao.getmemberDao().update(member);
			if(result2) {
				response.sendRedirect("/jspweb/member/update.jsp?result=1");
			}else {
				response.sendRedirect("/jspweb/member/update.jsp?result=2");
			}
	}

}
