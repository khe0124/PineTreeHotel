<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 -->
<div class="hero-wrap" style="background-image: url('../images/bg_1.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
          <div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
          	<div class="text">
	            <p class="breadcrumbs mb-2"><span class="mr-2"><a href="/pinetree/index.do">Home</a></span> <span>MyPage</span></p>
	            <h1 class="mb-4 bread">MyPage</h1>
            </div>
          </div>
        </div>
      </div>
</div>

	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row">
			<div class="col-md-12 mb-4">
            <h2 class="pagetitle" style="text-align: center;">회원탈퇴</h2>
          </div>			
                        
          <div class="col-md-12 d-flex">        	          	
          	<div class="bg-white p-5 login-form">                   	
            <form name="loginfrm" 
				  method="post" 
				  action="/pinetree/member/memberdelete.do"
				  onsubmit="return memDeleteCheck(this)">
	            <div class="form-group">              	
	              	<label for="ac_passwd">비밀번호</label>              	
	                <input type="password" name="ac_passwd" id="ac_passwd" placeholder="비밀번호를 입력해주세요" class="form-control" >
	             </div>

              <div class="form-group">
                <input type="submit" value="정보 수정" class="btn btn-primary py-3 px-5 formBtn">
              </div>
              </form>
              
			</div>
		</div>
		
		
		</div>
		</div>
	</section>

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
