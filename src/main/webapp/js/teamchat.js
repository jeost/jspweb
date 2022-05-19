function submit(){
	let cName=$("#cName").val();
	let cContent=$("#cContent").val();
	$.ajax({
		type:"POST",
		url: "chat",
		data:{"cName":cName, "cContent":cContent},
		success:function(result){
			if(result==1){
				console.log('전송 성공');
			}else{
				console.log('전송 실패');
			}
		}
	});
	$("#cContent").val("");
}
/* 특정 시간만큼 반복되는 함수 */
$(function() {
	timer = setInterval( function () {
	    $.ajax ({
	        url : "receive",
	        cache : false,
	        success : function ( result ) {
		        var co =  result.split(",");
		        var contents = "";
		        for( var i = 0 ; i<co.length-1 ; i++ ){
					
					let ip = $("#ip").html();
					
					if(  co[i].split("^")[0] != "x"){
						contents += 
						'<img class="img" alt="" src="/jspweb/board/upload/'+co[i].split("^")[0]+'">'
					}
					
					if( co[i].split("^")[3]!="x" && co[i].split("^")[2] == ip ){
						contents += 
					 '<div class="box"  style="text-align: right;">'+
						'<div class="cName">'+co[i].split("^")[3]+'</div>'+
						'<span class="date">'+co[i].split("^")[1].split(" ")[1]+'</span>'+
						'<span class="cContent">'+co[i].split("^")[4]+'</span>'+
					'</div>'
					}else if( co[i].split("^")[3]!="x" ) {
						contents += 
					 '<div class="box">'+
						'<div class="cName">'+co[i].split("^")[3]+'</div>'+
						'<span class="cContent">'+co[i].split("^")[4]+'</span>'+
						'<span class="date">'+co[i].split("^")[1].split(" ")[1]+'</span>'+
					'</div>'
					}
						
				}
				
				$("#contentlist").html( contents );
	        }
	    });
	    }, 1500);
});