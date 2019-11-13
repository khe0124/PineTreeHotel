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
	            <h1 class="mb-4 bread">Review</h1>
            </div>
          </div>
        </div>
      </div>
</div>
<!--  -->
<section class="ftco-section">
	<div class="container">
	  <div class="row d-flex">
        <c:forEach var="dto" items="${articleList }">
        	<div class="col-md-3 d-flex ftco-animate">
        		<div class="reviewList">
		            <div class="blog-entry align-self-stretch">
						<a href="/pinetree/contact/reviewRead.do?re_num=${dto.re_num }" class="block-20" style="background-image: url('/pinetree/contact/storage/${dto.re_filename }');">
			            </a>
			            <div class="text mt-3 d-block">
					      <h3 class="heading mt-3">
						    ${dto.re_title }
					      </h3>
					    <div class="meta mb-3">
						  <c:set var="re_date" value="${dto.re_date }"></c:set>
						  <c:set var="re_date" value="${fn:substring(re_date,0,10) }"></c:set>
						  <% pageContext.setAttribute("enter","\n"); %>
						   <p class="review_cont">${fn:replace(fn:replace(fn:escapeXml(dto.re_cont), enter, '<br/>') , ' ', ' ')}</p>
						  <div><a href="#">${dto.ac_id }</a></div>
						  <div><a href="#">${re_date }</a></div>		                
					      </div>
				        </div>
		            </div>
	            </div>
           </div>
         </c:forEach>
          <!-- 끝 -->
        </div>
	    <c:if test="${s_id!=null }">
	      <div class="text-center">
	        <a href="/pinetree/contact/reviewCreate.do" class="btn btn-primary" >Write</a>
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
						<li class="page-item"><a class="page-link" href="./review.do">이전</a></li>
						</c:if>
						<c:if test="${startPage > 0 }">
						<li class="page-item"><a class="page-link" href="./review.do?pageNum=${startPage }">이전</a></li>
						</c:if>
						
						<c:forEach var="i" begin="${startPage+1 }" end="${endPage-1 }">
							<li class="page-item"><a class="page-link" href="./review.do?pageNum=${i }">${i }</a></li>
						</c:forEach>
						
						<c:if test="${endPage<pageCount }">
						 <li class="page-item"><a class="page-link" href="./review.do?pageNum=${startPage+11 }">다음</a></li>
						</c:if>
					</c:if>  
					</ul>
		        </div>
		     </div>
		</div>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
