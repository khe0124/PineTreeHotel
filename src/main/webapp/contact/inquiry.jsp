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
		        <table class="table">
		        		<tr>
		        			<th>제목</th>
		        			<th>작성자</th>
		        			<th>작성일</th>
		        			<th>유형</th>
		        			<th>답변상태</th>
		        		</tr>
			        <c:forEach var="dto" items="${articleList }">
			        		<tr>
			        			<td>
			        				<c:if test="${dto.ac_id == s_id || s_mlevel == '6' }">
			        				<a href="/pinetree/contact/inquiryRead.do?iq_num=${dto.iq_num }">
			        					${dto.iq_title }
			        				</a>
			        				</c:if>
			        				<c:if test="${dto.ac_id != s_id &&  s_mlevel != '6' }">
			        					관리자만 열람가능 합니다.
			        				</c:if>
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
			        			<c:choose>
			        				<c:when test="${dto.iq_check eq 'A' }">
			        					<td>미답변</td>
			        				</c:when>
			        				<c:when test="${dto.iq_check eq 'B' }">
			        					<td>답변완료</td>
			        				</c:when>
			        			</c:choose>
			        		</tr>
			        </c:forEach>
		        </table>
        	<!-- 끝 -->
        </div>
        <c:if test="${s_id!=null }">
        <div class="text-center">
        		<a href="/pinetree/contact/inquiryform.do" class="btn btn-primary" >Write</a>
        </div>
		</c:if>
    </div>
</section>

<!-- paging -->
<div class="col-md-12 my-5">
		    <div class="text-center">
		       <div class="row" style="text-align:center;">
		       	<ul class="pagination" style="text-align:center;">
					<c:if test="${count>0 }"> 
						<c:set var="pageCount" value="${totalPage }" />
						<c:set var="startPage" value="${startPage }" />
						<c:set var="endPage" value="${endPage }" />
						
						<c:if test="${endPage>pageCount }">
							<c:set var="endPage" value="${pageCount+1 }" />
						</c:if>
						
						<c:if test="${startPage == 0 }">
						<li class="page-item"><a class="page-link" href="./inquiry.do">이전</a></li>
						</c:if>
						<c:if test="${startPage > 0 }">
						<li class="page-item"><a class="page-link" href="./inquiry.do?pageNum=${startPage }">이전</a></li>
						</c:if>
						
						<c:forEach var="i" begin="${startPage+1 }" end="${endPage-1 }">
							<li class="page-item"><a class="page-link" href="./inquiry.do?pageNum=${i }">${i }</a></li>
						</c:forEach>
						
						<c:if test="${endPage<pageCount }">
						 <li class="page-item"><a class="page-link" href="./inquiry.do?pageNum=${startPage+11 }">다음</a></li>
						</c:if>
						
					</c:if>  
					</ul>
		        </div>
		     </div>
		</div>

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
