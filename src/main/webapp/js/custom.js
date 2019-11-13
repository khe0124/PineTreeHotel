//----------------review-----------------------------------------------------------------
function re_pwCheck(f) {
	var re_passwd=f.re_passwd.value;
	re_passwd=re_passwd.trim();
	//alert(re_passwd);
	if(re_passwd.length<4){
		alert("비밀번호 4글자 이상 입력해주세요");
		f.re_passwd.focus();
		return false;
	}
	return true;
}//re_pwCheck



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


//----------------FAQ-------------------------------------------------------------------------------------
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


//-----------------------------email------------------------------------------------------------------------

function em_check(f) {
	//이메일 공백 및 @ 확인
	var em_email=f.em_email.value;
	em_email=em_email.trim();
	//alert(em_email);
	if(em_email.length==0){
		alert("이메일을 입력해 주세요.");
		return false;
	}else if(em_email.includes("@")==false){
		alert("이메일에 @ 포함해 주세요.");
		f.em_email.focus();
		return false;
	}
	
	
	//폰번호 합치기
	var em_phone_first=f.em_phone_first.value;
	var em_phone_middle=f.em_phone_middle.value;
	var em_phone_last=f.em_phone_last.value;
	em_phone_first=em_phone_first.trim();
	em_phone_middle=em_phone_middle.trim();
	em_phone_last=em_phone_last.trim();
	em_phone=em_phone_first+em_phone_middle+em_phone_last;
	//폰번호 숫자인지 확인
	//true면 문자, false면 숫자
	if(isNaN(em_phone)){
		alert("숫자를 입력해주세요");
		return false;
	}
	document.getElementById("em_phone").value=em_phone;
	//alert(f.em_phoen.value);
	
	//첨부파일은 이미지는 안됨
	var file=f.file.value;
	file=file.trim();
	var dot=file.lastIndexOf(".");//마지막 .의 위치
	var ext=file.substr(dot+1);//확장명
	ext=ext.toLowerCase(); //전부 소문자로 치환
	//alert("확장명"+ext);
	if(ext=="txt"|| ext=="xlsx"|| ext=="ppsx"){
		return true;
	}else{
		alert("확장명 txt,xlsx,ppsx 파일만 올려주세요");
		return false;
	}
	
	
	

	return true;
	
}//em_check




//-----------------------------member------------------------------------------------------------------------

//아이디 찾기 유효성 검사
function findIdCheck(f) {
	var ac_name_kor=f.ac_name_kor.value;
	ac_name_kor=ac_name_kor.trim();
	//alert(ac_name_kor);
	var engCheck=/[A-Za-z0-9]/;
	if(engCheck.test(ac_name_kor)){
		alert("이름을 한글로 작성해주세요.");
		f.ac_name_kor.focus();
		return false;
	}
	
	//휴대전화 - 제거
	var ac_phone=f.ac_phone.value;
	ac_phone=ac_phone.trim();
	//alert(ac_phone);
	//폰번호 합치기
	var ac_phone_first=f.ac_phone_first.value;
	var ac_phone_middle=f.ac_phone_middle.value;
	var ac_phone_last=f.ac_phone_last.value;
	ac_phone_first=ac_phone_first.trim();
	ac_phone_middle=ac_phone_middle.trim();
	ac_phone_last=ac_phone_last.trim();
	ac_phone=ac_phone_first+ac_phone_middle+ac_phone_last;
	//폰번호 숫자인지 확인
	//true면 문자, false면 숫자
	if(isNaN(ac_phone)){
		alert("숫자를 입력해주세요");
		return false;
	}
	document.getElementById("ac_phone").value=ac_phone;
	//alert(f.ac_phoen.value);
	
	
	
	return true;
}//findIdCheck


