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
        <!--  -->
        	<form name="noticeForm"
				  method="post"
				  action="/pinetree/promotions/noticeCreate.do"
				  enctype="multipart/form-data">
				<table class="table table-hover">
					<tr>
						<th>제목</th>
						<td><input type="text" class="form-control" name="nt_title" size="30" maxlength="100" class="form_input" ></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="5" class="form-control" cols="30" name="nt_cont" class="form_input"></textarea></td>
					</tr>
					<tr>
					<tr>
				      <th>파일첨부</th>
				      <td><input type='file' name='file' size='50'></td>    
					</tr>
					<tr>
						<td colspan="2" style="text-align:center;">
						<input type="submit" class="btn btn-primary" value="작성">
						<input type="reset" class="btn btn-danger" value="취소" onclick="location.href='./notice.do'">
						</td>
					</tr>
				</table> 
			</form>
			<!--  -->
        </div>
    </div>
</section>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
