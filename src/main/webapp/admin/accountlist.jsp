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
        <h1 class="mt-4">회원관리 페이지</h1>
			<!-- 본문시작 -->
			<div class="container" style="margin:0 auto;">
            <div class="col-md-12">
			<table class="table">	
				<tr>
					<th>회원아이디</th>
					<th>한글이름</th>
					<th>영문이름</th>
					<th>연락처</th>
					<th>멤버쉽등급</th>
					<th>숙박일수</th>
					<th>가입일자</th>
					<th>수정/삭제</th>
				</tr>
			
			  	<c:forEach var="dto" items="${list}">
			  		<tr style = "cursor:pointer;" onClick = " location.href='accountread.do?ac_id=${dto.ac_id }'">
				  		<td><a href="accountread.do?ac_id=${dto.ac_id }">${dto.ac_id }</a></td>
						<td>${dto.ac_name_kor }</td>
						<td>${dto.ac_name_eng }</td>
						<td>${dto.ac_phone }</td>
						<%
						//누적숙박수
															
						//등급

						%>
						<td>${dto.ac_grade }</td>
						<td>${dto.ac_stay }</td>
						<td>${dto.ac_date.substring(0,10) }</td>
						<td>
							<input type="button" value="회원수정" onclick="location.href='accountupdate.do'" class="btn">
					  		<input type="button" value="회원삭제" onclick="location.href='accountdelete.do'" class="btn btn btn-danger">						
						</td>						
			  	    </tr>
			  	 </c:forEach>

			
			</table>
      </div>
    </div>
    </div>
    </div>
    <!-- /#page-content-wrapper -->
  </div>
  <!-- /#wrapper -->
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>