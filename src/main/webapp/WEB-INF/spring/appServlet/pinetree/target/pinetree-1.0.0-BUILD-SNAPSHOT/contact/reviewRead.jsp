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

<section class="ftco-section ftc-no-pb ftc-no-pt">
				  
			<div class="container">
				<div class="row">
					<div class="col-md-5 p-md-5 img img-2 img-3 d-flex justify-content-center align-items-center">
						<img src="/pinetree/contact/storage/${dto.re_filename }">
					</div>
					<div class="col-md-7 py-5 wrap-about pb-md-5 ftco-animate">
			          <div class="heading-section heading-section-wo-line pt-md-5 pl-md-5 mb-5">
			          	<div class="ml-md-0">
				          	<span class="subheading">${dto.ac_id }</span>
				            <h2 class="mb-4">${dto.re_title }</h2>
			            </div>
			          </div>
			           <div class="pb-md-5">
				            <% pageContext.setAttribute("enter","\n"); %>
							<p>${fn:replace(fn:replace(fn:escapeXml(dto.re_cont), enter, '<br/>') , ' ', ' ')}</p>
						</div>
					</div>
				</div>
			</div>
			
			<input type="button" value="수정" onclick="location.href=">
    		<input type="button" value="삭제" onclick="location.href=">
  
</section>
		
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
