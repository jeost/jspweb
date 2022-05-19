<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	<link href="/jspweb/css/main.css" rel="stylesheet">
	<link href="/jspweb/css/admin.css" rel="stylesheet">
</head>
<body>
	<marquee scrollamount="20">공지사항 표시 위치[제품 관리]</marquee>
	<div id="sidebar">
		<ul>
			<li><h6>EZEN SHOP <br> 관리자 모드</h6></li>
			<li><button onclick="pagechange('productView')">제품 목록</button></li>
			<li><button onclick="pagechange('productadd')">제품 등록</button></li>
			<li><button onclick="pagechange('productstock')">제품 재고</button></li>
			<li><button onclick="#">주문 현황</button></li>
			<li><button onclick="#">주문 배송</button></li>
			<li><button onclick="#">매출 관리</button></li>
			<li><a href="/jspweb/main.jsp">홈페이지</a></li>
			<li><a href="/jspweb/logout">로그아웃</a></li>
		</ul>
		<!-- 사이드바 버튼 -->
		<span class="sidebarbtn" id="sidebarbtn">||||</span>
	</div>
	<!-- -------------------------페이지 전환시 포함되는 구역 ---------------------------- -->
	<div class="container" id="mainbox">
		
	</div>
	<!-- -------------------------관리자 메인페이지 ---------------------------- -->
	<div class="container">
		관리자 메인페이지
	</div>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script> <!-- jquery cdn -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<script src="/jspweb/js/dashboard.js" type="text/javascript"></script>
</body>
</html>