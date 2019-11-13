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
       		<c:if test="${dto==null }">
        		<script>
        			alert("비밀번호를 다시 확인해주세요.");
        			window.history.back();//뒤로가기
        		</script>
       		</c:if>
       		
       		
       		<c:if test="${dto!=null }">
				<table class="table">
				  <tr>
				    <th colspan="2">${dto.iq_title }</th>
				  </tr>
				  <tr>
				    <td>${dto.ac_id }</td>
				    <td>${dto.iq_date }</td>
				  </tr>
				  <tr>
				    <td colspan="2" rowspan="2">
						<% pageContext.setAttribute("enter","\n"); %>
						<p>${fn:replace(fn:replace(fn:escapeXml(dto.iq_cont), enter, '<br/>') , ' ', ' ')}</p>
				    </td>
				  </tr>
				  <tr>
				  </tr>
				</table>
				
				<input type="button" value="수정" onclick="location.href='./inquiryupdateform.do?iq_num=${dto.iq_num}'">
				<input type="button" value="삭제" onclick="location.href='./inquirydelete.do?iq_num=${dto.iq_num}'">
				<c:if test="${s_mlevel=='6' }">
					<input type="button" value="답변" onclick="location.href='./inquiryupdateform.do?iq_num=${dto.iq_num}'">
				</c:if>       		
       		</c:if>
       		
			
			
        </div>
    </div>
</section>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
