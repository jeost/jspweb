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
	<%
		String mid=(String)session.getAttribute("login");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-3"> <!-- 사이드바 -->
				<%@include file="infosidebar.jsp" %>
			</div>
			<div class="col-md-9"> <!-- 본문 -->
				<h3>회원탈퇴 확인</h3>
					<input type="password" name="mpassword" id="mpassword">
					<button id="btnconfirm" onclick="passwordcheck('<%=mid%>')">확인</button>
					<span id="checkmsg"></span>
					<button id="btndelete" style="display:none;" onclick="mdelete('<%=mid%>')">진짜로 탈퇴</button>
			
			</div>
		</div>
	</div>
	<%@include file="../footer.jsp" %>
	<script type="text/javascript" src="../js/info.js"></script>
</body>
</html>