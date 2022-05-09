<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타이틀</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

	<link href="/jspweb/css/main.css" rel="stylesheet">
</head>
<body>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script> <!-- jquery cdn -->
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
	<div class="container header">
	<% String loginid=(String)session.getAttribute("login");
	%>
	<!-- 헤더페이지 [모든 페이지에서 사용하니까 절대 경로 사용 ] -->
	<!-- 공통 -->
	<a href="/jspweb/main.jsp">home</a>
	<a href="#">BIG SIZE!</a>
	<a href="#">MUSCLE-FIT</a>
	<a href="#">1+1이벤트</a>
	<a href="#">아우터</a>
	<a href="#">상의</a>
	<a href="#">바지</a>
	<a href="#">슈즈</a>
	<a href="#">악세사리</a>
	<a href="#">BEST</a>
	<a href="#">트레이닝</a>
	<a href="#">모델처럼입자!</a>
	<a href="#">50% 할인</a>
	<input type="text"><button>검색</button>
	<a href="#"><img src="#">장바구니이미지</a>
	<!-- 로그인이 안된 상태 -->
	<%if(loginid==null){ %>
	<a href="/jspweb/member/login.jsp">로그인</a>
	<a href="/jspweb/member/signup.jsp">회원가입</a>
	<%} %>
	<!-- 로그인 된 상태 -->
	<%if(loginid!=null){ %>
	<a href="/jspweb/logout">로그아웃</a>
	<a href="/jspweb/member/myshopping.jsp">나의쇼핑</a>
	<%} %>
	<a href="/jspweb/board/boardlist.jsp">자유게시판</a>
	</div>
</body>
</html>