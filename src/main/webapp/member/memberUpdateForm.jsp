<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

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
							<span class="mr-2"><a href="index.html">Home</a></span> <span>MyPage</span>
						</p>
						<h1 class="mb-4 bread">MyPage</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<c:if test="${dto==null }">
		<script>
			alert("비밀번호를 확인해주세요");
			history.back();
		</script>
	</c:if>

	<c:if test="${dto!=null }">
	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row">
			<div class="col-md-12 mb-4">
            <h2 class="pagetitle">회원정보 수정</h2>
          </div>			
                        
          <div class="col-md-12 d-flex">          	
          	<div class="bg-white p-5 join-form">
          		<div class="formDiv">
            <form method="post" action="/pinetree/member/memberupdateproc.do" name="joinfrm" id="joinfrm" onsubmit="return joinCheck2(this)">
            
            <h3 class="h4">회원정보 수정</h3>
            <div class="form-group">                      	
              	<label for="ac_id">아이디</label>              	
                <input type="text" name="ac_id" id="ac_id" value="${dto.ac_id }" readonly class="form-control">                
            </div>
            <div class="form-group">
            	<span id="panel_id"></span>
            </div> 
            
            <div class="form-group">
                <label for="ac_passwd">비밀번호</label>               	
                <input type="password" name="ac_passwd" id="ac_passwd" class="form-control">
            </div>                  
            <div class="form-group">
                <label for="ac_passwd">비밀번호확인</label>               	
                <input type="password" name="ac_passwd_ck" id="ac_passwd_ck" class="form-control">
            </div>
            
            <h3 class="h4">성명(한글)</h3>
              <div class="form-group">              	
              	<label for="ac_name_kor">
                <input type="text" name="ac_name_kor" id="ac_name_kor" value="${dto.ac_name_kor }" placeholder="예시 - 홍길동" class="form-control">
                </label>
              </div>
              <div class="form-group">
            	<span id="panel_name_k"></span>
              </div>
              <h3 class="h4">성명(영문)</h3>
               <div class="form-group">
              	<label for="ac_name_eng">
                <input type="text" name="ac_name_eng" id="ac_name_eng" value="${dto.ac_name_eng }" placeholder="예시 - JennyKim" class="form-control">
                </label>
              </div>
              <div class="form-group">
            	<span id="panel_name_e"></span>
              </div>
              
              <h3 class="h4">연락처 & 이메일</h3>
              <div class="form-group">              	
              	<label for="ac_phone">핸드폰번호</label>            	
                <input type="text" name="ac_phone" id="ac_phone" class="form-control" value="${dto.ac_phone }" maxlength="11" placeholder="예시 - 01012341234">                               
              </div>
              <div class="form-group">              	
              	<label for="ac_email">이메일주소</label>            	
                <input type="text" name="ac_email" id="ac_email" class="form-control" value="${dto.ac_email }" placeholder="예시 - test01@gmail.com">                               
              </div>
              
              <div class="form-group">                
                <input type="hidden" name="ac_date" id="ac_date" class="form-control">
              </div>
              
              <div class="form-group">
                <input type="submit" value="정보수정" class="btn btn-primary py-3 px-5 formBtn">
              </div>
              </form>
              </div>
			</div>
		</div>
		</div>
		</div>
	</section>	
	</c:if>
	


<%@ include file="../footer.jsp"%>
