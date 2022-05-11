 // 문서 열렸을때 실행 함수 무조건 실행
 $(document).ready( function(){
	 $('#summernote').summernote({
    	placeholder: '내용 입력',
    	tabsize: 2,
   	 	minHeight : 250 , // 최소 높이
   	 	maxHeight : null , // 최대 높이 
   	 	lang : 'ko-KR'	// 메뉴 한글 버전 
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
function replywrite(bno){
	let rcontent=$("#rcontent").val();
	
	$.ajax({
		url:"replywrite",
		data:{"bno":bno, "rcontent":rcontent},
		success:function(result){
			if(result==1){alert("댓글이 작성되었습니다");
				$("#rcontent").val("");
				$("#replytable").load(location.href+" #replytable");
				//해당 태그에 자기 자신(현재 태그)을 불러오기
			}
			else{alert("댓글 작성을 실패하였습니다");}
		}
	});
}

function rereplyview( rno , bno , mid ){ // 대댓글 입력창 표시 메소드 
	// ' '  or " "	: 문자처리 	// '문자열' + 변수 + '문자열'
	if( mid == null ){ // 로그인 안되어 있으면
		alert("로그인후 작성이 가능합니다."); return;
	} 
	// JS 작성 공간 에서는 HTML 작성 불가능 --> HTML 문자처리 
	
	$("#"+rno).html(
		'<div class="row">'+
			'<div class="col-md-10">'+
				'<textarea id="rrcontent" class="form-control" rows=3></textarea>'+
			'</div>'+
			'<div class="col-md-2">'+
				'<button class="form-control py-4 my-1" onclick="rereplywrite('+rno+','+bno+')">대댓글 등록</button>'+
			'</div>'+
		'</div>'
	);	
}
function rereplywrite( rno , bno ){ // 대댓글 쓰기 메소드 
	let rrcontent = $("#rrcontent").val();
	$.ajax({
		url : "rereplywrite" , 
		data : { "rno" : rno , "bno" : bno  , "rrcontent" : rrcontent} ,
		success : function( result ){
			if( result == 1 ){
				 alert("대댓글 작성 되었습니다."); // 성공 메시지 알림 
				 $("#rrcontent").val(""); // 작성 input 공백으로 초기화 
				 $("#replytable").load( location.href+" #replytable"); // 특정 태그 새로고침
			}
			else{ alert("대댓글작성이 실패했습니다."); }
		}
	});
}


function replydelete(rno){
	$.ajax({
		url:"replydelete",
		data:{"rno":rno},
		success:function(result){
			if(result==1){
				$("#replytable").load(location.href+ "#replytable");
			}else{
				alert("삭제 실패")
			}
		}
	})
}
function replyupdate(rno){
	$("#"+rno).html(
		'<div class="row">'+
			'<div class="col-md-10">'+
				'<textarea id="reupdate" class="form-control" rows=3></textarea>'+
			'</div>'+
			'<div class="col-md-2">'+
				'<button class="form-control py-4 my-1" onclick="rupdate('+rno+')">댓글 수정</button>'+
			'</div>'+
		'</div>'
	);
}
function rreplyupdate(rno){
	$("#"+rno).html(
		'<div class="row">'+
			'<div class="col-md-10">'+
				'<textarea id="rreupdate" class="form-control" rows=3></textarea>'+
			'</div>'+
			'<div class="col-md-2">'+
				'<button class="form-control py-4 my-1" onclick="rrupdate('+rno+')">댓글 수정</button>'+
			'</div>'+
		'</div>'
	);
}
function rupdate(rno){
	let reupdate = $("#reupdate").val();
	$.ajax({
		url : "replyupdate" , 
		data : { "rno" : rno , "reupdate" : reupdate} ,
		success : function( result ){
			if( result == 1 ){
				 alert("댓글 수정 되었습니다."); // 성공 메시지 알림 
				 $("#reupdate").val(""); // 작성 input 공백으로 초기화 
				 $("#replytable").load( location.href+" #replytable"); // 특정 태그 새로고침
			}
			else{ alert("댓글 수정이 실패했습니다."); }
		}
	});
}
function rrupdate(rno){
	let rreupdate = $("#rreupdate").val();
	$.ajax({
		url : "replyupdate" , 
		data : { "rno" : rno , "reupdate" : rreupdate} ,
		success : function( result ){
			if( result == 1 ){
				 alert("댓글 수정 되었습니다."); // 성공 메시지 알림 
				 $("#rreupdate").val(""); // 작성 input 공백으로 초기화 
				 $("#replytable").load( location.href+" #replytable"); // 특정 태그 새로고침
			}
			else{ alert("댓글 수정이 실패했습니다."); }
		}
	});
}