function pmove(pno){
	alert(pno);
	$("#modalinput").val(pno);	
}
function activechange(active){
	let pno=$("#modalinput").val();
	alert(pno);
	$.ajax({
		url:"activechange",
		data:{"active":active,"pno":pno},
		success:function(re){
			if(re==1){
				alert('상태변경 성공');
				//$("#producttable").load(location.href+' #producttable');
				$("#modalclosebtn").click();
				$("#mainbox").load('#productlist.jsp');
			}else{
				alert('상태변경 실패');
			}
		}
	});
}

function getamount(pno){
	let scolor=$("#colorbox"+pno).val();
	let size=$("#sizebox"+pno).val();
	$.ajax({
		url:'getstock',
		data:{'field':'amount','pno':pno,'scolor':scolor,'ssize':size},
		success:function(re){
			if(re==""){
				$("#amountbox"+pno).html('해당 사이즈색상<br>재고없음');
				$("#datebox"+pno).html("");
			}
			else{
				$("#amountbox"+pno).html(re.split(',')[0]);
				$("#datebox"+pno).html(re.split(',')[1]);
			}
		}
	})
}
function getstock(pno){
	$.ajax({
		url:'getstock',
		data:{"pno":pno},
		success:function(re){
			$('#stocklistbox').html(re);
		}
	});
}
function showupdate(sno){
	$("#updatebox").css("display","block"); // 수정할 재고수량 입력창 열기
	$("#sno").val(sno); // 수정할 재고번호
}
function stockupdate(sno){
	let sno=$("#sno").val();
	let samount=$("#samount").val();
	
	$.ajax({
		url:'stockupdate',
		data:{'sno':sno, 'samount':samount},
		success:function(re){
			$("#modalclosebtn2").click(); // 모달 닫기버튼 클릭이벤트 강제발생
			$("#mainbox").load('productlist.jsp');
		}
	});
}