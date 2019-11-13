<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<div class="hero-wrap" style="background-image: url('../images/bg_1.jpg'); height:100px;">
	<div class="overlay"></div>
</div>
<div class="d-flex" id="wrapper">
    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading"><h1 class="mb-4 bread h3">Pinetree Admin</h1></div>
      <div class="list-group list-group-flush">
        <a href="adminhome.do" class="list-group-item list-group-item-action bg-light">관리자 홈</a>
        <a href="reservelist.do" class="list-group-item list-group-item-action bg-light">예약리스트</a>
        <a href="roomlist.do" class="list-group-item list-group-item-action bg-light">객실리스트</a>
        <a href="accountlist.do" class="list-group-item list-group-item-action bg-light">회원관리</a>
      </div>
    </div>
    
    <!-- /#sidebar-wrapper -->
    <!-- Page Content -->
    <div id="page-content-wrapper">
      <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
            <li class="nav-item active">
              <a class="nav-link" href="adminhome.do">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                MENU
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="reservelist.do">예약리스트</a>
                <a class="dropdown-item" href="roomlist.do">객실리스트</a>
                <a class="dropdown-item" href="accountlist.do">회원관리</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>

      <!-- 예약상세 -->
      <div class="container-fluid">
        <h1 class="mt-4">예약상세</h1>
        <!-- 본문시작 -->
			<table class="table">
			  	<tr>
			  		<td colspan='4'>
				  		<input type="button" value="예약목록" onclick="location.href='reservelist.do'" class="btn">
				  		<input type="button" value="예약수정" onclick="location.href='reserveupdate.do?cart_no=${dto.cart_no}'" class="btn">
				  		<input type="button" value="예약삭제" onclick="location.href='reservedelete.do?ol_num=${dto.ol_num}'" class="btn">
					</td>
				</tr>
				<tr>
					<th>예약번호</th>
					<th>예약날짜</th>
					<th>예약아이디</th>
					<th>객실번호</th>
					<th>체크인</th>
					<th>체크아웃</th>
					<th>어른수</th>
					<th>아이수</th>
					<th>조식어른수</th>
					<th>조식아이수</th>
					<th>침대수</th>
					<th>결제금액</th>
					<th>예약상태</th>
				</tr>
			  	<tr>
			  		<td>${dto.od_no }</td>
			  		<td>${dto.cart_date }</td>
			   		<td>${dto.ac_id }</td>
			  		<td>${dto.room_id }</td>
			  		<td>${dto.cart_chin }</td>
			  		<td>${dto.cart_chout }</td>
			  		<td>${dto.cart_adno }</td>
			  		<td>${dto.cart_bbno }</td>
			  		<td>${dto.cart_op_ad }</td>
  			 		<td>${dto.cart_op_bb }</td>
			  		<td>${dto.cart_op_bed }</td>
			  		<td>${dto.od_total }</td>
			  		<td>${dto.od_now }</td>
			  	</tr>
			</table>
     	 </div>
    </div>
    <!-- /#page-content-wrapper -->
  </div>
  <!-- /#wrapper -->
<%@ include file="../footer.jsp"%>