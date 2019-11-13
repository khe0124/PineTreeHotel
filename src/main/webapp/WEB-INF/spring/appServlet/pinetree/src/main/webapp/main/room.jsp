<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>
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
					<h1 class="mb-4 bread">Rooms</h1>
				</div>
			</div>
		</div>
	</div>
</div>


<section class="ftco-section bg-light">
	<div class="container">
		<div class="row">

			<div class="col-lg-9">
				<div class="row">

					<div class="col-sm col-md-6 col-lg-4 ftco-animate">
						<div class="room">
							<a href="room/familiysuite.do"
								class="img d-flex justify-content-center align-items-center"
								style="background-image: url(images/room-1.jpg);">
								<div
									class="icon d-flex justify-content-center align-items-center">
									<span class="icon-search2"></span>
								</div>
							</a>
							<div class="text p-3 text-center">
								<h3 class="mb-3">Familiy Suite</h3>
								<p>
									<span class="price mr-2">500,000원</span> <span class="per">1박</span>
								</p>
								<ul class="list">
									<li><span>최대:</span> 4명</li>
									<li><span>뷰:</span> 오션뷰 / 시티뷰</li>
									<li><span>침대 수:</span> 3개</li>
								</ul>
								<hr>
								<p class="pt-1">
									<a href="room/familiysuite.do" class="btn-custom">예약하기 <span
										class="icon-long-arrow-right"></span></a>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm col-md-6 col-lg-4 ftco-animate">
						<div class="room">
							<a href="room/twinsuite.do"
								class="img d-flex justify-content-center align-items-center"
								style="background-image: url(images/room-2.jpg);">
								<div
									class="icon d-flex justify-content-center align-items-center">
									<span class="icon-search2"></span>
								</div>
							</a>
							<div class="text p-3 text-center">
								<h3 class="mb-3">Twin Suite</h3>
								<p>
									<span class="price mr-2">400,000원</span> <span class="per">1박</span>
								</p>
								<ul class="list">
									<li><span>최대:</span> 2명</li>
									<li><span>뷰:</span> 오션뷰 / 시티뷰</li>
									<li><span>침대 수:</span> 2개</li>
								</ul>
								<hr>
								<p class="pt-1">
									<a href="room/twinsuite.do" class="btn-custom">예약하기 <span
										class="icon-long-arrow-right"></span></a>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm col-md-6 col-lg-4 ftco-animate">
						<div class="room">
							<a href="room/doublesuite.do"
								class="img d-flex justify-content-center align-items-center"
								style="background-image: url(images/room-3.jpg);">
								<div
									class="icon d-flex justify-content-center align-items-center">
									<span class="icon-search2"></span>
								</div>
							</a>
							<div class="text p-3 text-center">
								<h3 class="mb-3">Double Suite</h3>
								<p>
									<span class="price mr-2">400,000원</span> <span class="per">1박</span>
								</p>
								<ul class="list">
									<li><span>최대:</span> 2명</li>
									<li><span>뷰:</span> 오션뷰 / 시티뷰</li>
									<li><span>침대 수:</span> 1개</li>
								</ul>
								<hr>
								<p class="pt-1">
									<a href="room/doublesuite.do" class="btn-custom">예약하기 <span
										class="icon-long-arrow-right"></span></a>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm col-md-6 col-lg-4 ftco-animate">
						<div class="room">
							<a href="room/twindeluxe.do"
								class="img d-flex justify-content-center align-items-center"
								style="background-image: url(images/room-4.jpg);">
								<div
									class="icon d-flex justify-content-center align-items-center">
									<span class="icon-search2"></span>
								</div>
							</a>
							<div class="text p-3 text-center">
								<h3 class="mb-3">Twin Deluxe</h3>
								<p>
									<span class="price mr-2">250,000원</span> <span class="per">1박</span>
								</p>
								<ul class="list">
									<li><span>최대:</span> 2명</li>
									<li><span>뷰:</span> 오션뷰 / 시티뷰</li>
									<li><span>침대 수:</span> 2개</li>
								</ul>
								<hr>
								<p class="pt-1">
									<a href="room/twindeluxe.do" class="btn-custom">예약하기 <span
										class="icon-long-arrow-right"></span></a>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm col-md-6 col-lg-4 ftco-animate">
						<div class="room">
							<a href="room/twinsuite.do"
								class="img d-flex justify-content-center align-items-center"
								style="background-image: url(images/room-5.jpg);">
								<div
									class="icon d-flex justify-content-center align-items-center">
									<span class="icon-search2"></span>
								</div>
							</a>
							<div class="text p-3 text-center">
								<h3 class="mb-3">Double Deluxe</h3>
								<p>
									<span class="price mr-2">250,000원</span> <span class="per">1박</span>
								</p>
								<ul class="list">
									<li><span>최대:</span> 2명</li>
									<li><span>뷰:</span> 오션뷰 / 시티뷰</li>
									<li><span>침대 수:</span> 1개</li>
								</ul>
								<hr>
								<p class="pt-1">
									<a href="room/doubledeluxe.do" class="btn-custom">예약하기 <span
										class="icon-long-arrow-right"></span></a>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm col-md-6 col-lg-4 ftco-animate">
						<div class="room">
							<a href="room/doublestandard.do"
								class="img d-flex justify-content-center align-items-center"
								style="background-image: url(images/room-6.jpg);">
								<div
									class="icon d-flex justify-content-center align-items-center">
									<span class="icon-search2"></span>
								</div>
							</a>
							<div class="text p-3 text-center">
								<h3 class="mb-3">Double Standard</h3>
								<p>
									<span class="price mr-2">250,000원</span> <span class="per">1박</span>
								</p>
								<ul class="list">
									<li><span>최대:</span> 2명</li>
									<li><span>뷰:</span> 오션뷰 / 시티뷰</li>
									<li><span>침대 수:</span> 1개</li>
								</ul>
								<hr>
								<p class="pt-1">
									<a href="room/doublestandard.do" class="btn-custom">예약하기 <span
										class="icon-long-arrow-right"></span></a>
								</p>
							</div>
						</div>
					</div>

				</div>
			</div>

			<div class="col-lg-3 sidebar">
				<div class="sidebar-wrap bg-light ftco-animate">
					<h3 class="heading mb-4">객실 검색</h3>
					<form method="post" action="rmselect.do" onsubmit="return roomnameck()">
						<div class="fields">
							<div class="form-group">
								<input type="text" id="cart_chin"
									class="form-control checkin_date" placeholder="체크인 날짜">
							</div>
							<div class="form-group">
								<input type="text" id="cart_chout"
									class="form-control checkout_date" placeholder="체크아웃 날짜">
							</div>
							<div class="form-group">
								<div class="select-wrap one-third">
									<div class="icon">
										<span class="ion-ios-arrow-down"></span>
									</div>
									<select name="room_name" id="room_name" class="form-control">
										<option value="">객실 타입</option>
										<option value="1">Family Suite</option>
										<option value="2">Twin Suite</option>
										<option value="3">Double Suite</option>
										<option value="4">Twin Deluxe</option>
										<option value="5">Double Deluxe</option>
										<option value="6">Double Standard</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="select-wrap one-third">
									<div class="icon">
										<span class="ion-ios-arrow-down"></span>
									</div>
									<select name="room_num" id="room_num" class="form-control">
										<option value="">객실수</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="select-wrap one-third">
									<div class="icon">
										<span class="ion-ios-arrow-down"></span>
									</div>
									<select name="ad_num" id="ad_num" class="form-control">
										<option value="">어른 수</option>
										<option value="0">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="select-wrap one-third">
									<div class="icon">
										<span class="ion-ios-arrow-down"></span>
									</div>
									<select name="bb_num" id="bb_num" class="form-control">
										<option value="">아이</option>
										<option value="0">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<input type="submit" value="Search"
									class="btn btn-primary py-3 px-5">
							</div>
						</div>
					</form>
