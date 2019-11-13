<%@ page contentType="text/html; charset=UTF-8"%>
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
	                <li><span class="icon icon-map-marker"></span><span class="text">강원 고성군 거진읍 화진포길 280</span></li>
	                <li><a href="#"><span class="icon icon-phone"></span><span class="text">+82 033 1234 5678</span></a></li>
	                <li><a href="/pinetree/contact/email.do"><span class="icon icon-envelope"></span><span class="text">info@pinetree.com</span></a></li>
	              </ul>
	            </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 text-center">

            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Pintree Hotel
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
          </div>
        </div>
      </div>
    </footer>

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

  	<!-- script -->	
    <script src="../js/jquery-migrate-3.0.1.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.easing.1.3.js"></script>
    <script src="../js/jquery.waypoints.min.js"></script>
    <script src="../js/jquery.stellar.min.js"></script>
    <script src="../js/owl.carousel.min.js"></script>
    <script src="../js/jquery.magnific-popup.min.js"></script>
    <script src="../js/aos.js"></script>
    <script src="../js/jquery.animateNumber.min.js"></script>
    <script src="../js/bootstrap-datepicker.js"></script>
    <script src="../js/jquery.timepicker.min.js"></script>
    <script src="../js/scrollax.min.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6ebe91c1d39cad89656ce7fc92edc85b"></script>
    <script src="../js/google-map.js"></script>
    <script src="../js/main.js"></script>
    <script src="../js/custom.js"></script>
    <script type="text/javascript" src="../js/moment.min.js"></script>
    <script type="text/javascript" src="../js/daterangepicker.min.js"></script>

  
	
  <script>
  /* KAKAO MAP API */
  var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
  var options = { //지도를 생성할 때 필요한 기본 옵션
  	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
  	level: 3 //지도의 레벨(확대, 축소 정도)
  };
  
  

  var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	$(function() {
	  $('input[name="daterange"]').daterangepicker({
		opens: 'left'
	  }, function(start, end, label) {
		console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
		  $("#cart_chin").val(start.format('YYYY-MM-DD'));
		  $("#cart_chout").val(end.format('YYYY-MM-DD'));
	  });
	});
  
	</script>
  </body>
</html>
