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


	<a href="/pinetree/contact/reviewCreate.do">Write</a>



   
<section class="ftco-section">
	<div class="container">
        <div class="row d-flex">
        
        <c:forEach var="dto" items="${list }">
        	<div class="col-md-3 d-flex ftco-animate">
        		<div class="reviewList">
		            <div class="blog-entry align-self-stretch">
							 	<a href="/pinetree/contact/reviewRead.do?re_num=${dto.re_num }" class="block-20" style="background-image: url('/pinetree/contact/storage/${dto.re_filename }');">
			              		</a>
			              		<div class="text mt-3 d-block">
					                <h3 class="heading mt-3">
						                <% pageContext.setAttribute("enter","\n"); %>
										<p class="review_cont">${fn:replace(fn:replace(fn:escapeXml(dto.re_cont), enter, '<br/>') , ' ', ' ')}</p>
					                </h3>
					                <div class="meta mb-3">
										<c:set var="re_date" value="${dto.re_date }"></c:set>
										<div><a href="#">${dto.re_title }</a></div><br>
										<c:set var="re_date" value="${fn:substring(re_date,0,10) }"></c:set>
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
    </div>
    
</section> 

<!-- 페이징 -->
<div class="row mt-5">
    <div class="col text-center">
       <div class="block-27">
          <ul>
             <li><a href="#">&lt;</a></li>
             <li class="active"><span>1</span></li>
             <li><a href="#">2</a></li>
             <li><a href="#">3</a></li>
             <li><a href="#">4</a></li>
             <li><a href="#">5</a></li>
             <li><a href="#">&gt;</a></li>
             </ul>
        </div>
     </div>
</div>


<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
