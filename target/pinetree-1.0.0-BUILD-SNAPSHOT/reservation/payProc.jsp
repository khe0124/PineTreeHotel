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
      <div class="container">
        <div class="row d-flex mb-5 contact-info">
          <div class="col-md-12 mb-4">
            <h2>2. 최종 결제</h2>
          </div>
          <div class="w-100"></div>
              
          <div class="col-md-8 d-flex">
          	
          	<div class="bg-white p-5 contact-form">
            <form action="#" class="">
            <h3>예약고객 정보</h3>
              <div class="form-group">
              	<h4>성명(한글)</h4>
              	<label for="ac_name_kor_fa">성
                <input type="text" name="ac_name_kor" id="ac_name_kor_fa" class="form-control">
                </label>
                <label for="ac_name_kor_gn">이름
                <input type="text" name="ac_name_kor" id="ac_name_kor_gn" class="form-control">
                </label>
              </div>
               <div class="form-group">
              	<h4>성명(영문)</h4>
              	<label for="ac_name_eng_fa">Family Name
                <input type="text" name="ac_name_eng" id="ac_name_eng_fa" class="form-control">
                </label>
                <label for="ac_name_eng_gn">Given Name
                <input type="text" name="ac_name_eng" id="ac_name_eng_gn" class="form-control">
                </label>
              </div>
              <div class="form-group">
              	<h4>연락처</h4>
              	<label for="ac_phone">핸드폰번호              	
                <input type="text" name="ac_phone" id="ac_phone" class="form-control">
                </label>                
              </div>
              <div class="staycustomer" style="border:1px solid #000; padding: 10px;">
              <h3>투숙고객 정보</h3>
	              <label for="samecus"> 
	              <input type="checkbox" id="samecus">
	              	예약고객정보와 동일합니다.
	              </label>
              <div class="form-group">
              	<h4>성명(한글)</h4>
              	<label for="ac_name_kor_fa">성
                <input type="text" name="ac_name_kor" id="ac_name_kor_fa" class="form-control">
                </label>
                <label for="ac_name_kor_gn">이름
                <input type="text" name="ac_name_kor" id="ac_name_kor_gn" class="form-control">
                </label>
              </div>
               <div class="form-group">
              	<h4>성명(영문)</h4>
              	<label for="ac_name_eng_fa">Family Name
                <input type="text" name="ac_name_eng" id="ac_name_eng_fa" class="form-control">
                </label>
                <label for="ac_name_eng_gn">Given Name
                <input type="text" name="ac_name_eng" id="ac_name_eng_gn" class="form-control">
                </label>
              </div>
              <div class="form-group">
              	<h4>연락처</h4>
              	<label for="ac_phone">핸드폰번호              	
                <input type="text" name="ac_phone" id="ac_phone" class="form-control">
                </label>                
              </div>
              </div>
              
              <h3>신용카드 정보</h3>
              <div class="form-group">              	
              	<label for="od_card">신용카드 종류</label>
              	<select id="od_card" class="form-control">
              		<option id="C_AME">American Express카드</option>
              		<option id="C_DIN">Diners Club카드</option>
              		<option id="C_JCB">JCB카드</option>
              		<option id="C_MAS">Maestro카드</option>
              		<option id="C_VISA">VISA카드</option>
              		<option id="C_KUK">국민카드</option>
              		<option id="C_NOH">농협카드</option>
              		<option id="C_LOT">롯데카드</option>
              		<option id="C_BCC">비씨카드</option>
              		<option id="C_SAM">삼성카드</option>
              		<option id="C_SHC">신한카드</option>
              		<option id="C_CTC">씨티카드</option>
              		<option id="C_WOC">우리카드</option>
              		<option id="C_HAN">하나카드(구외환)</option>
              		<option id="C_HDC">현대카드</option>
              	</select>
              </div>
              <div class="form-group">
              	<label for="od_card_no">신용카드 번호</label>
                <input type="text" name="od_card_no" id="od_card_no" class="form-control form-credit" maxlength="4">
                <input type="text" name="od_card_no" id="od_card_no" class="form-control form-credit" maxlength="4">
                <input type="text" name="od_card_no" id="od_card_no" class="form-control form-credit" maxlength="4">
                <input type="text" name="od_card_no" id="od_card_no" class="form-control form-credit" maxlength="4">
                
                <label for="ac_name_kor_gn">이름
                <input type="text" name="ac_name_kor" id="ac_name_kor_gn" class="form-control">
                </label>
              </div>
              
            </form>   
            </div>   
          </div>

          <div class="bg-white col-md-4 p-5" style="border:1px solid #000">
          	 <h3 class="h4">확정 요금</h3>
          	 <p>온라인 확정요금</p>
          	 <div class="form-group">
                <input type="submit" value="결제하기" class="btn btn-primary py-3 px-5">
             </div>   	
          </div>
        
      </div>
      </div>
    </section>






<%@ include file="../main/footer.jsp"%>
