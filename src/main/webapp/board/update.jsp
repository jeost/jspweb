<%@page import="dao.boardDao"%>
<%@page import="dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- 게시판api( 썸머노트) css cdn -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
 	<!-- 썸머노트 기본 부트스트랩버전 3버전 css cdn -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<!-- 썸머노트 css cdn -->
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
</head>
<body>
<%@include file="../header.jsp" %>
	<%int bno=Integer.parseInt(request.getParameter("bno"));
	Board board=boardDao.getboarddao().getboard(bno);
	%>
	<div class="container">
			<a href="boardlist.jsp"><button>글목록</button></a>
		<h3> 글 수정하기 </h3>
		<form action="../board/update" method="post" enctype="multipart/form-data" >
			글 번호: <input type="text" name="bno" value="<%=bno%>">
			제목 : <input type="text" name="btitle" value="<%=board.getBtitle()%>"> <br>
			<textarea name="bcontent" id="summernote"><%=board.getBcontent()%></textarea>
			<%if(board.getBfile()!=null){ %>
			첨부파일 : <input type="file" name="bfile"><%=board.getBfile() %><button type="button" onclick="filedelete(<%=bno%>)">파일삭제</button> <br>
			<%}else{ %>
			첨부파일 : <input type="file" name="bfile">
			<%} %>
			<input type="submit" value="수정"><input type="reset" value="취소">
		</form>
	</div>
	<!-- 썸머노트 기본 부트스트랩버전 3버전 js cdn -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- 썸머노트 js cdn  -->
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
	<!-- 사용자 정의 js -->
	<script src="/jspweb/js/board.js" type="text/javascript"></script>
<%@include file="../footer.jsp" %>
</body>
</html>