<!-- <script>
/* 객실타입선택 */
function roomnameck(f){
	var rn=f.room_name.value;
	rn=rn.trim();
	
	if(rn==1){
		location.href="room/familiysuite.do";
	}else if(rn==2){
		location.href="room/twinsuite.do";
	}else if(rn==3){
		location.href="room/doublesuite.do";
	}else if(rn==4){
		location.href="room/twindeluxe.do";
	}else if(rn==5){
		location.href="room/doubledeluxe.do";
	}else if(rn==6){
		location.href="room/doublestandard.do";
		return false;
	}//if end
	return true;
}//

/* 각 셀렉트값 넘기기 */
/* var target=document.getElementById("room_name");
alert('선택된옵션text값='+target.options[target.selectedIndex].text);
alert('선택된옵션value값='+target.options[target.selectedIndex].value);

var target=document.getElementById("room_num");
alert('선택된옵션text값='+target.options[target.selectedIndex].text);
alert('선택된옵션value값='+target.options[target.selectedIndex].value);

var target=document.getElementById("ad_num");
alert('선택된옵션text값='+target.options[target.selectedIndex].text);
alert('선택된옵션value값='+target.options[target.selectedIndex].value);

var target=document.getElementById("bb_num");
alert('선택된옵션text값='+target.options[target.selectedIndex].text);
alert('선택된옵션value값='+target.options[target.selectedIndex].value); */



</script> -->
				</div>
			</div>
		</div>
	</div>
</section>


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


<%@ include file="../main/footer.jsp"%>
