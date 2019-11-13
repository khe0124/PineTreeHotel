<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>
<%
if(s_id.equals("guest") || s_passwd.equals("guest")|| s_mlevel.equals("guest"))
	{ //로그인을 하지 않은 경우
	  //쿠키값을 가져오기
	  Cookie[] cookies = request.getCookies();
	  String c_id = "";
	  if(cookies != null) { //쿠키가 존재하는지?
		  for (int i = 0; i<cookies.length; i++) {
			  Cookie cookie = cookies[i];
			  //쿠키변수 c_id
			  if(cookie.getName().equals("c_id")==true){
				  c_id = cookie.getValue();
			  }
		  }
	  }
	}
 %>

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
							<span class="mr-2"><a href="index.html">Home</a></span> <span>Account</span>
						</p>
						<h1 class="mb-4 bread">Login</h1>
					</div>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row">
			<div class="col-md-12 mb-4">
            <h2 class="pagetitle" style="text-align: center;">로그인페이지</h2>
          </div>			
                        
          <div class="col-md-12 d-flex">        	          	
          	<div class="bg-white p-5 login-form">                   	
            <form name="loginfrm" 
				  method="post" 
				  action="./login.do"
				  onsubmit="return loginCheck(this)">
	            <h3>Login</h3>
	            <div class="form-group">              	
	              	<label for="ac_id">아이디</label>              	
	                <input type="text" name="ac_id" id="ac_id" value="${c_id }" placeholder="아이디를 입력하세요." required class="form-control" >
	             </div>
	             <div class="form-group">      	                
	                <label for="ac_passwd">비밀번호 </label>               	
	                <input type="password" name="ac_passwd" id="ac_passwd" size="30" placeholder="비밀번호를 입력하세요."
								required class="form-control">
               </div>
                <input type="hidden" name="ac_grade" id="ac_grade" value="${s_mlevel }" required class="form-control">
               <div class="form-group">
                <label for="s_id_save">
               	<input type="checkbox" id="s_id_save" value="아이디 저장">               	
               	아이디저장
               	</label>
               </div>
              <div class="form-group">
                <input type="submit" value="로그인" class="btn btn-primary py-3 px-5 formBtn">
              </div>
              </form>
              
              <div class="contact-form" style="border-top:1px solid #000;">
              	<a href="/pinetree/member/findId.do">아이디</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a href="/pinetree/member/findPasswd.do">비밀번호</a>&nbsp;&nbsp;찾기
              </div>
			</div>
		</div>
		</div>
		</div>
	</section>
	
	<script>
	$(document).ready(function(){
		$("#formBtn").unbind("click").click(function(e){
			e.preventDefault();
			fn_login();
		});
	});
	
	function fn_login() {
		if($("#ac_id").val().length < 1){
			alert("아이디를 입력하시오.");
		} else if($("#ac_passwd").val().length < 1) {
			alert("비밀번호를 입력하시오.");
		} else {
			var comSubmit = new ComSubmit("loginfrm");
			comSubmit.setUrl("<c:url value='/user/loginProc.do' />");
			comSubmit.submit();
		}
		
	}
	
	</script>




<%@ include file="../main/footer.jsp"%>