//비밀번호 찾기 유효성
function findPasswdCheck(f) {
	///[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	//아이디 영어만
	var ac_id=f.ac_id.value;
	ac_id=ac_id.trim();
	var korCheck=/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	if(korCheck.test(ac_id)){
		alert("아이디를 영어로 입력하세요.");
		f.ac_id.focus();
		return false;
	}
	
	//휴대전화 - 제거
	var ac_phone=f.ac_phone.value;
	ac_phone=ac_phone.trim();
	//alert(ac_phone);
	//폰번호 합치기
	var ac_phone_first=f.ac_phone_first.value;
	var ac_phone_middle=f.ac_phone_middle.value;
	var ac_phone_last=f.ac_phone_last.value;
	ac_phone_first=ac_phone_first.trim();
	ac_phone_middle=ac_phone_middle.trim();
	ac_phone_last=ac_phone_last.trim();
	ac_phone=ac_phone_first+ac_phone_middle+ac_phone_last;
	//폰번호 숫자인지 확인
	//true면 문자, false면 숫자
	if(isNaN(ac_phone)){
		alert("숫자를 입력해주세요");
		return false;
	}
	document.getElementById("ac_phone").value=ac_phone;
	
	//이메일 공백 및 @ 확인
	var ac_email=f.ac_email.value;
	ac_email=ac_email.trim();
	//alert(em_email);
	if(ac_email.length==0){
		alert("이메일을 입력해 주세요.");
		return false;
	}else if(ac_email.includes("@")==false){
		alert("이메일에 @ 포함해 주세요.");
		f.ac_email.focus();
		return false;
	}	
	
	return true;
}//findPasswdCheck


//-----------------------------order-payment------------------------------------------------------------------------

//체크박스 선택시 정보들어가게
$("#samecus").change(function(){
	var name_kor=$("#ac_name_kor").val();
	var name_eng=$("#ac_name_eng").val();
	var phone=$("#ac_phone").val();
	if($("#samecus").is(":checked")){
		$("#od_name_kor").val(name_kor);
		$("#od_name_eng").val(name_eng);
		$("#od_phone").val(phone);
	}else{
		$("#od_name_kor").val('');
		$("#od_name_eng").val('');
		$("#od_phone").val('');	
	}
	
})

//최종결제 유효성 검사
function payCheck(f) {
	//이름한글
	var od_name_kor=f.od_name_kor.value;
	od_name_kor=od_name_kor.trim();
	//alert(od_name_kor);
	var engCheck=/[A-Za-z0-9]/;
	if(engCheck.test(od_name_kor)){
		alert("이름을 한글로 작성해주세요.");
		f.od_name_kor.focus();
		return false;
	}else if(od_name_kor.length==0){
		alert("한글이름을 입력해주세요.");
		f.od_name_kor.focus();
		return false;
	}
	
	//이름영문
	var od_name_eng=f.od_name_eng.value;
	od_name_eng=od_name_eng.trim();
	var korCheck=/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	if(korCheck.test(od_name_eng)){
		alert("이름을 영어로 입력하세요.");
		f.od_name_eng.focus();
		return false;
	}else if(od_name_eng.length==0){
		alert("영문이름을 입력해주세요.");
		f.od_name_eng.focus();
		return false;
	}
	
	//폰번호 숫자인지 확인
	//true면 문자, false면 숫자
	var od_phone=f.od_phone.value;
	od_phone=od_phone.trim();	
	if(isNaN(od_phone)){
		alert("숫자만 입력해주세요");
		f.od_phone.focus();
		return false;
	}else if(od_phone.length==0){
		alert("연락처를 입력해주세요");
		f.od_phone.focus();
		return false;
	}
	
	//신용카드 번호 합치키
	var od_card_no=f.od_card_no.value;
	var od_card_no1=f.od_card_no1.value;
	var od_card_no2=f.od_card_no2.value;
	var od_card_no3=f.od_card_no3.value;
	var od_card_no4=f.od_card_no4.value;
	od_card_no=od_card_no.trim();
	od_card_no1=od_card_no1.trim();
	od_card_no2=od_card_no2.trim();
	od_card_no3=od_card_no3.trim();
	od_card_no4=od_card_no4.trim();
	od_card_no=od_card_no1+od_card_no2+od_card_no3+od_card_no4;
	//alert(od_card_no);
	//카드번호 숫자인지 확인
	if(isNaN(od_card_no)){
		alert("숫자만 입력해주세요");
		return false;
	}
	document.getElementById("od_card_no").value=od_card_no;
	if(od_card_no1.length==0 ||od_card_no2.length==0 ||od_card_no3.length==0 ||od_card_no4.length==0){
		alert("신용카드 번호를 입력해주세요.");
		f.od_card_no1.focus();
		return false;
	}
	
	//유효기간 번호 합치기
	var od_card_date=f.od_card_date.value;
	var od_card_date1=f.od_card_date1.value;
	var od_card_date2=f.od_card_date2.value;
	
	od_card_date=od_card_date.trim();
	od_card_date1=od_card_date1.trim();
	od_card_date2=od_card_date2.trim();
	od_card_date=od_card_date1+od_card_date2;
	//alert(od_card_no);
	document.getElementById("od_card_date").value=od_card_date;
	
	//카드번호 숫자인지 확인
	if(isNaN(od_card_date)){
		alert("숫자만 입력해주세요");
		return false;
	}else if(od_card_date.length==0){
		alert("신용카드 유효기간을 확인해주세요");
		f.od_card_date1.focus();
		return false;
	}
	
	var od_point=f.od_point.value;
	od_point=od_point.trim();
	if(od_point.length==0){
		document.getElementById("od_point").value=0;
		return true;
	}else if(od_point<1000){
		alert("포인트는 1000포인트 이상부터 사용가능합니다.");
		f.od_point.focus();
		return false;
	}
	return true;
}//payCheck

