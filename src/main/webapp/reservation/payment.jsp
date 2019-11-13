<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>
<%
int rp = Integer.parseInt(request.getParameter("roomprice"));
%>
<div class="hero-wrap" style="background-image: url('images/bg_1.jpg');">
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
<!-- post로 변경하기 / action도 변경 -->
 <section class="ftco-section contact-section bg-light">
	 <form method="post" action="./paymentproc.do" class="" onsubmit="return payCheck(this)">
      <div class="container">
        <div class="row d-flex mb-5 contact-info">
          <div class="col-md-12 mb-4">
            <h2>2. 최종 결제</h2>
          </div>
          <div class="w-100"></div>
          <div class="col-md-8 d-flex">
          	<div class="bg-white p-5 contact-form">
            <h3>예약고객 정보</h3>
              <div class="form-group">
              	<h4>성명(한글)</h4>
              	<label for="ac_name_kor_fa">이름
                <input type="text" name="ac_name_kor" id="ac_name_kor" value="${m_dto.ac_name_kor }" class="form-control">
                </label>
              </div>
               <div class="form-group">
              	<h4>성명(영문)</h4>
              	<label for="ac_name_eng_fa">Name
                <input type="text" name="ac_name_eng" id="ac_name_eng" value="${m_dto.ac_name_eng }" class="form-control">
                </label>
              </div>
              <div class="form-group">
              	<h4>연락처</h4>
              	<label for="ac_phone">핸드폰번호              	
                <input type="text" name="ac_phone" id="ac_phone" value="${m_dto.ac_phone }" class="form-control">
                </label>                
              </div>
              <div class="staycustomer" style="border:1px solid #000; padding: 10px;">
              <h3>투숙고객 정보</h3>
	              <label for="samecus"> 
	              <input type="checkbox" name="samecus" id="samecus">
	              	예약고객정보와 동일합니다.
	              </label>
              <div class="form-group">
              	<h4>성명(한글)</h4>
              	<label for="ac_name_kor_fa">이름
                <input type="text" name="od_name_kor" id="od_name_kor" class="form-control">
                </label>
              </div>
               <div class="form-group">
              	<h4>성명(영문)</h4>
              	<label for="ac_name_eng_fa">Name
                <input type="text" name="od_name_eng" id="od_name_eng" class="form-control">
                </label>
              </div>
              <div class="form-group">
              	<h4>연락처</h4>
              	<label for="ac_phone">핸드폰번호              	
                <input type="text" name="od_phone" id="od_phone" class="form-control" placeholder="예:01012341234" maxlength="11">
                </label>           
              </div>
              </div>
              <h3>신용카드 정보</h3>
              <div class="form-group"> 
              	<label for="od_card">신용카드 종류</label>
              	<select id="od_card" name="od_card" class="form-control">
              		<option value="C_AME">American Express카드</option>
              		<option value="C_DIN">Diners Club카드</option>
              		<option value="C_JCB">JCB카드</option>
              		<option value="C_MAS">Maestro카드</option>
              		<option value="C_VISA">VISA카드</option>
              		<option value="C_KUK">국민카드</option>
              		<option value="C_NOH">농협카드</option>
              		<option value="C_LOT">롯데카드</option>
              		<option value="C_BCC">비씨카드</option>
              		<option value="C_SAM">삼성카드</option>
              		<option value="C_SHC">신한카드</option>
              		<option value="C_CTC">씨티카드</option>
              		<option value="C_WOC">우리카드</option>
              		<option value="C_HAN">하나카드(구외환)</option>
              		<option value="C_HDC">현대카드</option>
              	</select>
              </div>
              <div class="form-group">
              	<label for="od_card_no">신용카드 번호</label>
              	<input type="hidden" name="od_card_no" id="od_card_no">
                <input type="text" name="od_card_no1" id="od_card_no1" class="form-control form-credit" maxlength="4" required>
                <input type="password" name="od_card_no2" id="od_card_no2" class="form-control form-credit" maxlength="4" required>
                <input type="password" name="od_card_no3" id="od_card_no3" class="form-control form-credit" maxlength="4" required>
                <input type="text" name="od_card_no4" id="od_card_no4" class="form-control form-credit" maxlength="4" required>
              </div>
               <div class="form-group">
              	<label for="od_card_date">신용카드 유효기간</label>
              	<input type="hidden" name="od_card_date" id="od_card_date">              	
                <input type="number" name="od_card_date1" id="od_card_date1" class="form-control form-credit" placeholder="년도" min="2019" max="2030" required>
                <input type="number" name="od_card_date2" id="od_card_date2" class="form-control form-credit" placeholder="년월" min="1" max="12" required>
              </div>
              <%--
              <label for="cp_no">쿠폰사용</label>
              <select id="cp_no" name="cp_no" class="form-control">
               <c:forEach var="cp_dto" items="${cp_list }">
              	<option value="${cp_dto.cp_no }">
              		<c:if test="${cp_dto.cp_no eq 'COU001' }">가입환영쿠폰</c:if>
              		<c:if test="${cp_dto.cp_no eq 'COU002' }">20일 장기투숙객 쿠폰</c:if>
              		<c:if test="${cp_dto.cp_no eq 'COU003' }">10일 장기투숙객 쿠폰</c:if>
              	</option>
              </c:forEach> 
              </select>
              <label for="od_point">사용가능한 적립금 : ${po_dto.ac_total_acpoint }</label>
              <input type="number" name="od_point" id="od_point" placeholder="1000원 이상 사용가능">
              
              --%>
            </div>   
          </div>
          <div class="bg-white col-md-4 p-5" style="border:1px solid #000">
          	<h3 class="h4">예약 정보</h3>
          	<dl>	          
          	 	<dt>체크인날짜</dt>	 
	          	<dd>${c_dto.cart_chin }</dd>
	          	<dt>체크아웃날짜</dt>	 
	          	<dd>${c_dto.cart_chout }</dd>
	          	<dt>객실ID</dt>	 
	          	<dd>${c_dto.room_id }</dd>	 
	        	<dt>객실타입</dt>	 
	          	<c:if test='${c_dto.room_id.substring(0,4) == "R_AD"}'>
	          	  <dd>더블 스위트</dd>	 
	          	</c:if>
	          	<c:if test='${c_dto.room_id.substring(0,4) == "R_AF"}'>
	          	  <dd>패밀리 스위트</dd>	 
	          	</c:if>
	          	<c:if test='${c_dto.room_id.substring(0,4) == "R_AT"}'>
	          	  <dd>트윈 스위트</dd>	 
	          	</c:if>
	          	<c:if test='${c_dto.room_id.substring(0,4) == "R_BT"}'>
	          	  <dd>트윈 디럭스</dd>	 
	          	</c:if>
	          	<c:if test='${c_dto.room_id.substring(0,4) == "R_BD"}'>
	          	  <dd>더블 디럭스</dd>	 
	          	</c:if>
	          	<c:if test='${c_dto.room_id.substring(0,4) == "R_CD"}'>
	          	  <dd>더블 스탠다드</dd>	 
	          	</c:if>	
	          	<dt>객실 수</dt>	 
	          	<dd>${c_dto.cart_oprm } 객실</dd>	          	 
	          	<dt>인원 수</dt>
	          	<dd>성인 : ${c_dto.cart_adno } 인 , 어린이: ${c_dto.cart_bbno } 인</dd>       	
          	 </dl>
          	<h3 class="h4">확정 요금</h3>
          	<h5><%=rp%>원</h5>
          	 <input type="hidden" name="od_total" id="od_total" value=<%=rp%>>
	          	 <input type="hidden" name="ac_id" id="ac_id" value=${s_id }>
	          	 <input type="hidden" name="cart_date" id="cart_date" value=${c_dto.cart_date }>
	         <hr class="line">
          	 <div class="form-group">
	          	 <h3 class="h4">환불규정</h3> 
	          	 <div>
	          	 	<dl>
	          	 		<dt>30일 이전 취소 시</dt>
	          	 		<dd> - 하루 숙박 총 요금의 90% 환불</dd>
	          	 		<dt>15일 이전 취소 시</dt>
	          	 		<dd> - 하루 숙박 총 요금의 60% 환불</dd>
	          	 		<dt>7일 이전 취소 시</dt>
	          	 		<dd> - 하루 숙박 총 요금의 30% 환불</dd>
	          	 		<dt>1일 전 취소 시</dt>
	          	 		<dd> - 환불불가</dd>
	          	 	</dl>
	          	 </div>         	 
          	 </div> 	 
          	 <div class="form-group">
                <input type="submit" value="결제하기" class="btn btn-primary py-3 px-5">
             </div>   	
          </div>
       </div>
      </div>
   </form>
<%@ include file="../main/footer.jsp"%>