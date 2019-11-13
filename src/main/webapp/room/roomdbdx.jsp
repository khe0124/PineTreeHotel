<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<%
 String room = request.getParameter("room_name");
 String ri = request.getParameter("room_id");
%>
<div class="hero-wrap" style="background-image: url('../images/bg_1.jpg');">
	<div class="overlay"></div>
	<div class="container">
		<div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
			<div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
				<div class="text">
					<p class="breadcrumbs mb-2"><span class="mr-2"><a href="index.do">Home</a></span> <span>About</span></p>
					<h1 class="mb-4 bread">Double Deluxe</h1>
				</div>
			</div>
		</div>
	</div>
</div>

	<!-- section -->
	<section class="ftco-section">
		<div class="container">
			<div class="row">

				<!-- 객실상세정보 -->
				<div class="col-lg-9">
					<div class="row">

						<div class="col-md-12 ftco-animate">
							<h2 class="mb-4">더블 디럭스</h2>
							<div class="row">
								<figure>
									<img src="../images/room-1.jpg" width="100%">
								</figure>
							</div>
						</div>

						<div class="row">
							<div class="col=md-12">
								<div style="padding:25px;"></div>
							</div>
						</div>
												
						<!-- 객실특징 -->
						<div class="container">
							<h3 align="center">Double Deluxe 상세정보</h3>
							<div class="row">
								<div class="col-md-4">
									<div class="thumbnail">
										<img src="../images/room-2.jpg" alt="Lights"
											style="width: 100%">
										<div class="caption">
											<p>아늑하고 프라이빗한 공간, 사색적인 분위기의 객실로, 파인트리의 격조 높은 서비스를 경험하실 수
												있습니다.</p>
											<p>심플하고 모던한 분위기 아래 편안한 라이프 스타일을 반영한 이곳은 비즈니스를 위해 방문한
												고객이나, 여가를 즐기는 고객 모두가 만족할 수 있습니다.</p>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="thumbnail">
										<img src="../images/room-3.jpg" alt="Nature"
											style="width: 100%">
										<div class="caption">
											<p>프라이빗피치의 아름다운 경관이 펼쳐지는 오션뷰와 화려한 도시의 느낌을 즐길 수 있는 시티뷰 중
												어떤 선택을 하셔도 최상의 휴식을 제공합니다.</p>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="thumbnail">
										<img src="../images/room-4.jpg" alt="Fjords"
											style="width: 100%">
										<div class="caption">
											<p>안락한 반원형 형태의 소파를 중심으로 영화를 감상할 수 있는 미디어 룸을 갖춘 패밀리 스위트는
												가족 또는 지인들과 소중한 추억을 보내기 좋은 최적의 객실입니다.</p>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-md-12 room-single mt-4 mb-5 ftco-animate">
							<div class="d-md-flex mt-5 mb-5">
								<ul class="list">
									<li><span>최대:</span> 4명</li>
								</ul>
								<ul class="list ml-md-5">
									<li><span>뷰:</span> 오션뷰 / 시티뷰</li>
								</ul>
								<ul class="list ml-md-5">
									<li><span>침대 수:</span> 3개</li>
								</ul>
							</div>
						</div>

						<div class="col-md-12 ftco-animate">
							<h2 class="mb-4" align="center">객실 내부 사진</h2>
							<div class="single-slider owl-carousel">
								<div class="item">
									<div class="room-img"
										style="background-image: url(../images/room-1.jpg);"></div>
								</div>
								<div class="item">
									<div class="room-img"
										style="background-image: url(../images/room-2.jpg);"></div>
								</div>
								<div class="item">
									<div class="room-img"
										style="background-image: url(../images/room-3.jpg);"></div>
								</div>
							</div>
						</div>

						<!-- 예약하기버튼 -->
						<div class="col-md-12 room-single ftco-animate mb-5 mt-5"
							align="center">
							<div class="btn-group">
								<button type="button" class="btn btn-primary">예약하기</button>
							</div>
						</div>
	
						<!-- 다른 예약가능한방 -->
						<div class="col-md-12 room-single ftco-animate mb-5 mt-5">
							<h4 class="mb-4">다른 객실 둘러보기</h4>
							<div class="row">
								<div class="col-sm col-md-4 ftco-animate">
									<div class="room">
										<a href="./twinsuite.do"
											class="img img-2 d-flex justify-content-center align-items-center"
											style="background-image: url(../images/room-1.jpg);">
											<div
												class="icon d-flex justify-content-center align-items-center">
												<span class="icon-search2"></span>
											</div>
										</a>
										<div class="text p-4 text-center">
											<h3 class="mb-3">Twin Suite</h3>
											<p>
												<span class="price mr-2">450,000원</span> <span class="per">1박</span>
											</p>
											<hr>
											<p class="pt-1">
												<a href="./twinsuite.do" class="btn-custom">객실 상세보기 <span
													class="icon-long-arrow-right"></span></a>
											</p>
										</div>
									</div>
								</div>
								<div class="col-sm col-md-4 ftco-animate">
									<div class="room">
										<a href="./doublesuite.do"
											class="img img-2 d-flex justify-content-center align-items-center"
											style="background-image: url(../images/room-2.jpg);">
											<div
												class="icon d-flex justify-content-center align-items-center">
												<span class="icon-search2"></span>
											</div>
										</a>
										<div class="text p-4 text-center">
											<h3 class="mb-3">Double Suite</h3>
											<p>
												<span class="price mr-2">400,000원</span> <span class="per">1박</span>
											</p>
											<hr>
											<p class="pt-1">
												<a href="./doublesuite.do" class="btn-custom">객실 상세보기 <span
													class="icon-long-arrow-right"></span></a>
											</p>
										</div>
									</div>
								</div>
								<div class="col-sm col-md-4 ftco-animate">
									<div class="room">
										<a href="./twindeluxe.do"
											class="img img-2 d-flex justify-content-center align-items-center"
											style="background-image: url(../images/room-3.jpg);">
											<div
												class="icon d-flex justify-content-center align-items-center">
												<span class="icon-search2"></span>
											</div>
										</a>
										<div class="text p-4 text-center">
											<h3 class="mb-3">Twin Deluxe</h3>
											<p>
												<span class="price mr-2">250,000원</span> <span class="per">1박</span>
											</p>
											<hr>
											<p class="pt-1">
												<a href="./twindeluxe.do" class="btn-custom">객실 상세보기 <span
													class="icon-long-arrow-right"></span></a>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<!-- BOOKING -->
				<div class="col-lg-3 sidebar">
					<div class="sidebar-wrap bg-light ftco-animate">
						<h3 class="heading mb-4">객실 바로예약</h3>
						<%
						if(ri == null){	
							out.print("<form method='get' action='./roomresult.do'>");
						} else {
							out.print("<form method='post' action='../reservation.do'>");
						}
						 %>
							<div class="fields">
								<div class="form-group">
								<label for="daterange">체크인 날짜</label>
					    			<input type="date" class="form-control" name="cart_chin" id="cart_chin" value=${s_chin }>
								</div>
								<div class="form-group">
								<label for="daterange">체크아웃 날짜</label>
					    			<input type="date" class="form-control" name="cart_chout" id="cart_chout" value=${s_chout }>
								</div>
								<div class="form-group">
								<label for="room_name">객실 타입</label>
									<div class="select-wrap one-third">
										<input type="text" class="form-control" value="더블 디럭스" readonly>
										<input type="hidden" name="room_name" id="room_name" class="form-control" value="DE" readonly>
										<input type="hidden" name="room_id" id="room_id" class="form-control" value=<%=ri%> readonly>
										<input type="hidden" name ="ac_id" id="ac_id" value="${s_id }" >
									</div>
								</div>
								<div class="form-group">
								<label for="cart_oprm">객실수</label>
									<div class="select-wrap one-third">
										<div class="icon">
											<span class="ion-ios-arrow-down"></span>
										</div>										
										<select name="cart_oprm" id="cart_oprm" class="form-control">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
										</select>
									</div>
								</div>
								<div class="form-group">
								<label for="cart_adno">성인</label>
									<div class="select-wrap one-third">
										<div class="icon">
											<span class="ion-ios-arrow-down"></span>
										</div>
										<select name="cart_adno" id="cart_adno" class="form-control">
											<option value="1">어른 1</option>
											<option value="2">어른 2</option>
										</select>
									</div>
								</div>
								<div class="form-group">
								<label for="cart_bbno">어린이</label>
									<div class="select-wrap one-third">
										<div class="icon">
											<span class="ion-ios-arrow-down"></span>
										</div>
										<select name="cart_bbno" id="cart_bbno" class="form-control">
											<option value="0">아이 0</option>
											<option value="1">아이 1</option>
											<option value="2">아이 2</option>
										</select>
									</div>
								</div>
								<%
								if(ri == null){									
									out.print("<div class='form-group'>");
									out.print("<input type='submit' value='객실검색' class='btn btn-primary py-3 px-5'>");
									out.print("</div>");
								} else {
									out.print("<div class='form-group'>");
									out.print("<input type='submit' value='예약하기' class='btn btn-primary py-3 px-5'>");
									out.print("<a href='../room.do' class='btn btn-outline-secondary py-3 px-5'>다른날짜 다시검색</a>");
									out.print("</div>");
								}
								%>			
							</div>
						</form>
					</div>
				</div>
				<!-- BOOKING -->
			</div>
		</div>
	</section>
	<!-- .section -->


	<%@ include file="../footer.jsp"%>