//----------------review-----------------------------------------------------------------
function re_pwCheck(f) {
	var re_passwd=f.re_passwd.value;
	re_passwd=re_passwd.trim();
	//alert(re_passwd);
	if(re_passwd.length<4){
		alert("비밀번호 4~10글자 사이로 입력해주세요");
		f.re_passwd.focus();
		return false;
	}
	
	var message="진행된 내용은 복구되지 않습니다.\n계속 진행하시겠습니까?";
	if(confirm(message)){
		//확인 true, 취소 false 반환
		return true;
	}else{
		return false;
	}//if
}//re_pwCheck

//review form check
function reviewCheck(f) {
	
	var re_title=f.re_title.value;
	re_title=re_title.trim();
	if(re_title.length==0){
		alert("제목을 입력해주세요.");
		f.re_title.focus();
		return false;
	}
	
	var re_cont=f.re_cont.value;
	re_cont=re_cont.trim();
	if(re_cont.length==0){
		alert("내용을 입력해주세요.");
		f.re_cont.focus();
		return false;
	}
	
	var re_passwd=f.re_passwd.value;
	re_passwd=re_passwd.trim();
	//alert(re_passwd.length);
	if(re_passwd.length<4){
		alert("비밀번호를 4~10자 사이로 설정해주세요.");
		f.re_passwd.focus();
		return false;
	}
	
	var file=f.file.value;
	file=file.trim();
	var dot=file.lastIndexOf(".");//마지막 .의 위치
	var ext=file.substr(dot+1);//확장명
	ext=ext.toLowerCase(); //전부 소문자로 치환
	//alert("확장명"+ext);
	if(ext=="jpg"|| ext=="png" || ext=="gif"){
		return true;
	}else{
		alert("이미지 파일 올려주세요");
		return false;
	}
	
	return true;
}//reviewCheck

//review update check
function reviewCheck2(f) {
	
	var re_title=f.re_title.value;
	re_title=re_title.trim();
	if(re_title.length==0){
		alert("제목을 입력해주세요.");
		f.re_title.focus();
		return false;
	}
	
	var re_cont=f.re_cont.value;
	re_cont=re_cont.trim();
	if(re_cont.length==0){
		alert("내용을 입력해주세요.");
		f.re_cont.focus();
		return false;
	}
	
	var re_passwd=f.re_passwd.value;
	re_passwd=re_passwd.trim();
	//alert(re_passwd.length);
	if(re_passwd.length<4){
		alert("비밀번호를 4~10자 사이로 설정해주세요.");
		f.re_passwd.focus();
		return false;
	}
	
	var file=f.file.value;
	file=file.trim();
	var dot=file.lastIndexOf(".");//마지막 .의 위치
	var ext=file.substr(dot+1);//확장명
	ext=ext.toLowerCase(); //전부 소문자로 치환
	//alert("확장명"+ext);
	if(ext=="jpg"|| ext=="png" || ext=="gif" || ext.length==0){
		return true;
	}else{
		alert("이미지 파일 올려주세요");
		return false;
	}
	
	return true;
}//reviewCheck2



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
	
	//이메일 공백 및 @ 확인
	var iq_email=f.iq_email.value;
	iq_email=iq_email.trim();
	//alert(em_email);
	if(iq_email.length==0){
		alert("이메일을 입력해 주세요.");
		f.iq_email.focus();
		return false;
	}else if(iq_email.includes("@")==false){
		alert("이메일에 @ 포함해 주세요.");
		f.iq_email.focus();
		return false;
	}
	
	//문의 유형 선택
	var iq_type=document.getElementById("iq_type");
	iq_type=iq_type.options[iq_type.selectedIndex].value;
	//alert(fq_type);
	if(iq_type=="0"){
		alert("문의 유형을 선택해주세요");
		return false;
	}
	

	var iq_title=f.iq_title.value;
	iq_title=iq_title.trim();
	if(iq_title.length==0){
		alert("제목을 입력해주세요");
		f.iq_title.focus();
		return false;
	}
	
	var iq_cont=f.iq_cont.value;
	iq_cont=iq_cont.trim();
	if(iq_cont.length==0){
		alert("내용을 입력해주세요");
		f.iq_cont.focus();
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

	
	//첨부파일은 이미지는 안됨
	var file=f.file.value;
	file=file.trim();
	var dot=file.lastIndexOf(".");//마지막 .의 위치
	var ext=file.substr(dot+1);//확장명
	ext=ext.toLowerCase(); //전부 소문자로 치환
	//alert("확장명"+ext);
	if(ext=="xlsx"|| ext=="ppsx" || ext.length==0 || ext=="hwp"|| ext=="docx"){
		return true;
	}else{
		alert("확장명 xlsx,ppsx 파일만 올려주세요");
		return false;
	}	
	
}//iqCheck


