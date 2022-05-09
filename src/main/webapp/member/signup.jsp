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
<div class="container">
	<div class="col align-self-center">
		<div class="col-md-3 register-left">
		<h3>회원가입페이지</h3>
		</div>
	<div class="col-md-9 register-right">
	<form id="signupform" action="signup" method="post">
		<span class="sform">아이디 : <input type="text" id="mid" name="mid" placeholder="user id"></span><br>
		<span id="idcheck"></span><br>
		<span class="sform">비밀번호 : <input type="password" id="mpassword" name="mpassword" placeholder="user pw"><br></span><br>
		<span class="sform">비밀번호 확인 : <input type="password" id="mpasswordcheck" placeholder="user password check"></span>
		<span id="passwordcheck"></span><br><br>
		<span class="sform">이름 : <input type="text" id="mname" placeholder="user name" name="mname"></span>
		<span id="namecheck"></span><br><br>
		<span class="sform">전화번호 : <input type="text" id="mphone" placeholder="user phone" name="mphone"></span>
		<span id="phonecheck"></span><br><br>
		<span class="sform">이메일 : <input type="text" id="memail" placeholder="user email" name="memail">@<input type="text" id="emailadd" name="memailaddress"></span>
		<span class="sform"><select id="emailselect">
			<option value="">직접입력</option>
			<option value="naver.com">naver.com</option>
			<option value="gmail.com">gmail.com</option>
			<option value="hanmail.net">hanmail.net</option>
			<option value="daum.com">daum.com</option>
		</select></span><br>
		<span id="emailcheck"></span><br>
		<input type="text" id="sample4_postcode" name="address1" placeholder="우편번호">
			<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br><br>
			<span class="sform"><input type="text" id="sample4_roadAddress" name="address2" placeholder="도로명주소"></span>
			<input type="text" id="sample4_jibunAddress" name="address3" placeholder="지번주소">
			<span id="guide" style="color:#999;display:none"></span>
			<input type="text" id="sample4_detailAddress" name="address4" placeholder="상세주소">
		<span id="addcheck"></span>
		<button onclick="signup()" type="button">가입하기</button>
	</form>
	</div>
	</div>
</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="../js/signup.js"></script>
	<%@include file="../footer.jsp" %>
</body>
</html>