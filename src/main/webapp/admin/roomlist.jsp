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

      <div class="container-fluid">      
        <h1 class="mt-4 text-center">객실리스트</h1>
        <!-- 본문시작 -->
        <div class="container" style="margin:0 auto;">
        <div class="col-md-12">
		<table class="table hover">
			<tr>
				<td colspan='3'></td>
				<td colspan='2'><p>예약상태 : P-예약완료 / S-기본상태</p></td>
			</tr>
			<tr>
				<th>객실코드</th>
				<th>객실이름</th>
				<th>객실가격</th>
				<th>예약상태</th>
				<th>예약날짜</th>
			</tr>
		  	<c:forEach var="dto" items="${roomList}">
		  		<tr>
		  			<td>${dto.room_id }</td>
		  			<td>${dto.room_name }</td>
		  			<td>${dto.room_price }</td>
		  			<td>${dto.od_now }</td>
		  			<td>${dto.cart_date.substring(0,10) }</td>
		  	    </tr>
		  	</c:forEach>
		</table>
		</div>
		
		<!-- 페이징 -->
		<div class="col-md-12  my-5">
		    <div class="text-center">
		       <div class="row" style="text-align:center;">
		       	<ul class="pagination" style="text-align:center;">
					<c:if test="${count>0 }"> 
						<c:set var="pageCount" value="${totalPage }" />
						<c:set var="startPage" value="${startPage }" />
						<c:set var="endPage" value="${endPage }" />
						
						<c:if test="${endPage>pageCount }">
							<c:set var="endPage" value="${pageCount+1 }" />
						</c:if>
						
						<c:if test="${startPage == 0 }">
						<li class="page-item"><a class="page-link" href="./roomlist.do">이전</a></li>
						</c:if>
						<c:if test="${startPage > 0 }">
						<li class="page-item"><a class="page-link" href="./roomlist.do?pageNum=${startPage }">이전</a></li>
						</c:if>
						
						<c:forEach var="i" begin="${startPage+1 }" end="${endPage-1 }">
							<li class="page-item"><a class="page-link" href="./roomlist.do?pageNum=${i }">${i }</a></li>
						</c:forEach>
						
						<c:if test="${endPage<pageCount }">
						 <li class="page-item"><a class="page-link" href="./roomlist.do?pageNum=${startPage+11 }">다음</a></li>
						</c:if>
						
					</c:if>  
					</ul>
		        </div>
		     </div>
		</div>
		<!-- 페이징끝 -->
		
		</div>
		<!-- 본문끝 -->
		
      </div>
    </div>
    <!-- /#page-content-wrapper -->
  </div>
  <!-- /#wrapper -->
<%@ include file="../footer.jsp"%>