//----------------FAQ-------------------------------------------------------------------------------------
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


//-----------------------------email------------------------------------------------------------------------

function em_check(f) {
	
	var em_name=f.em_name.value;
	em_name=em_name.trim();
	if(em_name.length==0){
		alert("이름을 입력해주세요");
		f.em_name.focus();
		return false;
	}
	
	//이메일 공백 및 @ 확인
	var em_email=f.em_email.value;
	em_email=em_email.trim();
	//alert(em_email);
	if(em_email.length==0){
		alert("이메일을 입력해 주세요.");
		f.em_email.focus();
		return false;
	}else if(em_email.includes("@")==false){
		alert("이메일에 @ 포함해 주세요.");
		f.em_email.focus();
		return false;
	}
	
	
	var em_phone=f.em_phone.value;
	em_phone=em_phone.trim();
	//폰번호 숫자인지 확인
	//true면 문자, false면 숫자
	if(isNaN(em_phone)){
		alert("숫자를 입력해주세요");
		f.em_phone.focus();
		return false;
	}else if(em_phone.length==0){
		alert("번호를 입력해주세요");
		f.em_phone.focus();
		return false;
	}
	
	var em_title=f.em_title.value;
	em_title=em_title.trim();
	if(em_title.length==0){
		alert("제목을 입력해주세요");
		f.em_title.focus();
		return false;
	}
	
	var em_cont=f.em_cont.value;
	em_cont=em_cont.trim();
	if(em_cont.length==0){
		alert("내용을 입력해주세요");
		f.em_cont.focus();
		return false;
	}

	
	//첨부파일은 이미지는 안됨
	var file=f.file.value;
	file=file.trim();
	var dot=file.lastIndexOf(".");//마지막 .의 위치
	var ext=file.substr(dot+1);//확장명
	ext=ext.toLowerCase(); //전부 소문자로 치환
	//alert("확장명"+ext);
	if(ext=="xlsx"|| ext=="ppsx" || ext.length==0 || ext=="hwp"|| ext=="docx"){
		return true;
	}else{
		alert("확장명 xlsx,ppsx 파일만 올려주세요");
		return false;
	}
	

	return true;
	
}//em_check




//-----------------------------member------------------------------------------------------------------------

//아이디 찾기 유효성 검사
function findIdCheck(f) {
	var ac_name_kor=f.ac_name_kor.value;
	ac_name_kor=ac_name_kor.trim();
	//alert(ac_name_kor);
	var engCheck=/[A-Za-z0-9]/;
	if(engCheck.test(ac_name_kor)){
		alert("이름을 한글로 작성해주세요.");
		f.ac_name_kor.focus();
		return false;
	}
	
	//휴대전화
	var ac_phone=f.ac_phone.value;
	ac_phone=ac_phone.trim();
	//alert(ac_phone);
	//폰번호 숫자인지 확인
	//true면 문자, false면 숫자
	if(isNaN(ac_phone)){
		alert("숫자를 입력해주세요");
		return false;
	}
	
	
	
	return true;
}//findIdCheck


