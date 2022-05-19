$( function getcategory(){ 
	$.ajax({
		url : "getcategory" , 
		data : { "type" : "option" } ,
		success : function( re ){
			$("#categorybox").html( re );
		}
	});
});
/* 카테고리목록 select 값이 변경 될때마다 .*/
$("#categorybox").change( function(){
	let cno = $("#categorybox").val();
	$.ajax({
		url : "getproduct" ,
		data : { "type" : "option" , "cno" : cno } ,
		success : function( re ){
			if( re == ""){
				alert("해당 카테고리의 제품이 없습니다.");
				$("#productbox").html(" ");
				$("#stockaddform").css('display','none');
			}else{ 
				$("#productbox").html( re );
				$("#stockaddform").css('display','block');
				getstock();
			}
		}
	})
});
// 제품 재고 추가
function stockadd(){
	let pno=$("#productbox").val();
	let scolor=$("#scolor").val();
	let ssize=$("#ssize").val();
	let samount=$("#samount").val();
	
	$.ajax({
		url:"stockadd",
		data:{"pno" : pno,"scolor":scolor,"ssize":ssize,"samount":samount},
		success:function(re){
			if(re==1){
				$("#mainbox").load('productstock.jsp');
			}else{
				alert("실패")
			}
		}
	});
}
$("#productbox").change(function(){
	getstock();
})
function getstock(){
	let pno=$("#productbox").val();
	$.ajax({
		url:'getstock',
		data:{"pno":pno},
		success:function(re){
			$("#stocklistbox").html(re);
		}
	})
}
