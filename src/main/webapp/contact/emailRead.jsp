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
	            <h1 class="mb-4 bread">E-mail</h1>
            </div>
          </div>
        </div>
      </div>
</div>
<form action="/pinetree/contact/emailupdate.do"
	  method="get"
      name="email">
<section class="ftco-section">
	<div class="container">
        <div class="row d-flex">
        	<input type="hidden" name="em_num" id="em_num" value="${dto.em_num }">
 				<table class="table">
				  <tr>
				    <th colspan="3">${dto.em_title }</th>
				  </tr>
				  <tr>
				    <td>이름 : ${dto.em_name }</td>
				    <td>등록일 : ${dto.em_date }</td>
				    <td>답변상태 : 
				    <c:set var="em_check" value="${dto.em_check }"></c:set>
				    
				    <c:choose>
				    	<c:when test="${em_check eq 'A' }">
					    	<select name="em_check" id="em_check">
					    		<option value="A" selected>미답변</option>
					    		<option value="B">답변완료</option>
					    	</select>
				    	</c:when>
				    	<c:when test="${em_check eq 'B' }">
					    	<select name="em_check" id="em_check">
					    		<option value="A">미답변</option>
					    		<option value="B" selected>답변완료</option>
					    	</select>
				    	</c:when>
				    </c:choose>
				    </td>
				  </tr>
				  <tr>
				    <td colspan="3">
						<% pageContext.setAttribute("enter","\n"); %>
						<p>${fn:replace(fn:replace(fn:escapeXml(dto.em_cont), enter, '<br/>') , ' ', ' ')}</p>
				    </td>
				  </tr>
				  <tr>
				  	<td colspan="3">이메일 : ${dto.em_email }</td>
				  </tr>
				    
				  <tr>
				  	<td colspan="3">
				  		<c:if test="${dto.em_filesize!=0 }">
				  		<a href="/pinetree/contact/storage/${dto.em_filename }">첨부파일 : ${dto.em_filename }</a>
				  		</c:if>
				  	</td>
				  </tr>
				</table>
        </div>
        <div class="text-center">
          <input type="submit" class="btn btn-primary" value="답변완료">	
          <a href="/pinetree/contact/emailList.do" class="btn btn-secondary">List</a>
        </div>
    </div>
</section>

</form>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