//비밀번호 찾기 유효성
function findPasswdCheck(f) {
	///[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	//아이디 영어만
	var ac_id=f.ac_id.value;
	ac_id=ac_id.trim();
	var korCheck=/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	if(korCheck.test(ac_id)){
		alert("아이디를 영어로 입력하세요.");
		f.ac_id.focus();
		return false;
	}
	
	//휴대전화
	var ac_phone=f.ac_phone.value;
	ac_phone=ac_phone.trim();
	//폰번호 숫자인지 확인
	//true면 문자, false면 숫자
	if(isNaN(ac_phone)){
		alert("숫자를 입력해주세요");
		return false;
	}
	
	//이메일 공백 및 @ 확인
	var ac_email=f.ac_email.value;
	ac_email=ac_email.trim();
	//alert(em_email);
	if(ac_email.length==0){
		alert("이메일을 입력해 주세요.");
		return false;
	}else if(ac_email.includes("@")==false){
		alert("이메일에 @ 포함해 주세요.");
		f.ac_email.focus();
		return false;
	}	
	
	return true;
}//findPasswdCheck


//memUpdateCheck
function memUpdateCheck(f) {
	var ac_passwd=f.ac_passwd.value;
	ac_passwd=ac_passwd.trim();
	//alert(ac_passwd);
	if(ac_passwd.length==0){
		alert("비밀번호를 입력해주세요.");
		f.ac_passwd.focus();
		return false;
	}
	return true;
}//memUpdateCheck

//memDeleteCheck
function memDeleteCheck(f) {
	var ac_passwd=f.ac_passwd.value;
	ac_passwd=ac_passwd.trim();
	//alert(ac_passwd);
	if(ac_passwd.length==0){
		alert("비밀번호를 입력해주세요.");
		f.ac_passwd.focus();
		return false;
	}
	
	var msg=confirm("한 번 진행하시면 다시 되돌릴 수 없습니다.\n정말 진행하시겠습니까?");
	if(msg){
		return true;
	}else{
		return false;
	}

	
}//memDeleteCheck



//------------------------join---------------------------------------------------------


//회원가입 유효성 검사 - 아이디는 제외
function joinCheck(f) {
	var pwreg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/; // PW검증 정규표현식
	var korCheck=/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/; // 한글검증 정규표현식
	var engCheck=/[A-Za-z0-9]/; // 영문검증 정규표현식
	
	//checkbox
	var agreement=$("#agreement");
	if(agreement.is(":checked") == false){
		alert("약관동의를 체크해주세요.");
		agreement.focus();
		return false;
	}
	
	//ac_id
	var ac_id=f.ac_id.value;
	ac_id=ac_id.trim();
	if(ac_id.length==0){
		alert("아이디를 입력해주세요.");
		f.ac_id.focus();
		return false;
	}	
	
	//passwd
	var ac_passwd=f.ac_passwd.value;
	ac_passwd=ac_passwd.trim();
	//alert(ac_passwd);
	if(ac_passwd.length<8){
		alert("비밀번호는 숫자+영문자+특수문자 조합으로\n8자리 이상 사용해야 합니다.");
		f.ac_passwd.focus();
		return false;
	}else if(!pwreg.test(ac_passwd)){
		alert("비밀번호는 숫자+영문자+특수문자 조합으로\n8자리 이상 사용해야 합니다.");
		f.ac_passwd.focus();
		return false;
	}
	
	//passwd check
	var ac_passwd_ck=f.ac_passwd_ck.value;
	ac_passwd_ck=ac_passwd_ck.trim();
	if(ac_passwd_ck!=ac_passwd){
		alert("비밀번호를 확인해주세요.");
		f.ac_passwd_ck.focus();
		return false;
	}
	
	//name kor
	var ac_name_kor=f.ac_name_kor.value;
	ac_name_kor=ac_name_kor.trim();
	if(engCheck.test(ac_name_kor)){
		alert("이름을 한글로 작성해주세요.");
		f.ac_name_kor.focus();
		return false;
	}else if(ac_name_kor.length==0){
		alert("이름을 입력해주세요.");
		f.ac_name_kor.focus();
		return false;
	}
	
	//name eng
	var ac_name_eng=f.ac_name_eng.value;
	ac_name_eng=ac_name_eng.trim();
	if(korCheck.test(ac_name_eng)){
		alert("이름을 영어로 작성해주세요.");
		f.ac_name_eng.focus();
		return false;
	}else if(ac_name_eng.length==0){
		alert("이름을 입력해주세요.");
		f.ac_name_eng.focus();
		return false;
	}
	
	//phone
	var ac_phone=f.ac_phone.value;
	ac_phone=ac_phone.trim();
	if(ac_phone.length==0){
		alert("전화번호를 입력해주세요.");
		f.ac_phone.focus();
		return false;
	}else if(isNaN(ac_phone)){
		alert("숫자만 입력해주세요");
		f.ac_phone.focus();
		return false;
	}
	
	var ac_email=f.ac_email.value;
	ac_email=ac_email.trim();
	//alert(ac_email);
	if(ac_email.length==0){
		alert("이메일을 입력해 주세요.");
		f.ac_email.focus();
		return false;
	}else if(ac_email.includes("@")==false){
		alert("이메일에 @ 포함해 주세요.");
		f.ac_email.focus();
		return false;
	}
	
	
	return true;
}//joinCheck

