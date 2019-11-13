<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 -->
<div class="hero-wrap" style="background-image: url('../images/bg_1.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
          <div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
          	<div class="text">
	            <p class="breadcrumbs mb-2"><span class="mr-2"><a href="/pinetree/index.do">Home</a></span> <span>FAQ</span></p>
	            <h1 class="mb-4 bread">FAQ</h1>
            </div>
          </div>
        </div>
      </div>
</div>

<section class="ftco-section">
	<div class="container">
        <div class="row d-flex">
			
			<c:if test="${cnt==0 }">
				<script>
					alert("다시 작성해주세요.");
					history.back();
				</script>
			</c:if>
			<c:if test="${cnt==1 }">
				<script>
					alert("댓글이 등록되었습니다.");
					history.reload();
				</script>
			</c:if>
			
        </div>
    </div>
</section>

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
