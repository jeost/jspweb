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
	<div class="container mt-5">
		<div class="row d-flex justify-content-center">
			<div class="col-md-6">
				<div class="card px-5 py-5" id="form1">
					<div class="form-data">
						<div class="forms-inputs mb-4">
						<form action="../login" method="post">
			로그인:<input type="text" name="mid"><br>
			비밀번호:<input type="password" name="mpassword">
			<input type="submit" value="로그인">
			<!-- 로그인 실패시 -->
			<%String result = request.getParameter("result"); 
				if(result!=null && request.equals("2")){
					%><span>동일한 회원정보가 없습니다.</span> <%
				}
			%>
		</form>
						</div>
					</div>
				</div>
			</div>
		
		</div>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>