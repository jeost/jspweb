<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/productadd.css" rel="stylesheet">
</head>
<body>
	<h6 class="admin_title">제품 등록 페이지</h6>
	<div class="col-md-6 offset-2">
		<form id="addform">
				<label for="basic-url" class="form-label">제품 이름 입력</label>
				<div class="input-group mb-3 col-md-8 offset-2">
				  <span class="input-group-text" id="basic-addon3">이름</span>
				  <input type="text" class="form-control" id="pname" name="pname" aria-describedby="basic-addon3">
				</div>
				<label for="basic-url" class="form-label">제품 가격 입력</label>
				<div class="input-group mb-3 col-md-8 offset-2">
				  <span class="input-group-text" id="basic-addon3">가격</span>
				  <input type="text"  name="pprice" id="pprice" class="form-control" aria-describedby="basic-addon3">
				</div>
				<label for="basic-url" class="form-label">제품 할인율 입력</label>
				<div class="input-group mb-3 col-md-8 offset-2">
				  <input type="text" name="pdiscount" id="pdiscount" class="form-control" aria-label="Amount (to the nearest dollar)">
				  <span class="input-group-text">소숫점 입력</span>
				 </div>
				 카테고리 <button type="button" onclick="categorybtn()">카테고리추가</button><br>
				<div id="categoryinput" class="col-md-8 offset-2"> <!-- DB에 저장된 카테고리 만큼 표시 -->
					
				</div>
				<div id="categorybox" class="col-md-8 offset-2"> <!-- DB 내 카테고리 개수만큼 라디오버튼 표시 -->
					
				</div>
				<br>이미지 : <input type="file" name="pimg" id="pimg">
			<button type="button" value="전송" class="btn btn-outline-info" onclick="productadd()">제품 등록</button>
		</form>
	</div>	
		<div class="col-md-4">
			<h5>대표이미지 미리보기</h5>
			<img id="preview">
		</div>
	
	<script src="/jspweb/js/productadd.js" type="text/javascript"></script>
	
</body>
</html>