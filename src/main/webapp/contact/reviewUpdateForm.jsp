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

<section class="ftco-section">
	<div class="container">
        <div class="col-md-8" style="margin: 0 auto">
        <!--  -->
        	<form name="reviewForm"
				  method="post"
				  action="/pinetree/contact/reviewUpdateProc.do"
				  enctype="multipart/form-data"
				  onsubmit="return reviewCheck2(this)">
				<input type="hidden" name="re_num" value="${re_num }">  
				<table class="table table-hover">
					<tr>
						<th>작성자</th>
						<td><input type="text" class="form-control" name="ac_id" size="10" maxlength="20" value="${dto.ac_id }" class="form_input" readonly></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" class="form-control" name="re_title" size="30" maxlength="100" value="${dto.re_title }" class="form_input" ></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="5" class="form-control" cols="30" name="re_cont" class="form_input">${dto.re_title }</textarea></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" class="form-control" name="re_passwd" size="10" maxlength="10" class="form_input"></td>
					</tr>
					<tr>
					<tr>
				      <th>파일첨부</th>
				      <td><input type='file' class="form-control" name='file' size='50'></td>    
					</tr>
					
				</table>  
					<div class="form-group text-center">
						<input type="submit" class="btn btn-primary" value="전송">
						<input type="reset" class="btn btn-danger" value="취소">
					</div>
			</form>
			<!--  -->
        </div>
    </div>
</section>

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
