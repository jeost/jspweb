function categorybtn(){
	$("#categoryinput").html(
		'<input type="text" id="cname">'+
		'<button onclick="categoryadd()" type="button">등록</button>'
	)
}
function categoryadd(){
	let cname=$("#cname").val();
	$.ajax({
		url: "categoryadd",
		data:{"cname" : cname},
		success:function(result){
			if(result==1){
				alert('카테고리 추가 성공');
				$("#categoryinput").html("");
				getcategory();
			}else{alert('카테고리 추가 실패');}
		}
	})
}

function getcategory(){
	$.ajax({ 
		url : "getcategory" , 
		success : function( re ){
			$("#categorybox").html(re);
		}
	});
}
function productadd(){
	var form=$("#addform")[0];
	var formData=new FormData(form);
	$.ajax({
		url: "productadd",
		type : 'POST',
		data : formData,
		contentType : false,
		processData : false,
		success : function(re){
			if(re==1){form.reset();}
			else{alert('등록실패')}
		}
	})
}
$(function category(){
	getcategory();
})
$("#pimg").change(function(e) {
	let reader=new FileReader();
	reader.readAsDataURL(e.target.files[0]) /* 파일 경로 읽기 */
	reader.onload=function(e){
		$("#preview").attr("src" , e.target.result);
	}
});