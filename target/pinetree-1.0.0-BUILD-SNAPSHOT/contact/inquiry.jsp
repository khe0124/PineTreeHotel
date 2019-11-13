<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 -->
<div class="hero-wrap" style="background-image: url('../images/bg_1.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
          <div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
          	<div class="text">
	            <p class="breadcrumbs mb-2"><span class="mr-2"><a href="/pinetree/index.do">Home</a></span> <span>Inquiry</span></p>
	            <h1 class="mb-4 bread">1:1 문의</h1>
            </div>
          </div>
        </div>
      </div>
</div>

<section class="ftco-section">
	<div class="container">
        <div class="row d-flex">
        	<!-- 시작 -->
        	
        	<a href="/pinetree/contact/inquiryForm.do">Write</a>

		        <table class="table">
		        		<tr>
		        			<th>제목</th>
		        			<th>작성자</th>
		        			<th>작성일</th>
		        			<th>유형</th>
		        		</tr>
			        <c:forEach var="dto" items="${iq_list }">
			        		<tr>
			        			<td>
			        				<a href="/pinetree/contact/inquiryRead.do?iq_num=${dto.iq_num }">
			        					${dto.iq_title }
			        				</a>
			        			</td>
			        			<td>${dto.ac_id }</td>
			        			<c:set var="iq_date" value="${dto.iq_date }"></c:set>
			        			<c:set var="iq_date" value="${fn:substring(iq_date,0,10) }"></c:set>
			        			<td>${iq_date }</td>
			        			<c:choose>
			        				<c:when test="${dto.iq_type eq 'F001' }">
			        					<td>예약</td>
			        				</c:when>
			        				<c:when test="${dto.iq_type eq 'F002' }">
			        					<td>멤버십</td>
			        				</c:when>
			        				<c:when test="${dto.iq_type eq 'F003' }">
			        					<td>다이닝</td>
			        				</c:when>
			        				<c:when test="${dto.iq_type eq 'F004' }">
			        					<td>취소/환불</td>
			        				</c:when>
			        				<c:otherwise>
			        					<td>기타</td>
			        				</c:otherwise>
			        			</c:choose>
			        		</tr>
			        </c:forEach>
		        </table>
        	<!-- 끝 -->
        </div>
    </div>
</section>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
