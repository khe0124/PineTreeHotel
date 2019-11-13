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
        	
        	<a href="/pinetree/contact/faqForm.do">Write</a>
        	
        	<c:if test="${list==0 }">
        		게시글이 없습니다.
        	</c:if>
        	
        	<c:if test="${list==1 }">
		        <table class="table">
		        	<tr>
		        		<th>번호</th>
		        		<th>제목</th>
		        		<th>작성일</th>
		        		<th>문의 유형</th>
		        	</tr>
			        <c:forEach var="dto" items="${fq_list }">
			        <tr>
			        	<td>${dto.fq_num }</td>
			        	<td>
			        		<a href="/pinetree/contact/faqRead.do?fq_num=${dto.fq_num }">
			        			${dto.fq_title }
			        		</a>
			        	</td>
			        	<td>${dto.fq_date }</td>
			        	<c:choose>
			        		<c:when test="${dto.fq_type eq 'F001' }">
			        			<td>예약</td>
			        		</c:when>
			        		<c:when test="${dto.fq_type eq 'F002' }">
			        			<td>멤버십</td>
			        		</c:when>
			        		<c:when test="${dto.fq_type eq 'F003' }">
			        			<td>다이닝</td>
			        		</c:when>
			        		<c:when test="${dto.fq_type eq 'F004' }">
			        			<td>취소/환불</td>
			        		</c:when>
			        		<c:otherwise>
			        			<td>기타</td>
			        		</c:otherwise>
			        	</c:choose>			        	
			        </tr>
			        </c:forEach>
		        </table>        	        	
        	</c:if>
        	
        	
        </div>
    </div>
</section>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
