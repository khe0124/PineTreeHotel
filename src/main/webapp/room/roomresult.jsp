<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<% 
 String chin = request.getParameter("cart_chin");
 String chout = request.getParameter("cart_chout");
 String roomtype = request.getParameter("room_name");
%>
<div class="hero-wrap" style="background-image: url('../images/bg_1.jpg');">
	<div class="overlay"></div>
	<div class="container">
		<div
			class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
			<div
				class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
				<div class="text">
					<p class="breadcrumbs mb-2">
						<span class="mr-2"><a href="index.do">Home</a></span> <span>About</span>
					</p>
					<h1 class="mb-4 bread">Rooms</h1>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 본문시작 -->
<section class="ftco-booking-in">
    	<div class="container">
    		<div class="row">
    			<div class="col-lg-12">
    				<form method="get" action="./roomresult.do" name="srcfrm" id="srcfrm" class="booking-form">
	        		<div class="row">
	        			<div class="col-md-3 d-flex">
	        				<div class="form-group p-4 align-self-stretch d-flex align-items-end roomsrch">
	        					<div class="wrap">
				    					<label for="daterange">체크인 날짜</label>
				    					<input type="date" class="form-control" name="cart_chin" id="cart_chin" value=<%=chin%>>
				    					<input type="date" class="form-control" name="cart_chout" id="cart_chout" value=<%=chout%>>
			    					</div> 
			    				</div>
						</div>	     								
	        			<div class="col-md d-flex">
	        				<div class="form-group p-4 align-self-stretch d-flex align-items-end roomsrch">
	        					<div class="wrap">
			      					<label for="room_name">객실</label>
			      					<div class="form-field">
				        			<div class="select-wrap">
				                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
					                    <select name="room_name" id="room_name" onchange="setValuesRoom();" value=${rt } class="form-control">
					                     <c:if test='${rt == "" }'>
					                     	<option value='' se>객실 타입</option>
					                     </c:if>
					                     <c:if test='${rt == "SU" }'>
					                     	<option value='SU'>Suite</option>
					                     </c:if>
					                     <c:if test='${rt == "DE" }'>
					                     	<option value='DE'>Deluxe</option>
					                     </c:if>
					                     <c:if test='${rt == "ST" }'>
					                     	 <option value='ST'>Standard</option>
					                     </c:if>
										</select>
					                  </div>
					              </div>
								</div>
		              		</div>
	        			</div>
	        			<!-- 객실수 -->
						<div class="col-md d-flex">
	        				<div class="form-group p-4 align-self-stretch d-flex align-items-end roomsrch">
	        					<div class="wrap">
							<label for="cart_oprm">객실수</label>
							<div class="form-field">
								<div class="select-wrap">
								<div class="icon"><span class="ion-ios-arrow-down"></span></div>
								<select name="cart_oprm" id="cart_oprm" class="form-control" value=${cart_oprm }>
								<c:if test = '${cart_oprm == 1 }'>
									<option value='1' selected>1</option>
								</c:if>
								<c:if test = '${cart_oprm == 2 }'>
									<option value='2' selected>2</option>
								</c:if>
								<c:if test = '${cart_oprm == 3 }'>
									<option value='3' selected>3</option>
								</c:if>
								</select>
							  </div>
							</div>
						  </div>
		             	  </div>
	        			</div>
	        			
	        			<div class="col-md d-flex">
	        				<div class="form-group p-4 align-self-stretch d-flex align-items-end roomsrch">
	        					<div class="wrap">
			      					<label for="cart_adno">성인</label>
			      					<div class="form-field">
			        					<div class="select-wrap">
			                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
			                    <select name="cart_adno" id="cart_adno" class="form-control" value=${cart_adno }>
			                   	<c:if test = '${cart_adno == 1 }'>
									<option value='1' selected>1인</option>
								</c:if>
								<c:if test = '${cart_adno == 2 }'>
									<option value='2' selected>2인</option>
								</c:if>
			                    </select>
			                  </div>
				              </div>
				            </div>
				            <div class="wrap">
			      					<label for="cart_bbno">어린이</label>
			      					<div class="form-field">
			        					<div class="select-wrap">
			                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
			                    <select name="cart_bbno" id="cart_bbno" class="form-control" value=${cart_bbno }>
			                    <c:if test = '${cart_bbno == 0 }'>
									<option value='0' selected>0인</option>
								</c:if>
								<c:if test = '${cart_bbno == 1 }'>
									<option value='1' selected>1인</option>
								</c:if>
								<c:if test = '${cart_bbno == 2 }'>
									<option value='2' selected>2인</option>
								</c:if>
			                    </select>
			                  </div>
				              </div>
				            </div>        
		              </div>
						</div>

	        			<div class="col-md d-flex">
	        				<div class="form-group d-flex align-self-stretch">
			              <input type="submit" value="객실검색" class="btn btn-primary py-3 px-4 align-self-stretch roomsrch">
			            </div>
	        			</div>
	        		</div>
	        	</form>
	    		</div>
    		</div>
    	</div>
    </section>			
<section class="ftco-section bg-light">
	<div class="container">
		<h3>객실 검색결과</h3>
					<p>${msg1}</p>
		<div class="row">
			<div class="col-lg-12">
				<div class="row">					
				<c:forEach var="dto" items="${searchlist}">					
					<p class="blind" style="display:none;">
					<c:choose>
						<c:when  test ="${dto.room_name == '더블 스위트' }">
							${link = 'doublesuite' }
						</c:when >
						<c:when  test ="${dto.room_name == '패밀리 스위트' }">
							${link = 'familiysuite' }
						</c:when >
						<c:when  test ="${dto.room_name == '트윈 스위트' }">
							${link = 'twinsuite' }
						</c:when >
						<c:when  test ="${dto.room_name == '더블 디럭스' }">
							${link = 'doubledeluxe' }
						</c:when >
						<c:when  test ="${dto.room_name == '트윈 디럭스' }">
							${link = 'twindeluxe' }
						</c:when >
						<c:when  test ="${dto.room_name == '더블 스탠다드' }">
							${link = 'doublestandard' }
						</c:when >
					</c:choose>
					</p>
											
					<div class="col-sm col-md-6 col-lg-4 ftco-animate">
						<div class="room">
							<a href="${link }.do"
								class="img d-flex justify-content-center align-items-center"
								style="background-image: url(../images/${link }.jpg);"> 
								<div
									class="icon d-flex justify-content-center align-items-center">
									<span class="icon-search2"></span>
								</div>
							</a>
							<div class="text p-3 text-center">
								<h3 class="mb-3">${dto.room_name }</h3>
								<p>
									<span class="price mr-2">${dto.room_price }</span> <span class="per">1박</span>
								</p>
								<ul class="list">
									<li><span>최대:</span> 4명</li>
									<li><span>뷰:</span> 오션뷰 / 시티뷰</li>
									<li><span>침대 수:</span> 3개</li>
								</ul>
								<hr>
									<p class="pt-1">									
										<form action="${link }.do" method="post">
											<input type="hidden" name="room_id" id="room_id" value=${dto.room_id } >
											<input type="hidden" name="cart_chin" id="cart_chin" value=${s_chin }  >
											<input type="hidden" name="cart_chout" id="cart_chout" value=${s_chout } >
											<input type="submit" class="btn btn-primary" value="예약하기">
										</form>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
						</div>
					</div>
				</div>
			</div>
	</section>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>