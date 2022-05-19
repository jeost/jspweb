<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="dao.memberdao"%>
<%@page import="dao.boardDao"%>
<%@page import="dto.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<%
		ArrayList<Board> boardlist=boardDao.getboarddao().getboardlist(0,10,"","");
		Date date;
		SimpleDateFormat sdf;
		Calendar ca;
		ca=Calendar.getInstance(); sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		ArrayList<Board> myboard=new ArrayList<Board>();
	%>
	<div class="container">
		<h3>자유게시판</h3>
		<%
		if((String)session.getAttribute("login")!=null){
		String mid=(String)session.getAttribute("login");
		for(Board temp:boardlist){
			if(temp.getMid().equals(mid)){
				myboard.add(temp);
			}
			}
		}else{
			response.sendRedirect("../error.jsp");
		}
		%>
		<table class="table"> <!-- 부트스트랩 테이블 -->
			<tr>
				<th>번호</th><th>제목</th><th>작성자</th><th>조회수</th><th>작성일</th>
			</tr>
			<!-- for문이용 보드 들어갈 위치 -->
			<%
				for(Board board : myboard){
					%>
					<tr>
						<td><%=board.getBno() %></td>
						<td><a href="boardview.jsp?bno=<%=board.getBno()%>"><%=board.getBtitle() %></a></td>
						<td><%=memberdao.getmemberDao().getmid(board.getMno()) %></td>
						<td><%=board.getBview() %></td>
						<%
						Date d=sdf.parse(board.getBdate());
						Calendar c1=Calendar.getInstance(); c1.setTime(d);
						if(ca.get(Calendar.DAY_OF_MONTH)==c1.get(Calendar.DAY_OF_MONTH)){
							%><td><%=board.getBdate().split(" ")[1] %></td><%
						}else{
							%><td><%=board.getBdate().split(" ")[0] %></td><%
						}
						%>
					</tr>
					<%
				}
			%>
			<tr>
			</tr>
		</table>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>