<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>

<div class="hero-wrap"
		style="background-image: url('images/bg_1.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
				<div
					class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
					<div class="text">
						<p class="breadcrumbs mb-2">
							<span class="mr-2"><a href="index.html">Home</a></span> <span>Reservation</span>
						</p>
						<h1 class="mb-4 bread">Reservation</h1>
					</div>
				</div>
			</div>
		</div>
	</div>


	 <section class="ftco-section contact-section bg-light">
	 <form method="post" action="./payment.do" class="container">
      <div class="container">
        <div class="row d-flex mb-5 contact-info">
        
          <div class="col-md-12 mb-4">
            <h2>1. Extra Options</h2>
          </div>
          <div class="w-100"></div>
              
          <div class="col-md-8 d-flex">
           	<div class="bg-white p-5 contact-form">
           	<input type="hidden" name="">
            
            <h3>Buffet & Extra Beds</h3>
              <div class="form-group">
              	<h4>조식뷔페권</h4>
              	<label>성인
                <input type="number" name="cart_op_ad" id="cart_op_ad" class="form-control" max="2" min="0">
                </label>
                <label>어린이
                <input type="number" name="cart_op_bb" id="cart_op_bb" class="form-control" max="2" min="0">
                </label>
              </div>
              <div class="form-group">
              	<h4>침대 추가</h4>
              	<label for = "cart_op_bad">수량
                <input type="number" name="cart_op_bad" id="cart_op_bad" class="form-control" max="2" min="0">
                </label>
              </div>
              
              <h3>요청사항</h3>
              <div class="form-group">              	
              	<label for = "cart_op_bad">객실위치
                	<select class="form-control">
                		<option>엘리베이터 옆</option>
                		<option>복도 끝</option>
                		<option>복도 중간</option>                		
                	</select>
                </label>
              </div>
              <div class="form-group">              	
              	<label for = "arrive_time">도착예정시간
                	<input type="time" class="form-control">
                </label>
              </div>
              <div class="form-group">
              	<label for = "rq_message">남기고 싶은 메시지
                <textarea name="" id="" cols="30" rows="7" id="rq_message" class="form-control" placeholder="Message"></textarea>
                </label>
              </div>              
             
            </div>   
          </div>

          <div class="bg-white col-md-4 p-5" style="border:1px solid #000">
          	 <h3 class="h4">확정 요금</h3>
          	 <p>온라인 확정요금</p>
          	 <!-- room.jsp 셀렉트옵션 가져오기 -->
          	 <dl>
	          	 <p>체크인</p>
	          	 <p>체크아웃</p>
	          	 <p>객실타입</p>
	          	 <p>객실수</p>
	          	 <p>어른 : 아이: </p>       	
          	 </dl>
          	 <div class="form-group">
                <input type="submit" value="결제하기" class="btn btn-primary py-3 px-5">
             </div>   	
          </div>
         
      </div>
      </div>
      </form> 
    </section>






<%@ include file="../main/footer.jsp"%>
