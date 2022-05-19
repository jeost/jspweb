<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타이틀</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	<link href="/jspweb/css/main.css" rel="stylesheet">
</head>
<body>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script> <!-- jquery cdn -->
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	
	<div class="container header">
	<% String loginid=(String)session.getAttribute("login");
	%>
	<!-- 헤더페이지 [모든 페이지에서 사용하니까 절대 경로 사용 ] -->
	<div class="container">
		<div class="py-4">
			<div class="row">
				<div class="col-md-4">
					<a href="/jspweb/main.jsp">HOME</a>
				</div>
				<div class="col-md-4 offset-md-4">
					<ul class="nav">	<!-- 로그인이 안된 상태 -->
						<%if(loginid==null){ %>
						<li><a href="/jspweb/member/login.jsp" class="header_topmenu">로그인</a></li>
						<li><a href="/jspweb/member/signup.jsp" class="header_topmenu">회원가입</a></li>
						<%} %><!-- 로그인 된 상태 -->
						<%if(loginid!=null){ %>
						<li><a href="/jspweb/logout" class="header_topmenu">로그아웃</a></li>
						<li><a href="/jspweb/member/myshopping.jsp" class="header_topmenu">나의쇼핑</a></li>
							<%if(loginid.equals("admin")){ %>
								<li><a href="/jspweb/admin/dashboard.jsp">관리자모드</a></li>
							<%} %>
						<%} %>
						<li><a href="/jspweb/board/boardlist.jsp?key=&keyword=" class="header_topmenu">자유게시판</a></li>
					</ul>
				</div>
			</div>
		</div>
			<div class="navbar navbar-expand-md navbar-lights bg-white">
				<ul class="navbar-nav col-md-12 justify-content-between">	
					<li class="nav-item"><a href="#">BIG SIZE!</a></li>
					<li class="nav-item" style="color: #00D8FF;"><a href="#">MUSCLE-FIT</a></li>
					<li class="nav-item" style="color: #0100FF;"><a href="#">1+1이벤트</a></li>
					<li class="nav-item"><a href="#" data-bs-toggle="dropdown">아우터</a>
						<!-- 드롭다운 -->
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">드롭다운 메뉴</a>
							<a class="dropdown-item" href="#">드롭다운 메뉴</a>
							<a class="dropdown-item" href="#">드롭다운 메뉴</a>
							<a class="dropdown-item" href="#">드롭다운 메뉴</a>
						</div>
					</li>
					<li class="nav-item"><a href="#">상의</a></li>
					<li class="nav-item"><a href="#">바지</a></li>
					<li class="nav-item"><a href="#">슈즈</a></li>
					<li class="nav-item"><a href="#">악세사리</a></li>
					<li class="nav-item"><a href="#">BEST</a></li>
					<li class="nav-item"><a href="teamchatting.jsp">트레이닝</a></li>
					<li class="nav-item" style="color: #FFBB00;"><a href="#">모델처럼입자!</a></li>
					<li class="nav-item" style="color: #FF0000;"><a href="#">50% 할인</a></li>
					<li class="nav-item"><input type="text" class="header_input" size="13"><a href="#"><i class="fas fa-search"></i></a></li>
					
					<li class="nav-item"><a href="/jspweb/product/productcart.jsp"><img src="/jspweb/cart.png">장바구니<span class="shoppingbox">3</span></a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>