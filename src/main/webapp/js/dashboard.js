// 사이드바에서 버튼 클릭시 특정 태그에 페이지 포함시키는 함수
function pagechange(page){
	$("#mainbox").load( page+".jsp");
}

//사이드바 위치 변경을 이용해서 열고 닫는 함수
$(function(){
	let side=$("#sidebar");
	side.find('span').on('click',function(){// find 내의 span태그 찾아서 클릭이벤트
		side.toggleClass('open');
		
		if(side.hasClass('open')){
			side.stop(true).animate({left:"0px"},200);
		}else{
			side.stop(true).animate( {left:"-200px"} , 200 );
		}
	}); 
});