<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 -->
<div class="hero-wrap" style="background-image: url('../images/bg_1.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
          <div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
          	<div class="text">
	            <p class="breadcrumbs mb-2"><span class="mr-2"><a href="/pinetree/index.do">Home</a></span> <span>Review</span></p>
	            <h1 class="mb-4 bread">Result</h1>
            </div>
          </div>
        </div>
      </div>
</div>

<section class="ftco-section">
	<div class="container">
        <div class="row d-flex">
        	<c:if test="${result==0 }">
        		게시글 없음
        	</c:if>
        	<c:if test="${result==1 }">
        		<script>
        			alert("입력성공!");
        			location.href="/pinetree/promotions/promoList.do";
        			
        		</script>
        		<a href="/pinetree/promotions/promoList.do">Go back to the list</a>
        	</c:if>
        	
        	<c:if test="${result==2 }">
        		<script>
        			alert("입력성공!");
        			location.href="/pinetree/promotions/notice.do";
        			
        		</script>
        		<a href="/pinetree/promotions/notice.do">Go back to the list</a>
        	</c:if>
        	
        	<c:if test="${result==3 }">
        		<script>
        			alert("수정성공!");
        			location.href="/pinetree/promotions/notice.do";
        			
        		</script>
        		<a href="/pinetree/promotions/notice.do">Go back to the list</a>
        	</c:if>
        	
        	<c:if test="${result==4 }">
        		<script>
        			alert("삭제실패!");
        			location.href="/pinetree/promotions/notice.do";
        			
        		</script>
        		<a href="/pinetree/promotions/notice.do">Go back to the list</a>
        	</c:if>
        	<c:if test="${result==5 }">
        		<script>
        			alert("삭제성공!");
        			location.href="/pinetree/promotions/notice.do";
        			
        		</script>
        		<a href="/pinetree/promotions/notice.do">Go back to the list</a>
        	</c:if>
        	
        	<c:if test="${result==6 }">
        		<script>
        			alert("수정성공!");
        			location.href="/pinetree/promotions/promoList.do";
        			
        		</script>
        		<a href="/pinetree/promotions/notice.do">Go back to the list</a>
        	</c:if>
        	
        	<c:if test="${result==7 }">
        		<script>
        			alert("삭제실패!");
        			location.href="/pinetree/promotions/promoList.do";
        			
        		</script>
        		<a href="/pinetree/promotions/notice.do">Go back to the list</a>
        	</c:if>
        	<c:if test="${result==8}">
        		<script>
        			alert("삭제성공!");
        			location.href="/pinetree/promotions/promoList.do";
        			
        		</script>
        		<a href="/pinetree/promotions/notice.do">Go back to the list</a>
        	</c:if>
        	
        	
        	
        	      	
        	
        	
        </div>
        
        
        	      	
    </div>
</section>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
