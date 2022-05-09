$(document).ready(function(){
	 $('#summernote').summernote({
        placeholder: '내용 입력',
        tabsize: 2,
        minHeght:400,
        maxHeight:null,
        lang:"ko-KR"
      });
});
function filedelete(bno){
	
	$.ajax({
		url:"filedelete", /*서블릿 통신*/
		data:{"bno":bno},
		success:function(result){
			if(result=="1"){alert("첨부파일 삭제 성공");
			location.reload; // 현재 페이지를 새로고침
			}
			else{alert("첨부파일 삭제 실패");}
		}
	});
}