<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 -->
<div class="hero-wrap" style="background-image: url('../images/bg_1.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
          <div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
          	<div class="text">
	            <p class="breadcrumbs mb-2"><span class="mr-2"><a href="/pinetree/index.do">Home</a></span> <span>MyPage</span></p>
	            <h1 class="mb-4 bread">MyPage</h1>
            </div>
          </div>
        </div>
      </div>
</div>

<section class="ftco-section">
	<div class="container">
        <div class="row d-flex">
			
			<c:if test="${dto==null }">
				<p>회원정보가 없습니다.</p>
			</c:if>
			
			<c:if test="${dto!=null }">
				
				<table class="table">
					<tr>
						<th>회원아이디</th>
						<td>${dto.ac_id }</td>
					</tr>
					<tr>
						<th>한글이름</th>
						<td>${dto.ac_name_kor }</td>
					</tr>
					<tr>
						<th>영문이름</th>
						<td>${dto.ac_name_eng }</td>
					</tr>
					<tr>
						<th>연락처</th>
						<td>${dto.ac_phone }</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${dto.ac_email }</td>
					</tr>
					<tr>
						<th>멤버쉽등급</th>
						<c:choose>
			        		<c:when test="${dto.ac_grade eq '1' }">
			        			<td>Classic</td>
			        		</c:when>
			        		<c:when test="${dto.ac_grade eq '2' }">
			        			<td>Plus</td>
			        		</c:when>
			        		<c:when test="${dto.ac_grade eq '3' }">
			        			<td>Premium</td>
			        		</c:when>
			        	</c:choose>
					</tr>
					<tr>
						<th>누적숙박수</th>
						<td>${dto.ac_stay }</td>
					</tr>
					<tr>
						<th>가입일자</th>
						<td>${dto.ac_date }</td>
					</tr>
					<tr>
						<th>최종로그인</th>
						<td>${dto.ac_logindate }</td>
					</tr>
					<tr>
				  		<td colspan ="2">
					  		<input type="button" value="정보수정" onclick="location.href='memberupdate.do'">
					  		<input type="button" value="회원탈퇴" onclick="location.href='memberdelete.do'">
						</td>
					</tr>
				</table>
				
			
			</c:if>
			
        </div>
    </div>
</section>

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
