<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<div class="hero-wrap"
		style="background-image: url('images/bg_1.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
				<div
					class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
					<div class="text">
						<p class="breadcrumbs mb-2">
							<span class="mr-2"><a href="index.html">Home</a></span> <span>About</span>
						</p>
						<h1 class="mb-4 bread">Join Us</h1>
					</div>
				</div>
			</div>
		</div>
	</div>


	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row">
			<div class="col-md-12 mb-4">
            <h2 class="pagetitle">신규회원가입</h2>
          </div>			
                        
          <div class="col-md-12 d-flex">          	
          	<div class="bg-white p-5 join-form">
          		<div class="formDiv">
            <form method="post" action="./join.do" name="join" id="join" onsubmit="return validate();">
            <h3 class="h4">약관동의</h3>
            <div class="form-group">  
             <textarea cols="55" rows="14" readonly>
             	약관동의 내용.
            </textarea>
            <label for="agreement">
            <input type="checkbox" id="agreement" value="약관동의" required>
               	약관에 동의합니다.
            </label>
            </div>
            
            
            <h3 class="h4">가입 정보</h3>
            <div class="form-group">                      	
              	<label for="ac_id">아이디</label>              	
                <input type="text" name="ac_id" id="ac_id" class="form-control" required>                
            </div>
            <div class="form-group">
            	<span id="panel_id"></span>
            </div> 
            
            <div class="form-group">
                <label for="ac_passwd">비밀번호</label>               	
                <input type="text" name="ac_passwd" id="ac_passwd" class="form-control" required>
            </div>           
            <div class="form-group">
                <label for="ac_passwd">비밀번호확인</label>               	
                <input type="text" name="ac_passwd_ck" id="ac_passwd_ck" class="form-control" required>
            </div>
             <div class="form-group">
            	<span id="panel_pw"></span>
            </div>
            
            <h3 class="h4">성명(한글)</h3>
              <div class="form-group">              	
              	<label for="ac_name_kor">
                <input type="text" name="ac_name_kor" id="ac_name_kor" class="form-control" required>
                </label>
              </div>
              <h3 class="h4">성명(영문)</h3>
               <div class="form-group">
              	<label for="ac_name_eng">
                <input type="text" name="ac_name_eng" id="ac_name_eng" class="form-control" required>
                </label>
              </div>
              
              <h3 class="h4">연락처 & 이메일</h3>
              <div class="form-group">              	
              	<label for="ac_phone">핸드폰번호</label>            	
                <input type="text" name="ac_phone" id="ac_phone" class="form-control" required>                               
              </div>
              <div class="form-group">              	
              	<label for="ac_email">이메일주소</label>            	
                <input type="text" name="ac_email" id="ac_email" class="form-control" required>                               
              </div>
              
              <div class="form-group">                
                <input type="hidden" name="ac_date" id="ac_date" class="form-control" required>
              </div>
              
              <div class="form-group">
                <input type="submit" value="회원가입" class="btn btn-primary py-3 px-5 formBtn">
              </div>
              </form>
              </div>
			</div>
		</div>
		</div>
		</div>
	</section>	

<script>

	//1) 아이디 중복확인
	$(function(){
		//해당페이지가 읽혀졌을 때 쿠키 변수 삭제
		$.removeCookie("checkID");
	});

	$("#ac_id").keyup(function(){
		//post (" 요청명령어 ", 전달값, 콜백함수, 응답받는 )
		var params = "ac_id=" + $("#ac_id").val();	
		$.post("idcheck.do", params, checkID, "json");			
	});//click end
	
	function checkID (result){
			
		var idreg = /^[A-za-z0-9]{5,15}$/g; // ID검증 정규표현식		
		var count = eval(result.count);		
		
		if( !idreg.test( $("#ac_id").val() ) ) {
			$("#panel_id").css("color","red");
			$("#panel_id").text("아이디는 4~12자의 영문 대소문자와 숫자로만 이루어져야합니다.");		
		       return false;			
		} else {
			if(count == 0) {
				$("#panel_id").css("color","blue");
				$("#panel_id").text("사용가능한 아이디입니다.");			
				$.cookie("checkID", "PASS"); //쿠키변수 생성
				return true;
			} else {
				$("#panel_id").css("color","red");
				$("#panel_id").text("중복된 아이디입니다.");
				$("#ac_id").focus();
				return false;
			}
			$("#panel_id").css("color","blue");
			$("#panel_id").text("아이디가 유효합니다.");	
		}
	} 
	
	function send() {		
		var checkID = $.cookie("checkID");
		if(checkID == "PASS"){
			return true;			
		} else {
			$("#panel_id").css("color","red");
			$("#panel_id").text("아이디를 확인하세요.");
			$("#ac_id").focus();
			return false;
		}
   }
	
	/* 비밀번호 일치여부 */
	$(function(){		
		  $('#ac_passwd_ck').keyup(function(){
		   if($('#ac_passwd').val()!=$('#ac_passwd_ck').val()){
			$("#panel_pw").css("color","red");
			$("#panel_pw").text("비밀번호가 일치하지 않습니다.");		
		   }else{
			$("#panel_pw").css("color","blue");
			$("#panel_pw").text("비밀번호가 일치합니다.");	
		   }
		  });
	 });
	
	/* 이름(한글) 유효성검사  */
	
	/* 이름(영문) 유효성검사  */
	
	/* 핸드폰번호 유효성검사  */
	
	/* 이메일 유효성검사  */
	
	
	
</script>    


<%@ include file="../footer.jsp"%>
