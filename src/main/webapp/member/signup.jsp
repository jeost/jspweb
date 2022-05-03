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
	회원가입페이지
	<form>
		아이디 : <input type="text" id="mid" placeholder="user id">
		<span id="idcheck"></span><br>
		비밀번호 : <input type="password" id="mpassword" placeholder="user pw">
		비밀번호 확인 : <input type="password" id="mpasswordcheck" placeholder="user password check">
		<span id="passwordcheck"></span><br>
		이름 : <input type="text" id="mname" placeholder="user name">
		<span id="namecheck"></span><br>
		전화번호 : <input type="text" id="mphone" placeholder="user phone">
		<span id="phonecheck"></span><br>
		이메일 : <input type="text" id="memail" placeholder="user email"><br>
		주소 입력 :
		<input type="text" id="postcode" placeholder="우편번호">
		<input type="button" onclick="Postcode()" value="우편번호 찾기"><br>
		<input type="text" id="roadAddress" placeholder="도로명주소">
		<input type="text" id="jibunAddress" placeholder="지번주소">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="detailAddress" placeholder="상세주소">
		<input type="text" id="extraAddress" placeholder="참고항목">
		<button onclick="signup()" type="button">가입하기</button>
	</form>
	</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="../js/signup.js"></script>
	<%@include file="../footer.jsp" %>
</body>
</html>