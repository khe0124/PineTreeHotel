
//----------------inquiry-----------------------------------------------------------------
//비밀번호 4자리
function pwCheck(f) {
	var iq_passwd=f.iq_passwd.value;
	iq_passwd=iq_passwd.trim();
	//alert(iq_passwd);
	if(iq_passwd.length<4){
		alert("비밀번호 4글자 이상 입력해주세요");
		f.iq_passwd.focus();
		return false;
	}
	
	var message="진행된 내용은 복구되지 않습니다.\n계속 진행하시겠습니까?";
	if(confirm(message)){
		//확인 true, 취소 false 반환
		return true;
	}else{
		return false;
	}//if	
}//pwCheck

function iqCheck(f) {
	//문의 유형 선택
	var iq_type=document.getElementById("iq_type");
	iq_type=iq_type.options[iq_type.selectedIndex].value;
	//alert(fq_type);
	if(iq_type=="0"){
		alert("문의 유형을 선택해주세요");
		return false;
	}
	
	//비밀번호 4자리
	var iq_passwd=f.iq_passwd.value;
	iq_passwd=iq_passwd.trim();
	//alert(iq_passwd);
	if(iq_passwd.length<4){
		alert("비밀번호 4글자 이상 입력해주세요");
		f.iq_passwd.focus();
		return false;
	}	
}//iqCheck


//----------------FAQ-----------------------------------------------------------------
//글쓰기 타입정하기
function typeCheck(f) {
	
	//문의 유형 선택
	var fq_type=document.getElementById("fq_type");
	fq_type=fq_type.options[fq_type.selectedIndex].value;
	//alert(fq_type);
	if(fq_type=="0"){
		alert("문의 유형을 선택해주세요");
		return false;
	}
	
}//typeCheck