//memberUpdateForm.jsp
function joinCheck2(f) {
	var pwreg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/; // PW검증 정규표현식
	var korCheck=/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/; // 한글검증 정규표현식
	var engCheck=/[A-Za-z0-9]/; // 영문검증 정규표현식
	
	//ac_id
	var ac_id=f.ac_id.value;
	ac_id=ac_id.trim();
	if(ac_id.length==0){
		alert("아이디를 입력해주세요.");
		f.ac_id.focus();
		return false;
	}	
	
	//passwd
	var ac_passwd=f.ac_passwd.value;
	ac_passwd=ac_passwd.trim();
	//alert(ac_passwd);
	if(ac_passwd.length<8){
		alert("비밀번호는 숫자+영문자+특수문자 조합으로\n8자리 이상 사용해야 합니다.");
		f.ac_passwd.focus();
		return false;
	}else if(!pwreg.test(ac_passwd)){
		alert("비밀번호는 숫자+영문자+특수문자 조합으로\n8자리 이상 사용해야 합니다.");
		f.ac_passwd.focus();
		return false;
	}
	
	//passwd check
	var ac_passwd_ck=f.ac_passwd_ck.value;
	ac_passwd_ck=ac_passwd_ck.trim();
	if(ac_passwd_ck!=ac_passwd){
		alert("비밀번호를 확인해주세요.");
		f.ac_passwd_ck.focus();
		return false;
	}
	
	//name kor
	var ac_name_kor=f.ac_name_kor.value;
	ac_name_kor=ac_name_kor.trim();
	if(engCheck.test(ac_name_kor)){
		alert("이름을 한글로 작성해주세요.");
		f.ac_name_kor.focus();
		return false;
	}else if(ac_name_kor.length==0){
		alert("이름을 입력해주세요.");
		f.ac_name_kor.focus();
		return false;
	}
	
	//name eng
	var ac_name_eng=f.ac_name_eng.value;
	ac_name_eng=ac_name_eng.trim();
	if(korCheck.test(ac_name_eng)){
		alert("이름을 영어로 작성해주세요.");
		f.ac_name_eng.focus();
		return false;
	}else if(ac_name_eng.length==0){
		alert("이름을 입력해주세요.");
		f.ac_name_eng.focus();
		return false;
	}
	
	//phone
	var ac_phone=f.ac_phone.value;
	ac_phone=ac_phone.trim();
	if(ac_phone.length==0){
		alert("전화번호를 입력해주세요.");
		f.ac_phone.focus();
		return false;
	}else if(isNaN(ac_phone)){
		alert("숫자만 입력해주세요");
		f.ac_phone.focus();
		return false;
	}
	
	var ac_email=f.ac_email.value;
	ac_email=ac_email.trim();
	//alert(ac_email);
	if(ac_email.length==0){
		alert("이메일을 입력해 주세요.");
		f.ac_email.focus();
		return false;
	}else if(ac_email.includes("@")==false){
		alert("이메일에 @ 포함해 주세요.");
		f.ac_email.focus();
		return false;
	}
	
	
	return true;
}//joinCheck2













