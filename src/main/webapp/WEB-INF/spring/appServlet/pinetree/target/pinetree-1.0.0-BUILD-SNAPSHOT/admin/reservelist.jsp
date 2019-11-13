<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<%@ include file="../header.jsp"%>

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
					<h1 class="mb-4 bread">예약리스트</h1>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- 본문시작 -->
<table class="table">
  	<tr>
  		<td>
	  		<input type="button" value="예약생성" onclick="location.href='reservecreate.do'">
	  		<input type="button" value="예약수정" onclick="location.href='reserveupdate.do?od_no=${dto.od_no}'">
	  		<input type="button" value="예약삭제" onclick="location.href='reservedelete.do?od_no=${dto.od_no}'">
		</td>
	</tr>
	
	<tr>
		<th>예약번호</th>
		<th>예약날짜</th>
		<th>예약아이디</th>
		<th>객실번호</th>
		<th>체크인</th>
		<th>체크아웃</th>
		<th>어른수</th>
		<th>아이수</th>
		<th>침대수</th>
		<th>결제금액</th>
		<th>예약상태</th>
		<th>수정/삭제</th>
	</tr>

  	<c:forEach var="dto" items="${list}">
  		<tr>
  			<td>${dto.od_no }</td>
  			<td>${dto.cart_date }</td>
  			<td>${dto.ac_id }</td>
  			<td>${dto.room_id }</td>
  			<td>${dto.cart_chin }</td>
  			<td>${dto.cart_chout }</td>
  			<td>${dto.cart_op_ad }</td>
  			<td>${dto.cart_op_bb }</td>
  			<td>${dto.cart_op_bed }</td>
  			<td>${dto.od_total }</td>
  			<td>${dto.od_now }</td>
   			<td>
  				<input type="button" value="수정" onclick="location.href='reserveupdate.do?mediano=${dto.od_no}'">
  				<input type="button" value="삭제" onclick="location.href='reservedelete.do?mediano=${dto.od_no}'">
  			</td>
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
