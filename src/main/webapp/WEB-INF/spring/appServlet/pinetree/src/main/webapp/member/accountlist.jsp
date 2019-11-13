<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="hero-wrap" style="background-image: url('images/bg_1.jpg');">
	<div class="overlay"></div>
	<div class="container">
		<div
			class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
			<div
				class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
				<div class="text">
					<p class="breadcrumbs mb-2">
						<span class="mr-2"><a href="index.html">Home</a></span> <span>About</span>
					</p>
					<h1 class="mb-4 bread">회원관리</h1>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- 본문시작 -->
<table class="table">	
	<tr>
		<th>회원아이디</th>
		<th>한글이름</th>
		<th>영문이름</th>
		<th>비밀번호</th>
		<th>연락처</th>
		<th>이메일</th>
		<th>멤버쉽등급</th>
		<th>누적숙박수</th>
		<th>가입일자</th>
		<th>최종로그인</th>
	</tr>

  	<c:forEach var="dto" items="${list}">
  		<tr>
	  		<td>${dto.ac_id }</td>
			<td>${dto.ac_name_kor }</td>
			<td>${dto.ac_name_eng }</td>
			<td>${dto.ac_passwd }</td>
			<td>${dto.ac_phone }</td>
			<td>${dto.ac_email }</td>
<%
			//누적숙박수
			
			//등급
			
			//최종로그인
%>
			<td>${dto.ac_grade }</td>
			<td>${dto.ac_stay }</td>
			<td>${dto.ac_date }</td>
			<td>${dto.ac_logindate }</td>
  	    </tr>
  	</c:forEach>

</table>


<!-- 본문끝 -->

<section class="instagram pt-5">
	<div class="container-fluid">
		<div class="row no-gutters justify-content-center pb-5">
			<div class="col-md-7 text-center heading-section ftco-animate">
				<h2>
					<span>Instagram</span>
				</h2>
			</div>
		</div>
		<div class="row no-gutters">
			<div class="col-sm-12 col-md ftco-animate">
				<a href="images/insta-1.jpg" class="insta-img image-popup"
					style="background-image: url(images/insta-1.jpg);">
					<div class="icon d-flex justify-content-center">
						<span class="icon-instagram align-self-center"></span>
					</div>
				</a>
			</div>
			<div class="col-sm-12 col-md ftco-animate">
				<a href="images/insta-2.jpg" class="insta-img image-popup"
					style="background-image: url(images/insta-2.jpg);">
					<div class="icon d-flex justify-content-center">
						<span class="icon-instagram align-self-center"></span>
					</div>
				</a>
			</div>
			<div class="col-sm-12 col-md ftco-animate">
				<a href="images/insta-3.jpg" class="insta-img image-popup"
					style="background-image: url(images/insta-3.jpg);">
					<div class="icon d-flex justify-content-center">
						<span class="icon-instagram align-self-center"></span>
					</div>
				</a>
			</div>
			<div class="col-sm-12 col-md ftco-animate">
				<a href="images/insta-4.jpg" class="insta-img image-popup"
					style="background-image: url(images/insta-4.jpg);">
					<div class="icon d-flex justify-content-center">
						<span class="icon-instagram align-self-center"></span>
					</div>
				</a>
			</div>
			<div class="col-sm-12 col-md ftco-animate">
				<a href="images/insta-5.jpg" class="insta-img image-popup"
					style="background-image: url(images/insta-5.jpg);">
					<div class="icon d-flex justify-content-center">
						<span class="icon-instagram align-self-center"></span>
					</div>
				</a>
			</div>
		</div>
	</div>
</section>


<%@ include file="../footer.jsp"%>
