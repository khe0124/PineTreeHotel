<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>
<%
	String room = request.getParameter("room_name");
	String rn = request.getParameter("cart_oprm");
	String ro = request.getParameter("cart_adno");
	String ri = request.getParameter("cart_bbno");
%>
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
	 <form method="post" action="./payment.do" class="container" onsubmit="return prCheck(this)">
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
                <input type="number" name="cart_op_ad" id="cart_op_ad" class="form-control" value="0" max="2" min="0">
                </label>
                <label>어린이
                <input type="number" name="cart_op_bb" id="cart_op_bb" class="form-control" value="0" max="2" min="0">
                </label>
              </div>
              <div class="form-group">
              	<h4>침대 추가</h4>
              	<label for = "cart_op_bad">수량
                <input type="number" name="cart_op_bed" id="cart_op_bed" class="form-control" value="0" max="2" min="0">
                </label>
              </div>
              
              <h3>요청사항</h3>
              <div class="form-group">              	
              	<label for = "cart_op_bad">객실위치
                	<select class="form-control">
                		<option selected>엘리베이터 옆</option>
                		<option>복도 끝</option>
                		<option>복도 중간</option>                		
                	</select>
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
          	 <h3 class="h4">예약 안내</h3>
          	 <!-- room.jsp 셀렉트옵션 가져오기 -->
          	 <dl>	          
          	 	<dt>체크인날짜</dt>	 
	          	<dd>${chin }</dd>
	          	<dt>체크아웃날짜</dt>	 
	          	<dd>${chout }</dd>
	          	<dt>객실ID</dt>	 
	          	<dd>${roomid }</dd>	 
	          	<dt>객실타입</dt>	 
	          	<dd>${roomname }</dd>	          	 
	          	<dt>객실 수</dt>	 
	          	<dd>${oprm } 객실</dd>	          	 
	          	<dt>인원 수</dt>
	          	<dd>성인 : ${adno } 인 , 어린이: ${bbno } 인</dd>       	
          	 </dl>
          	 
          	 <!-- Hidden Input -->
          	 <input type="hidden" name="ac_id" id="ac_id" value=${s_id }>
          	 <input type="hidden" name="room_id" id="room_id" value=${roomid }>
          	 <input type="hidden" name="cart_oprm" id="cart_oprm" value=${oprm }>
          	 <input type="hidden" name="cart_adno" id="cart_adno" value=${adno }>
          	 <input type="hidden" name="cart_bbno" id="cart_bbno" value=${bbno }>
          	 <input type="hidden" name="cart_chin" id="cart_chin" value=${chin }>
          	 <input type="hidden" name="cart_chout" id="cart_chout" value=${chout }>
          	 <input type="hidden" name="roomprice" id="roomprice" >
          	 
          	 <hr class="line">
          	 <div class="form-group">
	          	 <h3 class="h4">온라인 확정요금</h3>          	 
	          	 <input type="text" class="form-control" id="totalpr" value="${roomprice }원">
	          	 <div>
	          	 <dl id="totalex">
	          	 	<dt>총 숙박일 수</dt>
         			<dd id="b-day"></dd>
         			<dt>조식(성인)</dt>
         			<dd id="ad"></dd>
         			<dt>조식(어린이)</dt>
         			<dd id="bb"></dd>
         			<dt>침대 추가</dt>
         			<dd id="bed"></dd>
	          	 </dl>
	          	 </div>
	          	 <p id="totalbtn" class="btn btn-outline-secondary">옵션 합계</p>
          	 </div>
          	 
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
          	 <hr class="line">
          	 <div class="form-group">
                <input type="submit" value="결제하기" id="paybtn" class="btn btn-primary py-3 px-5">
             </div>   	
          </div>
      </div>
      </div>
      </form>  
      <script>
      	var chin = '${chin }';  
	    var chout = '${chout }';  
	    var da1 = chin.split("-");  
	    var da2 = chout.split("-");  
	    var dobj1 = new Date(da1[0], Number(da1[1])-1, da1[2]);  
	    var dobj2 = new Date(da2[0], Number(da2[1])-1, da2[2]);  
	    var betweenDay = parseInt((dobj2.getTime() - dobj1.getTime()) / 1000 / 60 / 60 / 24);  
		
   $(function(){	   
	   $("#totalbtn").on('click',function(){
	    var total = ${roomprice } * betweenDay;
     	var cart_op_ad = document.getElementById("cart_op_ad").value; 
     	var cart_op_bb = document.getElementById("cart_op_bb").value; 
     	var cart_op_bed = document.getElementById("cart_op_bed").value; 

     	var sum1 = parseInt($("#cart_op_ad").val() || 0 ); // input 값을 가져오며 계산하지만 값이 없을경우 0이 대입된다  뒷부분에 ( || 0 ) 없을경우 합계에 오류가 생겨 NaN 값이 떨어진다
        var sum2 = parseInt($("#cart_op_bb").val() || 0);
        var sum3 = parseInt($("#cart_op_bed").val() || 0);
        total = parseInt(total + (sum1 * 20000) + (sum2 * 10000) + (sum3*50000));
        alert(total);
        $("#roomprice").val(total); 
        $("#totalpr").val(total + '원');
        $("#b-day").text(betweenDay);
        $("#ad").text(sum1);
        $("#bb").text(sum2);
        $("#bed").text(sum3);
	   });
	   
	   $("#paybtn").on('click',function(){
		  	var b_day=$("#b-day").text();
		  	var ad=$("#ad").text();
		  	var bb=$("#bb").text();
		  	var bed=$("#bed").text();
		  	
		  	if(b_day.length==0 || ad.length==0 || bb.length==0 || bed.length==0 ){
		  		alert("온라인 확정요금의 옵션 합계 버튼을 눌러주세요.");
		  		return false;
		  	}
		  	return true;
	   });//
 
	  });
   </script>
<%@ include file="../main/footer.jsp"%>