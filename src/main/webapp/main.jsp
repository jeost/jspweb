<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="dto.Stock"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dao.ProductDao"%>
<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container">
		<div id="mainslide" class="carousel slide" data-bs-ride="carousel" data-bs-interval="3000"> <!-- 캐러셀 -->
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#mainslide" data-bs-slide-to="0" class="active"></button>
				<button type="button" data-bs-target="#mainslide" data-bs-slide-to="1"></button>
				<button type="button" data-bs-target="#mainslide" data-bs-slide-to="2"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img alt="" src="https://shadowverse-portal.com/image/card/phase2/common/C/C_124131010.png?202205170046">
				</div>
				<div class="carousel-item">
					<img alt="" src="https://shadowverse-portal.com/image/card/phase2/common/C/C_124134010.png?202205170046">
				</div>
				<div class="carousel-item">
					<img alt="" src="https://shadowverse-portal.com/image/card/phase2/common/C/C_123834010.png?202205170047">
				</div>
			</div>
			<button class="carousel-control-prev" type="button" data-bs-target="#mainslide" data-bs-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</button>
			<button class="carousel-control-next" type="button" data-bs-target="#mainslide" data-bs-slide="next">
				<span class="carousel-control-next-icon"></span>
			</button>
		</div>
		<div class="row adbox"> <!-- 광고 -->
			<div class="col-md-6">
				<img alt="" src="https://shadowverse-portal.com/image/card/phase2/common/C/C_123821030.png?202205170058">
			</div>
			<div class="col-md-6">
				<img alt="" src="https://shadowverse-portal.com/image/card/phase2/common/C/C_121841010.png?202205170058">
			</div>
		</div>
		<div class="main_box"> <!-- 베스트 -->
			<h5 class="main_title">베스트</h5>
			<div class="row">
				<div class="col-md-3 best_box">
					<img alt="" src="https://shadowverse-portal.com/image/card/phase2/common/C/C_123841030.png?202205170106">
				</div>
				<div class="col-md-3 best_box">
					<img alt="" src="https://shadowverse-portal.com/image/card/phase2/common/C/C_702211010.png?202205170113">
				</div>
				<div class="col-md-3 best_box">
					<img alt="" src="https://shadowverse-portal.com/image/card/phase2/common/C/C_120731010.png?202205170113">
				</div>
				<div class="col-md-3 best_box">
					<img alt="" src="https://shadowverse-portal.com/image/card/phase2/common/C/C_121221010.png?202205170113">
				</div>
			</div>
		</div>
		<div class="main_box"> <!-- 신상품 -->
			<h5 class="main_title">신상품</h5>
			<%
				ArrayList<Product> list=ProductDao.getProductDao().getProductList();
			%>
			<div class="row">
				<%for(Product p:list){ %>
				<div class="col-md-4 best_box">
					<a href="product/productview.jsp?pno=<%=p.getPno()%>">
					<img alt="" src="admin/productimg/<%=p.getPimg()%>"></a>
					<div class="p_item">
					<div><%=p.getPname() %></div>
					<%ArrayList<Stock> stocks=ProductDao.getProductDao().getStock(p.getPno());
						Set<String> sizelist=new TreeSet<>();
						for(Stock s:stocks){sizelist.add(s.getSsize());}
					%>
					<div>
					<%for(String temp:sizelist){ %>
						<%=temp+" "%>
					<%} %>
					</div>
					<hr>
					<div class="row">
					<%//천 단위 쉼표 만들기
						DecimalFormat df=new DecimalFormat("#,### 원");
					%>
					<%float price=p.getPprice()*p.getPdiscount();%>
					<%if(p.getPdiscount()==0){ // 할인있으면%>\
						<div class="p.price"><%=df.format(p.getPprice())%></div>
						<div class="p_discount"><%=price%></div>
						<div>리뷰:412</div>
						<%}else{ // 할인없으면%>
						<div class="p_discount"><%=df.format(p.getPprice())%></div>
						<div>리뷰:412</div>
						<%}	%>
					</div>
					</div>
				</div>
				<%} %>
				<div class="col-md-4 best_box">
					<img alt="" src="https://shadowverse-portal.com/image/card/phase2/common/C/C_120831010.png?202205170106">
				</div>
				<div class="col-md-4 best_box">
					<img alt="" src="https://shadowverse-portal.com/image/card/phase2/common/C/C_121811020.png?202205170112">
				</div>
			</div>
		</div>
		<div> <!-- 실시간 구매후기 -->
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>