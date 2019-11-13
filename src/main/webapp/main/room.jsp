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
<section class="ftco-booking-in">
    	<div class="container">
    		<div class="row">
    			<div class="col-lg-12">
    				<form method="get" action="room/roomresult.do" name="srcfrm" id="srcfrm" class="booking-form">
	        		<div class="row">
	        			<div class="col-md-3 d-flex">
	        				<div class="form-group p-4 align-self-stretch d-flex align-items-end">
	        					<div class="wrap">
				    					<label for="daterange">체크인 날짜</label>
				    					<input type="date" class="form-control" name="cart_chin" id="cart_chin">
				    					<input type="date" class="form-control" name="cart_chout" id="cart_chout">
			    					</div>
			    				</div>
						</div>	     								

	        			<div class="col-md d-flex">
	        				<div class="form-group p-4 align-self-stretch d-flex align-items-end">
	        					<div class="wrap">
			      					<label for="room_name">객실</label>
			      					<div class="form-field">
				        			<div class="select-wrap">
				                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
					                    <select name="room_name" id="room_name" onchange="setValuesRoom();" class="form-control">
											<option value="">객실 타입</option>
											<option value="SU">Suite</option>
											<option value="DE">Deluxe</option>
											<option value="ST">Standard</option>											
										</select>
					                  </div>
					              </div>
								</div>
		              		</div>
	        			</div>
	        			
	        			<!-- 객실수 -->
						<div class="col-md d-flex">
	        				<div class="form-group p-4 align-self-stretch d-flex align-items-end">
	        					<div class="wrap">
							<label for="cart_oprm">객실수</label>
							<div class="form-field">
								<div class="select-wrap">
								<div class="icon"><span class="ion-ios-arrow-down"></span></div>
								<select name="cart_oprm" id="cart_oprm" class="form-control">
								  <option value="1">1</option>
								  <option value="2">2</option>
								  <option value="3">3</option>
								</select>
							  </div>
							</div>
						  </div>
		             	  </div>
	        			</div>
	        			
	        			<div class="col-md d-flex">
	        				<div class="form-group p-4 align-self-stretch d-flex align-items-end">
	        					<div class="wrap">
			      					<label for="cart_adno">성인</label>
			      					<div class="form-field">
			        					<div class="select-wrap">
			                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
			                    <select name="cart_adno" id="cart_adno" class="form-control">
			                    	<option value="1">1 인</option>
			                      <option value="2">2 인</option>
			                    </select>
			                  </div>
				              </div>
				            </div>
				            <div class="wrap">
			      					<label for="cart_bbno">어린이</label>
			      					<div class="form-field">
			        					<div class="select-wrap">
			                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
			                    <select name="cart_bbno" id="cart_bbno" class="form-control">
			                    	<option value="0">0 인</option>
			                    	<option value="1">1 인</option>
			                      <option value="2">2 인</option>
			                    </select>
			                  </div>
				              </div>
				            </div>        
		              </div>
						</div>

	        			<div class="col-md d-flex">
	        				<div class="form-group d-flex align-self-stretch">
			              <input type="submit" value="객실검색" class="btn btn-primary py-3 px-4 align-self-stretch">
			            </div>
	        			</div>
	        		</div>
	        	</form>
	    		</div>
    		</div>
    	</div>
    </section>			

<!-- Rooms 전체 안내   -->
<section class="ftco-section bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
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
							<a href="room/doubledeluxe.do"
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
		</div>
	</div>
</section>
<%@ include file="../main/footer.jsp"%>