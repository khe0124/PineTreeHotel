<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 -->
<div class="hero-wrap" style="background-image: url('../images/bg_1.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
          <div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
          	<div class="text">
	            <p class="breadcrumbs mb-2"><span class="mr-2"><a href="/pinetree/index.do">Home</a></span> <span>Result</span></p>
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
        			location.href="/pinetree/contact/review.do";
        		</script>
        	</c:if>
        	
        	<c:if test="${result==2 }">
        		<script>
        			alert("입력성공!");
        			location.href="/pinetree/contact/inquiry.do";
        		</script>
        	</c:if>
        	
        	<c:if test="${result==3 }">
        		<script>
        			alert("입력성공!");
        			location.href="/pinetree/contact/faq.do";
        		</script>
        	</c:if>
        	
        	<c:if test="${result==4 }">
        		<script>
        			alert("비밀번호를 확인해주세요.");
        			history.back();
        		</script>
        	</c:if>
        	
        	<c:if test="${result==5 }">
        		<script>
        			alert("수정이 실패하였습니다.");
        			location.href="/pinetree/contact/review.do";
        		</script>
        	</c:if>          	
        	
        	<c:if test="${result==6 }">
        		<script>
        			alert("수정이 완료되었습니다.");
        			location.href="/pinetree/contact/review.do";
        		</script>
        	</c:if>
        	
        	<c:if test="${result==7 }">
        		<script>
        			alert("삭제가 실패하였습니다.");
        			location.href="/pinetree/contact/review.do";
        		</script>
        	</c:if>          	
        	
        	<c:if test="${result==8 }">
        		<script>
        			alert("삭제가 완료되었습니다.");
        			location.href="/pinetree/contact/review.do";
        		</script>
        	</c:if>
        	
        	<c:if test="${result==9 }">
        		<script>
        			alert("문의가 실패했습니다.");
        			location.href="/pinetree/contact/email.do";
        		</script>
        	</c:if>
        	
        	<c:if test="${result==10 }">
        		<script>
        			alert("문의가 성공했습니다.");
        			location.href="/pinetree/index.do";
        		</script>
        	</c:if>
        	
        	<c:if test="${result==11 }">
        		<script>
        			alert("유형수정실패");
        			location.href="/pinetree/contact/emailList.do";
        		</script>
        	</c:if>
        	
        	<c:if test="${result==12 }">
        		<script>
        			alert("유형수정성공");
        			location.href="/pinetree/contact/emailList.do";
        		</script>
        	</c:if>
        	
        	<c:if test="${result==13 }">
        		<script>
        			alert("수정실패");
        			location.href="/pinetree/contact/inquiry.do";
        		</script>
        	</c:if>
        	
        	<c:if test="${result==14 }">
        		<script>
        			alert("수정성공");
        			location.href="/pinetree/contact/inquiry.do";
        		</script>
        	</c:if>
        	
        	<c:if test="${result==15 }">
        		<script>
        			alert("삭제실패");
        			location.href="/pinetree/contact/inquiry.do";
        		</script>
        	</c:if>
        	
        	<c:if test="${result==16 }">
        		<script>
        			alert("삭제성공");
        			location.href="/pinetree/contact/inquiry.do";
        		</script>
        	</c:if>
        	
        	<c:if test="${result==17 }">
        		<script>
        			alert("수정실패");
        			location.href="/pinetree/contact/faq.do";
        		</script>
        	</c:if>
        	
        	<c:if test="${result==18 }">
        		<script>
        			alert("수정성공");
        			location.href="/pinetree/contact/faq.do";
        		</script>
        	</c:if> 
        	
        	<c:if test="${result==19 }">
        		<script>
        			alert("삭제실패");
        			location.href="/pinetree/contact/faq.do";
        		</script>
        	</c:if>
        	
        	<c:if test="${result==20 }">
        		<script>
        			alert("삭제성공");
        			location.href="/pinetree/contact/faq.do";
        		</script>
        	</c:if>          	          	         	        	    	         	        	        	
        	
        	
        </div>
    </div>
</section>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
