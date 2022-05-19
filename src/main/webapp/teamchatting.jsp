<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.chatDao"%>
<%@page import="dto.Chat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container">
		<div class="portlet-footer">
			<!-- overflow-y:scroll    div에 스크롤 만들기  -->
			<div id="contentlist" style="border: 2px dotted red; height: 500px; overflow-y:scroll">
				
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<input style="height: 40px;" type="text" id="cName" class="form-control" placeholder="이름" maxlength="20">
				</div>
			</div>
			<div class="row" style="height:90px">
				<div class="form-group col-md-7">
					<textarea style="height:80px;" id="cContent" class="form-control" placeholder="메시지를 입력하세요" maxlength="100"></textarea>
				</div> 
			</div>
			<div class="form-group col-md-2">
				<button type="button" class="btn btn-info pull-right" onclick="submit()">전송</button>
				<div class="cleayfix"></div>
			</div>
		</div>
	</div>
	<script src="/jspweb/js/teamchat.js" type="text/javascript"></script>
	<%@include file="footer.jsp" %>
</body>
</html>