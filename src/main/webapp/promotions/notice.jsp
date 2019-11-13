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
	            <h1 class="mb-4 bread">Notice</h1>
            </div>
          </div>
        </div>
      </div>
</div>

<section class="ftco-section">
	<div class="container">
        <div class="col-md-9" style="margin:0 auto;">
        	<form>
        		<table class="table">
        		<tr>
        			<th>글번호</th>
        			<th colspan="2">제목</th>
        			<th>등록일</th>
        			<c:if test='${s_mlevel == "6"}'>
        			<th>수정/삭제</th>
        			</c:if>
        		</tr>
        		<c:forEach var="dto" items="${notice}">
					<tr>
						<td>${dto.nt_num }</td>
						<td colspan="2"><a href="noticeRead.do?nt_num=${dto.nt_num }">${dto.nt_title }</a></td>
						<td>${fn:substring(dto.nt_date,0,11 )}</td>
					<c:if test='${s_mlevel == "6"}'>
        				<td>
							<input type="button" value="Edit" onclick="location.href='noticeUpdate.do?nt_num=${dto.nt_num}'">
							<input type="button" value="Remove" onclick="location.href='noticeDelete.do?nt_num=${dto.nt_num}'">
						</td>
        			</c:if>
					</tr>        		
        		</c:forEach>
        		<c:if test='${s_mlevel == "6"}'>
        		<tr>
        			<td colspan="5"><a href="/pinetree/promotions/noticeCreate.do" class="btn btn-primary"><strong>공지사항 등록</strong></a></td>
        		</tr>
        		</c:if>
        		</table>
        	</form>
        </div>
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
						<li class="page-item"><a class="page-link" href="./notice.do">이전</a></li>
						</c:if>
						<c:if test="${startPage > 0 }">
						<li class="page-item"><a class="page-link" href="./notice.do?pageNum=${startPage }">이전</a></li>
						</c:if>
						
						<c:forEach var="i" begin="${startPage+1 }" end="${endPage-1 }">
							<li class="page-item"><a class="page-link" href="./notice.do?pageNum=${i }">${i }</a></li>
						</c:forEach>
						
						<c:if test="${endPage<pageCount }">
						 <li class="page-item"><a class="page-link" href="./notice.do?pageNum=${startPage+11 }">다음</a></li>
						</c:if>
						
					</c:if>  
					</ul>
		        </div>
		     </div>
		</div>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>