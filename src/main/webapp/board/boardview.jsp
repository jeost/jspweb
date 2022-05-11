<%@page import="dto.Reply"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.memberdao"%>
<%@page import="dto.Board"%>
<%@page import="dao.boardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
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
	<h2 class="boardview_title"><%=board.getBtitle()%></h2>
	<table class="table"> <!-- 부트스트랩 테이블 클래스 -->
		<tr>
			<td width="25%">번호 : <%=board.getBno()%></td><td width="25%">작성자 : <%=mname%></td><td width="25%"> : 작성일<%=board.getBdate()%></td><td width="25%">조회수 : <%=board.getBview()%></td>
		</tr>
		<tr>
			<td colspan="4"><div class="boardview_content"><%=board.getBcontent()%></div></td>
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
	<div class="row">
		<div class="col-md-2">
		<%
			if(mid!=null){
		%>
		</div>
		<div class="col-md-2">
		<a href="boarddelete?bno=<%=board.getBno()%>"> <button class="form-control">삭제</button> </a>
		</div>
		<div class="col-md-2">
		<a href="update.jsp?bno=<%=board.getBno()%>"> <button class="form-control">수정</button> </a>
		<%} %>
		<a href="boardlist.jsp"> <button class="form-control">목록</button> </a>
		</div>
	</div>
	<h4 class="boardview_title">댓글</h4>
	<% if(mid!=null){
		
	%>
	<div class="row">
		<div class="col-md-10">
			<textarea id="rcontent" class="form-control" rows=3></textarea>
		</div>
		<div class="col-md-2">
			<button onclick="replywrite(<%=bno%>)" class="form-control py-4 my-1">등록</button>
		</div>
	</div>
	<%}else{
		%><h5 class="text-center">로그인 후 댓글 작성이 가능합니다.</h5><%
	}
		%>
<table id="replytable" class="table" > <!-- 댓글 작성 성공시 해당 태그 새로고침 => js( jquery ) -->
			<%  ArrayList<Reply> replylist = boardDao.getboarddao().replylist(bno);
				for( Reply reply : replylist ){  %>
			<tr>
				<td class="replywriter" width="15%">
					<%=reply.getMid() %> <br> 
					<span class="replydate"> <%=reply.getRdate() %> </span>
				</td>
				
				<td width="80%" colspan="2">
					<%=reply.getRcontent() %> <br> 
				<% if( mid !=null && mid.equals( reply.getMid() ) ){ // 본인 작성한 댓글이면 %>
					<button class="btn replybtn" onclick="replyupdate(<%=reply.getRno()%>)"> 수정 </button>
					<button class="btn replybtn" onclick="replydelete(<%=reply.getRno()%>)"> 삭제 </button>
				<%} %>
					<button class="btn replybtn" onclick="rereplyview(<%=reply.getRno()%> , <%=reply.getBno()%> , '<%=mid%>' )"> 
					댓글 
					</button>
				</td>
			</tr>
			
			<tr> <!-- 대댓글 입력창 -->
				<td> </td>
				<td colspan="2" id=<%=reply.getRno() %> > </td>   <!-- 해당 태그의 id값을 변수로 설정 = 댓글번호 ( 댓글 한개당 1개씩 ) -->
			</tr>
			
			<!-- 대댓글 출력창  -->
			<%ArrayList<Reply> rereplylist = boardDao.getboarddao().rereplylist( bno , reply.getRno() );
				for( Reply rereply : rereplylist ){%>
				<tr>
					<td></td>
					<td width="10%" class="replywriter">
						<%=rereply.getMid() %> <br> 
						<span class="replydate"> <%=rereply.getRdate() %> </span>
					</td>
					
					<td width="80%">
						<%=rereply.getRcontent() %> <br> 
					<% if( mid != null && mid.equals( rereply.getMid() ) ){ %>
						<button class="btn replybtn" onclick="rreplyupdate(<%=rereply.getRno()%>)"> 수정 </button>
						<button class="btn replybtn" onclick="replydelete(<%=rereply.getRno()%>)"> 삭제 </button>
						
					<%} %>
					</td>
				</tr>	
			<tr> <!-- 대댓글 입력창 -->
				<td> </td>
				<td colspan="2" id=<%=rereply.getRno() %> > </td>   <!-- 해당 태그의 id값을 변수로 설정 = 댓글번호 ( 댓글 한개당 1개씩 ) -->
			</tr>
				
			<%  }  } %>
		</table>
	<script src="/jspweb/js/board.js" type="text/javascript"></script>
	
	<%@include file ="../footer.jsp" %>


</body>
</html>

