<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 -->
<div class="hero-wrap" style="background-image: url('../images/bg_1.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
          <div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
          	<div class="text">
	            <p class="breadcrumbs mb-2"><span class="mr-2"><a href="/pinetree/index.do">Home</a></span> <span>Mail</span></p>
	            <h1 class="mb-4 bread">Mail</h1>
            </div>
          </div>
        </div>
      </div>
</div>

<section class="ftco-section">
	<div class="container">
        <div class="row d-flex">
        	
			<form method="post"
				  action="/pinetree/contact/emailProc.do"
				  enctype="multipart/form-data">
				
				<table class="table table-hover">
				<tr>
					<th>이름</th>
					<td><input type="text" name="em_name" class="form_input"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="em_email" class="form_input"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="em_title" class="form_input"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="10" cols="50" name="em_cont" class="form_input"></textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file"  name="file"></td>
				</tr>
				</table>
				
				<input type="submit" value="전송">
				<input type="reset" value="취소">
			</form>       	

        </div>
    </div>
</section>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
