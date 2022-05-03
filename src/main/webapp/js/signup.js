// jquery : js framework
//$(function(){}) : 문서 실행시 무조건 실행
$(function(){
	$("#mid").keyup(function(){
		let mid = document.getElementById("mid").value;
		let idcheck=document.getElementById("idcheck");
		//정규표현식
			// /^ : 정규표현식 시작
			// $/ : 정규표현식 끝
		let idj=/^[a-zA-Z0-9]{5,15}$/; // [a-z]는 소문자, [A-Z]는 대문자, [0-9]는 숫자, {최소길이, 최대길이}는 문자길이를 최소~최대 사이로 제한
			//정규표현식.test(변수) : 해당 변수가 정규표현식에 동일하면 true, 다르면 false
		if(idj.test(mid) ){
			
			//아이디 중복체크
				//비동기식 통신 [ 목적 : 페이지 전환 없이 java(controller) 통신]
			$.ajax({
				url:"../Idcheck",//통신할 경로 ( 서블릿파일과 통신 )
				data:{"mid":mid}, //통신시 보내는 데이터
				success : function(result){ // 통신 성공시 받는 데이터
					if(result==1){
						idcheck.innerHTML="사용중인 아이디 입니다";
					}else{
						idcheck.innerHTML="사용 가능한 아이디 입니다";
					}
				}
			}); // ajax end
		}else{ // 정규표현식과 다르면
			idcheck.innerHTML="영문, 숫자 포함 5~15글자 사이";
		}
	});
	//비밀번호 체크
		$("#mpassword").keyup(function(){
			let mpassword=$("#mpassword").val();
			let mpasswordcheck=$("mpasswordcheck").val();
			let passwordj=/^[a-zA-z0-9]{5,15}$/;
		
		if(passwordj.test(mpassword)){ // 정규 표현식이 같으면
			if(mpassword!=mpasswordcheck){
			//비밀번호와 비밀번호 체크가 다르면
				$("#passwordcheck").html("패스워드가 서로 다릅니다");
			}else{$("#passwordcheck").html("사용 가능한 비밀번호입니다.");}
		}else{ // 정규 표현식과 다르면
			$("#passwordcheck").html("영어 대소문자 5~15자리 사이로 입력해주세요");
		}
		
	});
	$("#mpasswordcheck").keyup(function(){
			let mpassword=$("#mpassword").val();
			let mpasswordcheck=$("mpasswordcheck").val();
			let passwordj=/^[a-zA-z0-9]{5,15}$/;
		
		if(passwordj.test(mpasswordcheck)){ // 정규 표현식이 같으면
			if(mpassword!=mpasswordcheck){
			//비밀번호와 비밀번호 체크가 다르면
				$("#passwordcheck").html("패스워드가 서로 다릅니다");
			}else{$("#passwordcheck").html("사용 가능한 비밀번호입니다.");}
		}else{ // 정규 표현식과 다르면
			$("#passwordcheck").html("영어 대소문자 5~15자리 사이로 입력해주세요");
		}
		//이름 체크
	});
	$("#mname").keyup(function(){
		let mname=$("#mname").val();
		let namej=/^[가-힣]{2,10}$/; // 한글만 2~10 정규표현식
		if(namej.test(mname)){
			$("#namecheck").html("")
		}else{
			$("#namecheck").html("한글 2~10 사이만 가능합니다.")
		}
	});
	//전화번호 체크
	$("#mphone").keyup(function(){
		let mphone=$("#mphone");
		let phonej=/^010-([0-9]{4})-([0-9]{4})$/;
		if(phonej.test(mphone)){
			$("#phonecheck").html("");
		}else{
			$("#phonecheck").html("010-####-#### 형식으로 입력해주세요");
		}
	});
});
 // 다음 우편번호 api
function Postcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("roadAddress").value = roadAddr;
                document.getElementById("jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
function signup(){

}