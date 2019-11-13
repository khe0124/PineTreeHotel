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
					<h1 class="mb-4 bread">Notice</h1>
				</div>
			</div>
		</div>
	</div>
</div>

<section class="ftco-section">
	<div class="container">
		<div class="row d-flex">
			<form method="post" action="./noticeUpdate.do"
				enctype="multipart/form-data">
				<input type="hidden" name="nt_num" value="${dto.nt_num }">
				<table align='center' border='1px' cellspacing='0px'
					cellpadding='5px'>
					<tr>
						<th>제목</th>
						<td><input type='text' name='nt_title' size="30"
							maxlength="100" class="form_input" value='${dto.nt_title }'></td>
					</tr>
					<tr>
						<th>내용</th>

						<td><textarea rows="5" cols="35" name="nt_cont">${dto.nt_cont }</textarea></td>


					</tr>
					<tr>
						<th>파일</th>
						<td><input type='file' name='file' size='50'>
						</td>
					</tr>
				</table>
				
				<div class='bottom'>
					<input type='submit' value='수정' > 
					<input type='button' value='취소' onclick="location.href='./notice.do'">
				</div>
			</form>
		</div>
	</div>
</section>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
