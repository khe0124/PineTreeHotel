<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
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
		style="background-image: url('../images/bg_1.jpg');">
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
            <h2 class="pagetitle" style="text-align: center;">아이디 찾기</h2>
          </div>			
                        
          <div class="col-md-12 d-flex">        	          	
          	<div class="bg-white p-5 login-form">                   	
            <form name="loginfrm" 
				  method="post" 
				  action="/pinetree/member/findId.do"
				  onsubmit="return findIdCheck(this)">
				 
	            <h3>ID</h3>
	            <div class="form-group">              	
	              	<label for="ac_name_kor">이름</label>              	
	                <input type="text" name="ac_name_kor" id="ac_name_kor" placeholder="가입 시 등록했던 이름 입력" required class="form-control" >
	             </div>
	             <div class="form-group">      	                
					<label for="ac_phone">휴대전화</label>
					<input type="text" name="ac_phone" id="ac_phone" placeholder="예)01012341234" maxlength="11" required class="form-control" >
               </div>

              <div class="form-group">
                <input type="submit" value="아이디 찾기" class="btn btn-primary py-3 px-5 formBtn">
              </div>
              </form>
              
			</div>
		</div>
		</div>
		</div>
	</section>
	


<%@ include file="../footer.jsp"%>
