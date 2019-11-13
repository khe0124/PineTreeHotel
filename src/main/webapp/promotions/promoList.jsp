<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 -->
<div class="hero-wrap"
	style="background-image: url('../images/bg_1.jpg');">
	<div class="overlay"></div>
	<div class="container">
		<div
			class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
			<div
				class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
				<div class="text">
					<p class="breadcrumbs mb-2">
						<span class="mr-2"><a href="/pinetree/index.do">Home</a></span> <span>Review</span>
					</p>
					<h1 class="mb-4 bread">Promotions</h1>
				</div>
			</div>
		</div>
	</div>
</div>

<section class="ftco-section">
	<div class="container">
		<div class="row d-flex">
			<c:if test="${pm_list == null }">
				<div class="col-md-12 my-5">
					<h3 class="text-center">아직 글이 없습니다.</h3>
				</div>			
			</c:if>
		
			<c:forEach var="dto" items="${pm_list }">
				<div class="col-md-3 d-flex ftco-animate">
					<div class="promoList">
						<div class="blog-entry align-self-stretch">
							<a href="/pinetree/promotions/promoRead.do?pm_num=${dto.pm_num }"
								class="block-20" 
								style="background-image: url('/pinetree/promotions/storage/${dto.pm_filename }');"></a>
								<div class="text mt-3 d-block">
									<h3 class="heading mt-3">${dto.pm_title }</h3>
									<div class="meta mb-3">
										<c:set var="pm_date" value="${dto.pm_date }"></c:set>
										<div>
										<% pageContext.setAttribute("enter","\n"); %>
										<c:if test= '${fn:length(dto.pm_cont) < 20 }'>
											<p>${dto.pm_cont }</p>
										</c:if>
										<c:if test= '${fn:length(dto.pm_cont) > 20 }'>
											<p>${dto.pm_cont.substring(0,20) }</p>
										</c:if>
										</div>
										<br>
										<c:set var="pm_date" value="${fn:substring(pm_date,0,10) }"></c:set>
										<div>
											<span>${pm_date }</span>
										</div>
									</div>
								</div>
							
							</div>
						</div>
					</div>
			</c:forEach>
			
		</div>
		<c:if test='${s_mlevel == "6"}'>
			<div class="text-center">
		     <a href="/pinetree/promotions/promoCreate.do" class="btn btn-primary" >Write</a>
		    </div>
        </c:if>
	</div>
</section>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>