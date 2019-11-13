<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../member/auth.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>PINETREE HOTEL | 최고의 휴양지 파인트리호텔 </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR|Noto+Serif+KR&display=swap" rel="stylesheet">
	
    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/aos.css">
    <link rel="stylesheet" href="css/ionicons.min.css">
    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">
    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/simple-sidebar.css" >
	<link rel="stylesheet" href="css/style.css"  type="text/css">
	<link rel="stylesheet" href="css/custom.css"  type="text/css">
	<link rel="stylesheet" type="text/css" href="css/daterangepicker.css" />
  </head>
  <body>
	    <!-- nav start -->
    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="/pinetree/index.do">
			<img src="images/pinetree.png" alt="logo">
		  </a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>	      

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><a href="/pinetree/index.do" class="nav-link">Home</a></li>
	          <li class="nav-item dropdown">
	          <a href="/pinetree/room.do" class="nav-link dropdown-toggle" data-hover="dropdown">Rooms</a>
	          <ul class="dropdown-menu">
                <li><a href="/pinetree/room/doublestandard.do">Standard Double</a></li>
                <li><a href="/pinetree/room/doubledeluxe.do">Double Deluxe</a></li>
                <li><a href="/pinetree/room/twindeluxe.do">Twin Deluxe</a></li>
                <li><a href="/pinetree/room/doublesuite.do">Double Suite</a></li>
                <li><a href="/pinetree/room/twinsuite.do">Twin Suite</a></li>
                <li><a href="/pinetree/room/familiysuite.do">Family Suite</a></li>
              </ul>	          
	          </li>	            
	          <li class="nav-item dropdown"><a href="/pinetree/restaurant.do" class="nav-link">Restaurant</a></li>
	          <li class="nav-item dropdown"><a href="/pinetree/about.do" class="nav-link">About</a></li>
	          <li class="nav-item dropdown">
	          <a href="/pinetree/promotions/promoList.do" class="nav-link" data-hover="dropdown">Promotions</a>
	          	<ul class="dropdown-menu">
                <li><a href="/pinetree/promotions/notice.do">공지사항</a></li>
              	</ul>	          
	          </li>
	          <li class="nav-item dropdown">
	          <a href="/pinetree/contact.do" class="nav-link" data-hover="dropdown">Contact</a>
	          <ul class="dropdown-menu">
                <li><a href="/pinetree/contact/faq.do">FAQ</a></li>
                <li><a href="/pinetree/contact/inquiry.do">1:1문의</a></li>
                <li><a href="/pinetree/contact/email.do">이메일문의</a></li>
                <li><a href="/pinetree/contact/review.do">Review</a></li>
              </ul>	          
	          </li>	   
	          <li class="nav-item"> 
		          <ul class="login-nav">
		      		<c:choose>
		      		<c:when test="${s_id == null}"> 
		      		<li><a href="/pinetree/login.do">로그인</a></li>
		      		<li><a href="/pinetree/member/join.do">회원가입</a></li>
		      		<li><a href="">예약조회</a></li>
		      		<li>${s_id}</li>
		      		</c:when>
		      		<c:when test='${s_mlevel == "6"}'> 
		      		<li><a href="/pinetree/logout.do">로그아웃</a></li>
		      		<li><a href="/pinetree/admin/adminhome.do">관리자페이지</a></li>
		      		<li>${s_id}</li>
		      		</c:when>		      		
		      		<c:otherwise> 
			      		<li><a href="/pinetree/logout.do">로그아웃</a></li>
			      		<li><a href="/pinetree/member/mypage.do">예약조회</a></li>
			      		<c:if test ='${s_mlevel == "1"}'>
			      			<li>CLASSIC</li>
			      		</c:if>
			      		<c:if test ='${s_mlevel == "2"}'>
			      			<li>PLUS</li>
			      		</c:if>	
			      		<c:if test ='${s_mlevel == "3"}'>
			      			<li>PREMIUM</li>
			      		</c:if>	   	      		
		      		</c:otherwise>
		      		</c:choose>
		      	</ul>
	      	</li>
	                          
	        </ul>
	      </div>
	  </nav>
    <!-- END nav -->
    <section class="home-slider owl-carousel">
      <div class="slider-item" style="background-image:url(images/bg_1.png);">
      	<div class="overlay"></div>
        <div class="container">
          <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-12 ftco-animate text-center">
          	<div class="text mb-5 pb-3">
	            <h1 class="mb-3">Welcome To Pinetree</h1>
	            <h2>Hotels &amp; Resorts</h2>
            </div>
          </div>
        </div>
        </div>
      </div>

      <div class="slider-item" style="background-image:url(images/bg_2.jpg);">
      	<div class="overlay"></div>
        <div class="container">
          <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-12 ftco-animate text-center">
          	<div class="text mb-5 pb-3">
	            <h1 class="mb-3">Enjoy A Luxury Experience</h1>
	            <h2>Join With Us</h2>
            </div>
          </div>
        </div>
        </div>
      </div>
    </section>
    
    <section class="ftco-booking">
    	<div class="container">
    		<div class="row">
    			<div class="col-lg-12">
    				<form method="get" action="./room/roomresult.do" name="srcfrm" id="srcfrm" class="booking-form">
	        		<div class="row">
	        			<div class="col-md-3 d-flex">
	        				<div class="form-group p-4 align-self-stretch d-flex align-items-end">
	        					<div class="wrap">
				    					<label for="daterange">체크인 날짜</label>
				    					<input type="date" class="form-control" name="cart_chin" id="cart_chin" placeholder="Check In">
				    					<input type="date" class="form-control" name="cart_chout" id="cart_chout" placeholder="Check Out">
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
  
    <section class="ftco-section ftc-no-pb ftc-no-pt">
			<div class="container">
				<div class="row">
					<div class="col-md-5 p-md-5 img img-2 d-flex justify-content-center align-items-center" style="background-image: url(images/bg_3.jpg);">
					</div>
					<div class="col-md-7 py-5 wrap-about pb-md-5 ftco-animate">
	          <div class="heading-section heading-section-wo-line pt-md-5 pl-md-5 mb-5">
	          	<div class="ml-md-0">
		          	<span class="subheading">Greetings</span>
		            <h2 class="mb-4">Pinetree Hotel</h2>
	            </div>
	          </div>
	          <div class="pb-md-5">
					<p>바다가 한 눈에 내려다 보이는 해안절벽 위에 구름처럼 자리한 
					    파인트리 호텔은 각박한 현대사회에서 쉽게 경험할 수 없는 아름다운 자연을 고객들의 삶 속에 되돌려 드립니다. 
					    자연을 우리의 삶 속에서 함께 살아 숨쉬게 하며, 이를 통해 인간의 삶에 생동감을 불어 넣습니다.
  					    강원도의 자연이 숨쉬는 공간, 바다와 산이 만나는 파인트리 호텔에서는
					    내추럴한 경험들을 통해 자연 속에서 진정한 이너피스 & 힐링 시간을 가져보십시오.</p>	
						<ul class="ftco-social d-flex">
			                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
			                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
			                <li class="ftco-animate"><a href="#"><span class="icon-google-plus"></span></a></li>
			                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
			              </ul>
						</div>
					</div>
				</div>
			</div>
		</section>

		<section class="ftco-section">
      <div class="container">
        <div class="row d-flex">
          <div class="col-md-3 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services py-4 d-block text-center">
              <div class="d-flex justify-content-center">
              	<div class="icon d-flex align-items-center justify-content-center">
              		<span class="flaticon-reception-bell"></span>
              	</div>
              </div>
              <div class="media-body p-2 mt-2">
                <h3 class="heading mb-3">25/7 Front Desk</h3>
                <p>필요한게 있으시면 항상 프론트를 찾아주세요. 고객 여러분을 위해 기다리고 있습니다.</p>
              </div>
            </div>      
          </div>
          <div class="col-md-3 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services py-4 d-block text-center">
              <div class="d-flex justify-content-center">
              	<div class="icon d-flex align-items-center justify-content-center">
              		<span class="flaticon-serving-dish"></span>
              	</div>
              </div>
              <div class="media-body p-2 mt-2">
                <h3 class="heading mb-3">Restaurant Bar</h3>
                <p>최정상급 셰프들의 예술적인 요리, 조식 부터 디너까지</p>
              </div>
            </div>    
          </div>
          <div class="col-md-3 d-flex align-sel Searchf-stretch ftco-animate">
            <div class="media block-6 services py-4 d-block text-center">
              <div class="d-flex justify-content-center">
              	<div class="icon d-flex align-items-center justify-content-center">
              		<span class="flaticon-car"></span>
              	</div>
              </div>
              <div class="media-body p-2 mt-2">
                <h3 class="heading mb-3">Transfer Services</h3>
                <p>공항까지 모셔다드리는 셔틀 서비스를 운영하고 있습니다.</p>
              </div>
            </div>      
          </div>
          <div class="col-md-3 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services py-4 d-block text-center">
              <div class="d-flex justify-content-center">
              	<div class="icon d-flex align-items-center justify-content-center">
              		<span class="flaticon-spa"></span>
              	</div>
              </div>
              <div class="media-body p-2 mt-2">
                <h3 class="heading mb-3">Spa Suites</h3>
                <p>스파를 즐기시는 고객 여러분들을 위해 고급 어메니티를 구비하고 있습니다.</p>
              </div>
            </div>      
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section bg-light">
    	<div class="container">
				<div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <h2 class="mb-4">Our Rooms</h2>
          </div>
        </div>    		
    		<div class="row">
    			<div class="col-sm col-md-6 col-lg-4 ftco-animate">
    				<div class="room">
    					<a href="rooms.html" class="img d-flex justify-content-center align-items-center" style="background-image: url(images/room-1.jpg);">
    						<div class="icon d-flex justify-content-center align-items-center">
    							<span class="icon-search2"></span>
    						</div>
    					</a>
    					<div class="text p-3 text-center">
    						<h3 class="mb-3"><a href="room/doublestandard.do">Standard Room</a></h3>
    						<p><span class="price mr-2">200,000원</span> <span class="per">1 박</span></p>
    						<hr>
    						<p class="pt-1"><a href="room/doublestandard.do" class="btn-custom">자세히 보기 <span class="icon-long-arrow-right"></span></a></p>
    					</div>
    				</div>
    			</div>
    			<div class="col-sm col-md-6 col-lg-4 ftco-animate">
    				<div class="room">
    					<a href="rooms.html" class="img d-flex justify-content-center align-items-center" style="background-image: url(images/room-2.jpg);">
    						<div class="icon d-flex justify-content-center align-items-center">
    							<span class="icon-search2"></span>
    						</div>
    					</a>
    					<div class="text p-3 text-center">
    						<h3 class="mb-3"><a href="room/doubledeluxe.do">Deluxe Room</a></h3>
    						<p><span class="price mr-2">250,000원</span> <span class="per">1 박</span></p>
    						<hr>
    						<p class="pt-1"><a href="room/doubledeluxe.do" class="btn-custom">자세히 보기 <span class="icon-long-arrow-right"></span></a></p>
    					</div>
    				</div>
    			</div>
    			<div class="col-sm col-md-6 col-lg-4 ftco-animate">
    				<div class="room">
    					<a href="rooms.html" class="img d-flex justify-content-center align-items-center" style="background-image: url(images/room-3.jpg);">
    						<div class="icon d-flex justify-content-center align-items-center">
    							<span class="icon-search2"></span>
    						</div>
    					</a>
    					<div class="text p-3 text-center">
    						<h3 class="mb-3"><a href="room/twinsuite.do">Suite Room</a></h3>
    						<p><span class="price mr-2">400,000원</span> <span class="per">1 박</span></p>
    						<hr>
    						<p class="pt-1"><a href="/pinetree/room/roomresult.do?cart_chin=&cart_chout=&room_name=SU&cart_oprm=1&cart_adno=1&cart_bbno=0" class="btn-custom">자세히 보기 <span class="icon-long-arrow-right"></span></a></p>
    					</div>
    				</div>
    			</div>    			
    		</div>
    	</div>
    </section>

   <section class="ftco-section ftco-counter img" id="section-counter" style="background-image: url(images/bg_2.jpg);">
    	<div class="container">
    		<div class="row justify-content-center">
    			<div class="col-md-10">
		    		<div class="row">
		          <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
		            <div class="block-18 text-center">
		              <div class="text">
		                <strong class="number" data-number="1534">0</strong>
		                <span>Pinetree를 찾아주신 고객분들</span>
		              </div>
		            </div>
		          </div>
		          <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
		            <div class="block-18 text-center">
		              <div class="text">
		                <strong class="number" data-number="90">0</strong>
		                <span>총 객실</span>
		              </div>
		            </div>
		          </div>
		          <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
		            <div class="block-18 text-center">
		              <div class="text">
		                <strong class="number" data-number="120">0</strong>
		                <span>직원들</span>
		              </div>
		            </div>
		          </div>
		          <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
		            <div class="block-18 text-center">
		              <div class="text">
		                <strong class="number" data-number="10000">0</strong>
		                <span>목표 고객수</span>
		              </div>
		            </div>
		          </div>
		        </div>
	        </div>
        </div>
    	</div>
    </section>


    <section class="ftco-section testimony-section bg-light">
      <div class="container">
      <div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section text-center ftco-animate fadeInUp ftco-animated">
            <h2 class="mb-4">Testimonials</h2>
          </div>
        </div>
        <div class="row justify-content-center">
          <div class="col-md-8 ftco-animate">
          	<div class="row ftco-animate">
		          <div class="col-md-12">
		            <div class="carousel-testimony owl-carousel ftco-owl">
		              <div class="item">
		                <div class="testimony-wrap py-4 pb-5">
		                  <div class="user-img mb-4" style="background-image: url(images/person_1.png)">
		                    <span class="quote d-flex align-items-center justify-content-center">
		                      <i class="icon-quote-left"></i>
		                    </span>
		                  </div>
		                  <div class="text text-center">
		                    <p class="mb-4">“직원분들이 너무 친절하시고 룸 상태도 정말 좋았어요. 특히 베딩과 베개가 너무 편해서 꿀잠잤습니다. 수영장도 아주 고급스럽고 이용하기 편했습니다”</p>
		                    <p class="name">이선영</p>
		                    <span class="position">Guests</span>
		                  </div>
		                </div>
		              </div>
		              <div class="item">
		                <div class="testimony-wrap py-4 pb-5">
		                  <div class="user-img mb-4" style="background-image: url(images/person_2.png)">
		                    <span class="quote d-flex align-items-center justify-content-center">
		                      <i class="icon-quote-left"></i>
		                    </span>
		                  </div>
		                  <div class="text text-center">
		                    <p class="mb-4">“환상적인 입지조건. 전통적인 서울을 알고 싶어하는 외국인에게 특히! 룸의 뷰와 관리상태, 서비스 정말 최고 수준입니다”</p>
		                    <p class="name">장민희</p>
		                    <span class="position">Guests</span>
		                  </div>
		                </div>
		              </div>
		              <div class="item">
		                <div class="testimony-wrap py-4 pb-5">
		                  <div class="user-img mb-4" style="background-image: url(images/person_3.png)">
		                    <span class="quote d-flex align-items-center justify-content-center">
		                      <i class="icon-quote-left"></i>
		                    </span>
		                  </div>
		                  <div class="text text-center">
		                    <p class="mb-4">최고의 시설과 오션뷰가 특히 아름다웠어요. 바다와 시가지 모두 가까이 있어서 편했고, 시설이 깨끗하고 직원분들도 친절합니다.</p>
		                    <p class="name">한아름</p>
		                    <span class="position">Guests</span>
		                  </div>
		                </div>
		              </div>
		              <div class="item">
		                <div class="testimony-wrap py-4 pb-5">
		                  <div class="user-img mb-4" style="background-image: url(images/person_4.png)">
		                    <span class="quote d-flex align-items-center justify-content-center">
		                      <i class="icon-quote-left"></i>
		                    </span>
		                  </div>
		                  <div class="text text-center">
		                    <p class="mb-4">가족들과 오기에도 너무 좋은 호텔입니다. 부모님 결혼기념일에 맞춰 예약했는데 가족 모두 만족했습니다.</p>
		                    <p class="name">이정민</p>
		                    <span class="position">Guests</span>
		                  </div>
		                </div>
		              </div>
		              <div class="item">
		                <div class="testimony-wrap py-4 pb-5">
		                  <div class="user-img mb-4" style="background-image: url(images/person_5.png)">
		                    <span class="quote d-flex align-items-center justify-content-center">
		                      <i class="icon-quote-left"></i>
		                    </span>
		                  </div>
		                  <div class="text text-center">
		                    <p class="mb-4">친구들과 놀러왔는데 아주 좋았습니다.~</p>
		                    <p class="name">석진규</p>
		                    <span class="position">Guests</span>
		                  </div>
		                </div>
		              </div>
		            </div>
		          </div>
		        </div>
          </div>
        </div>
      </div>
    </section>
  
    <section class="instagram">
      <div class="container-fluid">
        <div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section text-center ftco-animate fadeInUp ftco-animated">
            <h2 class="mb-4">Instagram</h2>
          </div>
        </div>
        <div class="row no-gutters">
          <div class="col-sm-12 col-md ftco-animate">
            <a href="images/insta-1.jpg" class="insta-img image-popup" style="background-image: url(images/insta-1.jpg);">
              <div class="icon d-flex justify-content-center">
                <span class="icon-instagram align-self-center"></span>
              </div>
            </a>
          </div>
          <div class="col-sm-12 col-md ftco-animate">
            <a href="images/insta-2.jpg" class="insta-img image-popup" style="background-image: url(images/insta-2.jpg);">
              <div class="icon d-flex justify-content-center">
                <span class="icon-instagram align-self-center"></span>
              </div>
            </a>
          </div>
          <div class="col-sm-12 col-md ftco-animate">
            <a href="images/insta-3.jpg" class="insta-img image-popup" style="background-image: url(images/insta-3.jpg);">
              <div class="icon d-flex justify-content-center">
                <span class="icon-instagram align-self-center"></span>
              </div>
            </a>
          </div>
          <div class="col-sm-12 col-md ftco-animate">
            <a href="images/insta-4.jpg" class="insta-img image-popup" style="background-image: url(images/insta-4.jpg);">
              <div class="icon d-flex justify-content-center">
                <span class="icon-instagram align-self-center"></span>
              </div>
            </a>
          </div>
          <div class="col-sm-12 col-md ftco-animate">
            <a href="../images/insta-5.jpg" class="insta-img image-popup" style="background-image: url(images/insta-5.jpg);">
              <div class="icon d-flex justify-content-center">
                <span class="icon-instagram align-self-center"></span>
              </div>
            </a>
          </div>
        </div>
      </div>
    </section>

    <footer class="ftco-footer ftco-bg-dark ftco-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            <h2 class="ftco-heading-2">Pinetree Hotel</h2>
              <p>탁 트인 바다 전경과 빛나는 야경을 함께 담은 아름다운 호텔</p>
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4 ml-md-5">
              <h2 class="ftco-heading-2">Our Service</h2>
              <ul class="list-unstyled">
                <li><a href="/pinetree/room.do" class="py-2 d-block">Rooms</a></li>
                <li><a href="/pinetree/restaurant.do" class="py-2 d-block">Restaurant</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
             <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">About</h2>
              <ul class="list-unstyled">
                <li><a href="/pinetree/about.do" class="py-2 d-block">About Us</a></li>
                <li><a href="/pinetree/contact.do" class="py-2 d-block">Contact Us</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Have a Questions?</h2>
            	<div class="block-23 mb-3">
	              <ul>
	                <li><span class="icon icon-map-marker"></span><span class="text">203 Ocean View land, Busan, Republic of Korea</span></li>
	                <li><a href="#"><span class="icon icon-phone"></span><span class="text">+82 070 1234 5678</span></a></li>
	                <li><a href="/pinetree/contact/email.do"><span class="icon icon-envelope"></span><span class="text">info@pinetree.com</span></a></li>
	              </ul>
	            </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 text-center">
            <p>Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Pintree Hotel</p>
          </div>
        </div>
      </div>
    </footer>

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>
  
	  <script src="js/jquery.min.js"></script>
	  <script src="js/jquery-migrate-3.0.1.min.js"></script>
	  <script src="js/popper.min.js"></script>
	  <script src="js/bootstrap.min.js"></script>
	  <script src="js/jquery.easing.1.3.js"></script>
	  <script src="js/jquery.waypoints.min.js"></script>
	  <script src="js/jquery.stellar.min.js"></script>
	  <script src="js/owl.carousel.min.js"></script>
	  <script src="js/jquery.magnific-popup.min.js"></script>
	  <script src="js/aos.js"></script>
	  <script src="js/jquery.animateNumber.min.js"></script>
	  <script src="js/bootstrap-datepicker.js"></script>
	  <script src="js/jquery.timepicker.min.js"></script>
	  <script src="js/scrollax.min.js"></script>
	  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6ebe91c1d39cad89656ce7fc92edc85b&libraries=services"></script>
	  <script src="js/main.js"></script>
	  <script src="js/custom.js"></script>
	  <script type="text/javascript" src="js/moment.min.js"></script>
	  <script type="text/javascript" src="js/daterangepicker.min.js"></script>	
	  <script src="js/jquery.cookie.js"></script>
	  	  
	  <script>		
	  
	  /* DateRange JQuery */
		$(function() {
		  $('input[name="daterange"]').daterangepicker({
			opens: 'left'
		  }, function(start, end, label) {
			console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
			  $("#cart_chin").val(start.format('YYYY-MM-DD'));
			  $("#cart_chout").val(end.format('YYYY-MM-DD'));
		  });
		});
	  
	  /* KAKAO MAP API */
	  var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	  mapOption = {
	      center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	      level: 3 // 지도의 확대 레벨
	  };  
		//지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
		//주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		//주소로 좌표를 검색합니다
		geocoder.addressSearch('강원 고성군 거진읍 화진포길 280', function(result, status) {
		
		  // 정상적으로 검색이 완료됐으면 
		   if (status === kakao.maps.services.Status.OK) {
		
		      var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
		      // 결과값으로 받은 위치를 마커로 표시합니다
		      var marker = new kakao.maps.Marker({
		          map: map,
		          position: coords
		      });
		
		      // 인포윈도우로 장소에 대한 설명을 표시합니다
		      var infowindow = new kakao.maps.InfoWindow({
		          content: '<div style="width:150px;text-align:center;padding:6px 0;">PineTree Hotel</div>'
		      });
		      infowindow.open(map, marker);
		
		      // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		      map.setCenter(coords);
		  } 
		});    
	  
	  $('.input-daterange input').each(function() {
		    $(this).datepicker('clearDates');
		});
	  
	  /* Main Nav메뉴 Hover시 드롭다운  */
		$('ul.nav li.dropdown').hover(function() {
		  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
		}, function() {
		  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
		});
				 		
	  </script>
  </body>
</html>