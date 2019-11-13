<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="member/auth.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>PINETREE HOTEL | 최고의 휴양지 파인트리호텔 </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
    <!-- css -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR|Noto+Serif+KR&display=swap" rel="stylesheet">
	
    <link rel="stylesheet" href="../css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="../css/animate.css">
    
    <link rel="stylesheet" href="../css/owl.carousel.min.css">
    <link rel="stylesheet" href="../css/owl.theme.default.min.css">
    <link rel="stylesheet" href="../css/magnific-popup.css">
    <link rel="stylesheet" href="../css/aos.css">
    <link rel="stylesheet" href="../css/ionicons.min.css">
    <link rel="stylesheet" href="../css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="../css/jquery.timepicker.css">
    
    <link rel="stylesheet" href="../css/flaticon.css">
    <link rel="stylesheet" href="../css/icomoon.css">
	<link rel="stylesheet" href="../css/style.css">
	<link rel="stylesheet" href="../css/simple-sidebar.css" >
	<link rel="stylesheet" href="../css/custom.css"  type="text/css">
	<link rel="stylesheet" type="text/css" href="../css/daterangepicker.css" />
	
	<script src="../js/jquery.js"></script>
	<script src="../js/jquery.min.js"></script>	
	<script src="../js/jquery.cookie.js"></script>
  </head>
  <body>

        <!-- nav start -->
    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="/pinetree/index.do">
			<img src="../images/pinetree.png" alt="logo">
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
	          <a href="/pinetree/contact.do" class="nav-link dropdown-toggle" data-hover="dropdown">Contact</a>
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
