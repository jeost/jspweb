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
<div class="container">
<h3 class="boardlist_title">자유게시판</h3>

<!-- 검색 처리 -->
<%
	request.setCharacterEncoding("UTF-8");
	String key=request.getParameter("key");
	String keyword=request.getParameter("keyword");
	
	//세션을 이용한 검색처리 저장
	
	//검색이 있을경우
	if(!key.equals("") && !keyword.equals("")){
		//페이징처리 후에도 검색한게 남아야해서 세션에 저장
		session.setAttribute("key", key);
		session.setAttribute("keyword", keyword);
	//검색이 없을경우
	}else{
		key=(String)session.getAttribute("key");
	}
	
	Date date;
	SimpleDateFormat sdf;
	Calendar ca;
	ca=Calendar.getInstance(); sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	int totalrow=boardDao.getboarddao().gettotalrow(key,keyword); // 전체 보드 갯수
	
	int currentpage=1;
	String pagenum=(request.getParameter("pagenum"));
		if(pagenum==null){
			currentpage=1;//페이지번호
		}else{
			currentpage=Integer.parseInt(pagenum);
		}
	int listsize=10; // 추후 사용자에게 입력받기
	int startrow=(currentpage-1)*listsize;
	int lastpage;
	if(totalrow%listsize==0){
		lastpage=totalrow/listsize;
	}else{
		lastpage=(totalrow/listsize)+1;
	}
	
	//페이징버튼 시작번호
	int startbtn=((currentpage-1)/5)*5+1; // 1 6 11 16
	//페이징 표시 개수
	int btnsize=5;
	//페이징버튼 끝번호
	int endbtn=startbtn+btnsize-1;
	if(endbtn>lastpage)endbtn=lastpage;
	ArrayList<Board> boardlist=boardDao.getboarddao().getboardlist(startrow, listsize, key, keyword);
	%>

			<div class="row boardlist_topbtn">
				<div class="col-md-1 offset-md-10">
					<button class="form-control">전체글</button>
				</div>
				<div class="col-md-1">
					<button class="form-control">인기글</button>
				</div>
			</div>
		
		<table class="table table-hover text-center"> <!-- 부트스트랩 테이블 -->
			<tr>
				<th width="15%">번호</th><th width="50%">제목</th><th width="10%">작성자</th><th width="10%">조회수</th><th width="15%">작성일</th>
			</tr>
			<!-- for문이용 보드 들어갈 위치 -->
			<%
				for(Board board : boardlist){
					%>
					<tr>
						<td><%=board.getBno() %></td>
						<td style="text-align:left;"><a href="boardview.jsp?bno=<%=board.getBno()%>"><%=board.getBtitle()%></a>
						[<%=boardDao.getboarddao().replyview(board.getBno()) %>]
						</td>
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
		<div class="col-md-2 offset-10">
			<%String mid=(String)session.getAttribute("login");
			if(mid!=null){
		%>
		<a href="boardwrite.jsp"><button class="form-control">글쓰기</button></a>
		<%}else{ %>
			<span>로그인 후 글 작성 가능</span>
		<%} %>
		</div>
		<!-- 페이징 계산 처리 -->
		<%
		
		%>
		<!-- 페이징 입력 구역 -->
		<div class="col-md-4 offset-4 d-flex justify-content-center">
			<ul class="pagination">
				<%if(currentpage==1){
					%><li class="page-item"><a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=currentpage%>">이전</a></li><%
				}else{%>
				<li class="page-item"><a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=currentpage-1%>">이전</a></li>
				<%} %>
				
				<%for(int i=1; i<=lastpage; i++){ %>
				<li class="page-item"><a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=i%>"><%=i%></a></li>
				<%} %>
				<%if(currentpage==lastpage){ %>
				<li class="page-item"><a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=currentpage%>">다음</a></li>
				<%}else{ %>
				<li class="page-item"><a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=currentpage+1%>">다음</a></li>
				<%} %>
			</ul>
		</div>
		<!-- 검색 입력 구역 -->
		<form action="boardlist.jsp?pagenum=<%=currentpage%>" class="col-md-4 offset-4 d-flex justify-content-center">
			<div class="col-md-3"><!-- 키워드 선택 -->
				<select class="form-select" name="key">
					<option value="btitle">제목</option>
					<option value="bcontent">내용</option>
					<option value="mno">작성자</option>
				</select>
			</div>
			<div class="col-md-7"><!-- 검색 입력창 -->
				<input type="text" class="form-control" name="keyword">
			</div>
			<div class="col-md-2"><!-- 검색 버튼 -->
				<input type="submit" class="form-control" value="검색">
			</div>
		</form>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>