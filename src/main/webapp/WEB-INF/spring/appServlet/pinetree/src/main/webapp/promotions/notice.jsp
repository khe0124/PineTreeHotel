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
	<a href="/pinetree/promotions/noticeForm.do"><strong>Write</strong></a>
        <div class="row d-flex">
        
        
        	<form>
        		<table>
        		<tr>
        			<th>글번호</th>
        			<th>제목</th>
        			<th>내용</th>
        			<th>등록일</th>
        			<th>파일명</th>
        			
        			
        		</tr>
        		
        		<c:forEach var="dto" items="${nt_list}">
					<tr>
						<td>${dto.nt_num }</td>
						<td><a href="noticeRead.do?nt_num=${dto.nt_num }">${dto.nt_title }</a></td>
						<td>${dto.nt_cont}</td>
						<td>${dto.nt_date }</td>
						<td>
							${dto.nt_filename }<br>
							<c:set var="nt_filesize" value="${dto.nt_filesize/1024 }"></c:set>
							<c:set var="nt_filesize" value="${fn:substringBefore(nt_filesize,'.') }"></c:set>
							${nt_filesize }KB
							<input type="button" value="Edit" onclick="Location.href='nt_update.do?nt_num=${dto.nt_num}'">
							<input type="button" value="Remove" onclick="Location.href='nt_delete.do?nt_num=${dto.nt_num}'">
							
						</td>
							
						
						
					</tr>        		
        		</c:forEach>
        		
        		
        		</table>
        		
        		
        	</form>
        	
        	
        </div>
    </div>
</section>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
