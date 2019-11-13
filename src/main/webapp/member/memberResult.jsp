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

<section class="ftco-section">
	<div class="container">
        <div class="row d-flex">
        
			<c:if test="${u_cnt==0 }">
				<script>
					alert("정보수정이 실패했습니다.");
					location.href="/pinetree/index.do";
				</script>
			</c:if>
			
			<c:if test="${u_cnt==1 }">
				<script>
					alert("정보수정이 성공했습니다.");
					location.href="/pinetree/index.do";
				</script>
			</c:if>
			
			<c:if test="${d_cnt==0 }">
				<script>
					alert("회원탈퇴가 실패했습니다.\n비밀번호를 확인해주세요");
					location.href="/pinetree/member/memberdelete.do";
				</script>
			</c:if>
			
			<c:if test="${d_cnt==1 }">
				<script>
					alert("회원탈퇴가 성공했습니다.");
					location.href="/pinetree/logout.do";
				</script>
			</c:if>			
			
			
        </div>
    </div>
</section>

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
