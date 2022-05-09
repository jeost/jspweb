<%@page import="dao.memberdao"%>
<%@page import="dto.Board"%>
<%@page import="dao.boardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../header.jsp" %>
	<h3>게시판 상세</h3>
	<%int bno=Integer.parseInt(request.getParameter("bno"));
		String mid=(String)session.getAttribute("login");
		String viewer=mid;
		if(session.getAttribute(bno+"")!=null){
		if(!session.getAttribute(bno+"").equals(mid+"")){
			session.setAttribute(bno+"", mid+"");
			session.setMaxInactiveInterval(24*60*60);
			boardDao.getboarddao().view(bno);
		}
	}else{
		boolean c=false;
		if(!c){
			session.setAttribute(bno+"", mid+"");
			session.setMaxInactiveInterval(24*60*60);
			boardDao.getboarddao().view(bno);
			c=true;
		}
	}
		Board board=boardDao.getboarddao().getboard(bno);
		String mname=memberdao.getmemberDao().getmid(board.getMno());
		if(board.getMno()==memberdao.getmemberDao().getmno(mid)){
			%>
			<a href="boarddelete?bno=<%=board.getBno()%>"><button>삭제</button></a>
			<a href="update.jsp?bno=<%=board.getBno()%>"><button>수정</button></a>
			<%
		}
	%>
	<a href="boardlist.jsp"><button>목록</button></a>
	<table>
		<tr>
			<td>번호</td><td><%=board.getBno()%></td><td>작성자</td><td><%=mname%></td><td>작성일</td><td><%=board.getBdate()%></td><td>조회수</td><td><%=board.getBview()%></td>
		</tr>
		<tr>
			<td>제목</td><td><%=board.getBtitle()%></td>
		</tr>
		<tr>
			<td>내용</td><td><%=board.getBcontent()%></td>
		</tr>
		<%if(board.getBfile()==null){
			%><tr><td>첨부파일 없음</td></tr><%
		}else{
			%><tr>
			<td>첨부파일</td><td><a href="filedown?bfile=<%=board.getBfile()%>"><%=board.getBfile()%></a></td>
			</tr>
		<%
		}
		%>
		
	</table>
<%@include file="../footer.jsp" %>
</body>
</html>