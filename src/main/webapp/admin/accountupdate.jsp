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
			<h1 class="mt-4">회원상세정보</h1>
			<!-- 본문시작 -->
			<!-- Nav tabs -->
			<ul class="nav nav-tabs">
				<li class="nav-item"><a class="nav-link active"
					data-toggle="tab" href="#acinfo">회원정보</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#menu1">예약내역</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#menu2">Menu 2</a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div class="tab-pane container active" id="acinfo">
					<div class="col-md-9">

						<!-- 폼시작 -->
						<form method="post" action="./accountupdate.do"
							onsubmit="return acCheck(this)">
							<input type="hidden" name="ac_id" id="ac_id"
								value="${dto.ac_id }">
							<table class="table">
								<tr>
									<th>회원아이디</th>
									<td>${dto.ac_id }</td>
								</tr>
								<tr>
									<th>한글이름</th>
									<td>${dto.ac_name_kor }</td>
								</tr>
								<tr>
									<th>영문이름</th>
									<td>${dto.ac_name_eng }</td>
								</tr>
								<tr>
									<th>비밀번호</th>
									<td>${dto.ac_passwd }</td>
								</tr>
								<tr>
									<th>연락처</th>
									<td><input type='text' name='ac_phone' size='10' value='${dto.ac_phone }'></td>
								</tr>
								<tr>
									<th>이메일</th>
									<td>${dto.ac_email }</td>
								</tr>
								<tr>
									<th>멤버쉽등급</th>
									<td><input type='text' name='ac_grade' size='1' value='${dto.ac_grade }'></td>
								</tr>
								<tr>
									<th>누적숙박수</th>
									<td><input type='text' name='ac_stay' size='5' value='${dto.ac_stay }'></td>
								</tr>
								<tr>
									<th>가입일자</th>
									<td>${dto.ac_date }</td>
								</tr>
								<tr>
									<td colspan="2">
										<input type="button" value="회원목록" onclick="location.href='accountlist.do'" class="btn"> 
										<input type="submit" value="수정완료" class="btn">
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				<div class="tab-pane container fade" id="menu1">...</div>
				<div class="tab-pane container fade" id="menu2">...</div>
			</div>


		</div>
	</div>
	<!-- /#page-content-wrapper -->
</div>
<!-- /#wrapper -->

<!-- 유효성 -->
<script>
    function acCheck(f) {
  	    /* 핸드폰 번호 유효성 검사*/  	    	 
	  	var phone=f.ac_phone.value;
	  	phone=phone.trim();
	  	if(phone.length!=11){
	  		alert("핸드폰번호 11자리로 입력해주세요");
	  		f.phone.focus();
	  		return false;
	  	}//if end
 	  	return true;
    }//acCheck(f) end
  
</script>

<%@ include file="../footer.jsp"%>