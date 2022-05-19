<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>제품 재고</h3>
	<select id="categorybox">
		
	</select>
	<select id="productbox">
	
	</select>
	
	<h3>재고 추가</h3>
	<form id="stockaddform" style="display:none;">
		색상<input type="text" id="scolor">
		사이즈<input type="text" id="ssize">
		수량<input type="text" id="samount">
		<button type="button" onclick="stockadd()">재고 추가</button>
	</form>
	
	재고 목록
	
	<table id="stocklist"></table>
<script type="text/javascript" src="/jspweb/js/productstock.js"></script>
</body>
</html>