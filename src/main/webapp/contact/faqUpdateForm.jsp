<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 -->
<div class="hero-wrap" style="background-image: url('../images/bg_1.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
          <div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
          	<div class="text">
	            <p class="breadcrumbs mb-2"><span class="mr-2"><a href="/pinetree/index.do">Home</a></span> <span>FAQ</span></p>
	            <h1 class="mb-4 bread">FAQ</h1>
            </div>
          </div>
        </div>
      </div>
</div>

<section class="ftco-section">
	<div class="container">
        <div class="col-md-8" style="margin: 0 auto">
			<form name="faqForm"
					  method="get"
					  action="/pinetree/contact/faqupdateproc.do"
					  onsubmit="return typeCheck(this)">
					  <input type="hidden" name="fq_num" id="fq_num" value="${dto.fq_num }">
					<table class="table table-hover">
						
						<tr>
							<th>제목</th>
							<td><input type="text" class="form-control" name="fq_title" size="10" maxlength="20" value="${dto.fq_title }"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea rows="5" class="form-control" cols="30" name="fq_cont">${dto.fq_cont }</textarea></td>
						</tr>
						<tr>
							<th>문의 유형</th>
							<td>
							  	<select name="fq_type" class="form-control" id="fq_type">
							      <option value="0" selected>선택하세요.</option>
							      <option value="F001">예약</option>
							      <option value="F002">멤버십</option>
							      <option value="F003">다이닝</option>
							      <option value="F004">취소/환불</option>
							      <option value="F005">기타</option>
							    </select>
							</td>						
						</tr>
					</table>  
						<div class="form-group text-center">
						<input type="submit" class="btn btn-primary" value="전송">
						<input type="reset" class="btn btn-danger" value="취소">
					</div>
				</form>
        </div>
    </div>
</section>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
