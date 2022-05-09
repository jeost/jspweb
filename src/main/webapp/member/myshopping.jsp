<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-3"> <!-- 사이드바 -->
				<%@include file="infosidebar.jsp" %>
			</div>
			<div class="col-md-9"> <!-- 본문 -->
				본문
			</div>
		</div>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>