package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.chatDao;
import dto.Chat;

@WebServlet("/chatlist")
public class chatlist extends HttpServlet {
	public static ArrayList<Chat> chatList=new ArrayList<Chat>();
	private static final long serialVersionUID = 1L;
       
    public chatlist() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html);charset-UTF-8");
		ArrayList<Chat> chatList =chatDao.chatdao.getChat();
		if(chatList!=null) {
			String recieve="";
			for(Chat temp: chatList) {
				recieve+="^"+temp.getcTime()+"^"+temp.getcId()+"^"+temp.getcName()+"^"+temp.getcContent()+",";
			}
		response.getWriter().write(recieve);}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
