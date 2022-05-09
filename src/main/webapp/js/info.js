function passwordcheck(mid){
	let mpassword=$("#mpassword").val();
	alert( 	mpassword );
	$.ajax({
		url: "../passwordcheck",// 어디로
		data: {"mid":mid,"mpassword":mpassword},// 보낼 데이터
		type: "POST", // http요청방식 정의(기본값 : get)
		success:function(result){ // 받을 데이터
		if(result==1){
		alert("비밀번호 일치함");
		$("#checkmsg").html("정말 탈퇴하시겠습니까?");
		$("#mpassword").css("display","none");	//css 사용가능
		$("#btndelete").css("display","block");
		$("#btnconfirm").css("display","none");
		}else if(result==2){
			$("checkmsg").html("패스워드가 다릅니다.");
			$("#mpassword").val("");
			}
		}
	});
}
function mdelete( mid ){
	alert("탈퇴를 시작합니다");
	$.ajax({
		url:"../delete",
		data:{"mid":mid},
		success:function(result){
			if(result==1){
				alert("회원탈퇴 완료");
				location.href="/jspweb/logout"; //js에서 서블릿으로 하이퍼링크[페이지연결]
			}else{
				location.href="/jspweb/error.jsp";
			}
		}
	});
}